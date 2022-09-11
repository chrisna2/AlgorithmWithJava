# 자바로 쉽게 배우는 알고리즘 - part 1 : 알고리즘 소개

## 알고리즘의 조건
1. 명확성 : 알고리즘의 각 단계는 애매모호 하지 않고 명확해야 한다.
2. 정확성 : 유효한 입력에 대해 올바른 결과를 출력해야 한다. 유효한 입력에 대햔 명확하게 명시되어야 한다.
3. 정지성 : 유효한 입력이 되면 반드시 유한한(짧은) 시간 내에 종료되어야 한다.

## 알고리즘의 문제 해결 과정
1. 문제이해 : 주어진 문제를 완전히 이해 한다. 애매한것은 명확하게 확인한다.
2. 알고리즘 설계 : ***이 책을 배우는 이유***
3. 정확성 증명 : 만들어진 알고리즘이 모든 유효한 입력에 대한 유한한 시간 내에 정확한 결과를 만들어 낸다는 것을 증명한다. 수학적 귀납법을 사용한다. 틀린 사례 한 가지라도 존제하면 끝이다.
4. 알고리즘 분석 : 알고리즘의 효율성 분석, 효율성이 떨어지면 재설계
    >   알고리즘의 효율성
    >   > 1. 시간의 효율성 : 처리시간의 효율성
    >   > 2. 공간의 효율성 : 사용하는 메모리의 효율성
    >   > 3. 코드의 효율성 : 보이는 코드의 간결성, 가독성
5. 알고리즘 구현 : 설계된 알고리즘을 코드로 작성, input validation 기능 

##  알고리즘의 표현

>   FindMAximum.java 참조

1. 자연어 (한글, 영어) : 문제가 복잡하면 애매해진다.
2. 의사코드(Pseduocode) : 실제 프로그램과 유사하게 표현한 자연어 코드
3. 프로그래밍 언어 코드(java) : 설계된 알고리즘으로 구현된 코드

## 알고리즘의 분류 : ***이책을 배우는 이유*** 
알고리즘 설계 기법을 ~~배우는~~ 외우는 것이 목적! 
> 문제를 해결하는 주요 알고리즘 
>   > - 분할정복 : 5장
>   > - 동적계획 : 6장
>   > - 탐욕기법 : 7장
>   > - 되추적 : 9장
>   > - 분기한정 : 10장 
>
> 그외 문제 유형에 따라 여러 가지 알고리즘 존재
>   >  - 억지 기법
>   >  - 무작위 알고리즘
>   >  - 근사 알고리즘
>   >  - 병렬 알고리즘
>   >  - 분산 알고리즘
>   >  - 양자 알고리즘
>   >  - 유전자 알고리즘
>
> 알고리즘을 해결하는 문제 유형에 따라
>   >  - 정렬 알고리즘
>   >  - 탐색 알고리즘
>   >  - 문자열 처리 알고리즘
>   >  - 그래프 알고리즘
>   >  - 조합 알고리즘
>   >  - 기하학적 알고리즘
>   >  - 수치 알고리즘
>   >  - 등등 ... 

> ## ※ 알고리즘 공부의 방향성 찾기
> 1. 다음 부터는 공부 할때 항상 노트랑 팬을 들고 공부를 하자.
> 2. 10분 고민 뒤 바로 생각안나면 찾아보자 (나는 쌓여 있는게 없다. 시간도 부족하다.)
> 3. 


### part1 공부하면서 배운 소소한 java 팁
1. java 랜덤 값 범위 지정하여 구하기 (정수)
```java

//(int)((Math.random()*(최대값-최소값+1))+최소값);
(int)((Math.random()*(200-100+1))+100);

```