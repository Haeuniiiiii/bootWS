package com.junsu.sohee.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString   // 디버깅 편하게
public class Idol {
	private int sid;     //  고유값
	private String name;
	private int age;
}
