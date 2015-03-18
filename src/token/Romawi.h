#ifndef Romawi_h
#define Romawi_h

#include <string>
#include "Token.h"
#include "StrToken.h"

//!kelas implementasi StrToken dengan aturan representasi bilangan romawi
class Romawi:public StrToken{
	public:
	
	//!mengembalikan true bila s dapat dikonversi ke token
	virtual bool canConvert(const std::string& s); 	
	
	//!mengembalikan representasi string dari token T.
	virtual std::string toString (const Token& T);	
	
	//!mengembalikan representasi token dari string s
	virtual Token toToken(const std::string& s);	

	private:
	std::string toString (int num);
	std::string toString (float num);
};

#endif
