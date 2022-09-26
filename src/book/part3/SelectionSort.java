package book.part3;

public class SelectionSort {

    public static void main(String[] args) {
        
        int arrMax = 10;
        int[] arr = new int[arrMax];

        for(int i= 0; i < arrMax; i++){
            arr[i] = (int)((Math.random()*(300-100+1))+100);
        }
 
        System.out.print("정렬전 => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print("  "+arr[x]);
        }

        selectionSort(arr);
        
        System.out.println();
        System.out.print("정렬후 => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print("  "+arr[x]);
        }

    }

    public static void selectionSort(int[] arr){

        int i, j, min, temp;
        int n = arr.length;

        for(i=0;i<n-1;i++){
            //arr[i] 부터 arr[n-1] 까지 요소들 중 가장 작은 최소 값의 지수를 찾는다.
            min = i;
            for(j=i+1; j<n; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //arr[i] 와 arr[min]을 교환한다.
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            /**
                선택정렬의 알고리즘 시간 복잡도 (10번의 비교 시)
                첫번째요소 체크 : 총 9번 비교 처리
                두번째요소 체크 : 총 8번 비교 처리
                
                ```
                
                열번째요소 체크 : 총 1번 비교 처리

                -> 10 + 9 + 8 ... + 1 = 55번 비교 = 1 ~ 10 까지의 총합
                => n(n-1)/2 ∈ O(n^2) : 2차 선형 시간 복잡도 

                이해하기는 쉽지만 빠른 알고리즘이 아니다.
             */
        }
    }



}