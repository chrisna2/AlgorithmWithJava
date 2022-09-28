package inflearn.aString;

import java.util.Scanner;

/*
설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
단어를 답으로 합니다.


예시 입력 1 
it is time to study

예시 출력 1
study

 */
public class FindLongWord {

    public static void main(String[] args) {
        FindLongWord T = new FindLongWord();

        Scanner kb =  new Scanner(System.in);

        //입력받을 문장일 경우 : nextLine
        String str = kb.nextLine();
        
        System.out.print(T.solution2(str));

        kb.close();
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
