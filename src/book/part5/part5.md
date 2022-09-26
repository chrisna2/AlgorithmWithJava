# 자바로 쉽게 배우는 알고리즘 - part 5 : 분할 정복
## 분할 정복이란?
- 컴퓨터 알고리즘 설계 중 가장 널리 알려진 설계 기법
- 아주 큰 문제를 해결하기위한 기법
- 예) 인구조사, 선거개표
- 해야 할 일을 더 작은 일들로 나눠어 지역별로 수행한 후 취합

## 분할 정복의 전략
1. 분할단계(Divide)
    - 주어진 문제를 같은 유형의 여러 개의 더 작은 부분 문제들로 나눈다.
    - 부분 문제는 쉽게 해결할 수 있을 정도로 작아질때 까지 나눈다.
2. 정복단계(Conquer)
    - 부분 문제들을 보통 **재귀적**으로 해결하여 해를 구함
3. 합병단계(merge)
    - 필요하다면 부분 문제드르이 해를 합쳐 원래 문제에 대한 해를 구함

## 분할 정복의 유형
1. 분할 과정이 쉽고 정복(합병)과정이 어려운 경우
    - 예) 최댓값과 최솟값 찾기 알고리즘, 합병 정렬
2. 분할 과정이 어렵고 정복(합병)과정이 쉬운 경우
    - 예) 퀵정렬, 선택 알고리즘

## 이번 과정의 목표 
- 최댓값 최솟값 구하기 알고리즘
- 합병정렬
- 퀵정렬
- n개의 숫자 중 k번째로 작은 숫자를 찾는 **선택** 알고리즘


