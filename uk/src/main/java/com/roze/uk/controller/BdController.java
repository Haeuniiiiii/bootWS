package com.roze.uk.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.roze.uk.service.BdService;
import com.roze.uk.vo.BdVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController					// 자동으로 @ResponseBody가 들어있어서 각 메서드에 있는 @ResponseBody 중복되는 것을 지워주자
//@Controller					// 접수 창구 역할! "어떤 업무를..? 원하시는지? 함부로 드릴 수 없져"
@RequestMapping("/api")		// 접수 창구 이름
public class BdController {

	// 리다이렉트 : "손님이 움직인다" 고객이 창구번호 바꿔서 재요청
	// 포워딩 : "가게안에서 넘어처리되는 중" 내부처리
	
	// 관례적 약속! RESTful => (get/post/put/delete)
	// RESTful은 AJAX와의 조합이 기가 막힌다!!!!
	// 사용법 설명이 쉬워진다! 이 사용법을 RestAPI라고 부르게 된다!
	// url에 api라고 적혀있다면 개발자들끼리는 안다! (아 여기 ajax 처리 되었구나!)
	
	// 화면으로 가지 않고 응답처리결과만 들고 갈거면? 메서드 위에 @ResponseBody
	// @ResponseBody가 반복되는게 싫다면? @RestController 어노테이션을 붙이자!
	
	// jsp에서는 JSON 형식인 문자열로 데이터를 보낸다. 
	// 그래서 잭슨라이브러리한테 JSON 문자열이 오면 자바객체로 바꿔라~ (@RequestBody)
	// @RequestBody  | JSON문자열 => 자바객체 
	// @ResponseBody | 자바객체 => JSON문자열 
	
	
	
	// 접수만 받고, 실제 처리는 하지 않는다!
	// 처리는 서비스가 한다!
	// 결국, 컨트롤러는 서비스를 호출한다!
	// 받은 결과 리턴은 컨트롤러가
	
	@Autowired
	private BdService bdService;
	
	// 읽기 1개
	@GetMapping("/bd")
	public List<BdVO> bdList() {
		log.info("bdList() 실행!!!!!!");
		return bdService.bdList();
	};
	
	// 읽기 2개
	// 쿼리스트링으로 직접 접근할 때에는 @PathVarible 어노테이션 활용
	@GetMapping("/bd/{bdId}")
	public BdVO readBd(@PathVariable int bdId) {
		log.info("readBd() 실행!!!!!!");
		log.debug("int bdId 넘어온 값 체크 {} ", bdId);
		return bdService.readBd(bdId);
	};
	
	// 쓰기 1개
	/*
	@PostMapping("/bd")
	public Map<String, String> insertBd(@RequestBody BdVO bdVO) {
		log.info("readBd() 실행!!!!!!");
		log.debug("bdVO 넘어온 값 체크 {} ", bdVO);
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("result", "ok");
		
//		String result = "success";
		int cnt = bdService.insertBd(bdVO);
		if(cnt == 0) {
			resultMap.put("result", "ng");
		}
		return resultMap; 
	};
	*/
	
	// 쓰기 1개 - 파일버전
	@PostMapping("/bd")
	public Map<String, String> insertBd(BdVO bdVO) throws Exception {
		// 잭슨 라이브러리는 json문자만 해석, 바이너리 코드는 해석 불가 그래서 파라미터 어노테이션 지움!
		// JSON 전문가 유배당함!..ㅋㅋ
		log.info("readBd() 실행!!!!!!");
		log.debug("bdVO 넘어온 값 체크 {} ", bdVO);
		log.debug("bdVO 파일이름 {}", bdVO.getBdFile().getOriginalFilename());
		log.debug("bdVO 파일사이즈 {}", bdVO.getBdFile().getSize());
		
		MultipartFile fileOne = bdVO.getBdFile();
		String savePath = "d:/upload272/";
		String webPath = "/upload272/";
		
		// 실제 저장하는 작업!
		fileOne.transferTo(new File(savePath + fileOne.getOriginalFilename()));
		
		Map<String, String> resultMap = new HashMap<>();
		
		// 실패했다면?
		resultMap.put("result", "ng");
		
		// 웹 접근 경로
		webPath = webPath + fileOne.getOriginalFilename();
		// VO에 저장, DB 경로가 저장되도록
		bdVO.setBdFurl(webPath);
		
		// 성공했다면?
		int cnt = bdService.insertBd(bdVO);
		if(cnt != 0) {
			resultMap.put("result", "ok");
			resultMap.put("path", webPath);
		}
		return resultMap; 
	};

	// 쓰기 2개
	@PutMapping("/bd")
	public int updateBd(@RequestBody BdVO bdVO) {
		log.info("updateBd() 실행!!!!!!");
		log.debug("bdVO 넘어온 값 체크 {} ", bdVO);
		
		return bdService.updateBd(bdVO);
	};
	
	// 쓰기 3개
	@DeleteMapping("/bd/{bdId}")
	public int deleteBd(@PathVariable int bdId) {
		log.info("deleteBd() 실행!!!!!!");
		log.debug("int bdId 넘어온 값 체크 {} ", bdId);
		return bdService.deleteBd(bdId);
	};
	
}
