public class Calculator {
    public static void main(String[] args) {
        int a = 133;
        int b = 11;
        char op = '^' ;

        switch (op) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '^':
                System.out.println(a + " ^ " + b + " = " + Math.pow(a, b));
                break;
            case '/':
                 System.out.println(a + " / " + b + " = " + ((double) a / b));
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다.");


        }

    }
}


//과제 4 ============= 계산기 프로그램 만들기
// 1. 산술 연산자 -> 더하기 빼기 곱하기 나누기(double)]
// 2. switch-case 여러 조건 중 하나를 선택하여 실행, if-else 보다 특정 값 비교에 간단함,
// brack 필수 -> 없으면 다른 case들도 실행된다
// 3. 변수 준비하기  -> 숫자 2개 ,  연산자 1개

//char 이어서 작은 따옴표 '' 사용
// switch (op) 로 op ㅇㄴ에 있는 연산자 가져와서 해당 case 실행

// break 없애보니 출발 case에서 없으면 아래 break있는 case까지 전부 실행됨

// 거듭제곱은 다음에 차차