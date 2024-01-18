
#include<iostream>
using namespace std;


void p14(int n) {
    

    for(int i=0; i<n; i++)
    {
        int a= 65;
        for(int j=0; j<=i; j++)
        {
            cout<<char(a)<<" ";
            a++;
        }
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p14(n);

    return 0;
}