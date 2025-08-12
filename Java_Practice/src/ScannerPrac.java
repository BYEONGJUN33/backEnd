import java.util.Scanner;
//스캐너 클래스가 있는 위치를 알려주는 역할

public class ScannerPrac {
    public static void main(String[] args) {
        // 키보드 입력을 받을 수 있는 Scanner 객체 sc를 만든2다는 뜻이다 system.in이 키보드 입력을 받는 스트림?이라고 한다
        Scanner sc = new Scanner(System.in);

        System.out.print("요일 번호를 입력하세요 (01=월, 2=화, 3=수, 목요일=목, Fri=금): ");
        String day = sc.nextLine();
        // System.out.print는 콘솔에 메세지를 출력해준다 -> 사용자에게 입력을 요구해줌
        // sc.nextInt ()가 입력한 숫자 받아와서  앞에 변수에 저장

        day = day.toLowerCase(); // 모두 소문자로 변환

        switch (day) {
            case "01":
                System.out.println("월요일");
                break;
            case "2":
                System.out.println("화요일");
                break;
            case "3":
                System.out.println("수요일");
                break;
            case "목요일":
                System.out.println("목요일");
                break;
            case "fri":
                System.out.println("금요일");
                break;
            default:
                System.out.println("주말");
        }


    }
}


// 스캐너는 자바에서 사용자로부터 콘솔 입력을 받기 위한 도구다
// 프로그램 실행 중 사용자가 값 입력하면 그 값을 읽어서 변수에 저장 가능