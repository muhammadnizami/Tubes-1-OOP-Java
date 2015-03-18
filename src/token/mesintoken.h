#ifndef mesintoken_h
#define mesintoken_h

#include "mesinkata.h"
#include "Token.h"
#include "converter.h"
#include <string>

//!tidak bisa untuk polymorphism
//!virtual destruktor belum diimplementasi (tidak dibutuhkan untuk proyek ini)
//!Responsibility
//!Membaca ekspresi token per token
//!Kelas ini menggunakan std::string. Kelas ini mewarisi Mesin Kata. Kelas ini mengandung kelas converter.
//!Method kelas ini meliputi konstruktor yang menerima string pita karakter, START(), ADV(), GetCToken(). Start memulai mesin, ADV memajukan satu token, dan GetCToken() mengakses token yang sedang dibaca.
class mesintoken:public mesinkata{
public:
	mesintoken (const std::string& ST); //! membentuk mesin token dengan pita karakter ST
	mesintoken (const std::string& ST, const Converter& _cvt); //! membentuk mesin token dengan pita karakter ST dan converter cvt

	//Getter
	Token GetCToken() const; //! prekondisi: !GetEnd()

	//override
	void START(); //! prekondisi pita karakter tidak kosong
	void ADV();//! prekondisi: !GetEnd()
private:
	Converter CVT;
	Token CToken;
};

#endif
