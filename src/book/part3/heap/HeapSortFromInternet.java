package book.part3.heap;

/**
 * HeapSortFromInternet
 */
public class HeapSortFromInternet {

    public static void main(String[] args) {

        int arrMax = 10;
        int[] arr = new int[arrMax];

        // 힙의 경우 배열의 보통 인덱스 0 에 값은 입력하지 않음 (편의상)
        // 그러나 나는 무식하게 0에다 값을 넣고 배열하기 바람
        for(int i= 0; i < arrMax; i++){
            arr[i] = (int)((Math.random()*(500-1+1))+1);
        }
        
        System.out.print("힙 정렬 전    => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.print("=========================================================================");
        System.out.println();

        buildHeap(arr); //배열을 힙으로 만드는 메서드

        System.out.print("힙으로 변경한 배열 => ");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.print("=========================================================================");
        System.out.println();

        heapSort(arr); //힙을 이용해서 정렬하는 메서드

        System.out.print("정렬 완료된 배열 =>");
        for(int x = 0; x<arr.length;x++){
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        System.out.print("=========================================================================");
    }

    static void heapSort(int[] arr) {
        int eNN = arr.length-1;
        while(eNN > 0) {//[Debug]루트부터
            swap(arr, 0, eNN); //[Debug]루트부터
            eNN--;
            pushDown(arr, 0, eNN);//[Debug]루트부터
        }
    }

    //eNN = endNodeNumber
    //tNN = tempNodeNumber
    static void buildHeap(int[] arr) {
        int eNN = arr.length - 1; // 마지막 노드
        int tNN = eNN/2 + 1; //1번째 리프노드 번호

        while(tNN > 0) {//[Debug]루트부터 
            tNN--; // 자식을 가지고 있는 마지막 노드부터 시작
            pushDown(arr, tNN, eNN);
        }
    }

    static void pushDown(int[] arr, int tNN, int eNN) {
        int y = findLarger(arr, tNN, eNN); 
        //자식 노드중에서 루트 노드보다 더 큰 값을 가지는 노드 번호 얻어냄

        while(arr[tNN] < arr[y]){
            swap(arr, tNN, y);
            tNN = y;
            y = findLarger(arr, tNN, eNN);
            // leaf노드 쪽으로 내려가면서 값의 제자리를 찾아간다.
        }
    }

    static int findLarger(int[] arr, int tNN, int eNN){
        int tmp = tNN*2+1; //오른쪽 자식 노드의 번호
        int y = tNN;

        if(tmp <= eNN){//자식 노드가 두개인 경우
            if(arr[tNN] < arr[tmp]) //오른쪽 자식 노드의 value가 더 크다면
                y = tmp;
            if(arr[y] < arr[tmp-1]) //왼쪽 자식 노드의 value가 더 크다면
                y = tmp-1;
        }
        else if(tmp-1 <= eNN){ //자식 노드가 1개인 경우
            if(arr[tNN] < arr[tmp-1]) // 자식 노드의 value가 더 크다면
                y = tmp-1;
        }
        return y;
    }

    static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}