package puyopuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] map = new char[12][6];
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		
		for(int i = 0; i<12; i++)
			map[i] = br.readLine().toCharArray() ;
		int res = 0;
        while(true) {
            boolean finish = true;
            down();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(map[i][j] == '.') continue;
                    visited = new boolean[12][6];
                    visited[i][j] = true;
                    int cnt = 0;
                    q.add(new Node(i, j));
                    
                    while(!q.isEmpty()) {
                        
                        Node cur = q.poll();
                        cnt++;
                        list.add(cur);
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            
                            if(!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] != map[cur.x][cur.y])
                                continue;
                            
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny));
                        }
                    }
                    
                    if(cnt >= 4) {
                        for(Node node : list) {
                            map[node.x][node.y] = '.';
                        }
                        finish = false;
                    }
                    list.clear();
                }
            }
            
            if(finish) break;
            res++;
        }
        System.out.println(res);
		
		

	}
	static void down() {
        for (int i = 11; i >=0 ; i--) {
            for (int j = 0; j < 6; j++) {
                if(map[i][j] == '.') 
                    continue;
                
                int nx = i;
                char mark = map[i][j];
                map[i][j] = '.';
                while(true) {
                    if(!isRange(nx+1, j) || map[nx+1][j] != '.') 
                        break;
                    nx++;
                }
                map[nx][j] = mark;
            }
        }
    }
    
    static boolean isRange(int x,int y) {
        if( x < 0 || x >= 12 || y < 0 || y >= 6) return false;
        return true;
    }

}

class Node {
    int x;
    int y;
    
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
