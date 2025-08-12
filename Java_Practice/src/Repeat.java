public class Repeat {
    public static void main(String[] args) {

        int n = 45;
        int evenSum = 0; //초기값 선언 0부터 더해질 것
        int oddSum = 0;

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
        }

        System.out.println("짝수 합 : " + evenSum);
        System.out.println("홀수 합 : " + oddSum);
    }
}



// 과제 2 ========= 반복문 사용하여 1부터 N까지 짝수 합 & 홀수 합 구하기   n은 45로 해봅시다..

// if(num % 2 == 0) → 짝수
// if(num % 2 != 0) → 홀수

//for (①초기식; ②조건식; ④증감식) {
//    ③반복할 코드                 }
//① 초기식: 반복에 사용할 변수 i의 시작값 설정 (i = 1)
//② 조건식 검사: 조건이 참(true) 이면 반복문 안으로 들어가고, **거짓(false)**면 반복 종료
//③ 반복문 본문 실행: 조건이 참일 때 실행할 코드
//④ 증감식 실행: i++나 i-- 등 값 변경 → 다시 ②로 돌아감
