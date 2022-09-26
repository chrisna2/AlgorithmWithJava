package book.part1;

public class FindMaximum {

    /*
     * 문제
     *  1보다 큰 자연수의 배열 중 최대값을 찾는 방법
    */


    /**
        1. 자연어
        
        [1] 베열의 첫번째 요소를 최대값으로 정한다.
        [2] 배열의 최대 값을 다음 요소와 비교한다. 
        [3] 최대값이 다음 요소와 작다면 최대값을 다음 요소와 바꾼다.
        [4] 배열 내에에 비교요소가 남아있다면 [2]단계로 가고 없으면 종료한다.
    
     */

     /*
        2. 의사코드 
        
        알고리즘 FindMaximum(A[0.....N-1])
            //배열내에 최대값을 찾는다.
            //IN : 1보다 큰 자연수를 가지는 배열 A
            //OUT : 최대값 
        
        max=A[0]
        for(1=i; i<N; i++){
            if(A[i]>max){
                max=A[i]
            }
        }

        return max
    */
    
    /**
     * 3. 프로그래밍 코드
     */
    public static void main(String[] args) {
        
        int[] input = {1,100,2000,39999,20,22222,999};
        System.out.println("findMaximum => "+findMaximum(input));

    }

    public static int findMaximum(int[] a){

        int i;
        int max;

        max = a[0];
        for(i=1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
        
    }

}
