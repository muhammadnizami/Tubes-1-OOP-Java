#ifndef Logika_h
#define Logika_h

#include <string>
#include "Token.h"
#include "StrToken.h"

/*! 
Responsibility\n
Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan bilangan Logika\n
Hubungan dengan kelas lain\n
mengimplementasi StrToken\n
Gambaran umum method\n
metodanya adalah implementasi metoda StrToken\n
*/
class Logika:public StrToken{
	public:
	
	//!mengembalikan true bila s dapat dikonversi ke token
	virtual bool canConvert(const std::string& s); 
	
	//!mengembalikan representasi string dari token T
	virtual std::string toString (const Token& T);	
	
	//!mengembalikan representasi token dari string s
	virtual Token toToken(const std::string& s);	
};

#endif
