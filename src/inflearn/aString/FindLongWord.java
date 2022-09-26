package inflearn.aString;

import java.util.Scanner;

public class FindLongWord {

    public static void main(String[] args) {
        FindLongWord T = new FindLongWord();

        Scanner kb =  new Scanner(System.in);

        //입력받을 문장일 경우 : nextLine
        String str = kb.nextLine();

        System.out.print(T.solution2(str));
    }

    private String solution(String str) {

        String answer = new String();
        String[] strArray = str.split(" ");
        
        int strLength = 0;

        for(String x : strArray){

            if(strLength < x.length()){
                strLength = x.length();
                answer = x;
            }
        }

        return answer;
    }

    private String solution2(String str){

        String answer = new String();

        int m = Integer.MIN_VALUE, pos;

        while((pos=str.indexOf(" "))!=-1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len>m){
                m = len;
                answer = tmp;
            }
            //이미 수색한 부분을 제외하고 자름
            str=str.substring(pos+1);

        }

        if(str.length()>m){
            answer = str;
        }

        return answer;

    }


    
}
