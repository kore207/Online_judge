
//https://blog.encrypted.gg/56 

#include <stdio.h>
#include <algorithm>

using namespace std;
typedef pair<int, int> ANT; // distance with end, ID
ANT ant[100001];
int ID[100001]; // position이 항상 증가하는 순으로 들어오므로 ID만 저장해도 됨
int main(void) {
	int T; //테스트 케이스의 개수
	scanf_s("%d", &T);
	while (T--) {
		int N, l, k; //개미 N 마리, 길이 L , K 번째로 떨어지는 개미
		scanf_s("%d %d %d", &N, &l, &k);
		for (int i = 0; i < N; i++) {
			int a, p; // 개미 id, 초기위치 
			scanf_s("%d %d", &p, &a);
			ID[i] = a;
			if (a < 0) { // dir이 왼쪽인경우
				ant[i].first = p + 1;
				ant[i].second = a;
			}
			else { // dir이 오른쪽인경우 끝 길이 기준으로 위치 
				ant[i].first = l - p + 1;
				ant[i].second = a;
			}
		}
		sort(ant, ant + N); // (start, end) 범위에 있는 인자를 오름차순으로 정렬 (퀵정렬)
		int left = 0; // 왼쪽에서 떨어지는 개미의 수
		int right = 0; // 오른쪽에서 떨어지는 개미의 수
		for (int i = 0; i < k - 1; i++) {
			if (ant[i].second < 0) // 왼쪽으로 가는 개미라면
				left++;
			else // 오른쪽으로 가는 개미라면
				right++;
		}
		if (k <= N - 1 && ant[k - 1].first == ant[k].first) { // ant[k-1], ant[k]가 동시에 떨어지는 상황. ant[k-1].S < 0, ant[k].S > 0
			printf("%d\n", min(ID[left], ID[N - right - 1])); // ID[left-1] : ant[k-1], ID[N-right-1] : ant[k]
			continue;
		}
		if (k > 1 && ant[k - 1].first == ant[k - 2].first) { // ant[k-2].S < 0, ant[k-1].S > 0
			printf("%d\n", max(ID[left - 1], ID[N - right - 1])); // ID[left-1] : ant[k-2], ID[N-right] : ant[k-1]
			continue;
		}

		if (ant[k - 1].second < 0) // 왼쪽에서 떨어지는 개미라면
			printf("%d\n", ID[left]);
		else
			printf("%d\n", ID[N - right - 1]);
		
	}		
}