#ifndef mesintoken_h
#define mesintoken_h

#include "mesinkata.h"
#include "Token.h"
#include "converter.h"
#include <string>

//!tidak bisa untuk polymorphism\n
//!virtual destruktor belum diimplementasi (tidak dibutuhkan untuk proyek ini)\n
//!Responsibility\n
//!Membaca ekspresi token per token\n
//!Kelas ini menggunakan std::string. Kelas ini mewarisi Mesin Kata. Kelas ini mengandung kelas converter.\n
//!Method kelas ini meliputi konstruktor yang menerima string pita karakter, START(), ADV(), GetCToken(). Start memulai mesin, ADV memajukan satu token, dan GetCToken() mengakses token yang sedang dibaca.\n
class mesintoken:public mesinkata{
public:
	//! membentuk mesin token dengan pita karakter ST
	mesintoken (const std::string& ST); 
	//! membentuk mesin token dengan pita karakter ST dan converter cvt
	mesintoken (const std::string& ST, const Converter& _cvt); 

	//!Getter@{
	//! prekondisi: !GetEnd()
	Token GetCToken() const; 
	//!@}

	//!@name override\n
	//!method-method ini mengoverride dengan menambahkan konversi ke token dan disimpan di CToken
	//!@{
	//! prekondisi pita karakter tidak kosong
	void START(); 
	//! prekondisi: !GetEnd()
	void ADV();
	//!@}
private:
	Converter CVT;
	Token CToken;
};

#endif
