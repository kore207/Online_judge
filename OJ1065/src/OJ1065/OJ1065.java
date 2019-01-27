package OJ1065;

import java.util.Scanner;

public class OJ1065 {

	public static void main(String[] args) {
		//어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두개의 수의 차이가 일정한 수열을 말한다.
		//N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
		
		//1.입력
		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();
		int cnt = 0;
		int tmp_1, tmp_10, tmp_100;
		
		//2. 동작
		for (int i = 1 ; i < inputN + 1; i ++)
		{
			if(i < 100)//100하의 수는 모두 한수가 된다.
				cnt ++;
			else// if(i >= 100)
			{
				tmp_100 = i / 100; //100의 자리				
				tmp_10 = (i / 10 ) - tmp_100 * 10; //10의 자리								
				tmp_1 = (i / 1) - (tmp_100 * 100) - (tmp_10 * 10) ;// 1의 자리		
				if((tmp_100 - tmp_10) == (tmp_10 - tmp_1))
					cnt++;
			}
		}									
		
		System.out.print(cnt);		
		sc.close();		
	}

}
