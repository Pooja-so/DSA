#include<iostream>
using namespace std;

int reverse(int n) {
    int r=0, rev=0;

    while( n!=0){
        r = n % 10;
        rev = rev*10 + r;
        n/=10;
    }

    return rev;
}


int main() {

    int n;

    cout<<"Enter a number: ";
    cin>>n;

    cout<<" Reversed number: "<< reverse(n);
    return 0;
}