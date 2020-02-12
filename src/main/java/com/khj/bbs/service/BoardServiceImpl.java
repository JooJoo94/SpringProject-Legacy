package com.khj.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.khj.bbs.dto.BoardVO;
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
	}

	@Override
	public BoardVO selectOne(int bno) {
		
		return null;
	}

	@Override
	public void update(BoardVO board) {
	}

	@Override
	public void delete(int bno) {
	}



}
