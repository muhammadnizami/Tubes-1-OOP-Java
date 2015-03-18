#include "Logika.h"
#include "StrToken.h"

#include <iostream>

using std::cout;
using std::endl;

/*test kelas Logika*/
int main(){
	StrToken * a = new Logika();
	cout<<a->toString(a->toToken("0"))<<endl;
	cout<<a->toString(a->toToken("1"))<<endl;
	cout<<a->toString(a->toToken("false"))<<endl;
	cout<<a->toString(a->toToken("true"))<<endl;
	cout<<a->canConvert("-400")<<endl;
	cout<<a->canConvert("0.0.3")<<endl;
	cout<<a->canConvert("XVII")<<endl;
	cout<<a->canConvert("4300000000000000000000000000000000000000000000000000")<<endl;
	cout<<a->canConvert("4300000000000000000000000000000000000-0")<<endl;

}
