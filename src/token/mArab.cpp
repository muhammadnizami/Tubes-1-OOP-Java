#include "Arab.h"
#include "StrToken.h"

#include <iostream>

using std::cout;
using std::endl;

int main(){
	StrToken * a = new Arab();
	cout<<a->toString(a->toToken("4000000000"))<<endl;
	cout<<a->toString(a->toToken("2.05"))<<endl;
	cout<<a->toString(a->toToken("0.464"))<<endl;
	cout<<a->toString(a->toToken("403"))<<endl;
	cout<<a->toString(a->toToken("-4000000000"))<<endl;
	cout<<a->toString(a->toToken("-2000000"))<<endl;
	cout<<a->toString(a->toToken("-0.5"))<<endl;
	cout<<a->canConvert("--400")<<endl;
	cout<<a->canConvert("0.0.3")<<endl;
	cout<<a->canConvert("XVII")<<endl;
	cout<<a->canConvert("4300000000000000000000000000000000000000000000000000")<<endl;
	cout<<a->canConvert("4300000000000000000000000000000000000-0")<<endl;
	cout<<a->toString(a->toToken("4300000000000000000000000000000000000000000000000000000000000000000000000000000000"))<<endl;
}
