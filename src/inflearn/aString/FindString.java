package inflearn.aString;

import java.util.Scanner;

public class FindString {
    
    public static void main(String[] args) {
        
        FindString T = new FindString();

        Scanner kb =  new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));

    }


    public int solution(String str, char findChar){

        int answer = 0;

        str=str.toUpperCase();
        findChar= Character.toUpperCase(findChar);

        /*
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==findChar){
                answer++;
            }
        }
        */

        for(char x : str.toCharArray()){
            if(x == findChar){
                answer++;
            }
        }


        return answer;
    }


    public char[] solution(String[] strArray) {
        return null;
    }


}
