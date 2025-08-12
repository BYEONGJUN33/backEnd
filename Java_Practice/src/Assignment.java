// 2025 08 11 JAVA 과제2
public class Assignment {
    public static void main(String[] args) {
        String storedID = "Admin";
        String inputID = "admin";

        if (storedID.equalsIgnoreCase(inputID)) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("아이디가 일치하지 않습니다.");
        }

    }
}

//자바에서 문자열의 내용 비교는 equals() 메서드 사용 *대소문자 구분됨
//따라서 equalsIgnoreCase() 메서드 사용하여 해보기
// ==으로 문자열의 주소 비교
// 1. 아이디 지정하고 나머지 대소문자 구분없이 비교할 수 있게 해야함 같으면 로그인 ㅅ성공 출력되도록 하자
