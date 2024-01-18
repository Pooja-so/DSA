#include<iostream>
#include<list>
using namespace std;

int main()
{
    list<int> list1;  // list of 0 length
    list<int> list2(7);  // Empty list of size 7

    // Insertion
    list1.push_back(10);
    list1.push_back(20);
    list1.push_back(30);
    list1.push_back(40);

    list<int> :: iterator iter;
    iter = list1.begin(); // iter points to first element of list1
    cout<<*iter<<endl;
    iter++;
    cout<<*iter;

    return 0;
}
