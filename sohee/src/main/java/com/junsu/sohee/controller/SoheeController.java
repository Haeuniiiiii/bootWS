package com.junsu.sohee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junsu.sohee.vo.Idol;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@Slf4j
@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class SoheeController {

	// 메모리상에서 관리
	private static List<Idol> idols = new ArrayList<>();
	
	@PostConstruct  // 객체 생성 뒤에 자동 실행 
	public void myInit() {
		Idol idol = null;
		for(int i=1; i<=7; i++) {
			idol = new Idol();
			idol.setSid(i);
			idol.setName("아이돌"+i);
			idol.setAge(20+i);
			idols.add(idol);
		}
	}
	
	// 리스트
	@GetMapping("/idols")
	public List<Idol> getIdols() {
		return idols;  // 잭슨 라이브러리가 동작해서 결과를 JSON문자열로 바꾸어 줌
	}
	
	// 개별 찾기
	@GetMapping("/idols/{sid}")
	public Idol getIdol(@PathVariable int sid) {
		for (Idol idol : idols) {
			if(idol.getSid() == sid) {
				return idol;
			}
		}
		return null;  // 못 찾았다면
	}

	// 생성
	@PostMapping("/idols")
	public Idol insIdol(@RequestBody Idol idol) {
	    log.debug("체킁 {}",idol)	;  // 이 습관이 엄청 중요, 개발자는 항상 값을 눈으로 볼수 있게
	    idols.add(idol);  // 추가
		return idol;
	}
	
	// 수정
	@PutMapping("/idols")
	public Idol updIdol(@RequestBody Idol uidol) {
	    log.debug("체킁 {}",uidol)	;  // 이 습관이 엄청 중요, 개발자는 항상 값을 눈으로 볼수 있게
	   
	    for (Idol idol : idols) {
			if(idol.getSid() == uidol.getSid()) {
				idol.setName(uidol.getName());
				idol.setAge(uidol.getAge());
				break;
			}
		}
		return uidol;
	}

	@DeleteMapping("/idols/{sid}")
	public String delIdol(@PathVariable int sid) {
		for (Idol idol : idols) {
			if(idol.getSid() == sid) {
				idols.remove(idol);
				break;
			}
		}
		return sid + "";
	}
	
}
