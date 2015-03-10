#include "Logika.h"
#include "Arab.h"
#include "Romawi.h"
#include "Operator.h"
#include <sstream>
#include <cassert>

Operator::Operator(){
	Opr[Kali]="*";
	Opr[Bagi]="/";
	Opr[Tambah]="+";
	Opr[Kurang]="-";
	Opr[Div]="div";
	Opr[Mod]="%";
	Opr[Kurungbuka]="(";
	Opr[Kurungtutup]=")";
	Opr[And]="&";
	Opr[Or]="|";
	Opr[Not]="~";
}

bool Operator::canConvert(const std::string& s){ 	//menembalikan true bila s dapat dikonversi ke token
	for (int i=0;i<TIPETOKEN_COUNT;i++)
		if (s==GetString((TipeToken)i))
			return true;
	return false;
}

std::string Operator::toString (const Token& T){	//mengembalikan representasi string dari token T
	assert(T.getTkn()!=Bilangan);

	return GetString(T.getTkn());
}

void Operator::SetString(TipeToken _tkn, const std::string& s){
	//I.S.:	0<= (int) _tkn <TIPETOKEN_COUNT
	//	s tidak dapat dikonversi oleh Arab, Romawi, maupun Logika
	assert(_tkn>=0 && _tkn<TIPETOKEN_COUNT);
	assert(StrRepComplies(s)); //nanti diganti jadi exception

	Opr[_tkn]=s;
}

std::string Operator::GetString(TipeToken _tkn){
	//mengembalikan Opr[_tkn]
	//prekondisi: 0<=_tkn<TIPETOKEN_COUNT
	
	assert(0<=_tkn && _tkn<TIPETOKEN_COUNT);
	return Opr[_tkn];

}

Token Operator::toToken(const std::string& s){	//mengembalikan representasi token dari string s
	assert(canConvert(s));

	Token retval;

	for (int i=0;i<TIPETOKEN_COUNT;i++)
		if (s==GetString((TipeToken)i)){
			retval.SetTkn((TipeToken)i);
			break;
		}

	return retval;
}

bool Operator::StrRepComplies(const std::string& s){
	//operator bersifat unik
	for (int i=0;i<TIPETOKEN_COUNT;i++)
		if (s==GetString((TipeToken)i))
			return false;

	//alfanumerik + simbol
	int n=s.length();
	for (int i=0;i<n;i++)
		if (	(s[i]<'0' || s[i] > '9')	&&
			(s[i]<'A' || s[i] > 'Z')	&&
			(s[i]<'a' || s[i] > 'z')	)
			switch(s[i]){
			case '+':
			case '-':
			case '/':
			case '*':
			case '%':
			case '&':
			case '|':
			case '~':
				break;
			default:
				return false;
			}
			
	//bukan merupakan representasi bilangan dalam bentuk romawi, arabic, dan logika
	Logika L; Arab A; Romawi R;
	return !(L.canConvert(s)||A.canConvert(s)||R.canConvert(s));
}
