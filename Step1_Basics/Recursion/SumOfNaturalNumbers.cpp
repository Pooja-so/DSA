#include<iostream>
using namespace std;

// Paramterized recursion
void para(int i, int sum) {

    if( i < 1 ) {
    cout<<"The sum (para): " << sum;
    return;
    }

    return para(i-1, sum+i);
}

// Functional recursion
int sum(int n) {

    if( n == 0)
        return 0;
    
    return(n + sum(n-1));
}   

int sumCube(int n) {

    if( n == 0)
        return 0;
    
    return((n*n*n) + sum(n-1));
}   

int main() {
    int n;

    cout<<"Enter n: ";
    cin>>n;

    int s = sum(n);
    cout<<"The sum (func): " << s << endl;

    para(n,0);
    
    return 0;
}