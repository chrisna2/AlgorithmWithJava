package part3.merge;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    
    
    public static void main(String[] args) {
        
        int arrMax = 10;
        
        List<Integer> arr = new ArrayList<>();


        for(int i= 0; i < arrMax; i++){
            arr.add((int)((Math.random()*(300-100+1))+100));
        }
 
        System.out.print("삽입정렬 전    => ");
        System.out.println(arr.toString());
        System.out.println("=========================================================================");

        List<Integer> result = mergeSort(arr);

        //List<Integer> a1 = arr.subList(0, arr.size()/2);
        //List<Integer> a2 = arr.subList(arr.size()/2, arr.size());


        System.out.println("=========================================================================");
        System.out.print("삽입정렬 후    => ");
        System.out.println(result.toString());
        //System.out.println(a1.toString());
        //System.out.println(a2.toString());



    }

    private static List<Integer> mergeSort(List<Integer> arr) {

        //재귀함수 종료 조건
        if(arr.size() <= 1){
            return arr;
        }

        int mid = arr.size()/2;
        int end = arr.size();

        List<Integer> g1 = mergeSort(arr.subList(0, mid));
        List<Integer> g2 = mergeSort(arr.subList(mid, end));

        /*  
            |JS|            |JAVA|
            Array.push    -> ArrayList.add(Object o); // Append the list
            Array.pop     -> ArrayList.remove(int index); // Remove list[index]
            Array.shift   -> ArrayList.remove(0); // Remove first element
            Array.unshift -> ArrayList.add(int index, Object o); // Prepend the list
        */

        List<Integer> result = new ArrayList<>();
        
        /*
            [debug] 이런 식으로 하게 되면 java.util.ConcurrentModificationException 이 발생한다. 
            자바는 파이선,자바스크립트와 다르게 앞에서 부터 인덱스가 변경되면 엘리먼트의 인덱스가 실시간으로 변함
            Length가 변경되면서 해당 인덱스의 값이 null 이 되기 때문에 발생
            
            즉 자바는 for, while 같이 루핑이 도는 와중에 루핑의 조건이 되는 인덱스가 실시간으로 변경이 되면 해당에러 발생
            파이썬, JS가 이런면에서는 편리함 

            while(g1.size() > 0 && g2.size() > 0){
                
                if(g1.get(0) < g2.get(0)){
                    result.add(g1.remove(0));
                }
                else{
                    result.add(g2.remove(0));
                }
            } 
            
            while(g1.size() > 0){
                result.add(g1.remove(0));
            }
            
            while(g2.size() > 0){
                result.add(g2.remove(0));
            }

            해결법 
            [1] Iterator로 변경 하여 적용 --> 문제는 이렇게 되면 pop에 해당하는 값을 각각 개별로 가져올 수가 없다. 
            next를 안쓰고 해당 위치의 값을 바로 구하지를 못함. hasNext 이것도 문제다....
        
            Iterator<Integer> g1Iter = g1.iterator();
            Iterator<Integer> g2Iter = g2.iterator();
                
            int g1val = 0;
            int g2val = 0;
            
            int i = 0;
            while(g1Iter.hasNext() && g2Iter.hasNext()){

                //초기화, next를 한다해도 문제임  
                if(i == 0){
                    g1val = g1Iter.next();
                    g2val = g2Iter.next();
                }

                //초기화
                if(g1val < g2val){
                    result.add(g1val);
                    g1Iter.remove();
                    if(g1Iter.hasNext()){
                        g1val = g1Iter.next();
                    }
                }
                else{
                    result.add(g2val);
                    g2Iter.remove();
                    if(g2Iter.hasNext()){
                        g2val = g2Iter.next();
                    }
                }
                i++;
            }

            while(g1Iter.hasNext()){
                result.add(g1Iter.next());
                g1Iter.remove();
            }
            
            while(g2Iter.hasNext()){
                result.add(g2Iter.next());
                g2Iter.remove();
            }
        */
        
        /* 
            해결법 
            [2] 그냥 remove를 안쓰고 인덱스 값으로 셋팅한다. -> 제일 간단한 방법인데 시간만 버림 
        */
        int i = 0;
        int j = 0;
        while(g1.size() > i && g2.size() > j){
            if(g1.get(i) < g2.get(j)){
                result.add(g1.get(i));
                i++;
            }
            else{
                result.add(g2.get(j));
                j++;
            }
        } 
        
        while(g1.size() > i){
            result.add(g1.get(i));
            i++;
        }
        
        while(g2.size() > j){
            result.add(g2.get(j));
            j++;
        }
            
        return result;

    }



}
