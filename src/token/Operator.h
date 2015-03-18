#ifndef Operator_h
#define Operator_h

#include <string>
#include "Token.h"
#include "StrToken.h"

#define TIPETOKEN_COUNT 12 //harus diubah apabila Token.h berubah

/*! kelas implementasi
Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan penulisan operator.
*/
class Operator: public StrToken{
	public:
	Operator();
	
	bool StrRepComplies(const std::string& s); //!mengembalikan true bila s dapat digunakan sebagai representasi operator
	void SetString(TipeToken _tkn, const std::string& s);
		//!I.S.:	0<= (int) _tkn <TIPETOKEN_COUNT
		//!	s tidak dapat dikonversi oleh Arab, Romawi, maupun Logika
		
	std::string GetString(TipeToken _tkn);
		//!mengembalikan Opr[_tkn]
		//!prekondisi: 0<=_tkn<TIPETOKEN_COUNT

	virtual bool canConvert(const std::string& s); 	//!mengembalikan true bila s dapat dikonversi ke token
	virtual std::string toString (const Token& T);	//!mengembalikan representasi string dari token T
	virtual Token toToken(const std::string& s);	//!mengembalikan representasi token dari string s

	private:
	std::string Opr[TIPETOKEN_COUNT];
};

#endif
