
#include<iostream>
using namespace std;


void p13(int n) {
    int k=1;

    for(int i=0; i<n; i++)
    {
        for(int j=0; j<=i; j++)
        {
            cout<<k<<" ";
            k++;
        }
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p13(n);

    return 0;
}