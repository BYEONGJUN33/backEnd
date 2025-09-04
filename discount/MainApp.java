package com.woongjin.discount;

import com.woongjin.discount.config.ScanConfig;
import com.woongjin.discount.service.CheckoutService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var ac = new AnnotationConfigApplicationContext(ScanConfig.class);

        //클래스 명       변수 이름 =
        CheckoutService checkout = ac.getBean(CheckoutService.class);
        checkout.checkout(1L);
        checkout.checkout(2L);
        checkout.checkout(33333L);

        ac.close();
    }
}

// psvm 문법으로 이 클래스가 실행기.

/// AnnotationConfigApplicationContext의 정체
// 스프링 컨테이너 자체, "자바 설정 파일(ScanConfig.class)을 읽어서, 어노테이션 기반으로 작동하는 스프링 컨테이너(마을)를 새로 건설해라!" 라는 명령
// 코드가 실행되면 Scan돼서 @Component 붙은 모든 클래스를 빈으로 등록하고 의존성 주입까지 마쳐서 조립을 끝낸다?

//var ac = ...
// var은 JAVA10부터 생긴 타입을 추론해주는 키워드

//ac는 Application Context의 줄임말 , 스프링 컨테이너를 가리키는 변수 이름

/// ac.getBean(CheckoutService.class)
//CheckoutService라는 전문가를 데려와라. => 완성된 빈(객체)를 꺼내오는 기능
//즉 checkout 변수에 전문가 담김

/// checkout.checkout(1L)   => 변수에 담긴 전무가의 메서드 이름 checkout과 매개변수
//[변수 이름].[메서드 이름](매개변수);

///ac.close()
//스프링 컨테이너(마을)의 문을 닫고 모든 자원을 정리하라는 명령

//이때 @PreDestroy 어노테이션이 붙은 메서드가 있다면 그 메서드가 실행되면서 마지막 정리 작업을 수행하게 됩니다. 이것이 바로 빈 소멸(destroy) 생명주기 콜백
