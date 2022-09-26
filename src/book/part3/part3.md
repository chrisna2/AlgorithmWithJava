# 자바로 쉽게 배우는 알고리즘 - part 3 : 정렬알고리즘
### 20220905 : 정렬부터 간다. 진도를 나간다. 문제는 나중에 푼다. 배경지식을 쌓는다.

## 정렬알고리즘
- 정렬 알고리즘은 컴퓨터 과학 중 가장 많이 연구된 분야
- 정렬은 정렬대상의 수가 증가할 수록 정렬의 단위 비용은 줄어들지 않고 더 늘어남

## 정렬 알고리즘의 분류
1. 배열의 크기에 기초해 나눈 후 배열을 합쳐서 정렬한다.
    > 1. 크기가 1인 배열과 크기가(n-1)인 배열로 나눈다
    >> ex) 삽입정렬 
    > 2. 크기가 n/2인 두 개의 배열로 나눈다.
    >> ex) 합병정렬

    &rightarrow; 여기에 해당 하는 정렬 알고리즘은 나누는 것은 쉽고 합치는 것은 어렵다. 

2. 배열의 특정 값에 기초하여 나눈 후 배열들을 합쳐서 정렬한다
    > 1. 최솟값에 기초하여 배열을 나눈다.
    >> ex) 선택정렬, 힙정렬
    > 2. 배열의 기준 값(예. 첫번째 값)에 기초하여 배열을 나눈다.
    >> ex) 빠른정렬

    &rightarrow; 여기에 해당 하는 정렬 알고리즘은 나누는 것은 어렵고 합치는 것은 쉽다.

## 선택정렬
> ***전체배열(0<N)에서 가장 작은 요소를 찾고, 그 요소를 첫번쨰 요소와 교환한다.***  
> ***&rightarrow; 두번째요소 부터 다음요소까지 가장 작은 요소를 찾고 그 요소를 두번째 요소와 교환한다.***  
> ***&rightarrow; 이 것을 (n-1)번 반복한다.***  

```java
SelectionSort.java 참조

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
        }
```  

- 선택정렬의 알고리즘 시간 복잡도 (10번의 비교 시)  
    > 첫번째요소 체크 : 총 9번 비교 처리  
    > 두번째요소 체크 : 총 8번 비교 처리
    > ___
    > 열번째요소 체크 : 총 1번 비교 처리

        -> 10 + 9 + 8 ... + 1 = 55번 비교 
        => 1 ~ n 까지의 총합 공식
        => n(n-1)/2 ∈ O(n^2) : 2차 선형 시간 복잡도 

### 선택정렬의 효용성
- 이해하기는 쉽지만 빠른 알고리즘이 아니다.

## 삽입정렬
> ***전체배열(0<N)에서 A[0] , A[1 ~ n-1]을 배열로 나눈다.***  
> ***&rightarrow; A[0]와 A[1]을 비교하여 A[1]을 첫번째 배열의 적절한 위치에 삽입 정렬한다..***  
> ***&rightarrow; A[0 ~1]과 A[2]를 비교하여 A[1]을 첫번째 배열의 적절한 위치에 삽입 정렬한다..***  
> ***&rightarrow; A[0 ~ n-2]과 A[n-1]를 비교하여 A[n-1]을 첫번째 배열의 적절한 위치에 삽입 정렬한다..***  
> ***&rightarrow; 첫번째 배열만 남고 정렬이 완료된다.***  

- 삽입정렬의 알고리즘 골격
```java
for(i=1;i<n;i++){
    A[0..i]를 "재배열"하여 정렬한다.
}
```
- 여기서 **"재배열"** 이 중요함 -> 여기선 선택 정렬을 사용함
- 첫번째요소 작은 요소부터 위로 순차적으로 비교하면서 찾거나 -> 숫자가 작을 수록 인덱스 수정이 많아짐
- 마지막요소 큰 요소부터 아래로 순차적으로 비교하면서 찾거나 -> 주로 사용

```java
InsertionSort.java 참조

    public static void InsertionSort(int[] arr){

        //배열 나눔 위치 for문
        for(int i = 1; i < arr.length; i++){

            int insertElement = arr[i];  // 삽입할 요소 A[i]의 값을 저장한다.

            int j = i - 1; // 0 ~> 9 까지
            // ... 배열을 나눈다는 말이 이거였구나. 
            // 배열을 진짜 나누는게 아니라 있는 배열에서 위치를 나눈다는 것이었어.
            // 위치가 위로 이동하면서 아래의 배열은 정렬을 하면서 올라감
        

            //삽입정렬 알고리즘의 핵심, 원래 위치한 값이 들어가는 값 보다 큰 경우
            //위에서 부터 아래까지 들어가는 값이 원래 위치한 값보다 클 때까지(작지 않을 때 까지)
            //최악의 경우 0 아래로 되는 경우 방지, and조건
            while(j>=0  && arr[j]>insertElement){

                //원래 들어 있던 값의 자리를 "하나 씩" 바꿔준다.
                arr[j+1] = arr[j];

                //배열 나눔위치에서로 큰 요소부터 아래로 순차적으로 비교하면서 "재배열" 함
                j = j - 1; 
            }
            //최악의 경우 -1이 되더라도 0을 유지시키기 위해 +1
            arr[j+1] = insertElement;

        }        
    }

```
> 결과
```linux
삽입정렬 전    => 120  268  286  272  285  264  251  220  297  263  
=========================================================================
1번째 삽입정렬 => 120  268 | 286  272  285  264  251  220  297  263   : 1
2번째 삽입정렬 => 120  268  286 | 272  285  264  251  220  297  263   : 1
3번째 삽입정렬 => 120  268  272  286 | 285  264  251  220  297  263   : 2
4번째 삽입정렬 => 120  268  272  285  286 | 264  251  220  297  263   : 2
5번째 삽입정렬 => 120  264  268  272  285  286 | 251  220  297  263   : 5
6번째 삽입정렬 => 120  251  264  268  272  285  286 | 220  297  263   : 6
7번째 삽입정렬 => 120  220  251  264  268  272  285  286 | 297  263   : 7
8번째 삽입정렬 => 120  220  251  264  268  272  285  286  297 | 263   : 1
9번째 삽입정렬 => 120  220  251  263  264  268  272  285  286  297 |  : 7
=========================================================================
삽입정렬 후    => 120  220  251  263  264  268  272  285  286  297   : 총 32 연산
```
___
> 삽입 정렬의 최악의 수 &rightarrow; 모든 것이 역순으로 정렬 되어 있을 때  
>> 선택정렬과 같은 복잡도 구성 : n(n-1)/2 ∈ O(n^2) -> 2차 선형 시간복잡도
___
> 삽입 정렬의 최선의 수 &rightarrow; 모든 것이 정순으로 정렬 되어 있을 때  
>> 각각 한번씩 연산 : n-1 ∈ O(n) -> 1차 선형 시간복잡도
___
최악과 최선을 왔다 갔다 한다.


### 삽입정렬의 효용성
- 이미 정렬된 상태에서 더욱 효과적으로 발휘 됨. 
- 입력의 크기가 크지 않고 배열 내의 값들이 거의 정렬되어 있을 때 효과적.

## 힙정렬
책에 있는 코드 대신 참조한 힙정렬 코드 출처 : https://velog.io/@youswim96/%ED%9E%99-%EC%A0%95%EB%A0%ACHeap-sort-%EC%9E%90%EB%B0%94JAVA

 힙자료 구조를 이용하여 정렬하는 알고리즘  


### ※ 알고리즘 공부의 방향성 찾기
 1. 다음 부터는 공부 할때 항상 노트랑 팬을 들고 공부를 하자.
 2. 10분 고민 뒤 바로 생각안나면 찾아보자 (나는 쌓여 있는게 없다. 시간도 부족하다.)
 3. 근데 아무리 생각해 봐도 이 책은 수준이 좀 높은게 아닐까 싶다. 일단 지금 이 파트는 너무 어렵다. 일단 급한 정렬 알고리즘 부터 본다. 복잡한 수식은 일단 재껴 놓는게 필요
 4. 이 책 문제점이 알고리즘 연습문제에 대한 풀이가 없다. 연습문제는 주말에 몰아서 풀어야 할듯 진도 위주 진행. part2완료.
 5. 대학 교재라서 그런지 연습문제 풀이도 없고, 책에 있는 코드 그대로 수행해도 무한 루프가 발생한다. 아무리 생각해도 책을 잘못 고른것 같다. 젠장.