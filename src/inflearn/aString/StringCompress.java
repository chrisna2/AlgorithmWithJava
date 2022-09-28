package inflearn.aString;

import java.util.Scanner;

/*
설명

알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 압축된 문자열을 출력한다.

예시 입력 1 
KKHSSSSSSSE
예시 출력 1
K2HS7E

예시 입력 2 
KSTTTSEEKFKKKDJJGG
예시 출력 2
KST3SE2KFK3DJ2G2

 */
public class StringCompress {
    
    public static void main(String[] args) {
        
        StringCompress T = new StringCompress();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        System.out.println(T.mysolution(str));

        kb.close();
    }

    private String mysolution(String str) {

        int p = 1; //초기화 기준은 언제나 최소값기준
        char[] chararr = str.toCharArray();
        
        String answer = String.valueOf(str.charAt(0));
        char before = str.charAt(0);

        for(int i = 1; i < chararr.length; i++){
            
            if(chararr[i] == before){
                p++;
            }
            else{
                if(p != 1){
                    answer += p;
                }
                answer += chararr[i];
                p = 1;
            }
            before = chararr[i];
        }

        if(p>1){
            answer += p;
        }

        return answer;
    }

    

}
