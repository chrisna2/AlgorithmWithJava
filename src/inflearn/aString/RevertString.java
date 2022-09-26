package inflearn.aString;

import java.util.Scanner;

/*
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


예시 입력 1 
3
good
Time
Big

예시 출력 1
doog
emiT
giB
 */
public class RevertString {
    
    public static void main(String[] args) {
        
        RevertString T = new RevertString();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        int count = Integer.parseInt(str);


        String[] strArray = new String[count];

        for(int i =0;i<count;i++){
            strArray[i] = kb.next();
        }

        T.solution(strArray);

        kb.close();

    }

    /**
     * StringBuilder 기능을 익힌다.
     * @param strArray
     */
    private void solution(String[] strArray) {

        for(String x : strArray){
            // * StringBuilder : 메서드 체인을 사용
            // String 자체는 값이 내부적으로 변경되기 어려움 객체를 계속 변경되어야 함
            // StringBuilder 만들어진 객체 1개로 내부적으로 변경이 가능, 메모리 누수없이 문자열 변경이 가능
            String sb = new StringBuilder(x).reverse().toString();
            System.out.println(sb.toString());
        }

    }


}
