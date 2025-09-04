package com.woongjin.discount.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.woongjin.discount")
public class ScanConfig { }

/// @Configuration은 뭔 기능이지 ?
//부품들을 설정하고 관리하는 특별한 목적을 가진 설정 파일

/// @ComponentScan() 이것도 뭔지 모르겠는데 basePackages 가 뭐고 뒤에 주소가 왜 오지?
// @ComponentScan: 컴포넌트(@Component, @Service, @Repository 등)를 스캔(Scan)하라는 직접적인 명령
//basePackages = "com.woongjin.discount": 스캔을 시작할 기본 폴더(패키지) 주소를 알려주는 것
//@Component가 붙은 클래스들을 모두 찾아서 스프링 빈으로 등록

//public class ScanConfig { }
//클래스에 붙은 @Configuration과 @ComponentScan 어노테이션이 실질적인 모든 일을 하기 때문에 클래스의 존재 이유는 충분