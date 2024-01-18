#include<iostream>
using namespace std;

void pattern(int n)
{
    for(int i=0; i<n; i++)  
    {
        for(int s=1; s<n-i; s++)
        {
            cout<<" ";
        }
        for(int j=1; j<=((i*2)+1); j++)
        {
            cout<<"*";
        }
            cout<<endl;
    }

}

// void printTriangle(int n) {
        
//         for(int i=0;i<n;++i){
//             for(int j=0;j<n-i-1;++j)
//                 cout<<"*";
//             for(int k=0;k<=i;++k)
//                 cout<<"*";
//             for(int l=0;l<i;++l)
//                 cout<<"*";
//             cout<<endl;
//         }
//     }


int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    pattern(n);
   // printTriangle(n);
    /*
        i: no. of rows
        s: no. of spaces in each row
        j: no. of stars
        n: row number
        m: odd number (m=1,3,5,7,9,....) m+=2
    */
    
    return 0;
}
