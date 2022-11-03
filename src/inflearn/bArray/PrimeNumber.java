package inflearn.bArray;

import java.util.Arrays;
import java.util.Scanner;

/*
5. 소수(에라토스테네스 체)
	설명
		자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
		만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
		
	입력
		첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
	
	출력
		첫 줄에 소수의 개수를 출력합니다.
	
	예시 입력 1 
		20
	
	예시 출력 1
		8
*/
public class PrimeNumber {
	
    public static void main(String[] args) {
    	
    	PrimeNumber t = new PrimeNumber();

        Scanner kb =  new Scanner(System.in);

        int count = kb.nextInt();
        
        System.out.println(t.solutionEraltosFliter(count)); 
        
        //System.out.println(t.solutionTimeExceed(count)); O(n^2)

        kb.close();
    	
		
	}

    //에라토스테의 채 : 체크에 걸리지 않은 것은 소수이다. 
    //체크에 걸린 수의 배수는 다음 배열에서 모두 체크한다. 
    //체크된수는 바로 넘겨 버리고 체크되지 않은 수로 바로 간다. 반복
    private int solutionEraltosFliter(int maxSize) {
    	
    	int count = 0 ;
    	
    	boolean[] eratosFilter = new boolean[maxSize+1];//java는 0부터 시작하니까 마지막 인덱스는 maxSize - 1임
    	
    	//System.out.println(Arrays.toString(eratosFilter));
    	for(int i = 2; i<= maxSize; i++) {
    		if(eratosFilter[i] == false) {
    			eratosFilter[i] = true;
    			for(int j = 2; i*j <= maxSize; j++) {
    				eratosFilter[i*j] = true;
    			}
    			//System.out.println(i+" is prime number");
    			count++;
    		}
    		else {
    			continue;//다음 처리
    		}
    	}
    	//System.out.println(Arrays.toString(eratosFilter));
    	//System.out.println(count);
    	return count;
    	
    }
    
    
    
	//20만이 넘어가니 시간이 많이 걸린다.
	private int solutionTimeExceed(int count) {
		
		int countPrimeNum = count;
		//소수의 특징 : 1과 자기 자신을 제외 한 약수가 없는 숫자.
		for(int i = 2; i <= count; i++) {
			//2중 for문을 사용해보자...
			for(int j = 2 ; j < i ; j++) {
				//서로가 같지 않은 상태에서 
				//이러면 약수가 있다는 거임
				if(i % j == 0) {
					//System.out.println("not prime number -> "+ i + " by : "+j);
					countPrimeNum--;
					break;//멈춤
				}
			}
		}
		//1 숫자는 제외
		return countPrimeNum - 1;
	}
	
	

	
	
}
