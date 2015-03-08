#ifndef Romawi_h
#define Romawi_h

#include <string>
#include "Token.h"
#include "StrToken.h"

//kelas implementasi
class Romawi:public StrToken{
	public:
	virtual bool canConvert(const std::string& s); 	//menembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T);	//mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s);	//mengembalikan representasi token dari string s

	private:
	std::string toString (int num);
	std::string toString (float num);
};

#endif
