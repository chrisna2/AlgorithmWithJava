package inflearn.aString;

import java.util.ArrayList;
import java.util.Scanner;

/*
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1 
teachermode e

예시 출력 1
1 0 1 2 1 0 1 2 2 1 0

*/
public class ShortCharLength{

    public static void main(String[] args) {
        
        ShortCharLength T = new ShortCharLength();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));

        kb.close();

    }

    private String solution(String str, char c) {

        int idx = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();

        for(char x : str.toCharArray()){

            if(x == c){
                arr.add(idx);
            }
            idx++;
        }

        //System.out.println(arr.toString());
   

        return null;
    }

    

}