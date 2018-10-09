//
//  main.cpp
//  Online_judge
//
//  Created by Kim GT  on 03/10/2018.
//  Copyright © 2018 Kim GT . All rights reserved.
//

//#include <iostream>
//using namespace std;
//
//int main(int argc, const char * argv[]) {
//    // insert code here...
//    int init_num ;
//    int sec_num;
//    int com_num = 0;
//    bool else_flag = false;
//    int cnt = 0 ;
//    cin >> init_num ;
//    if(init_num <10)
//    {
//        else_flag = true ;
//        init_num = init_num * 10 ;
//    }
//    int digit_num[2] ;
//    int temp_digit[2] ;
//    digit_num[0] = init_num / 10 ;
//    digit_num[1] = init_num - (digit_num[0]*10) ;
//
//    while(com_num != init_num)
//    {
//        if(else_flag == true)
//        {
//            init_num = init_num / 10 ;
//        }
//        cnt++ ;
//        sec_num = digit_num[0] + digit_num[1] ;
//        if(sec_num > 9)
//        {
//            temp_digit[0] = sec_num / 10 ;
//            temp_digit[1] = sec_num - (temp_digit[0] * 10) ;
//            com_num = (digit_num[1] * 10) + temp_digit[1] ;
//        }
//        else
//        {
//            com_num = (digit_num[1] * 10) + sec_num ;
//        }
//
//        digit_num[0] = com_num /10 ;
//        digit_num[1] = com_num - (digit_num[0]*10) ;
//
//    }
//    cout << cnt ;
//
//    return 0 ;
//
//}
#include <stdio.h>

int main(void){
    int number;
    int count = 0;
    int A, B, C , Add;
    scanf("%d", &number);
    Add = number;
    while (Add != number || count==0){
        A = Add / 10;
        B = Add % 10;
        C = (A + B) % 10;
        A = B; B = C;
        Add = A * 10 + B;
        count++;
    }
    
    printf("%d\n", count);
    
}



