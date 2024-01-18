#include<iostream>
using namespace std;

void p10(int n) 
{
    for(int i=0; i<n; i++) 
    {
        for(int j=0; j<=i; j++)
        {
            cout<<"*";
        }
        cout<<endl;
    }

    for(int i=0; i<(n-1); i++) 
    {
        for(int j=i; j<(n-1); j++)
        {
            cout<<"*";
        }
        cout<<endl;
    }
    


}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p10(n);

    return 0;
}

