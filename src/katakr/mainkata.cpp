/*!driver untuk mengetes class mesinkata*/
#include <cassert>
#include <iostream>
#include "mesinkata.h"

using std::cout;
using std::endl;

int main(){
	mesinkata mk("  test1    test2  test3 a");
	mesinkata mkarar(mk);
	for (mkarar.START();!mkarar.GetEnd();mkarar.ADV()){
		cout<<mkarar.GetKata()<<endl;
	}
	mk.START();
	cout<<mk.GetKata()<<endl;
	assert(mk.GetKata() == "test1");
	mk.ADV();
	cout<<mk.GetKata()<<endl;
	assert(mk.GetKata() == "test2");
	mk.ADV();
	cout<<mk.GetKata()<<endl;
	assert(mk.GetKata() == "test3");
	mk.ADV();
	cout<<mk.GetKata()<<" "<<mk.GetEnd()<<endl;
	assert(mk.GetKata() == "a");
	mk.ADV();
	assert(mk.GetEnd());
	
	
}
