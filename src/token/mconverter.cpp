#include "converter.h"

#include <iostream>

using std::cout;
using std::endl;

/*! test untuk kelas Converter */
int main(){
	Converter c;
	Token T;

	T.SetBilangan(1000);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	c.SetMode(c._Romawi);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	T.SetBilangan(true);
	c.SetMode(c._Logika);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	c.SetMode(c._Arab);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	T.SetTkn(Tambah);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	T.SetTkn(Kali);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	c.SetStrOperator("Lolol",Kali);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	T.SetTkn(And);
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;

	Converter c2 = c;
	T.SetTkn(Kali);
	cout << c2.toString(T) << endl;
	cout << c2.toString(c2.toToken(c2.toString(T))) <<endl;

	c2.SetStrOperator("*",Kali);
	cout << c2.toString(T) << endl;
	cout << c2.toString(c2.toToken(c2.toString(T))) <<endl;
	cout << c.toString(T) << endl;
	cout << c.toString(c.toToken(c.toString(T))) <<endl;
	
}
