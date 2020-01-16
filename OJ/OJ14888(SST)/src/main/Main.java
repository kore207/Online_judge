package main;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int min = Integer.MAX_VALUE ; // MAX, MIN 값이 맞지 않아 오탑 처리 되었었
	static int max = Integer.MIN_VALUE;
	static int [] An ;
	static int [] op; // + - * /
	
	
	

	public static void main(String[] args) {		  
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			
		An = new int [N];
		op = new int [4];
		
		for(int i = 0 ; i < N ; i++)		
			An[i] = sc.nextInt();
		
		for(int i = 0 ; i < 4 ; i++)		
			op[i] = sc.nextInt();
		
		sc.close();
		
		dfs(An[0], 0);//brute-force : dfs 로 모든 값을 탐색 후 최종 값 출력한다. 
					
		System.out.println(max);
		System.out.println(min);
		

	}
	
	public static void dfs(int result, int count) {
		if(count == N-1)
		{
			if(result >max)
				max = result ;
			if(result < min)
				min = result ;
			return ;
		}
		
		for(int i = 0; i < 4;  i++)
		{
			if(op[i] != 0)
			{
				--op[i] ;
				if(i == 0)
				{
					dfs(result + An[count+1], count +1);
				}
				else if(i == 1)
				{
					dfs(result - An[count+1], count +1);
				}
				else if(i == 2)
				{
					dfs(result * An[count+1], count +1);
				}
				else if(i == 3)
				{
					dfs(result / An[count+1], count +1);
				}
				++op[i];
				
			}
		}
			
	}

}
