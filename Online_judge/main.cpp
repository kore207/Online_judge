//
//  main.cpp
//  Online_judge
//
//  Created by Kim GT  on 03/10/2018.
//  Copyright © 2018 Kim GT . All rights reserved.
//

#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    // insert code here...
    int std_num;
    int std_score[1000] ;
    float std_sum = 0;
    float std_avg ;
    int avg_up = 0;
    float avg_ratio = 0 ;
    int part_num ;
    cin >> part_num ;
    cout << fixed ;
    cout.precision(3) ;
    for(int i = 0; i< part_num; i++)
    {
        cin >> std_num ;
        for(int j = 0; j < std_num ; j ++)
        {
            cin >> std_score[j] ;
            std_sum += std_score[j] ;
        }
        std_avg = std_sum / std_num ;
        for(int k = 0 ; k <std_num ; k++)
        {
            if(std_score[k] > std_avg)
                avg_up++ ;
        }
        avg_ratio = (float)avg_up / (float)std_num ;
        cout << avg_ratio*100 <<"%"<<endl ;
//        std_avg = 0;
        avg_up = 0 ;
        std_sum = 0 ;
        
    }
    return 0 ;
}
