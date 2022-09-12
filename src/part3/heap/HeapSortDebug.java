package part3.heap;

public class HeapSortDebug {
    public static void main(String[] args) {

        int arrMax = 15;
        int[] arr = new int[arrMax];

        // 힙의 경우 배열의 보통 인덱스 0 은 입력하지 않음
        // 그러나 나는 무식하게 0에다 값을 넣고 배열하기 바람
        for(int i= 0; i < arrMax; i++){
            arr[i] = (int)((Math.random()*(500-1+1))+1);
        }
        
        System.out.print("힙 정렬 전    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.println("=========================================================================");
        
        heapSort(arr);

        System.out.println("=========================================================================");
        System.out.println("힙 정렬 후    => ");

        int i = 0;//등비 수열 처리
        for(int x = 0; x<arr.length;x++){
            //각 노드 마다 줄바꿈 처리
            if(i > 0){
                if(x == i){
                    i = 2 * i + 1;            //각 노드 마다 줄바꿈 처리
                    if(i > 0){
                        if(x == i){
                            i = 2 * i + 1;
                            System.out.println();
                        }
                    }
                    else{
                        if(i == 0){
                            i = 1;
                            System.out.println();
                        }
                    }
        
                    System.out.println();
                }
            }
            else{
                if(i == 0){
                    i = 1;
                    System.out.println();
                }
            }  
            System.out.print(arr[x]+"  ");
        }

    }


    /**
     * 힙 정렬
     * @param arr
     */
    public static void heapSort(int[] arr) {

        //System.out.println("heapSort");

        int eh,temp;

        eh = arr.length - 1;
        // 주어진 배열을 힙으로 만든다.
        buildHeap(arr,eh);

        System.out.println("힙 전환 배열  => ");


        int i = 0; //공비 수열 처리 

        for(int x = 0; x<arr.length;x++){

            //각 층 마다 줄바꿈 처리
            if(i > 0){
                if(x == i){
                    i = 2 * i + 1;
                    System.out.println();
                }
            }
            else{
                if(i == 0){
                    i = 1;
                    System.out.println();
                }
            }

            System.out.print(arr[x]+"  ");
        }
        System.out.println();

        // 힙에서 최대값을 제거하고 남음 트리를 다시 힙으로 만듬
        //[Debug]루트부터 
        while(eh > 0){

            //[Debug]루트부터 
            temp = arr[0];
            arr[0] = arr[eh];
            arr[eh] = temp;
            // 제거 함 -> DeleteMax

            // 힙에서 최대 값을 제거
            eh = eh - 1;

            // 남은 트리를 다시 힙으로 생성
            //[Debug]루트부터 
            pushDown(arr,0,eh/2,eh);
        }
    }
    
    /**
     * 배열을 힙으로 만든다.
     * @param arr
     * @param eh
     */
    public static void buildHeap(int[] arr, int eh) {

        //System.out.println("buildHeap");

        int bh,x;

        bh = (arr.length - 1)/2 +1; // 부모 노드의 위치
        
        while(bh > 0){

            //System.out.println("bh => "+bh);

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

        //System.out.println("pushDown");

        int y,temp;

        y = findLarger(arr,x,eh);

        while(arr[x] < arr[y]){

            temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;

            x = y;
            
            y = findLarger(arr, x, eh);
        }
    }


    /**
     * arr[x]보다 더 큰 값을 가지는 x의 자식 노드이 지수를 구한다. -> 이 조건 들이 이상하다...
     * @param arr
     * @param x
     * @param eh
     * @return
     */
    public static int findLarger(int[] arr, int x, int eh) {

        //System.out.println("findLarger");

        int y = x; // [Debug log 2] 초기화에 큰 실패를 함, 이게 0이면 계속 바뀌게 됨

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
        }
        // [Debug log 1] 자식 노드가 하나만 있는 경우 -> 이게 문제였던 것 같음 조건이 밖으로 나와야 됨
        else{
            if(2*x <= eh && arr[2*x] > arr[x]){
                y = 2*x;
            }
        }
        
        // [Debug log 2] 문제는 해당 조건에 모두 해당 되잔 않은 경우 값이 0으로 고정 됨
        return y;
    }




}
