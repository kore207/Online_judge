#include <iostream>
using namespace std;

int main()
{
    int beat[8] , output;

    //000 001 = 1 010 =2  100 = 4
    for(int i=0 ; i<8 ; i++)    
        cin >> beat[i] ;

    // switch (beat[7])
    // {
    // case 8:
    //     cout << "ascending" ;
    //     break;
    // case 1:
    //     cout << "descending" ;
    //     break;            
    // default:
    //     cout << "mixed" ;
    //     break;
    // }
    if(beat[7] == 8)
        cout << "ascending" ;
    else if(beat[7] == 1)
        cout << "descending" ;
    else
        cout << "mixed" ;
    
    return 0 ;
}