package com.roze.uk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roze.uk.mapper.BdMapper;
import com.roze.uk.vo.BdVO;

// 요즘은 서비스 I/F 업이 바로 구현체를 만드는 경우도 많음!
// 회사 RULE에 따를 것!
/*
 * 원래 서비스가 만들어진 목적은 여기에 업무 규칙을 기술하시옹! (비지니스로직)
 * 고로, 만든 의도!가 여기 있다는 말
 * 
 * 실제는 비지니스 로직을 Front나 SQL로 처리하는 경우가 많아졌당!
 * 그래서 서비스 레이어가 점점 약해지는 추세이다...!
 */

@Service
public class BdService {
	
	// 서비스는 맵퍼를 호출! 부른다~
	@Autowired
	private BdMapper bdMapper;

	// 읽기 1개
	public List<BdVO> bdList() {
		return bdMapper.bdList();
	};
	
	// 읽기 2개
	public BdVO readBd(int bdId) {
		return bdMapper.readBd(bdId);
	};
	
	// 쓰기 1개
	public int insertBd(BdVO bdVO) {
		return bdMapper.insertBd(bdVO);
	};
	
	// 쓰기 2개
	public int updateBd(BdVO bdVO) {
		return bdMapper.updateBd(bdVO);
	};
	
	// 쓰기 3개
	public int deleteBd(int bdId) {
		return bdMapper.deleteBd(bdId);
	};
	

}
