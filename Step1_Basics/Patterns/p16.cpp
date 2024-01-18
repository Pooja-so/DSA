
#include<iostream>
using namespace std;


void p16(int n) {
    char c = 'A';
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<=i; j++)
        {
            cout<<c<<" ";
        }
        c++;
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p16(n);

    return 0;
}