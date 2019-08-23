
//https://blog.encrypted.gg/56 

#include <stdio.h>
#include <algorithm>

using namespace std;
typedef pair<int, int> ANT; // distance with end, ID
ANT ant[100001];
int ID[100001]; // position�� �׻� �����ϴ� ������ �����Ƿ� ID�� �����ص� ��
int main(void) {
	int T; //�׽�Ʈ ���̽��� ����
	scanf_s("%d", &T);
	while (T--) {
		int N, l, k; //���� N ����, ���� L , K ��°�� �������� ����
		scanf_s("%d %d %d", &N, &l, &k);
		for (int i = 0; i < N; i++) {
			int a, p; // ���� id, �ʱ���ġ 
			scanf_s("%d %d", &p, &a);
			ID[i] = a;
			if (a < 0) { // dir�� �����ΰ��
				ant[i].first = p + 1;
				ant[i].second = a;
			}
			else { // dir�� �������ΰ�� �� ���� �������� ��ġ 
				ant[i].first = l - p + 1;
				ant[i].second = a;
			}
		}
		sort(ant, ant + N); // (start, end) ������ �ִ� ���ڸ� ������������ ���� (������)
		int left = 0; // ���ʿ��� �������� ������ ��
		int right = 0; // �����ʿ��� �������� ������ ��
		for (int i = 0; i < k - 1; i++) {
			if (ant[i].second < 0) // �������� ���� ���̶��
				left++;
			else // ���������� ���� ���̶��
				right++;
		}
		if (k <= N - 1 && ant[k - 1].first == ant[k].first) { // ant[k-1], ant[k]�� ���ÿ� �������� ��Ȳ. ant[k-1].S < 0, ant[k].S > 0
			printf("%d\n", min(ID[left], ID[N - right - 1])); // ID[left-1] : ant[k-1], ID[N-right-1] : ant[k]
			continue;
		}
		if (k > 1 && ant[k - 1].first == ant[k - 2].first) { // ant[k-2].S < 0, ant[k-1].S > 0
			printf("%d\n", max(ID[left - 1], ID[N - right - 1])); // ID[left-1] : ant[k-2], ID[N-right] : ant[k-1]
			continue;
		}

		if (ant[k - 1].second < 0) // ���ʿ��� �������� ���̶��
			printf("%d\n", ID[left]);
		else
			printf("%d\n", ID[N - right - 1]);
		
	}		
}