package com.woongjin.discount.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 스프링 빈에 등록하는 행위
@Primary //기본 전략으로 사용 (Qualifier 없이 주입됨)
public class RateDiscountPolicy implements DiscountPolicy {

    private final int ratePercent = 10; // 10% 할인

    @Override
    public int discount(int price) {
        return price * ratePercent / 100;
    }
}

//@Primary 어노테이션으로 => 상시 구현이 아니라 '기본 선택 옵션'으로 이해하는 게 좋다.
    //나중에 Rate 이 클래스 말고 다른 구현체가 FixDiscount 같이 여러개가 생길 수 있어서 이를 대비하기 위해 기본값 지정

//implements로 정책 규픽을 따르겠다고 선언

// private로 정보 숨기고 final로 불변한다 선언하고 자료타입은 int에 ratePercent = 10이 오는데
// 근데 private final은 왜 적지? -> 이 할인율은 클래스만의 비밀  레시피 같은 것, 10%할인율을 고정되어 바뀌지 않을것.
//그리고 ratePercent가 오는데 이는 상수 선언!, 메서드가 아니며 계산을 돕기위해 값을 저장해두는 변수.

//오버라이드해서
//이거를 리턴값으로 price * ratePercent / 100
// 즉 10000원짜리가 있고 10분의1로 곱하니까 1000원이 되는데? 엥 그럼 90%할인????
/// => int discount(int price); // 정가를 받아 '할인금액'을 반환
// 따라서 1000원이 나온 게 할인값이 1000이라
// 최종금액 = 정가 10000 - 할인값 1000 = 90000
// discount 1000원이 된다고 읽었어야함 ....

