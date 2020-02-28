#include <iostream>
using namespace std;

int main(void)
{
	int N;
	cin >> N;
	//각 자리수를 구하기 위한 방법 	 ex) 314
	//1. 10으로 모드연산      314 % 10 = 4
	//2. 10으로 나눈다        314/10 = 31 
	//3. 10으로 모드연산      31 % 10 = 1 
	//4. 10으로 나눈다        31/10 =3
	//5. 10으로 모드연산      3 % 10 = 0 
	//6 모드연산 결과가 0이면 정지 	
	// 시작값 + 모드연산의 결과값들을 더한다 .			

	int cnt = 1;
	while (1)
	{
		int indexNum = cnt;
		int sum = cnt;
		while (indexNum)
		{
			sum += indexNum % 10;
			indexNum /= 10;
		}
		if (sum == N)
		{
			cout << cnt;
			return 0;
		}
		if (cnt == N)
		{
			cout << 0;
			return 0;
		}
		cnt++;
	}
	return 0;
}