#include "mesintoken.h"
#include <cassert>

//konstruktor
mesintoken::mesintoken(const std::string& ST):mesinkata(ST){}

mesintoken::mesintoken(const std::string& ST, const Converter& _cvt):mesinkata(ST){
	CVT = _cvt;
}

//getter
Token mesintoken::GetCToken() const{
	assert(!GetEnd());
	return CToken;
}

//override
void mesintoken::START(){
	mesinkata::START();
	if (!GetEnd())
		CToken = CVT.toToken(GetKata());
}

void mesintoken::ADV(){
	assert(!GetEnd());
	mesinkata::ADV();
	if (!GetEnd())
		CToken = CVT.toToken(GetKata());

}
