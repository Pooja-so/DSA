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

void triangle(int n)
{
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<=i; j++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }
}