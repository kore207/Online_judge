package dragonCurve;

import java.util.Scanner;

public class Main {

	static int N = 0;
	static int [] X ;
	static int [] Y ;
	static int [] D ;
	static int [] G ;
	static int [][] map = new int [101][101]  ;
	static int [][] H = new int [10][1025]; //최대 버퍼 개수는 2^세대 
	static int count = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() ;
		
		X =new int [N];
		Y =new int [N];
		D =new int [N];
		G =new int [N];
		
				
		for(int i = 0 ; i < N; i++) //초기 값 입력 
		{
			X[i] =sc.nextInt();
			Y[i] =sc.nextInt();
			D[i] =sc.nextInt();
			G[i] =sc.nextInt();
		}
		
		
		for(int i=0; i<N; i++)
			dragoncurve(i) ;
	}
	
	public static void dragoncurve(int i) {
		map[X[i]][Y[i]] = 1;
		
		
		H[i][count -1] =D[i];
		
		int curX, curY = 0 ;
		
		if(H[i][count -1] == 0) {
			map[X[i] + 1][Y[i]] = 1 ;
			curX = X[i] + 1 ;
			curY = Y[i] ;
			count *= 2 ;
			
			genCurve(i,count,G[i], curX, curY) ;
		}
		else if(H[i][count -1] == 1) {
			map[X[i]][Y[i] - 1] = 1 ;
			curX = X[i]  ;
			curY = Y[i]-1 ;
			count *= 2 ;
			
			genCurve(i,count,G[i], curX, curY) ;
		}
		else if(H[i][count -1] == 2) {
			map[X[i] - 1][Y[i]] = 1 ;
			curX = X[i] - 1 ;
			curY = Y[i] ;
			count *= 2 ;
			
			genCurve(i,count,G[i], curX, curY) ;
		}
		else if(H[i][count -1] == 3) {
			map[X[i]][Y[i] + 1] = 1 ;
			curX = X[i] ;
			curY = Y[i] + 1;
			count *= 2 ;
			
			genCurve(i,count,G[i], curX, curY) ;
		}
			
		
	}
	
	public static void genCurve(int num, int count, int generation, int curX, int curY) {
		if(generation < 1)
		{
			count = 1;
			return ;
		}
		
		for(int j = 0; j < count/2; j++)
		{
			H[num][(count/2) + j] =  H[num][(count/2) - j - 1] + 1 ;
			if(H[num][(count/2) + j] == 4)
				H[num][(count/2) + j] = 0 ;
		}
		
		
		int c = count /2 ;
		for(int k =c ; k <count; k++)
		{			
			if(H[num][k] == 0) {
				map[curX+1][curY] = 1;
				curX++;
			}
			else if(H[num][k] == 1) {
				map[curX][curY-1] = 1;
				curY--;				
			}
			else if(H[num][k] == 2) {
				map[curX-1][curY] = 1;
				curX--;
			}
			else if(H[num][k] == 3) {
				map[curX][curY+1] = 1;
				curY++;
			}			
			
		}
		count *= 2 ;
		genCurve(num, count, G[num]-1, curX, curY );
		
		
		
		
	}
		
		
		
}

