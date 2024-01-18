#include<iostream>
using namespace std;
void diamond(int n);

int main()
{
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    diamond(n);

    return 0;
}

void diamond(int n)
{
    // Upper diamond
   for(int i=0; i<n; i++)
   {
    for(int s=1; s<n-i; s++)
    {   
        cout<<" ";  
    }    
    for(int j=1; j<=(i*2)+1; j++)
    {   
        cout<<"*";  
    }  
    cout<<endl;  
   }

    //  lower diamond
    for(int i=0; i<n; i++)
    {
        //for(int s=1; s<i+1; s++)
        for(int s=1; s<i+2; s++)
        {
            cout<<" ";
        }
        // for(int j=1; j<=2*(n-i)-1; j++)
        for(int j=1; j<=2*(n-i-1)-1; j++)
        {
            cout<<"*";
        }
        cout<<endl;
    }  


}