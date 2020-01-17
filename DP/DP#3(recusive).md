### 문제

정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오. (시간 복잡도 제한 없습니다).

예제)

Input: 1

Output: ["()"]

Input: 2

Output: ["(())", "()()"]

Input: 3

Output: ["((()))", "(()())", "()(())", "(())()", "()()()"]



```c
#include <iostream>
#include <list>

using namespace std;

void recurse(list<string> ans, string cur, int open, int close, int n) ;

int main()
{
    int num ;
    cin >> num ;
    list<string> L;
    
    recurse(L, "", 0, 0, num) ;
    
    return 0 ;
}

void recurse(list<string> ans, string cur, int open, int close, int n){
    if(cur.length() == n * 2){
        ans.push_back(cur) ;
        cout << cur <<endl;                
        return ;
    }

     if(open < n)
        recurse(ans, cur + "(", open + 1, close, n) ;
      if(close < open)
        recurse(ans, cur + ")", open, close + 1, n) ;
}


```

