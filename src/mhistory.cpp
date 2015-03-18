/*
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : history.h
 * Deskripsi    : Driver hisory untuk mengetes Kelas History
 * Tanggal      : 5 Maret 2015
*/
//! Driver hisory untuk mengetes Kelas History
#include <iostream>
#include <cstdio>
#include <cassert>
#include "history.h"

using namespace std;

int main(){
	string s,r;

	getline(cin,s);
	cin >> r;
	cout << s << endl;
	cout << r;
	History H(s,r);

	cout <<"GetAllBoth\n"<< H.GetAllBoth();

	History H2;
	H2.Add("a2","a1");
	H2.Add("aaa","aaa");
	H2.Add("aaaa","aaaa");
	cout<<H2.GetAllBoth();
	assert(H2.GetAllBoth() == "a2 = a1\naaa = aaa\naaaa = aaaa\n");
	assert(H2.GetBoth(2) == "aaa = aaa\naaaa = aaaa\n");
	

	return 0;
}
