package inheritance;


// 부모 클래스 정의
class Animal {
    String name;           //String은 '클래스'가 아니라 '자료형'이고, name 변수의 타입이 String(문자열)이라는 뜻
// name은 아직 값이 없는 인스턴스 변수(필드)

    void eat() {
        System.out.println(name + "가 음식을 먹습니다.");
    }   //하지만 "선언만" 하는 건 아니고, { } 안에 있는 println이 바로 실행 코드입니다.
}

// 자식 클래스 정의 (상속: Animal)
// eat() 메서드와 필드(name)를 물려받는다
class Dog extends Animal {                  // 여기 Animal의 모든 필드와 메서드 물려받음
    void bark() {                             // bark도 Dog 객체에서 호출 시 곧바로 실행되는 동작
        System.out.println(name + "가 짖습니다.");            // name은 부모로 부터 상속받은 필드다
    }           // 그러니까 bark는 Animal에는 없는 Dog만의 기능이다
}

public class Main {
    public static void main(String[] args) {               // (String[] args)는 실행 시 외부에서 문자열 인자를 받을 수 있는 배열이라는 뜻
        Dog dog = new Dog();    // Dog라는 설계도를 가져와 dog 객체 생성  이제 dog 변수명에 객체의 참조가 저장된다
        dog.name = "바둑이";    // 부모 클래스의 필드 접근가능 name에 바둑이 저장
        dog.eat();              // 부모 클래스의 메서드 사용
        dog.bark();             // 자식 클래스의 메서드 사용
    }
}

// 상속이란? 부모 클래스의 변수와 메서드를 자식클래스가 물려받아 재사용 하는 것
// 공통 기능은 부모 클래스에 만들어 놓고, 세부적인 기능은 자식 클래스에서 확장하거나 따로 추가 가능

// 중복 코드를 제거하여 코드 가독성 및 유지 등등에 좋다

//부모 필드·메서드 → 자식 객체에서 바로 사용 가능 (private 제외)



//return은 "값을 함수 밖으로 돌려준다"라는 의미