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

class Converter{
	public:
	Converter();
	Converter(const Converter& C);
	~Converter();//cleanup
	std::string toString(const Token&);
	Token toToken(const std::string&);
	enum TipeRepresentasiBilangan {_Arab, _Romawi, _Logika};
	void SetMode(TipeRepresentasiBilangan);
	void SetStrOperator(const std::string&, TipeToken);

	private:
	StrToken * _Operator;
	StrToken * _Operand;
	Arab A;
	Logika L;
	Romawi R;
	Operator O;

};

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
