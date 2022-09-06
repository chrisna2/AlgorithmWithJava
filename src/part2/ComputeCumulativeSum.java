package part2;

import java.util.ArrayList;

public class ComputeCumulativeSum {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> FREQ = new ArrayList<>();
        FREQ.add(1);
        FREQ.add(0);
        FREQ.add(7);
        FREQ.add(5);
        FREQ.add(4);
        FREQ.add(6);
     
        computeCumulativeSum2(FREQ);


    }    
    /**
     * 0<= i < n 일때
     * FREQ[i]는시험에서 등급 i를 받은 학생들의 수를 저항한다 등급은 자연수.
     * CUME[i]는시험에서 i등급 이하의 수를 저장한다.
     * 
     * 빈도의 누계를 계산한다.
     * 입력 : FREQ[] 시험 등급들의 빈도 배열 
     * 출력 : CUME[] 누계빈도들의 배열
     * @param n
     */

    // 시간 복잡도 2차 선형 O(n^2) 인 알고리즘
    public static void computeCumulativeSum1(ArrayList<Integer> FREQ){
        
        System.out.println("FREQ => "+FREQ.toString());

        ArrayList<Integer> CUME = new ArrayList<>();
        
        //한번 연산하고
        for(int i = 0; i< FREQ.size(); i++){

            int sum = 0;
            // 두번 연산한다. -> 중복 연산 발생
            for(int j = 0; j <= i; j++){
                sum = sum + FREQ.get(j);
            }

            CUME.add(sum);
            //CUME.set(i, sum);

        }

        System.out.println("CUME => "+CUME.toString());
    }


    // 시간 복잡도 1차 선형 O(n) 인 알고리즘
    public static void computeCumulativeSum2(ArrayList<Integer> FREQ){
        
        System.out.println("FREQ => "+FREQ.toString());

        ArrayList<Integer> CUME = new ArrayList<>();
        
        //첫번째 건 그냥 1차로 누계 시킴
        CUME.add(FREQ.get(0));
        //그 다음부턴 이전의 누적분에 새로운 것을 차례로 누적 시킴
        for(int i=1;i<FREQ.size();i++){ 
            int sum = CUME.get(i-1) + FREQ.get(i);
            CUME.add(sum);
        }

        System.out.println("CUME => "+CUME.toString());
    }


}
