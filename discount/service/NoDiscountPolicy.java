package com.woongjin.discount.service;

import org.springframework.stereotype.Component;

@Component
public class NoDiscountPolicy implements DiscountPolicy {
    @Override public int discount(int price) { return 0; }
}


//Component 어노테이션으로 또 스프링 빈 이름을 지정 --> 같은 소속이 된 것.
/// 팀 비유로는... 이런 느낌 => 역활이 명확해짐, 팀별로 스프링 기능 존재.
//@Component: 그냥 '일반 주민'입니다.
//@Repository: '창고 관리팀' (데이터 담당)
//@Service: '핵심 전략팀' (비즈니스 로직 담당)
//@Controller: '고객 응대팀' (웹 요청 담당)

//왜 NoDiscountPolicy가 필요한가?????????
//할인 안할 거면 그냥 적지 말지. => if/else가 없는 구조를 만들기 위해서.
//예시보니 이런 인터페이스 정책 구조를 사용하지 않으면 if else로 10%할인로직/2000원할인로직/할인없음 등등
//새로운 할인 정책이 생길 때마다 코드를 직접 수정해야하는데
//이따 만들 CheckoutService클래스는 '할인'이라는 행위를 직접하지 않는다.
// 대신 할인 전문가인 DiscountPolicy를 고용하여 그에게 맡기는 것.
//CheckoutService: "할인 전문가님, 이 상품 가격이 10,000원인데, 할인액이 얼마죠?" => 다른 Policy가 적용되어 맡는 할인율 적용해주는 구조
// 그니까 NoDiscountPolicy는 "할인 없음"이라는 역할을 담당하는 전문
/// NoDiscountPolicy는 '할인 없음' 상황을 '아무것도 안 함'이 아니라, '0원을 할인하는' 하나의 동작(전략)으로 취급하여 코드의 일관성과 유연성을 지켜주는 아주 중요한 장치
// 그냥 이 구조로 틀 다 만들고 원하는 거 요청 후 그냥 받아 쓰기만 하면 되는 구조. => 인터페이스 의존 프로그래밍의 장점

// implements로 정책 따른다 선언

//오버라이드로 정책을 재정의
    //리턴값을 0을 주면서 이 discount 메서드를 무효 시키면서 Product의 price 값이 그대로 나타나겠네.