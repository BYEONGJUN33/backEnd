package com.woongjin.discount.repository;

import com.woongjin.discount.domain.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class MemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> store = new ConcurrentHashMap<>();

    @Override
    public void save(Product product) {
        store.put(product.getId(), product);
    }

    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    // 데모용 초기 데이터
    @PostConstruct
    void init() {
        save(new Product(1L, "노트북", 1_500_000));
        save(new Product(2L, "키보드",   100_000));
        save(new Product(3L, "마우스",     50_000));
        System.out.println("[MemoryProductRepository] 샘플 데이터 적재 완료");
    }
}

/// @Repository
// 스프링 빈으로 등록하는 행위, @Component라는 어노테이션을 붙여도 등록되지만 더 구체적으로.
//데이터를 저장하고 조회하는 창고 역할을 전문 <- 이런 식으로

///오버라이드는 ProductRepository 인터페이스에 선언된 save와 findById 메서드를 재정의 하는 것.
//인터페이스에서 save랑 findById 메서드가 들어가라고 규칙을 세웠었고
//오버라이드 하여 오는 메서드 두개는 뒤에 {}추가 됐는데 이게 => save와 findById는 어떻게 구현하겠다라고 내용 작성

///시작할 때 implements ProductRepository를 작성하며 인터페이스 규칙을 따르겠다라는 의미


/// private final Map<Long, Product> store = new ConcurrentHashMap<>();
//Map 사물함 보관소 설계도. new ConcurrentHashMap<>(); 이걸로 실제 구축.
//<Long, Product> 보관소 규칙. <key, value> 구조 따라서 Long이 열쇠 Product가 물건이 됨.
//store 이 사물함의 이름을 정해주는 것
//결론: "store 라는 변수에는, 여러 사람이 동시에 사용해도 안전한 ConcurrentHashMap 타입의 실제 사물함을 만들어서 연결해 줘!" 라는 뜻입니다.

/// public void save(Product product) {store.put(product.getId(), product);}
//put 넣는 행위
//product에서 getid로 열쇠를 꺼낸다. (ex: 1L)
// ,product 는 전달받은 물건자체
//store.get(id): 사물함에서 물건을 꺼내는(get) 행위
    //product 장바구니에 저장하는 게 아니라, store라는 이름의 Map(사물함)에 저장하는 것

/// PostConstruct가 뭔 기능이지?
// 생성 후 초기화 작업을 의미한다.
// 스프링이 MemoryProductRepository 객체를 만들고 모든 준비(의존성 주입 등)을 마친 직후,
// 딱 한 번 자동으로 실행해주는 특별한 메서드

/// 1L, 2L ... 왜 귀찮게?
// 실제 애플리케이션에서는 DB가 자동으로 1,2,3.. 순서대로 고유한 id를 생성해주는 기능을 사용한다.
// 하지만 지금은 DB가 아닌 데모용이기에 기능 테스트와 개발 편의를 위해 샘플 데이터를 하드코딩.
