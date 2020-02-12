package com.khj.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khj.bbs.dto.BoardVO;

public interface BoardService {

	public List<BoardVO> selectAll();
	public void insert(BoardVO board);
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);
	
	
}
