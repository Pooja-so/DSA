#include<iostream>
using namespace std;
void triangle(int n);

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    triangle(n);

    return 0;
}

/*
        i: no. of rows
        s: no. of spaces in each row
        j: no. of stars
        n: row number
        m: odd number (m=1,3,5,7,9,....) m+=2
*/

void triangle(int n)
{
    for(int i=0; i<n; i++)
    {
        for(int s=1; s<(i+1); s++)
        {
            cout<<" ";
        }
        for(int j=1; j<=2*(n-i)-1; j++)
        {
            cout<<"*";
        }
        cout<<endl;
    }
}