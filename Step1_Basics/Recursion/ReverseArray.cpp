#include<iostream>
using namespace std;

void printArray(int a[], int n) {
    for(int i=0; i<n; i++){
       cout << " " << a[i];     
    }
}

void swap(int* a, int* b){
    int tmp = *a;
    *a = *b;       
    *b = tmp;

}


void reverse1(int a[], int n) {
    for(int i=0, j=n-1; i<j; i++,j--){
            swap(&a[i], &a[j]);
    }
}

void reverse2(int a[], int n) {
    for(int i=0; i<(n/2); i++){
            swap(&a[i], &a[n-i-1]);
    }
}



int main() {

    int a[5] = {11, 22, 33, 44, 55};

    cout << endl << " The original array: ";
    printArray(a, 5); 

    reverse2(a, 5);

    cout << endl << " The reversed array: ";
    printArray(a, 5);

    return 0;
}