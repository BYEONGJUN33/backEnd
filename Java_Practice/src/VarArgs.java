public class VarArgs {
    public static void main(String[] args) {
        int[] anyNum = {4, 3, 22, 2, 9, 8, 7};

        int sum = 0;        // 합 저장 변수
        double average = 0; // 평균 저장 변수

        // 합 구하기 파트
        for (int num : anyNum) { //배열안에서 하나씩 꺼내어 num에 넣음
            sum += num;          //sum = sum + num

        }

        // 평균 구하기 파트
        average = (double) sum / anyNum.length;


        System.out.println("합 : " + sum  );
        System.out.println("평균 : " + average);
    }
}



// 과제 3 ========================= 숫자를 받아 합과 평균 구하기 Sum & Avg 구하고 -> 여러개를 배열처리 하고 -> 평균 = 합 나누기 개수
// 배열 여러 숫자 넣고 length로 개수 구하여 평균 구하기

//for (자료형 변수명 : 배열이름) {        // => 배열 안에서 하나씩 꺼내 변숫명에 넣고 {} 안에 코드 실행해라
    // 변수명으로 요소 사용할 수 있다
//}

// double 실수형을 사용하여 소수점 있는 수로 연산

// .length로 길이 구해 나누기

//for each 문으로 단순 반복 가능
