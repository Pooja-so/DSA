#include<iostream>
using namespace std;

 bool isPalindrome(int x) {
        int r=0, n=x;
        long int rev = 0;

    // if(x<0)
    //     return false;

    while( n>0){
        r = n % 10;
        rev = rev*10 + r;
        n/=10;
    }

    if( rev == x )
        return true;
    else
        return false;
}


int main() {

    int n;

    cout<<"Enter a number: ";
    cin>>n;

    if(isPalindrome(n))
        cout<<n<<" is a palindrome number";
    else
         cout<<n<<" is not a palindrome number";
    return 0;
}