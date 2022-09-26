package inflearn.aString;

import java.util.Scanner;

public class ReverseSpecificString {
    
    public static void main(String[] args) {

        ReverseSpecificString T = new ReverseSpecificString();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();

        System.out.println(T.solution(str));
    }

    /**
     * char배열을 통해 문자열과 비문자열을 구분하는 방법을 안다.
     * @param str
     */
    private String solution(String str) {

        String answer = "";

        int start = 0;
        int end = str.length()-1;

        char[] strCharArray = str.toCharArray();

        while (start < end){

            if(!Character.isLetter(strCharArray[start])){
                start++;
                continue;
            }
            if(!Character.isLetter(strCharArray[end])){
                end--;
                continue;
            }

            char tmp = strCharArray[end];
            strCharArray[end] = strCharArray[start];
            strCharArray[start] = tmp;

            start++;
            end--;
        }

        answer = String.valueOf(strCharArray);

        return answer;    

    }

}
