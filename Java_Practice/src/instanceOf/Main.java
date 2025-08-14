package instanceOf;


class Animal {
    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("강아지가 멍멍 짖습니다.");
    }
    void bark() {
        System.out.println("강아지가 짖습니다.");
    }
}      // 오버라이드 & 고유 메서드 만들었음을 확인.

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("고양이가 야옹 소리를 냅니다.");
    }
    void purr() {
        System.out.println("고양이가 그르렁입니다.");
    }
}      // Dog와 같은 패턴 오버라이드 & 고유 메서드 purr()

// 메인에서 다형성 및 instanceof 사용
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        // my동물로 새로운 객체생성하여 my동물을 사용하여 기존 메서드들 주소를 참조할 수 있게됨 .
        //“변수 타입이 Animal이라도, new로 어떤 객체를 넣었느냐에 따라 동작이 달라진다.”

        // 오버라이딩(다형성)된 sound() 실행
        myDog.sound(); // 강아지가 멍멍 짖습니다.
        myCat.sound(); // 고양이가 야옹 소리를 냅니다.
        //이건 그냥 오버라이드로 sound 실행한 건데 다형성이란 게 여기서 뭘 느껴야하지? ????????????


        // instanceof로 실제 타입 확인 후 다운캐스팅        instanceof를 새로운 객체와 기존 변수객체에  대조? 해서 만약 맞다면 강아지 bark를 출력하라는 조건문
        if (myDog instanceof Dog) {
            Dog dog = (Dog) myDog;
            dog.bark(); // 강아지가 짖습니다.
        }
        if (myCat instanceof Cat) {
            Cat cat = (Cat) myCat;
            cat.purr(); // 고양이가 그르렁입니다.
        }                                         //instanceof: 변수 안에 들어있는 실제 타입을 검사 → 맞으면 다운캐스팅해서 자식 전용 기능 호출 가능.
    }
}
