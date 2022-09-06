package part2;

public class ComputeSquare{

    public static void main(String[] args) {
        
        computeSquare3(5);


    }


    /* n^2 제곱계산에 대한 알고리즘으로 복잡도 표현 */

    // 시간 복잡도 : O(1) , 상수시간
    public static void computeSquare1(int n) {

        int result = n * n; // 연산을 한번 수행한다. 가장 깔끔

        // 1 ∈ O(1) 이렇게 표현. -> 공식이 있다면 바로 적용해서 사용하다. 우리가 수학을 배우는 이유

        System.out.println("result => "+result);

    }

    // 시간 복잡도 : O(n) , 1차 선형 시간
    public static void computeSquare2(int n){

        int result = 0;

        for(int i=1;i<=n;i++){ //-> 1 ~ N 까지 수행
            result=result+n;
        }

         // n ∈ O(n) 이렇게 표현.

        System.out.println(result);
    }

    // 시간 복잡도 : O(n^2) , 2차 선형 시간
    public static void computeSquare3(int n){

        int result = 0;

        for(int i = 1; i<=n;i++){ //-> 1번 실행 될때마다 
            for (int j =1;j<=n;j++){  //-> n번 만큼 실행된다.
                result=result+1;
            }
        }

        // n^2 ∈ O(n^2) 이렇게 표현.

        System.out.println(result);
    }

    


}