package part3.merge;

import java.util.ArrayList;
import java.util.List;

public class MergeSort2 {
    
    public static void main(String[] args) {
        
        int arrMax = 10;
        
        List<Integer> arr = new ArrayList<>();


        for(int i= 0; i < arrMax; i++){
            arr.add((int)((Math.random()*(300-100+1))+100));
        }
 
        System.out.print("삽입정렬 전    => ");
        System.out.println(arr.toString());
        System.out.println("=========================================================================");

        mergeSort(arr);

        //List<Integer> a1 = arr.subList(0, arr.size()/2);
        //List<Integer> a2 = arr.subList(arr.size()/2, arr.size());


        System.out.println("=========================================================================");
        System.out.print("삽입정렬 후    => ");
        System.out.println(arr.toString());

    }

    private static void mergeSort(List<Integer> arr) {

        //재귀함수 종료 조건
        if(arr.size() <= 1){
            return;
        }

        System.out.println("arr.size -> "+ arr.size()+" | arr -> "+arr.toString());

        int mid = arr.size()/2;
        int end = arr.size();


        /* [Debug] 이렇게 하면 안됨 .. 
        배열을 자르고 변수를 다르게 받는다고 해서 메모리까지 분리된게 아님. 
        아래와 같이 사용을 하면 arr을 변경할 경우 g1. g2 까지 영향을 받음

        List<Integer> g1 = arr.subList(0, mid);
        List<Integer> g2 = arr.subList(mid, end);
        */

        //아... 이게 연결되어 있는 거구나....

        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();

        g1.addAll(arr.subList(0, mid));
        g2.addAll(arr.subList(mid, end));

        mergeSort(g1);
        mergeSort(g2);

        System.out.println("g1 -> "+ g1.toString()+"| g1.size -> "+g1.size());
        System.out.println("g2 -> "+ g2.toString()+"| g2.size -> "+g2.size());

        
        int i = 0;
        int j = 0;
        int aIdx = 0;

        //System.out.println("> aIdx : "+aIdx+"|i : "+i+"|j : "+j);

        while(g1.size() > i && g2.size() > j){

            if(g1.get(i) < g2.get(j)){
                arr.set(aIdx, g1.get(i));
                i++;
                aIdx++;
            }
            else{
                arr.set(aIdx, g2.get(j));
                j++;
                aIdx++;
            }

            //System.out.println("-aIdx : "+aIdx+"|i : "+i+"|j : "+j+"|arr -> "+arr.toString());
        } 

        //System.out.println("aIdx : "+aIdx+"|i : "+i+"|j : "+j+"|arr -> "+arr.toString());
        
        while(g1.size() > i){
            
            //System.out.println("g1.get(i) => "+g1.get(i));
            arr.set(aIdx, g1.get(i));

            i++;
            aIdx++;
        }
        
        //System.out.println("aIdx : "+aIdx+"|i : "+i+"|j : "+j+"|arr -> "+arr.toString());
        while(g2.size() > j){
            arr.set(aIdx, g2.get(j));
            j++;
            aIdx++;
        }

        //System.out.println("aIdx : "+aIdx+"|i : "+i+"|j : "+j+"|arr -> "+arr.toString());

        //System.out.println(">arr => "+arr.toString());

    }

}
