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
void triangle(int n)
{
    for(int i=0; i<n; i++)
    {
        for(int j=i; j<n; j++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }
}
*/

void triangle(int n)
{
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<(n-i); j++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }
}
