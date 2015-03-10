/*
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : stack.h
 * Deskripsi    : Kelas Stackt
 * Tanggal      : 5 Maret 2015
*/

#include "stack.h"

using namespace std;

int main(){

    Stack<int> S;

    cout << "Size = " << S.Size() << endl;
    cout << "Top = " << S.Top() << endl;
    S.Push(2);
    cout << "Top = " << S.Top() << endl;
    S.Push(3);
    cout << "Top = " << S.Top() << endl;
    cout << S.Pop() << endl;

    return 0;
}