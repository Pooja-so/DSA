#include<iostream>
#include<bits/stdc++.h>
// #include<math.h>
using namespace std;

// Time complexity is O(n)
void divisor1(int n) {
    
    for(int i=1; i<=n; i++){
        if(n%i == 0)
            cout<<i<<" ";
    }
}

/*  Divisors of n = 36
  # # # # # # # # # # # # #  #
  #  1 x 36     =   1 x n/1  #
  #  2 x 18     =   2 x n/2  #
  #  3 x 12     =   3 x n/3  #
  #  4 x 9      =   4 x n/4  #
  # # # # # # # # # # # # #  #
  #  6 x 6      =   sqrt(n) x sqrt(n)  # 
  # # # # # # # # # # # # #  #
    9 x 4
    12 x 3
    18 x 2
    36 x 1
*/

// Time Complexity = O()
void divisor2(int n) {   
    vector<int> ls;
    /* Since sqrt() is a mathematical function it will take some amount of time to execute.
     so, we can use i*i <= n 
               i.e. 6*6 <= 36 True
               i.e. 7*7 <= 36 False
    */

    // for(int i=1; i<=sqrt(n); i++) 
    // i<=sqrt(n) i.e. square(i)<=n  -----(side change)

    //Loops runs for O(sqrt(n)) times 
    for(int i=1; i*i<=n; i++) {
        if(n%i == 0){
            ls.push_back(i);
            
            if((n/i) != i){
                ls.push_back(n/i);
            }
        }
    }
    // Time complexity of sort function - O(n logn) (Here n is the no. of factor)
    sort(ls.begin(), ls.end());
    for(vector<int>::iterator it = ls.begin(); it != ls.end(); it++){
        cout << " " << *(it);
    }
}

int main() {
    int n;

    cout<<"Enter n: ";
    cin>>n;

    divisor2(n);

    return 0;
}