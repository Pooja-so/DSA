#include<iostream>
#include<math.h>
using namespace std;

 bool isArmstrong(int x) {
    int r=0, n1=x, n2=x, c=0;

    long int num = 0;

    while(n1>0){
        c++;
        n1/=10;
    }

    // cout<<c<<endl;

    while( n2>0){
        r = n2 % 10;
        // cout<<r<<"^"<<c<<"="<<pow(r,c)<<endl;
        num += pow(r,c);
        n2/=10;
    }

    if( num == x )
        return true;
    else
        return false;
}


int main() {

    int n;

    cout<<"Enter a number: ";
    cin>>n;

    if(isArmstrong(n))
        cout<<n<<" is a armstrong number";
    else
         cout<<n<<" is not a armstrong number";
    return 0;
}