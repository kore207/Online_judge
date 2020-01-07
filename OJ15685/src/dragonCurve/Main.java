package dragonCurve ;
import java.io.*;
 import java.util.StringTokenizer;
 
 public class Main {
     static int [][]Map = new int[101][101];
     static int [][]arrow = {{1,0},{0,-1},{-1,0},{0,1}};
 
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
         StringTokenizer st;
         int point[] = new int[2];
         int startDirection , generation;
 
 
         for (int i = 0; i <N ; i++) {
             st = new StringTokenizer(br.readLine());
             point[0] = Integer.parseInt(st.nextToken()); // x
             point[1] = Integer.parseInt(st.nextToken()); // y 
             startDirection = Integer.parseInt(st.nextToken());
             generation = Integer.parseInt(st.nextToken());
 
             Map[point[0]][point[1]] = 1;
 
             int []directions = new int [(int)Math.pow(2,generation)];
             directions[0] = startDirection;
 
             makedirecionts(directions,1,generation);
             draw(point, directions,generation);
         }
 
 
         System.out.println(countMap());
     }
 
     private static int countMap() {
         int cnt=0;
         for (int i=0;i<100;i++){
             for (int j = 0; j <100 ; j++) {
                 if(Map[i][j]==1 && Map[i][j+1]==1 && Map[i+1][j]==1 && Map[i+1][j+1]==1) //사각혀
                     cnt++;
             }
         }
         return cnt;
     }
 
     private static void draw(int[] point, int[] directions , int generation) {
         int nextX,nextY;
         for (int i = 0; i <(int)Math.pow(2,generation) ; i++) {
             nextX = point[0] + arrow[directions[i]][0]; // arrow는 xy 번갈아 가며 상하 좌우  
             nextY = point[1] + arrow[directions[i]][1];
 
             Map[nextX][nextY] = 1;
 
             point[0] = nextX;
             point[1] = nextY;
         }
     }
 
     private static void makedirecionts(int[] directions, int n, int generation) {
         if (n==(int)Math.pow(2,generation)) //after N generation , there are 2^N directions in arr.
             return;
 
         for (int i=0; i<n; i++)
             directions[n+i] = (directions[n-i-1]+1) % 4;
 
         makedirecionts(directions,n*2,generation); //recursion 
     }
 }