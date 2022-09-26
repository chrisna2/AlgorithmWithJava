package inflearn.aString;

import java.util.Scanner;

/**
 * 강의 안보고 풀음
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
