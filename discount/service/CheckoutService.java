package com.woongjin.discount.service;

import com.woongjin.discount.domain.Product;
import com.woongjin.discount.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final ProductRepository productRepository;
    private final DiscountPolicy discountPolicy;

    public CheckoutService(ProductRepository productRepository,
                           DiscountPolicy discountPolicy) {
        this.productRepository = productRepository;
        this.discountPolicy = discountPolicy;
    }

//    discount 없는 방식으로 전략 변경 시
//    public CheckoutService(ProductRepository productRepository,
//                           @org.springframework.beans.factory.annotation.Qualifier("noDiscountPolicy")
//                           DiscountPolicy discountPolicy) {
//        this.productRepository = productRepository;
//        this.discountPolicy = discountPolicy;
//    }

    public int checkout(Long productId) {
        //생성자로 만든 메서드를 사용하여 상품을 찾아온다.
        Product p = productRepository.findById(productId);
        if (p == null) throw new IllegalArgumentException("상품 없음: " + productId);

        //메서드로 할인 금액을 계산한다.
        int discount = discountPolicy.discount(p.getPrice());
        int finalPrice = p.getPrice() - discount;

        System.out.printf("[결제] 상품=%s, 정가=%d, 할인=%d, 결제금액=%d%n",
                p.getName(), p.getPrice(), discount, finalPrice);

        return finalPrice;
    }
}

//Service라는 새로운 어노테이션이 등장. 새로운 팀으로 스프링 빈 생김.

/// 생성자(CheckoutService(...)) => **********의존성 주입
// 1. 필드 선언 private final... 설계도 선언 현재는 비어있는 상태.
// 2. 생성자 public CheckoutService(...) 조립설명서, (매개변수)안에 있는 것을 외부에서 전달 받는다.
    // this로 이 받아온 텅 비어있는 공간에 실제로 주입.
// 그니까 처음부터 뭐가 필요하다고 선언한 것. 필수적으로 필요해.
// 그럼 생성자쪽에서 () 이걸로 재료를 받아왔고,
// 받아온 재료를 알맞은 this 공간에 넣으라고 지시.
// 이를 통해 구현체를 받아서 클래스 내부에서 실행?? 실제로 이렇게 만들고 지시하고 뚝딱 만들었어, 그럼 조립한 걸로 뭐해? 조립된 걸로 뭐하는 거지?
/// 생성자에서 조립한 productRepository와 discountPolicy가 CheckoutService에 조립되어 언제든 사용 가능 => checkout()메서드로 쓰임

/// checkout 메서드
//IllegalArgumentException => 에러 경고등, 비정상적으로 종료되며 에러메세지 남김.
// checkout 메서드를 의존성 주입(맡기기)으로 조립하여 만들었으며, 이는 유연성과 확장성의 이득을 본다.

/// @org.springframework.beans.factory.annotation.Qualifier("noDiscountPolicy")
//Qualifier로 특정 집어서 데려오기 위함.  위 형식은 전체 주소를 적은 것이고 보통은 위에 import와 @Qualifier
//@Primary보다 우선순위.

//sout에 적힌 %는 형식에 맞게 출력하라는 뜻
// %s 문자열, %d 10진수 정수, %n 줄바꿈
// 자리 순서를 맞춰서 첫번쨰 자리에 Name 값 들어가며 순서대로 채워서 출력해줌

