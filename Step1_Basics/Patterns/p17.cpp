
#include<iostream>
using namespace std;


void p17(int n) {

    for(int i=1; i<=n; i++)
    {
        char c = 'A';

        for(int s=1; s<=n-i ; s++ ) {
            cout<<" ";
        }

        for(int j=1; j<=(i*2)-1; j++)
        {
            if(j>=i) {
                cout<<c;
                c--;
            } else {
                cout<<c;
                c++;
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

    p17(n);

    return 0;
}