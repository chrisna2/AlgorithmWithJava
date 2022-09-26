package book.part2;

/**
 * 재귀 알고리즘을 통해 팩토리얼 구하기 
 */
public class ComputeFactorial {

    /**
     * 팩토리얼 (※0! = 1임 이걸 몰라서 엄청 헷갈림) 공식
     * 0! = 1  최소값
     * n! = (n-1)! x n 최대값
     */


    public static void main(String[] args) {
        System.out.println("ComputeFactorial1 => "+ComputeFactorial1(10));
        System.out.println("ComputeFactorial2 => "+ComputeFactorial2(10));
    }

    /**
     * 일반적인 팩토리얼 공식을 재귀함수로 처리
     * @param n
     * @return
     */
    public static int ComputeFactorial1(int n){
        if(n>0){
            return ComputeFactorial1(n-1) * n; // -> 곱샘을 한번 수행 : 1 개 연산
        }
        else{   
            return 1;                          // -> 곱샘을 안하고 그냥 값을 리턴 : 0 연산 없음
        }
    }

    /**
        재귀 함수 복잡도

        M(n) = M(n-1)+1
            M(n-1) = M(n-2)+1
                M(n-2) = M(n-3)+1
                    ```
                    M(1) = M(1)+1   --> 여기까지 1만 더하면 n임
                        M(0) = 0 -> 연산이 없음

        n ∈ O(n) 이니까 1차 선형 시간 복잡도를 가짐 : O(n) 

     */

    // 굳이 재귀를 쓰지 않고 for 문을 돌려도 같은 복잡도를 가지기는 한다.
    public static int ComputeFactorial2(int n){
        int result = 1;
        for(int i = 1; i <= n;i++){
            result = result * i;
        }
        return result;
    }


}
