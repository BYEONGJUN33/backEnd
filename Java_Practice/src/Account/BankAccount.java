package Account;

public class BankAccount {
    //1. 멤버 변수(필드) - private로 캡슐화 진행
    private String accountNumber;
    private String owner;
    private double balance;

    //2. 생성자
    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("초기 잔액은 0이상이어야 합니다. 0으로 설정합니다.");
            this.balance = 0;
        }
    }

    //3. Getter 조회 단계
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getOwner() {
        return owner;
    }
    public double getBalance() {
        return balance;
    }

    //4. 입금 메서드
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + "원 입금 완료. 현재 잔액: " + balance + "원" );
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    //5. 출금 메서드
    public void withdraw(double amount) {
        if(amount > 0) {
            balance -= amount;
            System.out.println(amount + "원 출금 완료. 현재 잔액: " + balance + "원");
        }else {
            System.out.println("출금 실패");
        }
    }


}


//캡슐화?
// 클래스 내부의 데이터와 기능을 외부에 직접 공개하지 않고,**필요한 데이터는 메서드를 통해서만 접근, 수정 가능하게 하는 것
//변수(필드)는 private로 감춘 뒤 public getter/setter 메서드로 값을 읽거나 바꾸게 만들기
// 캡슐화 하면 데이터 보호 및 코드 안정성 유지보수에 좋다.
// 검증이 필요한 입력엔 반드시 조건문을 넣어야한다 .
// 생성자에서 초기화 때도 값체크, 에러 메세지 등 친절하게 처리
// 객체 지향의 설계 흐름 (데이터 은닉 -> 인터페이스로 기능 노출) 흐름으로


//BankAccount → 계좌 객체를 만들 수 있는 설계도(클래스)