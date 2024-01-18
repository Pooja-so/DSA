#include<iostream>
using namespace std;
void square(int n);

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    square(n);

    return 0;
}

void square(int n)
{
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }
}