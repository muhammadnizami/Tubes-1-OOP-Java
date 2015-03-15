#ifndef mesintoken_h
#define mesintoken_h

#include "mesinkata.h"
#include "Token.h"
#include "converter.h"
#include <string>

//tidak bisa untuk polymorphism
//virtual destruktor belum diimplementasi (tidak dibutuhkan untuk proyek ini)
class mesintoken:public mesinkata{
public:
	mesintoken (const std::string& ST);
	mesintoken (const std::string& ST, const Converter& _cvt);

	//Getter
	Token GetCToken() const; //prekondisi: !GetEnd()

	//override
	void START();
	void ADV();//prekondisi: !GetEnd()
private:
	Converter CVT;
	Token CToken;
};

#endif
