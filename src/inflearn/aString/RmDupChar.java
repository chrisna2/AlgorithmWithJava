package inflearn.aString;

import java.util.Scanner;

/**
<<설명>>

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.


예시 입력 1 

ksekkset

예시 출력 1

kset

 */
public class RmDupChar {
    public static void main(String[] args) {
        
        RmDupChar T = new RmDupChar();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        System.out.println(T.solution(str));

        kb.close();
    }

    //String.charAt(i)과 String.indexOf(i)를 사용해서 처리
    private String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++){
            //String.indexOf(String param) : 항상 제일 앞에 있는 문자열의 인덱스만 찍음
            if(str.indexOf(str.charAt(i)) != i){
                //이미 같은 선행 되는 값이 존제하기 때문에 제거
                continue; //중복제거
            }
            else{
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
