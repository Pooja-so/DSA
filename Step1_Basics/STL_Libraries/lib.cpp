#include<bits/stdc++.h>

using namespace std;

/*
    A pair is a container that combines two elements of the same or different data types.
    It consist of two elements, first and second must be in this order and the are accessed by dot(.) opeartor and the keyword first and second.
*/

void explainPair() {
     // pair<int, int> p = {10, 20}; // not allowed in c++98
    pair<int, int> p(10, 20);
    cout<< p.first << " " << p.second;


    // pair< pair<int, int>, int >  p3;
    // // pair< pair<int, int>, int> p1, p3;

    pair<pair<int,int>, int> p3;
    p3=make_pair(make_pair(1,2),3);
    cout << endl << p3.first.first << " " << p3.first.second << " " << p3.second;

    pair< int, pair<int,int> > p2;
    p2=make_pair(4, make_pair(5,6));
    cout << endl << p2.first << " " << p2.second.first << " " << p2.second.second;

    

    pair<int, int> arr[] = {{1,2}, {2,4}, {3,6}};
    cout<< endl << arr[0].first << arr[0].second;
    cout<< endl << arr[1].first << arr[1].second;
    cout<< endl << arr[2].first << arr[2].second;

}

/*
 2. Vectors are used to store elements of similar data types. However, unlike arrays, the size of a vector can grow dynamically i.e. we can change the size of the vector during runtime.
 Declaraton: vector<T> vector_name;
            where <T> cane be any prirmitive data type such as int, char, float etc.
 Example: vector<int> num; (here unlike arrays we need not to specify the size of vector during declaration because the size can grow dynamically.)
*/
void explainVector() {

    /*-----------------------Vector Declaration------------------------------*/

   std::vector<int> v; //It creates an empty conatiner {}

    // emplace_back(data) is faster than push_back(data): read article for reason
    v.push_back(1); // {1}
  //  v.emplace_back(2); // {1,2}

    vector<pair<int, int> > vec;
   // vec.push_back({1,2});
  //  vec.emplace_back(1,2);

    vector<int> v1(5); //Declares vector of size 5 with 5 garbage values or zeros depending on the compiler
    vector<int> v2(5, 100); //Declares vector of size 5 with 5 instances v2 = {100, 100, 100, 100, 100}
    vector<int> v3(5, 20); // v3 = {20, 20, 20, 20, 20}
    vector<int> v4(v3); // Creates copy of vector v3 .i.e. v4 = {20, 20, 20, 20, 20}

    /*----------------------Accessing Vector----------------------------------------
       -> Vectors elements are stored in contigiuous memory location. So it can be accessed using index.
       -> vector<T> vector_name = { 10,  20,   30 ,  40 } 
                                  v[0]  v[1]  v[2]  v[3]

        There are two ways to acces vectors:
        1. using index  
        -> Syntax: vector_name[index]    or    vector_name.at(index)    

        2. using iterators
        -> Iterator points to the memory address not the element.
        -> Syntax: vector<T>::iterator iterator_name = vextor_name.begin()
    */

   cout<< endl << "Accessing vectors: ";
   vector<int> vi;

   vi.push_back(10);
   vi.push_back(20);
   vi.push_back(30);
   vi.push_back(40);
   vi.push_back(50);

   vector<int>::iterator it = vi.begin(); // Points to the memory location of first element
   cout << endl << *(it); // Value value which the iterator is pointing to
   it++; // Increment iterator by 1
   cout << endl << *(it); // Value value which the iterator is pointing to

   it = it + 2;
   cout << endl << *(it);

   vector<int>::iterator i = vi.end(); // Points to the memory location after the last elemnet
   cout << endl << *(i); 
   i--;
   cout<< endl << *i;

    // vector<int>::iterator re = vi.rend(); // Points to the memory location before the first element
    // cout << endl << *(re); 
    // re++;
    // cout<< endl << *(re);

    
    // vector<int>::iterator rb = vi.rbegin(); // Points to the memory location to the last element
    // cout << endl << *(rb); 
    // rb++;
    // cout<< endl << *(rb);


    cout << endl << vi[0] << " " << vi.at(0);
    cout << endl << vi.back() << " "; // Returns a read/write reference to the data at the last  element of the %vector.

    cout<< endl << "The elements of vector: ";
    for(vector<int>::iterator it = vi.begin(); it != vi.end(); it++) {
        cout << " " << *(it);
    }

   
    cout<< endl << "The elements of vector: ";
    for(auto it = vi.begin(); it!=vi.end(); it++){
        cout << " " << *(it);
    }

    /*-------------------------Erasing Vector----------------------------------------*/
    /* Need to use begin() function. */

    vi.erase(vi.begin());  // Deleting first element i.e. Element at 0th index

    cout<< endl << "The elements of vector after erasing: ";
    for(vector<int>::iterator it = vi.begin(); it != vi.end(); it++) {
        cout << " " << *(it);
    }


    // vector<int>::iterator k = vi.begin();

    vi.erase(vi.begin() + 2, vi.begin() + 4); //// Deleting element at index 2 and 4


    cout<< endl << "The elements of vector after erasing: ";
    for(vector<int>::iterator it = vi.begin(); it != vi.end(); it++) {
        cout << " " << *(it);
    }

    /*-------------------------Inserting data into Vector----------------------------------------*/
    /* Need to use begin() function. */
    // Syntax: insert(vector<int>::iterator position, int data)

    vector<int> va(2, 100);  // {100, 100}
    va.insert(va.begin(), 300);  // {300, 100, 100}
    va.insert(va.begin() + 1, 2, 10);  // {300, 10, 10, 100, 100}

    //Inserting vector into another vector
    vector<int> c(2, 50);  // {50, 50}
    // va.insert(va.begin(), c.begin(), c.end());  // {50, 50, 300, 10, 10, 100, 100}
    va.insert(va.end(), c.begin(), c.end());  // {300, 10, 10, 100, 100, 50, 50}

    cout<< endl << "The elements of vector after inserting: ";
    for(vector<int>::iterator it = va.begin(); it != va.end(); it++) {
        cout << " " << *(it);
    }

    /*-------------------------Other functions of Vector----------------------------------------*/
    vector<int> vs(2, 100);

    vs.push_back(20);
    vs.push_back(30);

    vs.size(); // 3

    vs.pop_back(); // Pops out the last element {100, 100, 20}

    //  v1 -> {10, 20}   and     v2 -> {30, 40}
    v1.swap(v2); // v1 -> {30, 40} and v2 -> {10, 20}

    v.clear(); // Erases the entire vector {}

    cout<< endl << "Vector v is: "<< v.empty(); //Returns true - 1 if the %vector is empty. (Thus begin() would equal end().) otherwise false - 0

}


//  Insert in a vector is costilier
void explainList() {
    list<int> ls;

    ls.push_back(2);  // {2}
    ls.emplace_back(4);  // {2, 4}

    ls.push_front(5);  // {5, 2, 4}

    ls.emplace_front(); // {2, 4}
}


void explaindeque() {
    deque<int> dq;

    dq.push_back(1);  // {1}
    dq.emplace_back(2);  // {1, 2}
    dq.push_front(4); // {4, 1, 2}
    dq.emplace_front(3); // {3, 4, 1, 2}

    dq.pop_back();  // {3, 4, 1}
    dq.pop_front();  // {4, 1}

    dq.back();
    dq.front();

    // Rest functions are same as vector
    // begin, end, rbegin, rend, clear, insert, size, swap
}

void explainStack() {
    // Accesssing element through index is not allowed

    stack<int> st;
    st.push(1); // {1}
    st.push(2); // {2, 1}
    st.push(3); // {3, 2, 1}
    st.push(4); // {4, 3, 2, 1}
    st.emplace(5); // {5, 4, 3, 2, 1}

    cout << endl << st.top(); // print 5 "** st[2] is invalid **"

    st.pop(); // { 4, 3, 2, 1}

    cout << endl << st.top(); // 4

    cout << endl << st.size();  // 4

    cout << endl << st.empty();  // Prints 0  (means false)

    stack<int> s1, s2;
    s1.swap(s2);
}

void explainQueue() {
    queue<int> q;
    q.push(1); // {1}
    q.push(2); // {1, 2}
    q.push(3); // {1, 2, 3}
    q.emplace(4); // {1, 2, 3, 4}

    q.back() += 5;  // q.back() = 4 + 5

    cout << endl << q.back();  // 9

    cout << endl << q.front();  // 1

    cout << endl << q.size();  // 4

    q.pop(); // {2, 3, 9}

    cout << endl << q.front();  // 2
    cout << endl << q.back();   // 9

    q.pop(); // {3, 9}
    cout << endl << q.front(); //3

    q.pop(); // {9}
    cout << endl << q.front(); // 9
}

void explainPriorityQueue() {
    //  priority_queue<int> pq;  the largest elements stays at the top i.e. stores data in descending order
    // priority_queue<int, vector<int>, greater<int> > pq1; i.e. stores data in ascending order
    /* Time complexity
        push(): Ologn,  pop(): Ologn,   top(): O(1)
    */  


    priority_queue<int> pq;
    pq.push(5);  // {5}
    pq.push(2);  // {5, 2}
    pq.push(8);  // {8, 5, 2}
    pq.emplace(10);  // {10, 8, 5, 2}

    cout << endl << pq.top(); // 10

    pq.pop(); // {8, 5, 2}

    cout << endl << pq.top(); // 8

    //  size and swap and empty functions are same as others

    // Minimum Heap
    priority_queue<int, vector<int>, greater<int> > pq1;
    pq.push(5); // {5}
    pq.push(2); // {2, 5}
    pq.push(8); // {2, 5, 8}
    pq.emplace(10); // {2, 5, 8, 10}

    cout << endl << pq.top(); // 2


}


int main() {

//    explainPair();
//    explainVector();
//    explainList();
//    explaindeque();
//    explainStack();
   explainQueue();
   explainPriorityQueue();

    return 0;
}