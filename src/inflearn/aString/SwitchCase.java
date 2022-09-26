package inflearn.aString;

import java.util.Scanner;

/**
 * 대소문자 변환 알고리즘
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
