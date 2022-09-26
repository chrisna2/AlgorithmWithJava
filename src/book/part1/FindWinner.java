package book.part1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FindWinner {
       
    public static void main(String[] args) {
        //ex04(120);
        ex06(3);
    }

    /**
     * 연습 문제 4. 강의실에 있는 학생중 평균키 보다 큰 학생들의 수를 구하는 알고리즘
     * @param number
     */
    public static void ex04(int number){
        /**
         * 1. 강의실에 있는 학생의 이름과 키를 기록한다.
         * 2. 전체 키의 평균을 구한다.
         * 3. 순차적으로 평균 키보다 큰 키를 가진 학생들을 기록한다. (정렬안했기때문)
         */
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 1; i <= number; i++){
            map.put(String.valueOf(i)+"번째 학생", (int)((Math.random()*(200-100+1))+100));
        }
        
        // 평균 = 전체함 / 전체 갯수...
        double average = 0;
        int sum = 0;

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sum += entry.getValue();
        }
        average = (double)sum / map.size();

        //System.out.println("sum => "+sum+" cm");  
        //System.out.println("average => "+average+" cm");  

        ArrayList<String> winners = new ArrayList<String>();
        
        // 평균키 보다 큰사람들 수집
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > average){
                winners.add(entry.getKey());
            }
        }
        System.out.println("winners => "+winners.toString());

    }
    /** 연습문제 5 256개의 정렬된 이름가욷데 찾는 이름을 찾기위해 탐색하는 횟수 2^8 : 8번 */

    /**
     * 연습문제 6번. 오늘이 화요일일 때 1000일 이후 요일은?
     * 심화) 오늘의 요일기준 으로 특정 일자의 요일 구하기
     * 1. 일주일을 6개의 배열의 순서를 붙이고 각 요일에 인덱스넘버를 붙인다. (배열사용)
     * 2. 오늘의 요일(인덱스넘버)를 구한다.
     * 3. 특정일자의 7일 나머지를 구한다.
     * 4. (오늘의 요일(인덱스넘버) + 나머지) % 7 => 나머지 값이 인덱스로 사용돠는게 정답
     */
    public static void ex06(int days){

        //JDK1.8이후 일자 및 요일 구하기 => 로직과 별개
        LocalDate ld = LocalDate.now();
        DayOfWeek dow = ld.getDayOfWeek();
        String nowWeekName = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);     

        // 알고리즘 로직 -> 리팩토링 결과 6 줄로 수행됨 쩐다...
        String[] daynames ={"월","화","수","목","금","토","일"};
        
        int weekindex = Arrays.asList(daynames).indexOf(nowWeekName);

        int odd = days % 7;

        int dateindex = (weekindex+odd)%7;
        
        String dayname = "";
        dayname = daynames[dateindex];
        System.out.println(days+"일 후는 "+dayname+"요일입니다.");
        
        /* 
        //처음에는 case문을 생각해서 처리
        //심화를 거치니 그 방법은 코드 복잡성을 해쳐서 정리함
        
        //그 다음에 이걸 생각했는데
        int dateindex = weekindex+odd;
        if(dateindex >= 7){
            dateindex = dateindex - 7;
        }
        //특정 갯수에서 부터 되돌아오는 경우 나머지(%)를 사용한다. 이 패턴을 꼭 암기
        */
    }

    /**
        연습문제 7번 : 문제 길어서 생략 
        ==> 결국 2진 트리 문제임 15명이면 4번 안에 결과가 나온다 (2^4 = 16)     
     */

     


}
