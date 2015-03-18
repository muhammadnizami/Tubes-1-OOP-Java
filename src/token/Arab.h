#ifndef Arab_h
#define Arab_h

#include <string>
#include "Token.h"
#include "StrToken.h"

/*!
Responsibility
Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan bilangan arab
Hubungan dengan kelas lain
mengimplementasi StrToken
Gambaran umum method
metodanya adalah implementasi metoda StrToken
*/
class Arab:public StrToken{
	public:
	virtual bool canConvert(const std::string& s); 	//!mengembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T);	//!mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s);	//!mengembalikan representasi token dari string s
};

#endif
