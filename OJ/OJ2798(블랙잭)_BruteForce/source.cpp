#include <iostream>
using namespace std;

int main(void)
{
	int N, M;
	cin >> N; // ī�� ����
	cin >> M; // ������� �ϴ� ��

	int numArray[N]; //�־��� ī�� ��ȣ�� 
	for (int i = 0; i < N; i++)
	{
		cin >> numArray[i];
	}

	int min = 100, resultSum = 0;
	for (int i = 0; i < N - 2; i++)
	{
		for (int j = i + 1; j < N - 1; j++)
		{
			for (int k = j + 1; k < N; k++)
			{
				int sum;
				sum = numArray[i] + numArray[j] + numArray[k];
				//if(abs(M - sum) <= min)
				if (sum <= M && M - sum < M - resultSum)
				{
					// min = abs(M - sum) ;
					resultSum = sum;
				}
			}
		}
	}
	cout << resultSum;

}