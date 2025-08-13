package Account;

public class Main {
    public static void main(String[] args) {
        // 계좌 생성
        BankAccount account1 = new BankAccount("001", "배병준", 50000);
        //new BankAccount(...) → 설계도를 이용해 독립된 객체(인스턴스) 생성

        //입금
        account1.deposit(5000);

        //출금
        account1.withdraw(33000);

        //잔액 조회
        System.out.println("현재 잔액: " + account1.getBalance() + "원");
    }
}


//double써서 따옴표 쓰면 안됐고, account1로 독립 인스턴스 생성하여 실행 해봤으며
// getBalance()로 값 안전하게 가져와 읽음
//캡슐화를 했기에 메인에 뜨는 게 달라져보이네

//값을 바꿀 때 → deposit(), withdraw() 같은 public 메서드만 이용
//(중간에 반드시 검증 로직이 들어감 → 안전한 상태 유지)

//변수 숨기기(private) → 직접 접근 불가
//대신 public 메서드(getter/setter, 기능 메서드)로만 데이터 변경 가능

