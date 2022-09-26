package inflearn.aString;

import java.util.Scanner;

/*
설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


예시 입력 1 

a#b!GE*T@S
예시 출력 1

S#T!EG*b@a
 */
public class ReverseSpecificString {
    
    public static void main(String[] args) {

        ReverseSpecificString T = new ReverseSpecificString();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        System.out.println(T.solution(str));

        kb.close();
    }

    /**
     * char배열을 통해 문자열과 비문자열을 구분하는 방법을 안다.
     * @param str
     */
    String solution(String str) {

        String answer = "";

        int start = 0;
        int end = str.length()-1;

        char[] strCharArray = str.toCharArray();

        while (start < end){

            if(!Character.isLetter(strCharArray[start])){
                start++;
                continue;
            }
            if(!Character.isLetter(strCharArray[end])){
                end--;
                continue;
            }

            char tmp = strCharArray[end];
            strCharArray[end] = strCharArray[start];
            strCharArray[start] = tmp;

            start++;
            end--;
        }

        answer = String.valueOf(strCharArray);

        return answer;    

    }

}
