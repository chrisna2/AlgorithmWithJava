package part3.heap;

/**
 * 책보고 그대로 따라 했는데 계속 무한 루핑이 돌음
 * 자바로 쉽게 배우는 알고리즘 - 이충기 
 */
public class HeapSort {
    
    public static void main(String[] args) {

        int arrMax = 3;
        int[] arr = new int[arrMax];

        for(int i= 0; i < arrMax; i++){
            arr[i] = (int)((Math.random()*(500-1+1))+1);
        }
        
        System.out.print("힙 정렬 전    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.print("=========================================================================");
        
        heapSort(arr);

        System.out.println();
        System.out.println("=========================================================================");
        System.out.print("힙 정렬 후    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }

    }

    /**
     * 힙 정렬
     * @param arr
     */
    public static void heapSort(int[] arr) {

        System.out.println("heapSort");

        int eh,temp;

        eh = arr.length - 1;
        // 주어진 배열을 힙으로 만든다.
        buildHeap(arr,eh);

        // 힙에서 최대값을 제거하고 남음 트리를 다시 힙으로 만듬
        while(eh > 1){

            temp = arr[1];
            arr[1] = arr[eh];
            arr[eh] = temp;

            // 힙에서 최대 값을 제거
            eh = eh -1;

            // 남은 트리를 다시 힙으로 생성
            pushDown(arr,1,eh/2,eh);
        }
    }
    
    /**
     * 배열을 힙으로 만든다.
     * @param arr
     * @param eh
     */
    public static void buildHeap(int[] arr, int eh) {

        System.out.println("buildHeap");

        int bh,x;

        bh = (arr.length - 1)/2 +1;

        while(bh > 1){

            System.out.println("bh => "+bh);

            bh = bh - 1;
            x = bh;

            //x에서 힙 조건이 만족될 때까지 arr[x] 트리의 아래층으로 내려보냄
            pushDown(arr, x, bh, eh);
        }
    }
    
    /**
     * arr[x]를 힙 조건이 만족될 때까지 트리의 아래 층으로 내려 보낸다.
     * @param arr
     * @param x
     * @param j
     * @param eh
     */
    public static void pushDown(int[] arr, int x, int bh, int eh) {

        System.out.println("pushDown");

        int y,temp;

        y = findLarger(arr,x,eh);

        while(arr[x] < arr[y]){

            System.out.println("arr["+x+"] : "+arr[x]);
            System.out.println("arr["+y+"] : "+arr[y]);


            temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;

            System.out.println("arr["+x+"] : "+arr[x]);
            System.out.println("arr["+y+"] : "+arr[y]);

            x = y;
            
            y = findLarger(arr, x, eh);
        }



    }

    /**
     * arr[x]보다 더 큰 값을 가지는 x의 자식 노드이 지수를 구한다.
     * @param arr
     * @param x
     * @param eh
     * @return
     */
    public static int findLarger(int[] arr, int x, int eh) {

        System.out.println("findLarger");

        int y = 0;

        if(2*x+1 <= eh){            
            // 자식 노드가 둘 다 있는 경우
            if(arr[2*x] > arr[x] || arr[2*x+1] > arr[x]){
               
                // arr[x] 보다 더 큰 값을 가지는 자식 노드의 지수를 구한다
                if(arr[2*x] >= arr[2*x+1]){
                    y = 2*x;
                }
                else{
                    y = 2*x+1;
                }
            }
            // 자식 노드가 하나만 있는 경우
            else{
                if(2*x <= eh && arr[2*x] > arr[x]){
                    y = 2*x;
                }
            }
        }
        return y;
    }


}
