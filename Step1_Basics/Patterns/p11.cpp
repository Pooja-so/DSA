#include<iostream>
using namespace std;

void p11(int n) 
{   
    // s=start, p=next
    int s, p;

    for(int i=1; i<=n; i++) 
    {
        for(int j=1; j<=i; j++)
        {
            if(j==1) {
                if(i % 2 == 1) {
                     s=1;
                     p=0;
                }
                 else {
                    s=0;
                    p=1;
                 }
                cout<<s<<" ";
            }
            else {
                cout<<p<<" ";

                if(p==1)
                    p=0; 
                else
                    p=1;
            }
            
        }
        cout<<endl;
    }
}

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    p11(n);

    return 0;
}

