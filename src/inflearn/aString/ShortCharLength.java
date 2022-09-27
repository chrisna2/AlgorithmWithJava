package inflearn.aString;

import java.util.ArrayList;
import java.util.Arrays;
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

        T.solution(str, c);

        kb.close();

    }

    private void mysolution(String str, char c) {
        
        //두개의 배열 필요
        //정방향, 역방향 조회

        Integer[] right = new Integer[str.length()];
        Integer[] left = new Integer[str.length()];

        char[] charArr = str.toCharArray();

        int p = 1000; //작은 값을 비교 하기 위한 셋팅
        // 정방향으로
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == c){
                p = 0;
                right[i] = p;
            }
            else{
                p++;
                right[i] = p;
            }
        }
        
        //System.out.println(Arrays.asList(right).toString());

        p = 1000;
        // 역순으로
        for(int i = charArr.length-1; i > -1; i--){
            if(charArr[i] == c){
                p = 0;
                left[i] = p;
            }
            else{
                p++;
                left[i] = p;
            }
        }

        //System.out.println(Arrays.asList(left).toString());
        // 배열을 두개 만들어서 서로비교해서 작은 값을 보여준다.
        for(int i = 0; i < charArr.length; i++){

            if(right[i] < left[i]){
                System.out.print(right[i]);
            }
            else if(right[i] > left[i]){
                System.out.print(left[i]);
            }
            //같으면 
            else{
                System.out.print(left[i]);//아무거나 상관없음
            }

            System.out.print(" ");
        }
    }

    /**
     * 배열 한개로 처리
     * @param str
     * @param c
     */
    private void solution(String str, char c) {
        
   
        //정방향, 역방향 조회
        Integer[] idxarry = new Integer[str.length()];

        char[] charArr = str.toCharArray();

        int p = 1000; //작은 값을 비교 하기 위한 셋팅
        // 정방향으로
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == c){
                p = 0;
                idxarry[i] = p;
            }
            else{
                p++;
                idxarry[i] = p;
            }
        }
        
        //System.out.println(Arrays.asList(right).toString());

        p = 1000; //초기화
        // 역순으로
        for(int i = charArr.length-1; i > -1; i--){
            if(charArr[i] == c){
                p = 0;
                System.out.print(idxarry[i]);
            }
            else{
                p++;
                //JAVA : Math.min 사용하여 적용 작은 값을 찾아서 바꿔줌
                idxarry[i] = Math.min(idxarry[i], p);
                System.out.print(idxarry[i]);
            }
            System.out.print(" ");
        }

    }

}