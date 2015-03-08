#include "Logika.h"

#include "Arab.h"
#include <sstream>


bool Logika::canConvert(const std::string& s){ 	//menembalikan true bila s dapat dikonversi ke token
	return s=="0" || s=="1" || s=="true" || s=="false";
}

std::string Logika::toString (const Token& T){	//mengembalikan representasi string dari token T
	assert(T.getTkn() == Bilangan);
	assert(T.getTipeBilangan() == _bool);
	if (T.getBilanganBool())
		return "true";
	else	return "false";
}

Token Logika::toToken(const std::string& s){	//mengembalikan representasi token dari string s
	assert(canConvert(s));
	Token retval;
	if(s=="0" || s=="false")
		retval.SetBilangan(false);
	else	retval.SetBilangan(true);
	return retval;
}

