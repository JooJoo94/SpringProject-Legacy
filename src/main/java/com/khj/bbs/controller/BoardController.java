package com.khj.bbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khj.bbs.dto.BoardVO;
import com.khj.bbs.dto.Criteria;
import com.khj.bbs.dto.PageMaker;
import com.khj.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	BoardService service;
	

	@RequestMapping("/list")
	public String list(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println(cri.getType());
		int totalCount = service.totalCount(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);		
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.selectAll(cri));
		return "list";
	}
	
	@GetMapping("/input")
	public String insert() {
		return "input";
	}
	
	@PostMapping("/input")
	public String insert(@ModelAttribute("board") BoardVO board) {
		service.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute("cri") Criteria cri, @RequestParam int bno, @ModelAttribute("board") BoardVO board, Model model) {		
		model.addAttribute("board",service.selectOne(bno));
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("cri") Criteria cri, @ModelAttribute("board") BoardVO board, RedirectAttributes rttr) {
		service.update(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("type", cri.getKeyword());
		return "redirect:list"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno,  RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri ) {
		service.delete(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("type", cri.getKeyword());
		return "redirect:list";
	}
}
