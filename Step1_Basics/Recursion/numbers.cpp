#include<iostream>
using namespace std;


// without backtracking
void numN_To_1(int n){
    if(n == 0 )
        return;
        
    cout<< n << endl;
   
    numN_To_1(n-1);

}

// with backtracking
void numN_To_1(int n){
    if(n == 5 )
        return;
        
    numN_To_1(n-1);

     cout<< n << endl;

}

// Backtracking
void num1_To_N(int n){
    if(n == 0 )
        return;
       
    num1_To_N(n-1);

    cout<< n << endl;

}



int main() {
    int n;

    cout<<"Enter n: ";
    cin>>n;

    cout << endl << "From 5 to 1: "<< endl;
    numN_To_1(n);

    cout << endl << "From 1 to 5: "<< endl;
    num1_To_N(n);

    return 0;
}
