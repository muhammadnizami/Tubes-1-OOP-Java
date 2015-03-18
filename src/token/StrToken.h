#ifndef StrToken_h
#define StrToken_h

#include <string>
#include "Token.h"

/*!
Responsibility
Kelas ini merupakan kelas abstrak. Tanggung jawabnya adalah mengkonversi satu jenis representasi token antara objek string dan token.
Hubungan dengan kelas lain
kelas ini diimplementasi oleh kelas Arab, Logika, Romawi, dan Operator.
Gambaran umum method
metodanya adalah mengkonversi dari string ke token dan mengkonversi dari token ke string, serta pengecekan apakah string tertentu dapat dikonversi olehnya
*/
class StrToken{
	public:
	virtual ~StrToken(){};
	virtual bool canConvert(const std::string& s) = 0; 	//!mengembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T) = 0;	//!mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s) = 0;	//!mengembalikan representasi token dari string s
};

#endif
