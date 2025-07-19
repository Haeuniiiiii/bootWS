package com.roze.uk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.roze.uk.vo.BdVO;

@Mapper
public interface BdMapper {
	// 시키지 않아도 최소 5가지 메소드를 정의해야함
	// 읽기 (2개, 여러개 1개), 쓰기(3개, 입력, 수정, 삭제), 검색
	// GET : insert update delete
	// POST : insert modify
	
	// 읽기 1개
	public List<BdVO> bdList();
	// 읽기 2개
	public BdVO readBd(int bdId);
	
	// 쓰기 1개
	public int insertBd(BdVO bdVO);
	// 쓰기 2개
	public int updateBd(BdVO bdVO);
	// 쓰기 3개
	public int deleteBd(int bdId);
	
	

}
