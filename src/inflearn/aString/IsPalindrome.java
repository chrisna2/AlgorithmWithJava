package inflearn.aString;

import java.util.Scanner;

/*
설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


예시 입력 1 
gooG

예시 출력 1
YES

 */
public class IsPalindrome {
    public static void main(String[] args) {
                
        IsPalindrome T = new IsPalindrome();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        System.out.println(T.solution(str));

        kb.close();
    }

    private String mySolution(String str) {

        int start = 0;
        int end = str.length()-1;

        char[] charArry = str.toCharArray();

        while(start < end){
            //문제를 잘 읽자 : 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
            if(Character.toLowerCase(charArry[start]) == Character.toLowerCase(charArry[end])){
                start++;
                end--;
            }
            else{
                return "NO";
            }
        }

        return "YES";
    }

    //StringBuilder로 더 간단하게 처리하는 방법
    private String solution(String str){
        String answer = "YES";
        //StringBuilder method체인 기법 실행
        String tmp = new StringBuilder(str).reverse().toString();
        //equalsIgnoreCase : 대소문자 무시하고 비교 처리
        if(!str.equalsIgnoreCase(tmp)){
            answer = "NO";
        }

        return answer;
    }

}
