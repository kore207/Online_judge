package helloworld;

import java.util.Scanner;

public class OJ2839 {
	public static void main(String[] args) {
		//설탕을 N킬로그램 배달해야한다.
		//봉지는 3, 5킬로그램 봉지가 있다.
		//최대한 적은 봉지를 들고 가야한다.
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int data = 0 ;
		System.out.print(num);
		if((num>=3) && (num <= 5000)) {
			if((num == 7) ||num==4) {
				System.out.printf("-1 \n");				
			}
		}
		else if(num % 5 == 0)		
			data = num / 5;
		else if((num % 5) == 3 || (num % 5) == 1)
			data = num / 5 + 1;
		else if((num % 5) == 2 || (num % 5) == 4)
			data = num / 5 + 2;
		else
			data = -1 ;						
		
		System.out.print(data);
		sc.close();		
	}
}

