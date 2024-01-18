#include<iostream>
#include<math.h>
using namespace std;

int count1(int n) {

    int c=0;

    while(n!=0) {
        c++;
        n/=10;
    }

    return c;
}

int count2(int n) {
    int c = (int) (log10(n) + 1);
    return c;
}

int main() {

    int n;

    cout<<"Enter a number: ";
    cin>>n;

    cout<< n <<" contains "<< count2(n) <<" digits";
    return 0;
}