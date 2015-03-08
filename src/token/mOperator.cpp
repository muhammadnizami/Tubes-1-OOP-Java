#include "Operator.h"

#include <iostream>

using std::cout;
using std::endl;

int main(){
	Operator* b = new Operator();

	StrToken * a = b;
	cout<<a->toString(a->toToken("+"))<<endl;
	cout<<a->toString(a->toToken("-"))<<endl;
	cout<<a->toString(a->toToken("*"))<<endl;
	cout<<a->toString(a->toToken("/"))<<endl;
	cout<<a->toString(a->toToken("div"))<<endl;
	cout<<a->toString(a->toToken("%"))<<endl;
	cout<<a->toString(a->toToken("("))<<endl;
	cout<<a->toString(a->toToken(")"))<<endl;
	cout<<a->toString(a->toToken("&"))<<endl;
	cout<<a->toString(a->toToken("|"))<<endl;
	cout<<a->toString(a->toToken("~"))<<endl;

	b->SetString(Tambah,"tambah1**");
	b->SetString(Kurang,"kurang1**");
	b->SetString(Kali,"kali1**");
	b->SetString(Bagi,"bagi1**");
	b->SetString(Not,"notlalala**");
	cout<<a->toString(a->toToken("tambah1**"))<< a->toToken("tambah1**").ToStr() << endl;
	cout<<a->toString(a->toToken("kali1**"))<< a->toToken("kali1**").ToStr() << endl;
	cout<<a->toString(a->toToken("kurang1**"))<< a->toToken("kurang1**").ToStr() << endl;
	cout<<a->toString(a->toToken("bagi1**"))<< a->toToken("bagi1**").ToStr() << endl;
	cout<<a->toString(a->toToken("notlalala**"))<< a->toToken("notlalala**").ToStr() << endl;
	cout<<a->toString(a->toToken("("))<< a->toToken("(").ToStr() << endl;

	
}
