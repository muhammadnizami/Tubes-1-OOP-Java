#ifndef Token_h
#define Token_h

#include <string>
#include <exception>


enum TipeToken{ //karena identifikasi "and" sepertinya tidak dapat digunakan,
				//maka seluruhnya diganti menjadi diawali huruf kapital
	/*!
		Tipe Token menyatakan apakah token merupakan suatu operator atau bilangan
	*/
	Kali,
	Bagi,
	Tambah,
	Kurang,
	Div,
	Mod,
	Kurungbuka,
	Kurungtutup,
	And,
	Or,
	Not,
	Bilangan,
};

enum Tipe{
	_int,_float,_bool,
};

class Token{
public:
	/*!
		Kelas token bertanggung jawab sebagai objek yang dapat dimengerti oleh evaluator.
		Kelas token bertanggung jawab atas jenis-jenis bilangan dan operator serta perilakunya
		perilaku operator yaitu presedensi serta bagaimana operator tersebut mengoperasikan operand
	*/

	//!ctor
	Token();
		
	//cctor, dtor dan operator= menggunakan default
	//cctor dan operator= bitwise copy
	
	//!getter
	TipeToken getTkn() const; //!mengembalikan tipe token tersebut
	Tipe getTipeBilangan() const; //!prekondisi: getTkn()==Bilangan
	int getBilanganInt() const; //!prekondisi: getTipeBilangan()==_int
	float getBilanganFloat() const; //!prekondisi: getTipeBilangan()==_float
	bool getBilanganBool() const; //!prekondisi: getTipeBilangan()==_bool
	
	//!setter
	void SetTkn(TipeToken _Tkn);//!mengeset
	void SetBilangan(float f);//!mengeset bilangan
	void SetBilangan(int i);//!mengeset bilangan
	void SetBilangan(bool l);//!mengeset bilangan
	
	//!predikat
	bool isPunctuator() const;//!mengembalikan true bila ( atau )
	bool isOprUner() const;//!mengembalikan true bila ia operator uner
	bool isOprBiner() const;//!mengembalikan true bila ia operator uner
	bool isBilangan() const;//!mengembalikan true bila token merupakan bilangan
	bool isSmallerPrecedenceThan(const Token& T); 	//!prekondisi: isOprUner() || isOprBiner()
							//!mengembalikan true bila this presedensnya kurang dari T
							//!presedensi standar
	
	//!mengubah ke string 	(hanya akan digunakan untuk testing. Untuk penggunaan lebih lanjut,
	//!			gunakan kelas lain)
	std::string ToStr();
	
	//!method lain, untuk digunakan oleh kalkulator atau evaluator
	//!saat dioperasikan, tipe bilangan dapat berubah
	Token Operasikan(const Token& lhs, const Token& rhs) const; //!prekondisi: isOprBiner() && lhs.isBilangan()&& rhs.isBilangan()
						//!mengembalikan <lhs> <this> <rhs>
	Token Operasikan(const Token& rhs) const; 	//!prekondisi: isOprUner() && rhs.isBilangan()
					//!mengembalikan <this> <rhs>
		
private:
	typedef union{
		int I;
		float F;
		bool B;
	} BilanganT;
	enum TipeToken Tkn;
	BilanganT Val;
	enum Tipe TipeBilangan;

	//!method pembantu
	void Kalikan (const Token& dengan); 
	void Bagikan (const Token& dengan); 
	void Tambahkan (const Token& dengan); 
	void Kurangkan (const Token& dengan); 
	void Divkan (const Token& dengan);
	void Modkan(const Token& dengan);
	void Andkan (const Token& dengan); 
	void Orkan (const Token& dengan); 
	void Notkan ();

	//!method pembantu dari method pembantu
	void IntToBool();
};

#include <cassert>
#include <cstring>
//exception
class TokenException:public std::exception{
	/*
		exception yang dilempar kelas token
	*/
	public:
	static const int msg_maxlength;
	TokenException(){
		strcpy(msg,"Token Exception happened");
	}
	TokenException(const char * _msg){
		assert(strlen(_msg)<=127);
		strcpy(msg,_msg);
	}
	virtual const char* what() const throw(){
		return msg;
	}
	private:
	char msg[128];
};

#endif
