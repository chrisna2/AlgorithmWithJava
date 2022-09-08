package part3;

public class InsertionSort {
    
    public static void main(String[] args) {
        
        int arrMax = 10;
        int[] arr = new int[arrMax];

        for(int i= 0; i < arrMax; i++){
            arr[i] = (int)((Math.random()*(300-100+1))+100);
        }
 
        System.out.print("삽입정렬 전    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.print("=========================================================================");

        int sum = insertionSort(arr);

        System.out.println();
        System.out.println("=========================================================================");
        System.out.print("삽입정렬 후    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.print(" : 총 "+sum+" 연산");

    }

    public static int insertionSort(int[] arr){

        /**
         * for(i=1;i<n;i++) {
         *      
         *      insertElement=A[i] ... 삽입할 요소 A[i]의 값을 저장한다.
         *      
         *      j = i -1
         * 
         *      while(j>=0 and A[j]>insertElement){ ... 오름차순 정렬
         *          A[j+1]=A[j] ... A[j]를 오른쪽 한칸 이동시킨다.
         *          j = j-1
         *      }
         * 
         *      A[j+1] = insertElement ... A[i]를 찾은 위치에 저장한다.
         * }
         */

        int sum = 0; //총연산의 값

        for(int i = 1; i < arr.length; i++){

            int insertElement = arr[i];  // 삽입할 요소 A[i]의 값을 저장한다.

            int j = i - 1; // 0 ~> 9 까지 
            // ... 배열을 나눈다는 말이 이거였구나. 배열일 진짜 나누는게 아니라
            // 이미 있는 배열에서 위치를 나눈다는 것이었어.
        
            int k = 1; //연산이 얼마나 이루어질지 확인, 한번의 비교는 무조건 일루어짐(while)

            //삽입정렬 알고리즘의 핵심, 원래 위치한 값이 들어가는 값 보다 큰 경우
            //위에서 부터 아래까지 들어가는 값이 원래 위치한 값보다 클 때까지(작지 않을 때 까지)
            //최악의 경우 0 아래로 되는 경우 방지, and조건 
            while(j>=0  && arr[j]>insertElement){

                k++;//연산 카운트
                
                //원래 들어 있던 값의 자리를 "하나 씩" 바꿔준다.
                arr[j+1] = arr[j];

                //큰 요소부터 아래로 순차적으로 비교하면서
                j = j - 1; 
            }
            //최악의 경우 -1이 되더라도 0을 유지시키기 위해 +1
            arr[j+1] = insertElement;
            

            // 과정 확인용
            System.out.println();
            System.out.print(i+"번째 삽입정렬 => ");
            for(int x = 0; x<arr.length;x++){
                if(i == x){
                    System.out.print(arr[x]+" | ");                    
                }
                else{
                    System.out.print(arr[x]+"  ");                    
                }
            }
            
            System.out.print(" : "+k);
    
            sum += k;
        }     
        
        return sum;
    }
}
