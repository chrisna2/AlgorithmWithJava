package inflearn.bArray;

import java.util.Scanner;

/*
 
설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


예시 입력 1 

5
2 3 3 1 3
1 1 2 2 3

예시 출력 1
A
B
A
B
D

 */
public class RockScissorsPaper {
 
    public static void main(String[] args) {
        
        RockScissorsPaper t = new RockScissorsPaper();

        Scanner kb =  new Scanner(System.in);

        int count = kb.nextInt();

        Integer[] arrAman = new Integer[count];
        for(int i =0; i < arrAman.length; i++){
            arrAman[i] = kb.nextInt();
        }

        Integer[] arrBman = new Integer[count];
        for(int i =0; i < arrBman.length; i++){
            arrBman[i] = kb.nextInt();
        }

        t.solution(count,arrAman,arrBman);

        kb.close();

    }

    /*
     * 절대값 ㅎㅎ
     * 나름 기상 천외하게 하긴 했는데 딱히 더 나아 보이지 않는다.....ㅎㅎ
     * for 문 돌릴 경우 비기는 경우 제외 무조건 3댑스 고정
     */
    private void solution(int count, Integer[] arrAman, Integer[] arrBman) {

        for(int i=0;i<count;i++){

            if(arrAman[i]==arrBman[i]){//1
                System.out.println("D");
            }
            else{//1
                if(2 == Math.abs(arrAman[i]-arrBman[i])){//2
                    if(arrAman[i] < arrBman[i]){//3
                        System.out.println("A");
                    }
                    else{//5
                        System.out.println("B");
                    }
                }
                else{//2
                    if(arrAman[i] > arrBman[i]){//3
                        System.out.println("A");
                    }
                    else{//3
                        System.out.println("B");
                    }
                }
            }
        }
    }

    /*
     * 가위 바위 보 게임 : 비기거나, A가 이기거나, 그 나머지는 B가 이긴다. -> 조건 5개 -> 1 ~ 5댑스
     */
    private void teacherSolution(int count, Integer[] arrAman, Integer[] arrBman) {

        for(int i=0;i<count;i++){
            //비기거나
            if(arrAman[i]==arrBman[i]){//1
                System.out.println("D");
            }
            //A가 이기거나
            else if(arrAman[i]==1 && arrBman[i]==3){//2
                System.out.println("A");
            }
            else if(arrAman[i]==2 && arrBman[i]==1){//3
                System.out.println("A");
            }
            else if(arrAman[i]==3 && arrBman[i]==2){//4
                System.out.println("A");
            }
            //그외 나머지는 B가 이김
            else{//5
                System.out.println("B");
            }
        }
    }


}
