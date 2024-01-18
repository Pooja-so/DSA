#include<iostream>
using namespace std;

// int cnt=0;

void name(int n){
    if(n == 0 )
        return;
        
    cout<< " Pooja " << endl;
    // cnt++;
    name(n-1);

}

int main() {
    int n;

    cout<<"Enter n: ";
    cin>>n;

    name(n);

    return 0;
}