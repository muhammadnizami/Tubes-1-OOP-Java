#include "Romawi.h"
#include "StrToken.h"

#include <iostream>

using std::cout;
using std::endl;

int main(){
	StrToken * a = new Romawi();
	Token t;
	t.SetBilangan(1000);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(900);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(450);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(52);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(44);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(44.5f);
	cout<<a->toString(t)<<endl;
	t.SetBilangan(100001);
	cout<<a->toString(t)<<endl;

	t.SetBilangan(1.9f);
	cout<<a->toString(t)<<endl;

	t.SetBilangan(1329);
	cout<<a->toString(t)<<endl;

	cout<<a->toString(a->toToken("MXVII"))<<endl;
	cout<<a->toString(a->toToken("MXXXI"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS•"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS••"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS•••"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS••••"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS•••••"))<<endl;
	cout<<a->toString(a->toToken("CDXLIVS••••••"))<<endl;
	cout<<a->toString(a->toToken("IIIII•••••"))<<endl;

	cout<<a->canConvert("IIV")<<endl;
	cout<<a->canConvert("•••••••••••••••••••••d")<<endl;
	cout<<a->canConvert("Lolol")<<endl;
}
