#include<iostream>
using namespace std;

int main()
{
    int a,b,c, max=0;;

    cout<<"Enter the value for a, b, c: ";
    cin>>a>>b>>c;

    if(a>b && a>c)
        max=a;
    else if(b>c)
        max=b;
    else
        max=c;
    
    cout<<"Maximun no: "<<max;
    return 0;
}