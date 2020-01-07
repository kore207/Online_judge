import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Main {
	

	static boolean[] visited = new boolean[10001];
	static int[][] map = new int[51][51];
	static ArrayList<Integer> track = new ArrayList<Integer>();
	static int[] dx = {-1, 0, 1, 0 };
	static int[] dy = {0, -1, 0, 1 };
	static int N, L, R, ans;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //size
		L = sc.nextInt();//m 
		R = sc.nextInt(); // max
		
		for(int i=0; i<N; i++)
		{
			String[] c =sc.nextLine().split("");
			int size = c.length;
			
			for(int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(c[j]);
			}
		}
		
		boolean flag = true;
		while(flag) {
			Queue<Integer> q = new LinkedList<Integer>();
			visited = new boolean[10001];
			flag = false;
			ans++;
			//?번째 인구 이동 탐색
			for(int i =0; i<N*N; i++) {
				if(visited[i]) {
					continue;
				}
				track = new ArrayList<Integer>();
				
				int r = i/N;
				int c = i%N;
				q.add(i);
				visited[i] = true;
				track.add(i);
				int total = map[r][c];
				int n = 1;
				
				while(!q.isEmpty()) {
					int v = q.poll();
					r =v/N;
					c=v%N;
					
					for(int k =0; k<4; k++) {
						int nx = c + dx[k];
						int ny = r + dy[k];
						
						if(0<= nx && nx < N && 0 <= ny && ny < N) {
							int next = ny * N + nx;
							
							if(visited[next]) {
								continue;
							}
							
							int count = map[ny][nx];
							int pivot = map[r][c];
							if(L<=Math.abs(count - pivot) && Math.abs(count - pivot) <= R) {
								flag = true;
								q.add(next);
								visited[next] = true;
								track.add(next);
								total += map[ny][nx];
								n++;
							}
						}
					}
				}
				
				int updateN = total /n;
				if( track.size() > 1)
				{
					for(int v: track) {
						r = v / N;
						c = v % N;
						map[r][c] = updateN;
					}
				}
			}
			
		}
		System.out.println(ans -1);

	}

}
