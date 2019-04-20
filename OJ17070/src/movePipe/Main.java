package movePipe;
//
//import java.util.Scanner;
//
//public class Main {	
//		
//	static class PipePosition{
//		int x ;
//		int y ;
//	} 	
//
////	Main.PipePosition front = new PipePosition();
////	Main.PipePosition rear = new PipePosition() ;
//	static PipePosition front = new PipePosition() ; 
//	static PipePosition rear = new PipePosition() ; 
//	static PipePosition tmp = new PipePosition() ; 
//	
//	static int map[][] ;
//	static int mapsize ;
//	static int pipeState ; //파이프가 가로 세로 대각선인지 구분하는 변수
//	static int count = 0; //도달 할 수 있는 경우
//	
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in) ;
//		 mapsize = sc.nextInt() ;
//		
//		map = new int [mapsize+1][mapsize+1]; //첫 쨰줄 맵 크기 정의
//		for(int i = 1; i <mapsize+1 ; i ++)
//			for(int j = 1 ; j < mapsize+1 ; j ++)
//				map[i][j] = sc.nextInt() ;
//
//		
//		front.x = 1; front.y = 1 ;  //파이프 초기 위치 설정 초기엔 부조건 가로 상태
//		rear.x = 2; rear.y = 1 ;
//		
//		movePipe(front, rear);				
//		
//		System.out.print(count);
//					
//		
//	}
//	
//	static void movePipe(PipePosition front, PipePosition rear)
//	{				
//		if((rear.x == mapsize ) && (rear.y == mapsize )) //파이프의 끝이 맵의 끝에 오면 종료 //-1 1,1부터 시작하기 때문에 mapsize까지 검색
//		{
//			count ++ ;
//			return ;
//		}
//		
//		pipeState = PipestateCheck(front, rear) ;
//		if(pipeState == 0) { //가로 인 경우			
//			for(int i=0; i<2; i++) {
//				if(i == 0) { //우측 이동
//					if(rear.x == mapsize)
//						continue ;
//					tmp.x = front.x ;
//					tmp.y = front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.x =rear.x + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;
//					rear.x = rear.x -1 ;
//					
//					
//				}
//				else if(i == 1) { //대각선 이동	
//					if((rear.x == mapsize ) || (rear.y == mapsize )) 
//						continue ;
//					tmp.x = front.x ;
//					tmp.y = front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.x =rear.x + 1 ;
//					rear.y =rear.y + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;	
//					front.x = tmp.x ;
//					front.y = tmp.y ;
//					rear.x = rear.x -1 ;
//					rear.y = rear.y -1 ;
//					
//				}					
//			}			
//		}
//		else if(pipeState == 1) { //세로 인 경우
//			for(int i=0; i<2; i++) {
//				if(i == 0) { //아래 이동
//					if(rear.y == mapsize)
//						continue ;
//					tmp.x = front.x ;
//					tmp.y = front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.y =rear.y + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;					
//					rear.y = rear.y -1 ;
//				}
//				else if(i == 1) { //대각선 이동
//					if((rear.x == mapsize ) || (rear.y == mapsize )) 
//						continue ;
//					tmp.x =front.x ;
//					tmp.y =front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.x =rear.x + 1 ;
//					rear.y =rear.y + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;
//					rear.x = rear.x -1 ;
//					rear.y = rear.y -1 ;
//				}					
//			}	
//		}
//		else if(pipeState == 2) { //대각선 인 경우
//			for(int i=0; i<3; i++) {
//				if(i == 0) { //우측 이동
//					if(rear.x == mapsize)
//						continue ;
//					tmp.x = front.x ;
//					tmp.y = front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.x =rear.x + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;
//					rear.x = rear.x -1 ;					
//				}
//				else if(i == 1) { //대각선 이동
//					if((rear.x == mapsize ) || (rear.y == mapsize )) 
//						continue ;
//					tmp.x =front.x ;
//					tmp.y =front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;
//					rear.x =rear.x + 1 ;
//					rear.y =rear.y + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;
//					rear.x = rear.x -1 ;
//					rear.y = rear.y -1 ;
//				}
//				else if(i == 3) { //아래 이동
//					if(rear.y == mapsize)
//						continue ;
//					tmp.x=front.x ;
//					tmp.y=front.y ;
//					front.x = rear.x ;
//					front.y = rear.y ;					
//					rear.y =rear.y + 1 ;
//					if(wallcheck(pipeState) )
//						movePipe(front, rear) ;
//					front.x = tmp.x ;
//					front.y = tmp.y ;					
//					rear.y = rear.y -1 ;
//				}
//			}	
//		}							
//	}
//	
//	public static int PipestateCheck(PipePosition front, PipePosition rear) {
//		if((rear.x - front.x == 1) && (rear.y - front.y == 0)) //가로
//			return 0 ;
//		else if((rear.x - front.x == 0) && (rear.y - front.y == 1)) //세로
//			return 1 ;
//		else if((rear.x - front.x == 1) && (rear.y - front.y == 1)) //대각선
//			return 2 ;
//		
//		return 3; //error		
//	}
//	
//	public static boolean wallcheck(int pipeState) {
//		
//		if(pipeState == 0 || pipeState == 1) { //가로 나 세로인경우
//			if(map[rear.x][rear.y] == 1)
//				return false ;			
//		}
//		else if(pipeState == 2) {
//			if((map[rear.x][rear.y]== 1) || (map[rear.x][rear.y - 1]== 1) || (map[rear.x - 1][rear.y]== 1))
//				return false ;
//		}	
//		
//		return true ;				
//	}
//
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

 
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        dfs(0,1,1);
        
        System.out.println(cnt);
        
    } // end of main
    static int cnt;
    static int[] dy = {1,0, 1};
    static int[] dx = {0,1, 1}; //아래 오른쪽 대각선
    public static void dfs(int y,int x, int type){
        //type
        //0 : 세로
        //1 : 가로
        //2 : 대각선
        
        //visit[y][x]=true;
        //System.out.println(y+","+x);
        if(y==N-1 && x==N-1) { //도착
            //System.out.println("도착");
            cnt++;
            return;
        }
        
        int[] Dir = getDir(type);
        
        for(int i=0;i<Dir.length;i++) {
 
            int ny = y+dy[Dir[i]];
            int nx = x+dx[Dir[i]];
            
            if(ny<0 || ny>N-1 || nx<0 || nx>N-1 || map[ny][nx]!=0) continue;
            //대각선으로 이동시 주변 4칸이 확보되어 있어야 한다.
            if(Dir[i]==2 && (map[y][x+1]!=0||map[y+1][x]!=0)) continue; 
            
            
            dfs(ny,nx,Dir[i]);
            
        }
        
    }
    
    public static int[] getDir(int type) {
        
        //type
        //0 : 세로
        //1 : 가로
        //2 : 대각선
        
        //아래 오른쪽 대각선
        if(type == 0) { //세로
            int[] ret = {0,2};
            return ret;
        } 
        if(type == 1) { //가로
            int[] ret = {1,2};
            return ret;
        }
        if(type ==2) {
            int[] ret = {0,1,2};
            return ret;
        }
        return null;
    }
    
}