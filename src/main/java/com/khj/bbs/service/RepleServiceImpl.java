package com.khj.bbs.service;

import java.util.List;

import javax.inject.Inject;

import com.khj.bbs.dto.RepleVO;
import com.khj.bbs.mapper.BoardMapper;
import com.khj.bbs.mapper.RepleMapper;

public class RepleServiceImpl implements RepleService {

	@Inject
	private RepleMapper repleMapper;
	@Inject
	private BoardMapper boardMapper;
	
	
	@Override
	public void register(RepleVO reple) {
		boardMapper.updateRepleCount(1, reple.getBno());
		repleMapper.insert(reple);
		
	}

	@Override
	public List<RepleVO> getList(int bno) {

		return repleMapper.getList(bno);
	}

	@Override
	public void remove(int rno) {
		RepleVO reple= repleMapper.getReple(rno);
		boardMapper.updateRepleCount(-1, reple.getBno());
		repleMapper.delete(rno);
	}

}
