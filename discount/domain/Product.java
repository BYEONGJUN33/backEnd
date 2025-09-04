package com.woongjin.discount.domain;

import lombok.Getter;

@Getter
public class Product {
    private Long id;
    private String name;
    private int price; // 정가(원)

    // 객체를 만드는 방법을 정의한 부분이다.
    public Product(Long id, String name, int price) {
        this.id = id; this.name = name; this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}




// 상품의 이름과 가격 정보를 담는 간단한 데이터 바구니(객체)라고 생각
// 왜 final 붙이라고 노란 밑줄이 뜨지 ? => 고유값이나 '하나만 존재'해서라기보다는 불변성 때문, 노란 밑줄은 추천 기능이라함

// @Getter 애노테이션을 왜 써야 할까?
    // public Long getId() {return id;} 이런 코드들 단축 가능
    // 반복적이고 귀찮은 Getter 메서드들을 컴파일 시점에 자동으로 만들어주는 역할, 코드 가독성도 좋아짐

///public Product()로 생성자 주입 모양이랑 같은 거 아닌가?? => 여긴 '생성자'는 맞는데 '생성자 주입'은 아니다.
    //생성자의 역할: Product라는 데이터 바구니를 만들 때, 필요한 초기 데이터 id,name,price를 받아서 채워넣는 것
    //의존성 주입은 @Service나 @Repository처럼 다른 부품을 필요로 하는 클래스에서 사용될 것.
    //생성자 주입은 다른 전문가(객체)를 데려와서 협력하게 만듬

//this 멤버변수로 하는 이유도 알아야겠다
//this의 의미: this 는 '이 객체 자신'을 의미함
    //private int price는 Product 객체 안에 있는 가격을 '저장할 공간'
    //public Product(...,int price)는 객체를 만들 때 외부에서 전달해 주는 가격 데이터

///this.price = price; 코드는 이렇게 해석할 수 있습니다.
    //"이 객체 자신의(this.) price 공간에, 방금 외부에서 전달받은 price 데이터를 저장해라."
//왜 this.id = inputId; 이런 식으로 차이를 안둬서 헷갈리게 하냐?
    //=> 자바 개발자들의 약속이자 관습 "생성자로 들어오는 데이터는 클래스 내부의 변수와 이름이 같을 것이다" 라고 암묵적으로 약속

//@Override 애노테이션을 쓴 이유는 -> 오버라이드가 부모 그걸 가져와서 재정의하여 사용하는 것

//그렇기에 아래 public String toString() 이게 뭘까
    //toString의 부모는 자바의 모든 클래스가 자동으로 상속받는 Object라는 최상위 클래스.
    //toString()은 객체를 문자열로 표현할 때 사용되는, Object 클래스에 정의된 약속된 이름의 메서드

// Object 클래스 안에 들어있는 원본 (상상 속의 코드)
//public String toString() {
//    // 클래스 이름과 메모리 주소를 조합해서 반환한다.
//    return getClass().getName() + "@" + Integer.toHexString(hashCode());
//}


// 리턴값으로 Product id값과, 이름, 가격이 한 줄에 출력되겠네 문자타입이겠지 앞에 String 밖에 없으니

