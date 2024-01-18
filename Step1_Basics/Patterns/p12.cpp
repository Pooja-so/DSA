
#include<iostream>
using namespace std;

// int s[10]=0;
// int top=-1;

void p12(int n) {

    

    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=i; j++) 
        {
            cout<<j;

        }
        for(int s=1; s<= (n*2 - i*2); s++)
        {
                cout<<" ";
        }
        for(int j=i; j>=1; j--) 
        {
            cout<<j;

        }
        
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p12(n);

    return 0;
}