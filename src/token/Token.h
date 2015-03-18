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

	/*!
		Kelas token bertanggung jawab sebagai objek yang dapat dimengerti oleh evaluator.
		Kelas token bertanggung jawab atas jenis-jenis bilangan dan operator serta perilakunya
		perilaku operator yaitu presedensi serta bagaimana operator tersebut mengoperasikan operand
	*/
class Token{
public:

	//!ctor
	Token();
		
	//cctor, dtor dan operator= menggunakan default
	//cctor dan operator= bitwise copy
	
	//!@name getter
	//!tidak mengubah status token
	//!@{
	//!
	//!mengembalikan tipe token tersebut
	TipeToken getTkn() const; 
	//!prekondisi: getTkn()==Bilangan
	Tipe getTipeBilangan() const; 
	//!prekondisi: getTipeBilangan()==_int
	int getBilanganInt() const; 
	//!prekondisi: getTipeBilangan()==_float
	float getBilanganFloat() const; 
	//!prekondisi: getTipeBilangan()==_bool
	bool getBilanganBool() const; 
	//!@}
	
	//!@name setter
	//!@mengubah status token. Akan digunakan oleh yang membangun dan mengubah token, seperti converter dan sebagainya
	//!@{
	
	//!mengeset token
	void SetTkn(TipeToken _Tkn);
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi float dan isinya f
	void SetBilangan(float f);
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi int dan isinya i
	void SetBilangan(int i);
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi logika dan isinya l
	void SetBilangan(bool l);
	//@}
	
	//!name predikat
	//!boolean, true false. tidak mengubah status token
	//!@{
	
	//!mengembalikan true bila ( atau )
	bool isPunctuator() const;
	//!mengembalikan true bila ia operator uner
	bool isOprUner() const;
	//!mengembalikan true bila ia operator uner
	bool isOprBiner() const;
	//!mengembalikan true bila token merupakan bilangan
	bool isBilangan() const;
	//!prekondisi: isOprUner() || isOprBiner()\n
	//!mengembalikan true bila this presedensnya kurang dari T\n
	//!presedensi standar\n
	bool isSmallerPrecedenceThan(const Token& T); 	
	///@}
	
	//!mengubah ke string 	(hanya akan digunakan untuk testing. Untuk penggunaan lebih lanjut,
	//!			gunakan kelas lain)
	std::string ToStr();
	
	//!name method lain
	//!untuk digunakan oleh kalkulator atau evaluator\n
	//!saat dioperasikan, tipe bilangan dapat berubah\n
	///@{
		
	
	//!prekondisi: isOprBiner() && lhs.isBilangan()&& rhs.isBilangan()\n
	//!mengembalikan <lhs> <this> <rhs>\n
	Token Operasikan(const Token& lhs, const Token& rhs) const; 
	
	//!prekondisi: isOprUner() && rhs.isBilangan()\n
	//!mengembalikan <this> <rhs>\n
	Token Operasikan(const Token& rhs) const; 	
	
	///@}
		
private:
	typedef union{
		int I;
		float F;
		bool B;
	} BilanganT;
	enum TipeToken Tkn;
	BilanganT Val;
	enum Tipe TipeBilangan;

	//!method pembantu@{
	void Kalikan (const Token& dengan); 
	void Bagikan (const Token& dengan); 
	void Tambahkan (const Token& dengan); 
	void Kurangkan (const Token& dengan); 
	void Divkan (const Token& dengan);
	void Modkan(const Token& dengan);
	void Andkan (const Token& dengan); 
	void Orkan (const Token& dengan); 
	void Notkan ();
	//!@}

	//!method pembantu dari method pembantu
	void IntToBool();
};

#include <cassert>
#include <cstring>
//exception
	/*!
		exception yang dilempar kelas token
	*/
class TokenException:public std::exception{
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
