### 문제

랜덤한 정수 배열이 주어지면 중복된 원소의 값을 모두 프린트 하시오. 단, 공간복잡도 O(1)이여야 합니다.

input: [0, 6, 3, 4, 0]

output: 0

input: [5, 4, 3, 2, 1, 1, 1, 1, 1, 2]

output: 1, 2



```c 
#include <iostream>

using namespace std ;

int main()
{
    int inputArray[10] ;

    for(int i = 0 ; i < 10 ; i ++)
        cin >> inputArray[i] ;

    for(int i = 0 ; i < 10 ; i ++)
    {
        for(int j = i+1 ; j <10 ; j++)
        {
            if(inputArray[i] == inputArray[j])
                cout << inputArray[i] ;
        }
    }    
    
    return 0 ;
}
```

### 풀이

이 문제는 두가지 방법으로 풀 수 있습니다.

첫째는 시간복잡도를 제일 효율적으로 푸는 것이고 두번째는 공간복잡도를 제일 효율적으로 푸는 것입니다.



시간복잡도를 제일 효율적으로 푼다면, 해쉬맵(hashmap)를 만든후 주어진 배열의 모든 원소를 해쉬맵에 갯수를 저장하면 됩니다.

```
def printDuplicates(arr): 
    dict = {} 
    for element in arr: 
        try: 
            dict[element] += 1
        except: 
            dict[element] = 1
              
    for item in dict: 
        if(dict[item] > 1): 
            print(item)
```

시간복잡도 O(n)

공간복잡도 O(n)



두번째은 공간복잡도를 쓰지 않는것 입니다. 이 경우엔 배열을 O(nlogn) 알고리즘으로 정렬하여 배열의 모든 원소를 체크합니다. 각 원소마다 다음 원소의 값과 비교하여 같다면 프린트하면 됩니다.

```
def printDuplicates(arr):
    arr.sort()
    print (arr)
    last_dup = None
    for i in range(len(arr) - 1):
        if arr[i] == arr[i+1] and arr[i] != last_dup:
            last_dup = arr[i]
            print arr[i]
```

시간복잡도 O(nlogn)

공간복잡도 O(1)