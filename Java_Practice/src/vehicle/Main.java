package vehicle;



// 부모 클래스 : 모든 차량의 공통 속성과 동작 정의
class Vehicle {
    String brand;                               // 차량 브랜드 필드
    String model;                               // 차량 모델명 필드

    // 생성자(Constructor): 객체 생성 시 brand, model 초기화
    Vehicle(String brand, String model) {
        // this는 "현재 생성 중인 객체 자기 자신"을 가리킴
        // this.brand = brand; → 필드와 매개변수 이름이 같을 때 구분하기 위해 사용
        this.brand = brand;
        this.model = model;
    }

    // 공통 대여 메서드: 모든 차량이 기본적으로 제공하는 기능
    void rent(int days) {
        System.out.println(brand + " " + model + " 차량을 " + days + "일 대여합니다.");
    }
}

// 자식 클래스 : 승용차
class Car extends Vehicle {  // Vehicle을 상속 → brand, model 필드와 rent() 메서드 물려받음
    // Car 생성자: Vehicle 생성자를 호출하여 brand, model 초기화
    Car(String brand, String model) {
        super(brand, model); // super()는 부모 생성자를 호출하는 예약어
    }

    @Override // 부모의 rent()를 재정의 → 승용차 요금체계 적용
    void rent(int days) {
        int fee = 50000 * days; // 승용차 대여 요금 = 5만원 * 대여일수
        System.out.println(brand + " " + model + " (승용차) " + days + "일: " + fee + "원");
    }
}

// 자식 클래스 : 트럭
class Truck extends Vehicle {
    Truck(String brand, String model) {
        super(brand, model); // 부모 생성자 호출 → 필드 초기화
    }

    @Override // 부모 rent() 대신 트럭 전용 요금체계 적용
    void rent(int days) {
        int fee = 80000 * days;
        System.out.println(brand + " " + model + " (트럭) " + days + "일: " + fee + "원");
    }

    // 트럭 전용 메서드: 화물 적재 기능
    void loadCargo() {
        System.out.println(brand + " " + model + "에서 화물을 싣습니다.");
    }
}

// 자식 클래스 : 전기차
class ElectricCar extends Vehicle {
    ElectricCar(String brand, String model) {
        super(brand, model);
    }

    @Override // 부모 rent() 대신 전기차 전용 요금체계 적용
    void rent(int days) {
        int fee = 70000 * days;
        System.out.println(brand + " " + model + " (전기차) " + days + "일: " + fee + "원 (충전비 별도)");
    }
}

// 실행 클래스
public class Main {
    public static void main(String[] args) {

        // [다형성] 부모 타입 배열에 서로 다른 자식 객체(Car, Truck, ElectricCar) 저장
        // 부모 타입(Vehicle)으로 선언 → 모든 자식 타입(Car, Truck, ElectricCar)을 한 번에 관리 가능
        Vehicle[] vehicles = {
                new Car("Hyundai", "Sonata"),
                new Truck("Kia", "Bongo"),
                new ElectricCar("Tesla", "Model 3")
        };

        // 배열 반복 처리
        for (Vehicle v : vehicles) { // vehicles 배열에서 하나씩 꺼내 Vehicle 타입 변수 v에 저장
            v.rent(3); // 오버라이딩된 rent() 실행 → 실제 객체의 타입(Car, Truck, ElectricCar)에 맞는 메서드 호출

            // [instanceof] 특정 타입인지 확인 후, 해당 타입만의 기능 사용
            if (v instanceof Truck) {
                // 다운캐스팅(부모 타입 → 자식 타입) 후 Truck 전용 메서드 loadCargo() 실행
                ((Truck) v).loadCargo();
            }

            System.out.println(); // 줄바꿈
        }
    }
}

//this → 현재 객체 자신을 가리키는 참조, 필드와 매개변수 이름이 같을 때 구분하는 용도로 자주 사용.
//
//super → 부모 생성자나 부모 메서드 호출에 사용, 여기서는 부모 생성자로 필드 초기화를 맡김.
//
//생성자 → 객체 생성 시 필드를 초기화하는 특별한 메서드(클래스 이름과 동일, 반환타입 없음).
//
//다형성 → 부모 타입 변수/배열에 여러 자식 타입 객체를 담아, 공통 메서드를 호출할 때 실제 객체 타입에 맞는 동작이 실행됨.
//
//instanceof → 실제 객체의 타입을 런타임에 확인한 뒤, 다운캐스팅하여 자식 전용 기능을 안전하게 호출.


// 상속으로 물려받아 쓰고 오버라이딩으로 재정의 하여 사용할 수 있는 것을 배웠고
// instanceof를 if 조건문으로 자식이면 실행되게끔 사용하는 방법을 배웠다