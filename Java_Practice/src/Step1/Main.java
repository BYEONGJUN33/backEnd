package Step1;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();     // 인스턴스를 만듬
        person1.sayHello();

        person1.name = "홍길동";
        person1.age = 18;
        person1.height = 170;

        person1.sayHello();

        Person person2 = new Person("김영희", 19,180);
        person2.sayHello();
        //생성자는 인스턴스를 만들 때 딱 한 번 실행된다

    }
}
