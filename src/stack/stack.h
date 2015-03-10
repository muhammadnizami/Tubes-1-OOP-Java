/*
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : stack.h
 * Deskripsi    : Kelas Stackt
 * Tanggal      : 5 Maret 2015
*/

#include <iostream>
#include <cstdio>


#ifndef STACK_H
#define STACK_H


template <class T>
class Stack{
	public:
	
    // Konstruktor
    Stack();
    Stack(int newsize);
    
    // Destruktor
    ~Stack();
    
    //Getter
    int Size();
    int Top();
    
    // Predikat
    int Full();
    int Empty();
    void Push(T elemen);
    T Pop();
    
	private:
    int size;
    int TOP;
    T *Tab;
    
};

// Implementasi

// Konstruktor
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

// Destruktor
template <class T>
Stack<T>::~Stack(){
    delete [] Tab;
    size = 0;
};

//Getter
template <class T>
int Stack<T>::Size(){
    return size;
};

template <class T>
int Stack<T>::Top(){
    return TOP;
};

// Predikat
template <class T>
int Stack<T>::Full(){
    return TOP == size;
};

template <class T>
int Stack<T>::Empty(){
    return TOP == -1;
};

template <class T>
void Stack<T>::Push(T elemen){
    TOP++;
    Tab[TOP] = elemen;
};

template <class T>
T Stack<T>::Pop(){
    T tmp;
    tmp=Tab[TOP];
    TOP--;
    return tmp;
};
#endif
