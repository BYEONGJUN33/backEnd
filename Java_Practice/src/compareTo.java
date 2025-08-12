public class compareTo {
    public static void main(String[] args) {
        String[] words = {"apple", "mango", "orange", "pear", "cherry"};

        for (int i = 0; i < words.length; i++) {             //i 는 첫번째 단어의 위치를 가르킨다
            for (int j = i + 1; j < words.length; j++) {     //j는 두번째 단어의 위치 가리킨다 i + 1

                //compareTO
                if (words[i].compareTo(words[j]) > 0) {
                    //자리바꾸기
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        //출력하기 결과
        for (String word : words) {
            System.out.println(word);
        }
    }
}

//사전 순서 정렬 => 단어들을 알파벳 순서대로 나열하는 것
//compareTo 메서드는 문자열을 사전식으로 비교함
// 단어들을 배열에 저장하고 -> 단어를 비교하여 사전 순서대로 정렬 -> 출력

//int result = words[4].compareTo(words[2]);
//        System.out.println(result);
// 출력값이 -12인데       c의 유니코드 99 o유니코드 111을 비교한 것임 따라서 -12 출력된 거라 한다
// => 음수 양수 0 여부를 중요하게 봐서 뭐가 뒤에 있는 지 알 수 있는 것에 중점


//for문
//바깥 for  -> 기존 단어 선택 i
//안쪽 for  -> 그 기준 단어 이후에 있는 단어들과 차례차례 비교 j
//j 를 0부터 시작하면 중복 비교가 생기기에 j = i + 1 써서 중복 제거 및 자신비교 방지