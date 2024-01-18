
#include<iostream>
using namespace std;


void p15(int n) {

    for(int i=0; i<n; i++)
    {
        int a= 65;
        for(int j=i; j<n; j++)
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

    p15(n);

    return 0;
}