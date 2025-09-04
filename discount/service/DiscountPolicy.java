package com.woongjin.discount.service;

public interface DiscountPolicy {
    int discount(int price);  // 정가를 받아 할인금액을 반환
}

///이것도 인터페이스니까 여기 Service의 규칙을 적는 것으로 보임. -> 할인 정책 규칙
//discount라는 이름의 기능을 만들 건데,
    //이 기능은 실행이 끝나면 반드시 int 타입의 결과(할인 금액)를 돌려줘야 해
//int타입으로 price 만큼 할인?
    //(int price): "이 discount 기능이 작동하려면, 재료로 int 타입의 price(정가)를 반드시 줘야 해."
    //매개변수로 받는 것은 메서드가 작동하기 위해 필요한 재료.

// 지금까지 오버라이드 해서 이미 있는 예약어나 정해진 기능을 가져와 썼다면
// discount는 기능을 우리가 만드는 것인데, 위 구조로 새 메서드를 선언하는 것.
    //메서드(타입 이름, 매개변수)