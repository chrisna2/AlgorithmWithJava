package part3.quick;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {


    
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
        List<Integer> result = quickSort(arr);


        System.out.println("=========================================================================");
        System.out.print("퀵 정렬 후    => ");
        System.out.println(result.toString());

    }

    private static List<Integer> quickSort(List<Integer> arr) {

        List<Integer> result = new ArrayList<>();

        int n = arr.size();

        //종료 조건
        if(n<=1){
            return arr;
        }

        //기준값 설정 : 맨 마지막 값
        int pivot = arr.get(arr.size()-1);
        
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        //그룹 분배시 맨마지막 값은 제외하고 분배
        for(int i = 0 ; i < arr.size()-1 ; i++){
            if(pivot > arr.get(i)){
                small.add(arr.get(i));
            }
            else{
                big.add(arr.get(i));       
            }
        }

        result.addAll(quickSort(small));
        result.add(pivot);
        result.addAll(quickSort(big));

        return result;
    }
    
}
