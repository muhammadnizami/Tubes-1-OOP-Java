#include "mesintoken.h"
#include <string>
#include <iostream>

using std::cout;
using std::endl;

//! test mesin token
int main(){
	std::string lalla = "* / + - div ( ) & | ~ 123";
	Converter cvtTest;
	mesintoken mtkn(lalla);
	mtkn.START();
	cout<<cvtTest.toString(cvtTest.toToken("*"))<<endl;
	cout<<mtkn.GetKata()<<" "<<cvtTest.toString(mtkn.GetCToken())<<endl;
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Kali);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Bagi);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Tambah);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Kurang);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Div);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isPunctuator() && mtkn.GetCToken().getTkn()==Kurungbuka);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isPunctuator() && mtkn.GetCToken().getTkn()==Kurungtutup);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==And);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprBiner() && mtkn.GetCToken().getTkn()==Or);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isOprUner() && mtkn.GetCToken().getTkn()==Not);
	mtkn.ADV();
	assert(!mtkn.GetEnd() && mtkn.GetCToken().isBilangan() && mtkn.GetCToken().getTipeBilangan()==_int && mtkn.GetCToken().getBilanganInt()==123);
	mtkn.ADV();
	assert(mtkn.GetEnd());

	Converter cvtRom;
	cvtRom.SetMode(cvtRom._Romawi);
	std::string lalla2 = "* / + - div ( ) & | ~ I";
	mesintoken mtkn2(lalla2,cvtRom);
	mtkn2.START();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Kali);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Bagi);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Tambah);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Kurang);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Div);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isPunctuator() && mtkn2.GetCToken().getTkn()==Kurungbuka);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isPunctuator() && mtkn2.GetCToken().getTkn()==Kurungtutup);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==And);
	mtkn2.ADV();
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprBiner() && mtkn2.GetCToken().getTkn()==Or);
	mtkn2.ADV();
	cout<<mtkn2.GetKata()<<endl;
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isOprUner() && mtkn2.GetCToken().getTkn()==Not);
	Romawi rm;
	cout<<(rm.canConvert("I"))<<endl;
	cout<<cvtRom.toToken("I").getBilanganInt()<<endl;
	mtkn2.ADV();
	cout<<cvtRom.toString(mtkn2.GetCToken())<<" "<<endl;
	assert(!mtkn2.GetEnd() && mtkn2.GetCToken().isBilangan() && mtkn2.GetCToken().getTipeBilangan()==_int && mtkn2.GetCToken().getBilanganInt()==1);
	mtkn2.ADV();
	assert(mtkn2.GetEnd());
}
