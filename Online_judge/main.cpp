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
    int score_num;
    float score[1000] ;
    int score_max=1 ;
    float score_sum = 0 ;
    cin >> score_num ;
    for(int i = 0 ; i < score_num ; i++)
    {
        cin >> score[i] ;
        if(score[i] > score_max)
        {
            score_max = score[i] ;
        }
    }
    for(int i=0 ; i <score_num; i++)
    {
        
        score[i] = (score[i]/score_max)*100 ;        
        score_sum += score[i];
    }
    float avg = score_sum/score_num ;
    cout << avg ;
    
    return 1;
}
