#include<iostream>
using namespace std;

void num1(int n) {

    for(int i=1; i<=5; i++) {
        for(int j=1; j<=i; j++) {
            cout<<j<<" "; 
        }
        cout<<endl;
    }
}

void num2(int n) {

    for(int i=1; i<=5; i++) {
        for(int j=1; j<=i; j++) {
            cout<<i<<" "; 
        }
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    num1(n);
    num2(n);

    return 0;
}