package part1;

import java.util.ArrayList;

public class Excercise {

    public static void main(String[] args) {
        //ex08();
        
        //ex09();s
        //System.out.println(Math.abs(20 - 30));

        //ex08Upgrade(48,3);

        ex12(25, 5);
        
    }
    
    /**
     * 문제 08, 동전 40개, A, B 교대로 A가 먼저 동전을 가져감. 
     * 한번에 하나 이상 5개 이하만 가져 갈 수 있음. 
     * 마지막 동전을 가지는 사람이 이김. 항상 A가 이기는 전략의 알고리즘?
     */
    public static void ex08(){

        /* B 마지막 단계 직전에 6개가 남아야 한다. =>  B에게 항상 6의 배수만큼 남겨준다.*/
        int coins = 40;
        int turn = 0;

        Integer[] toBValue = {36,30,24,18,12,6,0};

        boolean sw = true; // true -> A , false -> B
        while(coins > 0){
            if(sw){
                System.out.println("======"+(turn+1)+"턴======");
                for(int i = 0; i <toBValue.length; i++){
                    //1~5범주에 드는 경우
                    if( coins - toBValue[i] > 0 && 
                        coins - toBValue[i] < 6){
                            int getAVal = (coins-toBValue[i]);
                            coins -= getAVal;
                            System.out.println("A가 "+getAVal+"만큼 가져갔다. 남은건 "+coins+"개!");
                            if(coins == 0){
                                System.out.println("A가 마지막 코인을 가져갔다. "+(turn+1)+"턴 만에 A의 승리!");
                            }
                            break;
                    }
                    else{
                        continue;
                    }
                }
                sw = false;
            }
            else{
                int getBVal = (int)(Math.random()*(5-1+1))+1;
                coins -= getBVal;
                System.out.println("B가 "+getBVal+"만큼 가져갔다. 남은건 "+coins+"개!");
                sw = true;
                turn++;
            }
        }
    }

    /**
     * 문제 09 두개의 접시에 동전이 20개 30개 있음, A, B 교대로 A가 먼저 동전을 가져감. 
     * 한번에 하나 이상 가져 갈 수 있음. 단 한접시에 있는 동전만 가져갈수 있음.
     * 마지막 동전을 가지는 사람이 이김. 항상 A가 이기는 전략의 알고리즘?
     */
    public static void ex09(){
        int plate1 = 20;
        int plate2 = 30;

        /* 
        먼저 집는 경우, 각각의 접시의 담긴 코인의 숫자를 같게 한다.
           => B턴에 담긴 개수가 같은 경우 무조건 이기게 되어있음
           => 반대로 처음부터 두 접시의 갯수 가 같다면 A가 무조건 지게 됨
           => 즉 B턴에 양 접시의 갯수가 서로 같으면 A는 무조건 이김
        */
        int turn = 0;
        boolean sw = true; // A true , B false
        while(plate1>0 || plate2>0){    
            if(sw){
                System.out.println("======"+(turn+1)+"턴======");
                int abs = Math.abs(plate2 - plate1);
                if(abs > 0){
                    if(plate2 < plate1){
                        plate1 -= abs;
                        System.out.println("A가 접시1에서 "+abs+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                    }
                    else{
                        plate2 -= abs;
                        System.out.println("A가 접시2에서 "+abs+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                    }

                    if(plate1 == 0 && plate2 == 0){
                        System.out.println("A가 마지막을 골랐다 A승");
                    }
                }
                sw = false;
            }
            else{
                int getBVal = 0;
                if(plate1==0&&plate2>0){
                    getBVal = (int)((Math.random()*(plate2-1+1))+1);
                    plate2 -= getBVal;
                    System.out.println("B가 접시2에서 "+getBVal+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                }
                else if(plate1>0&&plate2==0){
                    getBVal = (int)((Math.random()*(plate1-1+1))+1);
                    plate1 -= getBVal;
                    System.out.println("B가 접시1에서 "+getBVal+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                }
                else if(plate1>0&&plate2>0){
                    int random = (int)(Math.random()*100)%2;
                    if(random == 0){
                        getBVal = (int)((Math.random()*(plate1-1+1))+1);
                        plate1 -= getBVal;
                        System.out.println("B가 접시1에서 "+getBVal+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                    }
                    else{
                        getBVal = (int)((Math.random()*(plate2-1+1))+1);
                        plate2 -= getBVal;
                        System.out.println("B가 접시2에서 "+getBVal+"만큼 가져 갔다. 접시1 : "+plate1+"개 | 접시2 : "+plate2+"개");
                    }
                }
                sw = true;
                turn++;
            }
        }
    }

    /**
     * 문제 08 심화> 동전 N개, A, B 교대로 A가 먼저 동전을 가져감. 
     * 한번에 하나 이상 K개 이하만 가져 갈 수 있음. 
     * 마지막 동전을 가지는 사람이 이김. 항상 A가 이기는 전략의 알고리즘?
     */
    public static void ex08Upgrade(int N, int k){

        /* B 마지막 단계 직전에 6개가 남아야 한다. =>  B에게 항상 6의 배수만큼 남겨준다.*/
        
        int turn = 0;

        int coins = N;
        ArrayList<Integer> toBValue = new ArrayList<>();
        int looping = N/(k+1);
        for(int i = looping;i>=0;i--){
            toBValue.add((k+1)*i);
        }
        
        System.out.println("coins => "+coins +" | "+"최대 가져갈수 있는 개수 => "+k + " | 배수 => "+(k+1));
        System.out.println("toBValue => "+toBValue.toString());

        boolean sw = true; // true -> A , false -> B

        while(coins > 0){
            if(sw){
                System.out.println("======"+(turn+1)+"턴======");
                for(int i = 0; i <toBValue.size(); i++){
                        //1~5범주에 드는 경우
                        if( coins - toBValue.get(i) > 0 && 
                            coins - toBValue.get(i) < (k+1)){
                                int getAVal = (coins-toBValue.get(i));
                                coins -= getAVal;
                                System.out.println("A가 "+getAVal+"만큼 가져갔다. 남은건 "+coins+"개!");
                                if(coins == 0){
                                    System.out.println("A가 마지막 코인을 가져갔다. "+(turn+1)+"턴 만에 A의 승리!");
                                }
                                break;
                        }
                        else if(coins - toBValue.get(i) == 0){
                            int getAVal = (int)(Math.random()*(k-1+1))+1;
                            System.out.println("A가 어쩔수 없이 일단 "+getAVal+"만큼 가져갔다. 남은건 "+coins+"개! 상대가 똑똑하면 A가 진다.");
                            break;
                        }
                        else{
                            continue;
                        }
                    }
                    sw = false;
                }
                else{
                int getBVal = (int)(Math.random()*(k-1+1))+1;

                if(coins > getBVal){
                    coins -= getBVal;
                    System.out.println("B가 "+getBVal+"만큼 가져갔다. 남은건 "+coins+"개!");
                }
                else{
                    getBVal = coins;
                    coins -= getBVal;
                    System.out.println("B가 마지막 코인을 가져갔다. "+(turn+1)+"턴 만에 A의 승리!");
                }
                sw = true;
                turn++;
            }
        }
    }

    /**
    25마리의 말이 있다. 5마리씩 경주를 한다. 매 경기마다 같은 속도를 유지한다. 말의 속도는 서로 다름
    1> 가장 빠른 말 찾기위한 최소 경기
    2> 가장 빠른 말과 두번째로 빠른 말을 찾기위한 최소 경기
    3> 가장 빠른 말, 두번째로 빠른 말, 세번째로 빠른 말을 찾기위한 최소 경기 수
    
    구글 입사 문제 였음.....

     */
    public static void ex12(int N, int k){

        // [1] 5 : 20 ->  5 : 16 -> 5 : 12 -> 5 : 8 -> 5 : 4 -> 5 : 0 : 6번 
        // 4 마리씩 교체  5 - 1 -> k - 1
        // 25 / 4 = 6 (% 1) : ....... 잘못된 풀이 ㅜㅜ => 토너먼트를 생각하면 된다. 5개조 1등 끼리 붙임 : 6번 ???? 어라 같네...

        // [1] 토너 먼트 형태 -> 총 다섯개조 5번 경기 , 토너먼트로 1경기, 총 6경기
        // [2] 1등말 결정전까지 6경기 + 1등말의 조 2등말 + 나머지 1등말 끼리의 경기로 총 7경기 
        // [3] 1등말 결정전까지 6경기 + 1등말의 조 2등말, 3등말/ 2등말의 조 1등말, 2등말, 3등말 / 3등말의 조 1등말 이렇게 경기 하면 됨

        // 만약 k가 2면 어캐 될까. 이건 그냥 토너먼트 이기 때문 1등말 결승까지 가고 3,4위전 하면된다.

        
        // 근데이거 정렬 알고리즈.... 코드로 짜기는 애매 해서 주석으로 남김, 생각해 볼만한 여지는 있음

    }

    /**
     동전이 들어있는 10개 가방이 있음, 9개의 가방에는 10g의 동전들이 들어있고 나머지 한개는 9g의 동전들이 있음
     한 번(?) 무게를 제어 이 9g동전이 있는 가방을 찾아 내는 알고리즘 작성하라.

     한번이 뭐임 한번만임? -> 문제가 애매함..... pass -> 남은 시간 진도를 빠르게 나가기 위해 연습문제는 일단 다음시간에..
     */
    public static void ex13(){

    }




}