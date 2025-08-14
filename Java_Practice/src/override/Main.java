package override;

// 부모 클래스 정의
class Animal {
    String name;
    // 부모 클래스에서 name이라는 자료형 변수 생성 String은 참조형 자료형(클래스)이고, name은 Animal 객체가 가질 '인스턴스 변수(필드)'

    // 부모의 sound() 메서드 : 기본 동물 소리
    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    } // 메서드도 만들었음 사용할때 sound로 상속받은 클래스들은 사용가능
}

// 자식 클래스 정의 (상속: Animal)
class Dog extends Animal {       // 자식 클래스 정의

    // @Override: 오버라이딩 했다고 알리는 어노테이션. 실수 방지에 도움!       // @Override : 부모 메서드를 재정의(오버라이딩)했음을 알려주는 '어노테이션'
    @Override                       //일단 여기서 오버라이딩이라는 표시인가? @를 사용하여 오버라이딩 치고 이러면 이제 Dog는 기능을 바꾸겠지?
    void sound() { // 부모와 똑같은 시그니처로 재정의(재구현)         // 부모와 시그니처(이름, 매개변수, 반환타입) 동일해야 함
        System.out.println(name + "가 멍멍 짖습니다.");              // 그러니까 Dog를 받는 name은 이 메서드를 보이겠구나
        super.sound(); // 부모의 sound()도 실행
    }

    void bark() {                                     // bark는 Dog만의 메서드로 다른 곳에서는 못쓰겠지 ? 이러면 하나의 name 받으면 둘다 출력되겠네
        System.out.println(name + "가 짖습니다."); // Dog 전용 메서드 (오버라이딩 아님)
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();       // 이 과정을 통해 1. new Dog()로 Dog 인스턴스를 메모리에 생성 2. 이 안에는 부모의 필드 메서드 포함. 3. dog 변수에는 그 객체의 주소가 저장됨
        dog.name = "바둑이";         // 바둑이 받았네 이러면 두개의 출력값 나오겠지

        // 오버라이딩 메서드 호출!
        dog.sound(); // -> "바둑이가 멍멍 짖습니다."
        dog.bark();  // -> "바둑이가 짖습니다." (Dog 고유 기능)
    }
}




//오버라이딩이란
//자식 클래스가 부모 클래스의 "메서드 이름, 매개변수, 반환타입이 똑같은 메서드"를 새로 재정의하는 것
// 왜 쓰냐?
// 부모의 기본 기능은 사용하면서, 자식에 맞게 동작을 수정하고 싶을 때 사용

//@Override는 필수는 아니지만 습관적으로 붙이는 게 좋음 (실수 방지)

//new Dog()의 의미를 **"메모리에 객체 생성 + 참조 저장"**으로 좀 더 정확히 표현


//super란 자식 클래스에서 부모 클래스의 필드나 메서드를 명확하게 사용할 때 사용하는 키워드
// 주로 오버라이디한 메서드 안에서 부모 메서드도 함께 호출할 때 많이 사용한다고 함





//19번째 줄 //부모와 시그니처(이름, 매개변수, 반환타입) 동일해야 함
// 여기서 이름은 sound
// 매개변수는 sound() 안에 둘 다 없음. -> 만약 안에 있으면 매개변수 달라진 거라 오버로딩이 된다
// 반환타입은 void로 둘다 return 없이 void기에 맞다


//*오버로딩은 같은 이름의 메서드를 여러개 정의하는 기술
// 매개변수의 개수 or 타입이 달라야 한다
// ex) int add(int a, int b)         double add(int a, int b) !오류!           int add(int a, int b, int c)            double add(double a, double b)