#ifndef StrToken_h
#define StrToken_h

#include <string>
#include "Token.h"

/*!
Responsibility\n
Kelas ini merupakan kelas abstrak. Tanggung jawabnya adalah mengkonversi satu jenis representasi token antara objek string dan token.\n
Hubungan dengan kelas lain\n
kelas ini diimplementasi oleh kelas Arab, Logika, Romawi, dan Operator.\n
Gambaran umum method\n
metodanya adalah mengkonversi dari string ke token dan mengkonversi dari token ke string, serta pengecekan apakah string tertentu dapat dikonversi olehnya\n
*/
class StrToken{
	public:
	virtual ~StrToken(){};
	
	//!mengembalikan true bila s dapat dikonversi ke token
	virtual bool canConvert(const std::string& s) = 0; 	
	
	//!mengembalikan representasi string dari token T
	virtual std::string toString (const Token& T) = 0;	
	
	//!mengembalikan representasi token dari string s
	virtual Token toToken(const std::string& s) = 0;	
};

#endif
