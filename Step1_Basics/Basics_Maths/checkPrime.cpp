// Prime Numbers: A number which has excatly 2 factors which is 1 and itself 
#include<iostream>
using namespace std;

/* Brute Force approach
// Not an efficient function as the loop iterates n times. So Time Complexity is O(n) 
bool isPrime(int n){
    int cnt=0;
    for(int i=1; i<=n; i++){
        if(n % i == 0)
            cnt++;
    }
    if(cnt==2)
        return true;
    else
        return false;
}
*/

// All the factors can be found in sqrt(n) times. So need to iterates for n times.

bool isPrime(int n){
    int flag=1;

    //  for(int i=2; i<=sqrt(n); i++)
    for(int i=2; i*i<=n; i++){
        if(n % i == 0) {
            cout<< n << " % " << i << " = " << n % i<< endl;
            flag=0;
            break;
        }
    }
    return flag;
}

int main(){
    int n;

    cout<<endl<<"Enter n: ";
    cin>>n;

    // int ans = isPrime(n);

    if(isPrime(n))
        cout<< n << " is prime number."<<endl;
    else
        cout<< n << " is not a prime number."<<endl;
}


