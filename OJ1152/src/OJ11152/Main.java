package OJ11152;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in) ;
		String input = sc.nextLine().trim(); // .trim은 해당 문자의 앞뒤 공백을 제거한다.
		sc.close();
		
		if(input.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(input.split(" ").length);
		}	
		
	}

}
