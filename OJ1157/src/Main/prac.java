package Main;

import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		sc.close();
		
		int[] cnt = new int[26]; //알파벳의 개수를 카운트할 배열
		int max = 0;
		char answer = '?';
		
		for(int i = 0 ; i < str.length(); i++)
		{
			cnt[str.charAt(i)-65]++;
			if(max < cnt[str.charAt(i)-65])
			{
				answer = str.charAt(i);
				max = cnt[str.charAt(i)-65];
			}
			else if(max == cnt[str.charAt(i)-65])
				answer = '?' ;
		}
		
		System.out.println(answer);

	}

}
