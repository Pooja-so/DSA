/*   
    ***----------------- Data Types ---------------------***
    Primitive                   Derived          User-Defined
    -Integer(1,5,100)          -Function           -class
    -Float(3.14,1.00)          -Array              -structure
    -Character(a,c,#,@)        -Pointer            -union
    -Boolean(0,1)              -Reference          -enum

    ***-----------------Type Modifier ---------------------***
    Type Modifiers are special keywords that are used to modify the range of the data types and 
    also memory allocated to the variables.
    e.g. signed(4 bytes), unsigned(4 bytes), long(8 bytes), short(2 bytes)  
    (int data type is by default signed)

*/

#include<iostream>
using namespace std;

int main() {

    int i; //Declaration
    i=22; //Initialization
    cout<<"Size of int: "<< sizeof(i)<< " bytes" <<endl;    // 4 bytes

    float f; 
    cout<<"Size of float: "<< sizeof(f)<< " bytes" <<endl;  // 4 bytes

    char c;
    cout<<"Size of char: "<< sizeof(c)<< " bytes" <<endl;   // 1 bytes

    bool b;
    cout<<"Size of bool: "<< sizeof(b)<< " bytes" <<endl;   // 1 bytes

    short int si;
    long int li;
    cout<<"Size of short int: "<< sizeof(si)<< " bytes" <<endl;    // 4 bytes
    cout<<"Size of long int: "<< sizeof(li)<< " bytes" <<endl;    // 4 bytes


    return 0;
}