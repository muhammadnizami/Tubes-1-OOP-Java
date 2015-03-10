#ifndef StrToken_h
#define StrToken_h

#include <string>
#include "Token.h"

//kelas abstrak
class StrToken{
	public:
	virtual ~StrToken(){};
	virtual bool canConvert(const std::string& s) = 0; 	//menembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T) = 0;	//mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s) = 0;	//mengembalikan representasi token dari string s
};

#endif
