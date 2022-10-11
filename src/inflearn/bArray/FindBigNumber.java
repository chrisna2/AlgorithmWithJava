package inflearn.bArray;

import java.util.Scanner;

/* 
설명
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


예시 입력 1 
6
7 3 9 5 6 12

예시 출력 1
7 9 6 12
*/
public class FindBigNumber {
    
    public static void main(String[] args) {
        
        FindBigNumber t = new FindBigNumber();

        Scanner kb =  new Scanner(System.in);

        int count = kb.nextInt();
        Integer[] array = new Integer[count];

        for(int i =0; i < array.length; i++){
            array[i] = kb.nextInt();
        }

        t.solution(array);

        kb.close();

    }

    public void solution(Integer[] array){

        int beforeVal = 0;

        String result = "";

        for(int a : array){

            if(beforeVal < a){
                result += a+" ";
            }

            beforeVal = a;
        }

        System.out.println(result);

    }


}
