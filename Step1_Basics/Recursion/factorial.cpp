#include<iostream>
using namespace std;

// Space complexity: O(n). As stack memory is occupied by n functional calls.
// Time complexity: O(n)

void para(int i, int fact) {
    if(i==1) {
        cout<<"Factorial of n(para): " << fact;
        return;
    }

    return para(i-1, fact*i);
}

int factorial(int n){
    if( n == 1)
        return 1;
    
    return ( n * factorial(n-1));
}

int main(){

    int n;

    cout<<"Enter n: ";
    cin>>n;

    int f = factorial(n);
    cout<<"Factorial of n (func): " << f << endl;

    para(n,1);

    return 0;
}