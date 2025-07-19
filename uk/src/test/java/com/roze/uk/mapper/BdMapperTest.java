package com.roze.uk.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roze.uk.vo.BdVO;

// Mapper I/F 와 SQL을 만든 뒤에 하는 테스트가 가장 가성비가 좋음, 습관으로 승화!!

@SpringBootTest
public class BdMapperTest {
	
	@Autowired
	private BdMapper bdMapper;
	
	@Test
	@DisplayName("입력insert테스트")
	@Disabled	// 이미 테스트가 끝났다면 disabled 처리 (추가 테스트 할 수 있으니)
	void insertBdTest() {
		BdVO bdVO;
		int cnt = 0;
		
		for(int i=1; i<=5; i++) {
			bdVO = new BdVO();
			bdVO.setBdTitle(i + "제목제목");
			bdVO.setBdCont(i + "내용내용");
			bdVO.setBdFurl(i + "몰라몰라");
			cnt += bdMapper.insertBd(bdVO);
		}
		// (기대값, 기준값)
		assertEquals(5, cnt);
	}
	
	@Test
	@DisplayName("전체리스트개수 테스트")
	@Disabled
	void listTest() {
		List<BdVO> bdList = bdMapper.bdList();
		assertEquals(10, bdList.size());
	}
	
	// 이제 get, update, delete 빨리 만들어봐요!
	@Test
	@DisplayName("1개조회 테스트")
	@Disabled
	 void oneTest() {
		 int bdId = 11;
		 BdVO bdVO = bdMapper.readBd(bdId);
		 assertEquals("5제목제목", bdVO.getBdTitle());
	}
	
	@Test
	@DisplayName("수정 테스트")
	@Disabled
	void updTest() {
		BdVO bdVO = new BdVO();
		bdVO.setBdTitle("재석졸림");
		bdVO.setBdCont("나도졸림");
		bdVO.setBdFurl("URL");
		bdVO.setBdId(20);	// 이게 꼭 필요
		
		int cnt = bdMapper.updateBd(bdVO);
		assertNotEquals(1, cnt);
	}
	
	
	
	// 이제 get, update, delete 빨리 만들어봐요!
	@Test
	@DisplayName("1개지우기 테스트")
	@Disabled
	 void delTest() {
//		 int bdId = 100;
		 int bdId = 20;
	     int cnt = bdMapper.deleteBd(bdId);
		 assertEquals(1, cnt);
	}
	
}
