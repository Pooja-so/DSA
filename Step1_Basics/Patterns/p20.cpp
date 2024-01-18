#include<iostream>
using namespace std;

void p1(int n){
    for(int i=1; i<=n; i++){
        
        int j,s,k;

        for(j=1; j<=i; j++){
            cout<<"*";
        }
        for(s=j; s<=(2*n)-i; s++){
            cout<<" ";
        }
        for(k=s; k<=(2*n); k++){
            cout<<"*";
        }
        cout<<endl;
    }
}

void p2(int n){
    for(int i=1; i<=n; i++){
        
        int j,s,k;

        for(j=1; j<=n-i; j++){
            cout<<"*";
        }
        for(s=j; s<=n+i; s++){
            cout<<" ";
        }
        for(k=s; k<=(2*n); k++){
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

    p1(n);
    p2(n);

    return 0;
}