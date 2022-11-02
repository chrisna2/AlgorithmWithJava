# 인프런 : 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비
## 섹션 2. Array(1, 2차원 배열)

1. 큰 수 출력하기 - ***FindBigNumber.java***
    - 문제 내용 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력
    - POINT : for문선언 하기 전에 기준 값을 셋팅해 둔다.
 
2. 보이는 학생 - ***Student.java***
    - 문제 내용 : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
    - POINT : 결국 큰놈들만 보인다.
    ```java 
		 private void solution(Integer[] array) {
	
	        int result = 0;
	        int bigman = 0;
	
	        for(int a : array){
	            if(bigman < a){
	                bigman = a;
	                result++;
	            }
	        }
	        
	        System.out.println(result);
	    }
    ```
 
3. 가위바위보 - ***RockScissorsPaper.java***
    - 문제 내용 : 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요. 
    - POINT : 비기거나, A가 이기거나, 그 나머지는 B가 이긴다. -> 조건 5개 -> 1 ~ 5댑스

4. 피보나치 수열 - ***Fibonacci.java***
    - 문제 내용 : N 개의 피보나치 수열을 구하세요
    - POINT : 피보나치 수열을 1 1 로 시작한다. 필요한 변수는 3개

5. 소수(에라토스테네스 체) - ***PrimeNumber.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
6. 뒤집은 소수 - ***ReversePrimeNumber.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
7. 점수계산 - ***PointCalculate.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
8. 등수구하기 - ***GetRank.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
9. 격자판 최대합 - ***MaxGridSum.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
10. 봉우리 - ***Peaks.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
11. 임시반장정하기 - ***SetTempLeader.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 
12. 멘토링 - ***Mentoring.java***
    - 문제 내용 : 
    - POINT : 
    ```java 

    ```
 