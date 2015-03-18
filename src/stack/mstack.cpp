/*
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : stack.h
 * Deskripsi    : Kelas Stackt
 * Tanggal      : 5 Maret 2015
*/

// Driver untuk mengetes Kelas Stackt

#include "stack.h"
#include <cassert>
#include <iostream>

using namespace std;

int main(){

	Stack<int> S2;
	assert(S2.Empty());
	for (int i=0;i<1000;i++){
		assert(S2.GetSize()==i);
		S2.Push(i);
	}
	
	Stack<int> S3 = S2;
	
	for(int i=999;i>=0;i--){
		int a;
		S2.Pop(&a);
		assert(S2.GetSize()==i);
		cout<<a<<" "<<i<<endl;
		assert(a==i);
		S3.Pop(&a);
		assert(S3.GetSize()==i);
		cout<<a<<" "<<i<<endl;
		assert(a==i);
	}
	
	
    return 0;
}
