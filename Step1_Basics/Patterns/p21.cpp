#include<iostream>
using namespace std;

void p(int n) {
    
    for(int i=1; i<=n; i++){
        
        if(i==1 || i==n) {
            for(int j=1; j<=n-1; j++){
                cout<<" *";
            }
        } else if((i%2) == 1) {
            for(int j=1; j<=n-1; j++){
                if(j==1 || j==n-1) 
                    cout<<" *";
                else
                    cout<<"  ";
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

    p(n);

    return 0;
}

