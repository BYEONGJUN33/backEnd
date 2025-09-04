package com.woongjin.discount.repository;

import com.woongjin.discount.domain.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
}

//우선 왜 인터페이스 ProductRepository를 만들었냐? 왜 인터페이스지? 클래스가 아니라?
    //운전석의 엑셀,브레이크와 같은 '역할'또는 '규칙'을 정의하는 것
        //ProductRepository인터페이스 : 상품 저장소라면 save와 findById라는 기능이 있어야 한다고 규칙만 선언!!
        //인터페이스로 규칙만 선언한 것을 이제 클래스가 규칙을 실제로 구현하는 '실제 구현체'
/// 왜 이렇게 하는데? => 나중에 저장 방식을 메모리에서 데이터베이스로 바꿀 때 다른 서비스 코드를 변경할 필요X 클래스만 바꾸면 됨.

/// 위 내용이 전략 패턴. 인터페이스는 다양한 전략들이 따라야 할 공통 규칙.

//(Product product): Product 타입의 데이터를 product라는 이름의 바구니에 담아서 전달할 거야.
//void save(...): "save라는 기능(메서드)을 실행할 건데, 이 기능은 실행 후 돌려주는 값(return)은 없어(void)."
//Long id: "상품을 찾기 위한 재료로 Long 타입의 id 값을 전달해 줄 거야."
//Product findById(...): "findById라는 기능을 실행할 건데, 이 기능은 실행이 끝나면 Product 타입의 데이터를 반드시 돌려줘야 해."
///결론: ProductRepository는 "Product를 주면 저장해주고(save), id를 주면 저장된 Product를 찾아주는(findById) 역할을 하는 녀석이다" 라고 명시하는 것입니다.

