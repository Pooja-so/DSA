#include<iostream>
#include<math.h>
using namespace std;


//  the reason behind writing min(a,b) : for eg. gcd(36,40) 36 as any no. greater than 36 i.e. 37, 38, 39, 40 cannot divide 36 to produce 0 as remainder.
int gcd1(int a, int b) {
    int ans=0, it=0;
    for(int i=1; i<=min(a,b); i++){
        it++;
        if(a % i == 0  && b % i == 0) {
             ans=i;
        }
    }
    cout<< endl <<"GCD1: Loop iteartes " << it << " times.";
    return ans;
}


// Useful in such cases for example gcd(40,20) = 20 (Here loop iterates for onll one time)
int gcd2(int a, int b) {
    int ans=0, it=0;
    for(int i=min(a,b); i>=1; i--){
        it++;
        if(a % i == 0  && b % i == 0) {
             ans=i;
             break;
        }
    }
    cout<< endl << endl <<"GCD2: Loop iteartes " << it << " times.";
    return ans;
}

//  Worst Case time complexity of both the functions gcd1 and gcd2 is O(min(a,b))

// ########################################################################################
/*  Euclidean Approach
    Worst Case time complexity: O(log(phi to the base)(min(a,b))) 

*/ 
int euclideanGCD(int a, int b) {
    int it=0;
    while( a > 0   &&     b > 0){
        it++;
        if(a>b)
            a = a % b;
        else
            b = b % a;
    }

    cout<< endl << endl <<"Euclidean: Loop iteartes " << it << " times.";

    if( a == 0)
        return b;

    return a;
}

int main() {

    int a,b;

    cout<<"Enter 2 number: ";
    cin>>a>>b;

    int g1 = gcd1(a,b);
    cout<< endl <<"GCD1 of the two numbers is "<< g1;

    int g2 = gcd2(a,b);
    cout<< endl <<"GCD2 of the two numbers is "<< g2;

    int g3 = euclideanGCD(a,b);
    cout<<endl <<"(Euclidean Approach) GCD of the two numbers is "<< g3;

    return 0;
}