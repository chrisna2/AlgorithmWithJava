package part2;

import java.util.ArrayList;
import java.util.Comparator;

public class BianarySearch {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> testBed = new ArrayList<>();

        for(int i=0;i<300; i++){
            testBed.add((int)((Math.random()*(3000-1+1))+1));            
        }
        //찾는 값
        if(!testBed.contains(100)){
            testBed.remove(0);
            testBed.add(100);
        }
        //해당 ArrayList 배열 정렬 방법
        testBed.sort(Comparator.naturalOrder());
        System.out.println(testBed.toString());

        //95번째 값을 찾는 다고 가정
        System.out.println("bianarySearch => "+(bianarySearch(testBed,0,99,100) + 1)+"번째 위치");


    }

    //2진 탐색 : 재귀함수 
  
    /** 
     * @param A : A[first - last] : A[n]
     * @param first : 배열의 처음요소 
     * @param last : 배열의 마지막 요소 
     * @param x : 찾는 값 
     */
    public static int bianarySearch(ArrayList<Integer> A, int first, int last, int x) {
        

        // 대표적인 O(log n) 알고리즘

        //없으면 -1 리턴 
        if(first > last){
            return -1;
        }
        else{
            int mid = (last + first)/2;

            System.out.println("mid => "+mid);
            //그 자리에 있다면 바로 리턴ㅉ
            if(x == A.get(mid)){
                return mid;
            }
            else if(x < A.get(mid)){
                // 현재 위치 mid 이전 1개서 부터
                return bianarySearch(A,first,mid-1,x);
            }
            else{
                // 현재위치 mid 다음 1개서 부터
                return bianarySearch(A,mid+1,last,x);
            }
        }
    }
}
