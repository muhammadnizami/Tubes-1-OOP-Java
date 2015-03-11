#include "converter.h"
#include "Arab.h"
#include <cassert>

Converter::Converter(){//defaultnya apa saja
	_Operator = &O;
	_Operand = &A;
}

Converter::Converter(const Converter& C){
	O=C.O;
	A=C.A;
	R=C.R;
	L=C.L;
	_Operator = &O;
	if (C._Operand == &(C.A))
		_Operand = &A;
	else 	if (C._Operand == &(C.L))
		_Operand = &L;
	else  	if (C._Operand == &(C.R))
		_Operand = &R;
}

Converter::~Converter(){//cleanup
	_Operator = NULL;
	_Operand = NULL;
}

Converter& Converter::operator=(const Converter& C){
	O=C.O;
	A=C.A;
	R=C.R;
	L=C.L;
	_Operator = &O;
	if (C._Operand == &(C.A))
		_Operand = &A;
	else 	if (C._Operand == &(C.L))
		_Operand = &L;
	else  	if (C._Operand == &(C.R))
		_Operand = &R;
	return *this;
}

std::string Converter::toString(const Token& T){
	if (T.isBilangan())
		return _Operand->toString(T);
	else
		return _Operator->toString(T);
	
}

Token Converter::toToken(const std::string& s){
	if (_Operator->canConvert(s))
		return _Operator->toToken(s);
	else if (_Operand->canConvert(s))
		return _Operand->toToken(s);
	else	throw ConverterException();
}

void Converter::SetMode(TipeRepresentasiBilangan TRB){
	switch(TRB){
	case _Arab:
		_Operand = &A;		
		break;
	case _Romawi:
		_Operand = &R;
		break;
	case _Logika:
		_Operand = &L;
		break;
	}
}
void Converter::SetStrOperator(const std::string& s, TipeToken tt){
	O.SetString(tt,s);
}


