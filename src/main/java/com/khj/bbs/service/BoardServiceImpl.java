package com.khj.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.khj.bbs.dto.BoardVO;
import com.khj.bbs.dto.Criteria;
import com.khj.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardMapper mapper;

	@Override
	public List<BoardVO> selectAll() {
		
		return mapper.getList();
	}

	@Override
	public void insert(BoardVO board) {
		 mapper.insert(board);		
		return;	
		
	}

	@Override
	public BoardVO selectOne(int bno) {
		
		mapper.updateReadCount(bno);
		return mapper.read(bno);
	}

	@Override
	public void update(BoardVO board) {
		
		mapper.update(board);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> selectAll(Criteria cri) {
		
		return mapper.oraListPaging(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		
		return mapper.totalCount();		//레코드 개수 가져옴
	}



}
