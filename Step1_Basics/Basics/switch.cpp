#include<iostream>
using namespace std;

int main()
{

    char btn;

    cout<<"Input a character: ";
    cin>>btn;

    switch(btn)
    {
        case 'a': cout<<"Hello"; // warning: Keep space between case and 'a'
        break;

        case 'b': cout<<"Namaste";
        break;

        default: cout<<"Bye";
    }

    return 0;
}