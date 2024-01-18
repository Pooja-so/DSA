#include<iostream>
using namespace std;



void swap(int* a, int* b){
    int tmp = *a;
    *a = *b;       
    *b = tmp;
}


void printArray(int a[], int n) {

    for(int i=0; i<n; i++){
       cout << " " << a[i];     
    }
}

void reverse1(int a[], int i, int j){
    if(i>=j)
        return;
    
    swap(&a[i], &a[j]);
    return reverse1(a, i+1, j-1);
}

void reverse2(int a[], int i, int n){
    if(i>=(n/2))
        return;
    
    swap(&a[i], &a[n-i-1]);
    return reverse2(a, i+1, n);
}

int main(){

    int a[5] = {11, 22, 33, 44, 55};

    cout << endl << " The original array: ";
    printArray(a, 5);

    reverse2(a, 0, 5);

    cout << endl << " The reversed array: ";
    printArray(a, 5);

    return 0;
}