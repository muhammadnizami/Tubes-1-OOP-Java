#ifndef StrToken_h
#define StrToken_h

#include <string>
#include "Token.h"

//kelas abstrak
class StrToken{
	public:
	virtual bool canConvert(const std::string& s){return false;} 	//menembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T){assert(true);}	//mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s){assert(this->canConvert(s));}	//mengembalikan representasi token dari string s
};

#endif
