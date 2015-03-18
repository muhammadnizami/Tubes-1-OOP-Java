/*!
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : stack.h
 * Deskripsi    : Kelas Stackt
 * Tanggal      : 5 Maret 2015
*/

//#include <iostream>
//#include <cstdio>
#include <assert.h>

using namespace std;

#ifndef STACK_H
#define STACK_H


template <class T>
class Stack{
	public:
	
    //! Konstruktor
    Stack();
    Stack(int newsize);
    
    //!cctor
    Stack(const Stack &S);

    // Destruktor
    ~Stack();
	
   //! assignment
   Stack<T>& operator=(const Stack &S);
    
    //!Getter
    //! mengembalikan banyaknya elemen yang disimpan di dalam stack
    int GetSize();
    
    //! Predikat
    int Full();
    int Empty();
    void Push(T elemen);
    //! Memasukan elemen ke dalam stack
    //! I.S Stack terdefinisi
    //! F.S. jika penuh Stack akan diresize terlebih dahulu. elemen sudah dimasukan ke dalam stack
    void Pop(T *elemen);
    //! Menghapus elemen di dalam stack
    //! I.S Stack terdefinisi dan tidak kosong
    //! F.S. elemen dihapus dari stack
    
    private:
   	int size;
    	int TOP;
    	T *Tab;
    
};

//! Implementasi

//! Konstruktor
template <class T>
Stack<T>::Stack(){
    TOP = -1;
    size = 10;
    Tab = new T[size];
};

template <class T>
Stack<T>::Stack(int newsize){
    size = newsize;
    TOP = -1;
    Tab = new T[size];
};

//!cctor
template <class T>
Stack<T>::Stack(const Stack &S){
    
    size = S.size;
    TOP = S.TOP;
    Tab = new T[size];
    for(int i = 0; i <= TOP ; i++){
        Tab[i] = S.Tab[i];
    }
};

template <class T>
Stack<T>& Stack<T>::operator=(const Stack &S){
	delete [] Tab;
    size = S.size;
    TOP = S.TOP;
    Tab = new T[size];
    for(int i = 0; i <= TOP ; i++){
        Tab[i] = S.Tab[i];
    }
	return *this;
};

// !Destruktor
template <class T>
Stack<T>::~Stack(){
    delete [] Tab;
    size = 0;
};

//!Getter
template <class T>
int Stack<T>::GetSize(){
    return TOP+1;
};

//! Predikat
template <class T>
int Stack<T>::Full(){
    return TOP+1 == size;
};

template <class T>
int Stack<T>::Empty(){
    return TOP == -1;
};

template <class T>
void Stack<T>::Push(T elemen){
    if(Full()){
//        cout << "Stack penuh\n";
        Stack<T> St(size);
        St.TOP = TOP;
        for(int i =0 ; i <= TOP ;i++){
            St.Tab[i] = Tab[i];
        }
        delete [] Tab;
        size++;
        Tab = new T[size];
        for(int i =0 ; i<= TOP ;i++){
            Tab[i] = St.Tab[i];
        }
    }
    TOP++;
    Tab[TOP] = elemen;
    
};

template <class T>
void Stack<T>::Pop(T *elemen){
    assert (!Empty()); *elemen=Tab[TOP];TOP--;
};
#endif
