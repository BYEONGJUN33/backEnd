package Step1;

public class Person {

    public Person() {
        name = "무명";
        age = 100;
        // 기본 생성자 초기값
    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    String name;

    int age;

    int height;


    public void sayHello(){
        System.out.println("안녕, 내 이름은 "+ name + "나이는 " + age + "몸무게는 " + height);



    }
}
