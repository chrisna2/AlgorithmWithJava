package inflearn.aString;

import java.util.Scanner;

/*
설명

대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.


예시 입력 1 

StuDY

예시 출력 1

sTUdy
 */
public class SwitchCase {
    public static void main(String[] args){
        SwitchCase T = new SwitchCase();

        Scanner kb =  new Scanner(System.in);

        //입력받을 문자열
        String str = kb.next();

        System.out.print(T.solution(str));

        kb.close();
      }

      public String solution(String str){

        String answer = "";
        
    
        // 문자열 대소문자 변환 1 : java 유틸 기능 활용
        for(char x : str.toCharArray()){
            if(Character.isUpperCase(x)){
                answer += Character.toLowerCase(x);
            }
            else{
                answer += Character.toUpperCase(x);
            }
        }

         /*
        // 문자열 대소문자 변환 2 : ASCii 문자열 번호 활용
        for(char x : str.toCharArray()){
            if(x>=97 && x<=122){
                answer += (char)(x-32);
            }
            else{
                answer += (char)(x+32);
            }
        }
        */

        return answer;

      }



}
