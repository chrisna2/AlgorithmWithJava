package part4.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import part4.Node;

public class BreadthFirstSearch {
    
    private Queue<Node> queue;

    public BreadthFirstSearch(){
        queue = new LinkedList<Node>();
    }

    public static void main(String[] args) {
     
        //각 정점들을 표현
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.addNeighbours(node2);
        node1.addNeighbours(node3);
        node1.addNeighbours(node5);

        node2.addNeighbours(node1);
        node2.addNeighbours(node3);
        
        node3.addNeighbours(node1);
        node3.addNeighbours(node2);
        node3.addNeighbours(node4);
        node3.addNeighbours(node5);
        
        node4.addNeighbours(node3);
        node4.addNeighbours(node6);
        
        node5.addNeighbours(node1);
        node5.addNeighbours(node3);
        
        node6.addNeighbours(node3);
        node6.addNeighbours(node4);

        BreadthFirstSearch bfsExample = new BreadthFirstSearch();

        System.out.println("너비 우선 탐색 실행 결과 :");   
        bfsExample.BFS(node1);//node1부터 너비우선 탐색 싷행


    }

    public void BFS(Node v){

        // v를 '방문함'으로 표시한다. 
        v.visited = true;

        // v를 큐에 추가한다.
        queue.add(v);

        while(!queue.isEmpty()){

            //큐 맨 앞에 있는 정점을 끄집어 내어 element에 저장한다.
            Node element = queue.remove();
            
            // elemnet에 인접한 정점들의 연결 목록을 끄집어 낸다.
            List<Node> neighbours = element.getNeighbours();

            // 정점 V에 대응되는 데이터를 출력한다.
            System.out.print("["+element.info+"]");
            System.out.print("의 이웃 정점 -> "+neighbours.toString());
            System.out.println(" | 남은 queue -> "+queue.toString());
            
            
            //element에 인접한 방문하지 않은 모든 정점들에 대해 너비우선 탐색을 수행한다.
            for(int i=0;i<neighbours.size();i++){
                //w는 element에 인접한 정점
                Node w = neighbours.get(i);

                if(w != null && !w.visited){
                    //w가 '방문안함'으로 표시된 경우
                    //w를 '방문함'으로 표시한다.
                    w.visited = true;
                    queue.add(w);//다시 큐 끝으로 추가한다.
                    System.out.println(" -> "+w.info + " 방문함 : 해당 정점의 이웃정점들을 탐색하기 위해 queue 등록 => "+queue.toString());
                }
                else{
                    System.out.print(" -> "+w.info);
                    if(w.visited){
                        System.out.println(" 이미 방문");
                    }
                }
            }
        }
    }


}
