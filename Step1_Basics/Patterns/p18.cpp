
#include<iostream>
using namespace std;


void p18(int n) {

    for(int i=1; i<=n; i++) 
    {
        char c = 'A';
        c+=(n-i);

        for(int j=1; j<=i; j++) 
        {
             cout<<c<<" ";
             c++;
        }
        cout<<endl;
    }
    
    
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p18(n);

    return 0;
}