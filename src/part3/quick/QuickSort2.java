package part3.quick;

import java.util.ArrayList;
import java.util.List;

public class QuickSort2 {
    public static void main(String[] args) {
        
        int arrMax = 20;
        
        List<Integer> arr = new ArrayList<>();


        for(int i= 0; i < arrMax; i++){
            arr.add((int)((Math.random()*(300-100+1))+100));
        }
 
        System.out.print("퀵 정렬 전    => ");
        System.out.println(arr.toString());
        System.out.println("=========================================================================");

        //퀵정렬 실행
        quickSortSub(arr, 0, arr.size()-1);

        System.out.println("=========================================================================");
        System.out.print("퀵 정렬 후    => ");
        System.out.println(arr.toString());

    }

    private static void quickSortSub(List<Integer> arr, int start, int end) {

        //종료 조건 : 정렬대상이 한개 이하이면 정렬할 필요 없음
        if(end - start <= 0){
            return;
        }

        //기준값 설정 : 맨 마지막 값
        int pivot = arr.get(end);
        int i = start;
        
        //기준 값을 정하고 기준 값에 맞춰 리스트 안에서 각 자료의 위치를 맞춤
        //[기준보다 작은 값들, 기준보타 큰 값들]
        for(int j = i ; j < end ; j++){
            //기준 값보다 작은 값은 위치 변경
            if(pivot >= arr.get(j)){
                
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);

                i++;
            }
        }

        //기준값 스왑
        int temp = arr.get(i);
        arr.set(i,arr.get(end)); 
        arr.set(end,temp);
        
        //System.out.println("arr =>"+arr.toString());

        //재귀호출
        quickSortSub(arr, start, i-1); //기준값도 보다 작은 그룹을 재귀호출로 정렬

        //System.out.println("small =>"+arr.toString());

        quickSortSub(arr, i+1, end);    //기준값보다 큰 그룹을 재귀호출로 정렬

        //System.out.println("big =>"+arr.toString());

    }
}
