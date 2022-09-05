package part1;

import java.util.ArrayList;

public class Excercise {

    public static void main(String[] args) {
        //ex08();
        
        //ex09();
        //System.out.println(Math.abs(20 - 30));

        ex08Upgrade(48,3);
        
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

}