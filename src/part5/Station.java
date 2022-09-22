package part5;

/**
 * 가독성있게 가장 간단하게 짠다고 빠른건 아니다.
 * 그런데 그게 업무에서도 그럴까 싶다.  * 
 */
public class Station {
    
//https://school.programmers.co.kr/learn/courses/10302/lessons/62946

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int enter = 1;
        int range = w*2+1;
        
        for(int i = 0; i < stations.length; i++){
            int start = stations[i] - w; //시작지점
            int end = stations[i] + w; //끝지점
            if(enter < start){           
                //이거 한개 식으로 처리하는게 왜 메모리가 많이 드는 걸까?
                answer += (int)Math.ceil((double)(start - enter)/range);
                // 다음 시작 지점 지정
                enter = end + 1;
            }else{
                // 다음 시작 지점
                enter = end + 1;
            }
        }
        
        if(enter <= n){   
            //이거 한개 식으로 처리하는게 왜 메모리가 많이 드는 걸까?
            answer += (int)Math.ceil((double)(n + 1 - enter)/range);
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("answer => "+answer);

        return answer;
    }
}
