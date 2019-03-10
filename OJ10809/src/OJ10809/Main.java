package OJ10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();	
		sc.close();
		char alphabet[] = {'a','b','c','d','e',	
						   'f','g','h','i','j',
						   'k','l','m','n','o',
						   'p','q','r','s','t',
						   'u','v','w','x','y',
						   'z'};
	
		int cnt = 0;
	
	
		
		for(int i=0; i < 26; i++)
		{
			for(int j=0; j<word.length(); j++)
			{
				if(word.charAt(j) == alphabet[i])
				{
					System.out.print(cnt + " ");
					cnt = 0 ;		
					break;
				}
				else if(j == word.length() -1)
				{
					System.out.print("-1 ");
					cnt = 0 ;
					break;
				}
				else
					cnt++;
			}
		}
		
	}
}


 
