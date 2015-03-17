#include "Token.h"

#include <cassert>

#include <climits>

//ctor
Token::Token(){
	Tkn=Bilangan;
	Val.F=0;
	Val.I=0;
	TipeBilangan = _int;
}
	
//cctor, dtor dan operator= menggunakan default
//cctor dan operator= bitwise copy

//getter
TipeToken Token::getTkn() const{
		return Tkn;
}

Tipe Token::getTipeBilangan() const{
	assert(getTkn()==Bilangan);
	return TipeBilangan;
}
int Token::getBilanganInt() const{
	assert(getTipeBilangan()==_int);
	return Val.I;
}
float Token::getBilanganFloat() const{
	assert(getTipeBilangan()==_float);
	return Val.F;
}
bool Token::getBilanganBool() const{
	assert(getTipeBilangan()==_bool);
	return Val.B;
}

//setter
void Token::SetTkn(TipeToken _Tkn){
	Tkn=_Tkn;
}
void Token::SetBilangan(float f){
	Tkn=Bilangan;
	TipeBilangan = _float;
	Val.F = f;
}
void Token::SetBilangan(int i){
	Tkn=Bilangan;
	TipeBilangan = _int;
	Val.I = i;
}
void Token::SetBilangan(bool b){
	Tkn=Bilangan;
	TipeBilangan = _bool;
	Val.I = b;
}

//predikat
bool Token::isPunctuator() const{
	return Tkn==Kurungbuka || Tkn==Kurungtutup;
}
bool Token::isOprUner() const{
	return Tkn==Not;
}
bool Token::isOprBiner() const{
	return Tkn!=Not && Tkn!=Bilangan && !isPunctuator();
}
bool Token::isBilangan() const{
	return Tkn==Bilangan;
}
bool Token::isSmallerPrecedenceThan(const Token& T){
	assert(isOprUner() || isOprBiner());
	int this_rank;
	int T_rank;
	switch(getTkn()){
		case Not:
		this_rank=4;
		break;

		case Kali:
		case Bagi:
		case Mod:
		case Div:
		this_rank=3;
		break;

		case Tambah:
		case Kurang:
		this_rank=2;
		break;

		case And:
		this_rank=1;
		break;

		case Or:
		this_rank=0;

		default:
			this_rank=-999;
	}
	switch(T.getTkn()){
		case Not:
		T_rank=4;
		break;

		case Kali:
		case Bagi:
		case Mod:
		case Div:
		T_rank=3;
		break;

		case Tambah:
		case Kurang:
		T_rank=2;
		break;

		case And:
		T_rank=1;
		break;

		case Or:
		T_rank=0;

		default:
		T_rank=-999;
	}
	return this_rank<T_rank;
}

//method lain
Token Token::Operasikan(const Token& lhs, const Token& rhs) const{
	if (!isOprBiner())
		throw TokenException("INVALID OPERATOR");
	if (!lhs.isBilangan()||!rhs.isBilangan())
		throw TokenException("INVALID OPERAND");
	Token retval=lhs;
	switch(getTkn()){
	case Kali:
		retval.Kalikan(rhs);
		break;
	case Bagi:
		retval.Bagikan(rhs);
		break;
	case Tambah:
		retval.Tambahkan(rhs);
		break;
	case Kurang:
		retval.Kurangkan(rhs);
		break;
	case Div:
		retval.Divkan(rhs);
		break;
	case Mod:
		retval.Modkan(rhs);
		break;
	case And:
		retval.Andkan(rhs);
		break;
	case Or:
		retval.Orkan(rhs);
		break;

	}

	return retval;

}

#include <cmath>

Token Token::Operasikan(const Token& rhs) const{
	if (!isOprUner())
		throw TokenException("INVALID OPERATOR");
	if (!rhs.isBilangan())
		throw TokenException("INVALID OPERAND");

	Token retval=rhs;
	switch(getTkn()){
	case Not:
		retval.Notkan();
		break;
	}
	return retval;
}

/*
skema:
		if (getTipeBilangan()==_int){
			if (dengan.getTipeBilangan()==_int){
				//sini
			}else{
				//sini
			}
		}else{
			if(dengan.getTipeBilangan()==_int){
				//sini
			}else{
				//sini
			}
		}
*/

void Token::Kalikan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else {
		if (getTipeBilangan()==_int){
			if (dengan.getTipeBilangan()==_int){
				long tmp = getBilanganInt();
				tmp*= dengan.getBilanganInt();
				
				if (tmp>=INT_MAX || tmp<=INT_MIN)
					SetBilangan( (float) tmp);
				else	SetBilangan( (int) tmp);
			}else{
				float tmp = getBilanganInt();
				tmp*= dengan.getBilanganFloat();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}else{
			if(dengan.getTipeBilangan()==_int){
				float tmp = getBilanganFloat();
				tmp*=dengan.getBilanganInt();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}else{
				float tmp = getBilanganFloat();
				tmp*=dengan.getBilanganFloat();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}
		
	}
	
}
#include <iostream>
void Token::Bagikan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else{
		if (dengan.getTipeBilangan()==_int){
			if(dengan.getBilanganInt() == 0){
				throw TokenException("CANNOT DIVIDE BY ZERO");
			}
			if(getTipeBilangan()==_int){
				long tmp = getBilanganInt();
				long pembilang = dengan.getBilanganInt();
				if (tmp%pembilang == 0){
					tmp/=pembilang;
					SetBilangan((int)tmp);
				}else{
					float tmpf=(float)tmp/(float)pembilang;
					SetBilangan(tmpf);
				}
			}else{
				float tmp = getBilanganFloat();
				tmp/=dengan.getBilanganInt();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}else{
			if(dengan.getBilanganFloat() == 0){
				throw TokenException("CANNOT DIVIDE BY ZERO");	
			}
			if(getTipeBilangan()==_int){
				double tmp = getBilanganInt();
				tmp/=dengan.getBilanganFloat();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}else{
				double tmp = getBilanganFloat();
				tmp/=dengan.getBilanganFloat();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}
	}

}
 
void Token::Tambahkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else{
		if (getTipeBilangan()==_int){
			if (dengan.getTipeBilangan()==_int){
				long tmp = getBilanganInt();
				tmp += dengan.getBilanganInt();
				if (tmp>=INT_MAX || tmp<=INT_MIN)
					SetBilangan( (float) tmp);
				else	SetBilangan( (int) tmp);
			}else{
				float tmp = dengan.getBilanganFloat();
				tmp += getBilanganInt();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}else{
			if(dengan.getTipeBilangan()==_int){
				float tmp=getBilanganFloat();
				tmp+=dengan.getBilanganInt();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}else{
				float tmp=getBilanganFloat();
				tmp+=dengan.getBilanganFloat();
				if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);
			}
		}
	}

}
 
void Token::Kurangkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else{
		Token tmp;
		if (dengan.getTipeBilangan()==_float)
			tmp.SetBilangan(-dengan.getBilanganFloat());
		else	tmp.SetBilangan(-dengan.getBilanganInt());
		Tambahkan(tmp);
	}

}
 
void Token::Divkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if ((dengan.getTipeBilangan()==_float && dengan.getBilanganFloat()==0)
		|| (dengan.getTipeBilangan()==_int && dengan.getBilanganInt()==0))
		throw TokenException("CANNOT DIVIDE BY ZERO");

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else{
		if (getTipeBilangan()==_int &&dengan.getTipeBilangan()==_int)
				SetBilangan((int)getBilanganInt()/dengan.getBilanganInt());
		else{
			double a;
			double b;
			if (getTipeBilangan()==_float)
				a = getBilanganFloat();
			else	a = getBilanganInt();
			if (dengan.getTipeBilangan()==_float)
				b = dengan.getBilanganFloat();
			else	b = dengan.getBilanganInt();
			double tmp = trunc(a/b);
			if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
				SetBilangan( (int) tmp);
			else	SetBilangan( (float) tmp);				
		}
	}
}

void Token::Modkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if ((dengan.getTipeBilangan()==_float && dengan.getBilanganFloat()==0)
		|| (dengan.getTipeBilangan()==_int && dengan.getBilanganInt()==0))
		throw TokenException("CANNOT DIVIDE BY ZERO");

	if (getTipeBilangan()==_bool || dengan.getTipeBilangan()==_bool){
		throw TokenException("INVALID OPERAND");
	}else{
		if (getTipeBilangan()==_int && dengan.getTipeBilangan()==_int){
			SetBilangan(getBilanganInt() % dengan.getBilanganInt());
		}else{
			double a;
			double b;
			if (getTipeBilangan()==_float)
				a = getBilanganFloat();
			else	a = getBilanganInt();
			if (dengan.getTipeBilangan()==_float)
				b = dengan.getBilanganFloat();
			else	b = dengan.getBilanganInt();
			float tmp = fmod(a,b);
			if (tmp<=INT_MAX && tmp>=INT_MIN && tmp==floor(tmp))
				SetBilangan( (int) tmp);
			else	SetBilangan( (float) tmp);				
		}
	}
}
 #include <cstring>
void Token::Andkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()!=_bool || dengan.getTipeBilangan()!=_bool){
		if (getTipeBilangan()==_int || dengan.getTipeBilangan()==_int){
			Token tmp = dengan;
			try{
				if (getTipeBilangan()==_int)IntToBool();
				if (tmp.getTipeBilangan()==_int)tmp.IntToBool();
			}catch (TokenException e){
				if (!strcmp(e.what(),"THIS TOKEN CANNOT BE CONVERTED TO BOOL")){
					throw TokenException("INVALID OPERAND");
				} else throw e;
			}
			Andkan(tmp);
		}else{
			throw TokenException("INVALID OPERAND");
		}
	}else{
		SetBilangan(getBilanganBool() && dengan.getBilanganBool());
	}

}
 
void Token::Orkan (const Token& dengan){
	assert(isBilangan() && dengan.isBilangan());

	if (getTipeBilangan()!=_bool || dengan.getTipeBilangan()!=_bool){
		if (getTipeBilangan()==_int || dengan.getTipeBilangan()==_int){
			Token tmp = dengan;
			try{
				if (getTipeBilangan()==_int)IntToBool();
				if (tmp.getTipeBilangan()==_int)tmp.IntToBool();
			}catch (TokenException e){
				if (!strcmp(e.what(),"THIS TOKEN CANNOT BE CONVERTED TO BOOL")){
					throw TokenException("INVALID OPERAND");
				} else throw e;
			}
			Orkan(tmp);
		}else{
			throw TokenException("INVALID OPERAND");
		}
	}else{
		SetBilangan(getBilanganBool() || dengan.getBilanganBool());
	}

}
 
void Token::Notkan(){
	assert(isBilangan());
	if (getTipeBilangan()!=_bool){
		if (getTipeBilangan()==_int)
			if(getBilanganInt()==0){
				SetBilangan(true);
				return;
			}else if (getBilanganInt()==1){
				SetBilangan(false);
				return;
			}
		throw TokenException("INVALID OPERAND");
	}else{
		SetBilangan(!getBilanganBool());
	}
}

#include <sstream>

std::string Token::ToStr(){
	switch(getTkn()){
	case Kali:
		return "*";
	case Bagi:
		return "/";
	case Div:
		return "div";
	case Tambah:
		return "+";
	case Kurang:
		return "-";
	case Kurungbuka:
		return "(";
	case Kurungtutup:
		return ")";
	case Mod:
		return "%";
	case And:
		return "&";
	case Or:
		return "|";
	case Not:
		return "~";
	case Bilangan:
		std::ostringstream ss;
		switch (getTipeBilangan()){
		case _bool:
			if (getBilanganBool())
				return "true";
			else	return "false";
		case _int:
			ss << getBilanganInt();
			break;
		case _float:
			ss << getBilanganFloat();
			break;
		}
		return std::string(ss.str());
	}
}

//method pembantu dari method pembantu
void Token::IntToBool(){
	if (getTkn()==Bilangan)
	if (getTipeBilangan()==_int)
		if (getBilanganInt()==0){
			SetBilangan(false);
			return;
		}else if (getBilanganInt()==1){
			SetBilangan(true);
			return;
		}
	throw TokenException("THIS TOKEN CANNOT BE CONVERTED TO BOOL");
}

//exception
const int TokenException::msg_maxlength = 127;
