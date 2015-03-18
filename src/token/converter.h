#ifndef converter_h
#define converter_h

#include <exception>
#include <string>

#include "Token.h"
#include "StrToken.h"
#include "Arab.h"
#include "Logika.h"
#include "Operator.h"
#include "Romawi.h"

/*!
Responsibility
Kelas ini bertugas mengkonversi seluruh kata yang valid menjadi token, baik operand maupun operator
Hubungan dengan kelas lain
Ia merupakan agregasi dari StrToken dan/atau Turunannya
Gambaran umum method
metodanya adalah toString dan toToken.*/
class Converter{
	public:
	//!cctor,ctor,dtor
	//!@{
	//!default: operator default dan bilangan arab
	Converter();
	Converter(const Converter& C);
	~Converter();//cleanup
	Converter& operator=(const Converter& C);
	//!@}
	
	//!mengkonversi token ke string
	std::string toString(const Token&); 
	 //!mengkonversi string ke token. melempar exception bila gagal
	Token toToken(const std::string&);
	enum TipeRepresentasiBilangan {_Arab, _Romawi, _Logika};
	 //!mengeset apakah converter menggunakan bilangan _Arab, _Romawi, atau _Logika
	void SetMode(TipeRepresentasiBilangan);
	//!mengeset representasi operator
	void SetStrOperator(const std::string&, TipeToken); 

	private:
	StrToken * _Operator;
	StrToken * _Operand;
	Arab A;
	Logika L;
	Romawi R;
	Operator O;

};

/*!
kelas exception yang dilempar kelas converter
*/
class ConverterException:public std::exception{
	public:
	static const int msg_maxlength;
	ConverterException(){
		strcpy(msg,"Converter Exception happened");
	}
	ConverterException(const char * _msg){
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
