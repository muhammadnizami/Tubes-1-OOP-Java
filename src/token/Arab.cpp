#include "Arab.h"
#include <sstream>


bool Arab::canConvert(const std::string& s){ 	//menembalikan true bila s dapat dikonversi ke token
	int i=0;
	int n=s.length();
	bool dotExists = false;
	if (s[i]=='-') i++;
	for (;i<n;i++)
		if(s[i]=='.'){
			if(dotExists){
				return false;
			}else	dotExists=true;
		}else if (s[i]<'0' || s[i]>'9')
			return false;
	return true;
}

std::string Arab::toString (const Token& T){	//mengembalikan representasi string dari token T
	assert(T.getTkn()==Bilangan);

	std::ostringstream ss;

	switch(T.getTipeBilangan()){
		case _bool:
		if (T.getBilanganBool())
			return "1";
		else	return "0";
		case _int:
			ss << T.getBilanganInt();
			break;
		case _float:
			ss << T.getBilanganFloat();
			break;
	}

	return std::string(ss.str());
}

#include <climits>
#include <cmath>

Token Arab::toToken(const std::string& s){	//mengembalikan representasi token dari string s
	assert(canConvert(s));

	std::istringstream ss(s);

	float vf;
	ss >> vf;
	Token tkn;
	if (vf >= INT_MIN && vf <=INT_MAX && vf == floor(vf)){
		std::istringstream ss2(s);
		int vi;
		ss2 >> vi;
		tkn.SetBilangan(vi);
	}else
		tkn.SetBilangan(vf);
	return tkn;
}

