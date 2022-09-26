package book.part4.dfs;

import java.util.List;

import book.part4.Node;

public class DepthFirstSearch{

    public static void main(String[] args) {
        
        Node[] node = new Node[6]; // 정점들을 표현

        for(int i = 0; i < 6; i++){
            node[i] = new Node(i+1);
        }   

        node[0].addNeighbours(node[1]);
        node[0].addNeighbours(node[2]);
        node[0].addNeighbours(node[4]);

        node[1].addNeighbours(node[0]);
        node[1].addNeighbours(node[2]);
        
        node[2].addNeighbours(node[0]);
        node[2].addNeighbours(node[1]);
        node[2].addNeighbours(node[3]);
        node[2].addNeighbours(node[4]);
        
        node[3].addNeighbours(node[2]);
        node[3].addNeighbours(node[5]);
        
        node[4].addNeighbours(node[0]);
        node[4].addNeighbours(node[2]);
        
        node[5].addNeighbours(node[2]);
        node[5].addNeighbours(node[3]);

        System.out.println("재귀를 사용한 깊이 우선 탐색 실행 결과");

        DFS(node[0]);

        System.out.println("BFS 탐색 종료");

    }


    public static void DFS(Node v){
        
        // 정점 v를 '방문함'으로 표시한다.
        v.visited = true;
        
        // 정점 v에 인접한 정점들의 연결 목록을 끄집어 낸다.
        List<Node> neighbours = v.neighbours;
        
        // 정점 V에 대응되는 데이터를 출력한다.
        System.out.print("★ ["+v.info+"]");
        System.out.println("의 이웃 정점 -> "+neighbours.toString());

        // 정점 v에 인접한 방문하지 않은 모든 정점들에 대해 깊이 우선 탐색을 수행한다.
        for(int i = 0; i < neighbours.size(); i++){            
            Node w = neighbours.get(i);
            if(w != null && !w.visited){
                System.out.println(v.info+" -> "+w.info);
                DFS(w);
            }
            else{
                System.out.print(v.info+" -> "+w.info);
                if(w.visited){
                    System.out.println(" 이미 방문");
                }
            }
        }
        System.out.println("["+v.info+"]의 이전 분기로 돌아감");
    }
}