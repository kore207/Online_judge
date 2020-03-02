#include <iostream>
using namespace std;
//주어진 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

//소수 : 1과 자기 자신으로밖에 나누어떨어지지 않는 수 (1은 수학적으로 아님)
// 4이상일때 2or 3으로 나누어 떨어지면 소수가 아니다. 라고생각하면 안됨 

int main(void)
{
	int N;
	cin >> N;
	int inputArray[N], cnt = 0;

	for (int i = 0; i < N; i++)
	{
		cin >> inputArray[i];
		bool prime = true;
		if (inputArray[i] == 2 || inputArray[i] == 3)
			cnt++;
		else if (inputArray[i] % 2 == 1 && inputArray[i] > 1) //홀수일때
		{
			for (int j = 2; j < inputArray[i] / 2; j++)
			{
				if (inputArray[i] % j == 0)
				{
					prime = false;
					break;
				}
			}
			if (prime)
				cnt++;
		}
	}

	cout << cnt;
	return 0;
}