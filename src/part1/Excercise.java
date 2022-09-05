package part1;

public class Excercise {

    public static void main(String[] args) {
        ex08();
        

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


}