#include "Romawi.h"
#include <sstream>

bool Romawi::canConvert(const std::string& s){ 	//menembalikan true bila s dapat dikonversi ke token
	std::string rs[] = 
		{"M","CM","D","CD","C","XC",
		"L","XL","X","IX","V","IV","I",
		"S","*"};
	int j = 0;
	for (int i=0;i<15;i++)
		while (!s.compare(j,rs[i].length(),rs[i])){
			j+=rs[i].length();
		}
	return !j<s.length();
}

#include <cmath>
std::string Romawi::toString (const Token& T){	//mengembalikan representasi string dari token T
	assert(T.getTkn()==Bilangan);

	if (T.getTipeBilangan()==_int){
		return toString(T.getBilanganInt());
	}else if (T.getTipeBilangan()==_bool){
		return toString((int)T.getBilanganBool());
	}else{
		assert(T.getTipeBilangan()==_float);
		return toString(T.getBilanganFloat());
	}
}

std::string Romawi::toString (int num){
	
	std::string t;
	if(num<0) t+= "-";

	std::string s[] = 
		{"M","CM","D","CD","C","XC",
		"L","XL","X","IX","V","IV","I"};
	int u[] = 
		{1000, 900, 500, 400, 100, 90,
		50, 40, 10, 9, 5, 4, 1};
	for (int i = 0; i < 13; i++)
		while (num >= u[i]) {
			t+= s[i];
			num -= u[i];
		}
	if (t!="")
		return t;
	else	return "nulla";
}
std::string Romawi::toString (float num){

	//fractional part
	//hanya kelipatan uncia (1/12), sisanya di-truncate

	std::string t;
	if(num<0) t+= "-";
	std::string s[] = 
		{"M","CM","D","CD","C","XC",
		"L","XL","X","IX","V","IV","I",
		"S","*"};
	float u[] = 
		{1000, 900, 500, 400, 100, 90,
		50, 40, 10, 9, 5, 4, 1,
		(float)1/(float)2, (float)1/(float)12};
	for (int i = 0; i < 15; i++)
		while (num >= u[i]) {
			t+= s[i];
			num -= u[i];
		}
	if(num>(float)1/(float)24) t+= "*";
	if (t!="")
		return t;
	else	return "nulla";
}

#include <climits>

Token Romawi::toToken(const std::string& s){	//mengembalikan representasi token dari string s
	assert(canConvert(s));
	std::string rs[] = 
		{"M","CM","D","CD","C","XC",
		"L","XL","X","IX","V","IV","I",
		"S","*"};
	float u[] = 
		{1000, 900, 500, 400, 100, 90,
		50, 40, 10, 9, 5, 4, 1,
		(float)1/(float)2, (float)1/(float)12};
	float bfrf = 0;
	int bfri = 0;
	int j = 0;
	for (int i=0;i<15;i++)
		while (!s.compare(j,rs[i].length(),rs[i])){
			bfrf+=u[i];
			bfri+=u[i];
			j+=rs[i].length();
		}

	Token t;
	if (bfrf<=INT_MAX && bfrf>=INT_MIN && bfrf == floor(bfrf))
		t.SetBilangan( bfri);
	else	t.SetBilangan( bfrf);
	return t;
}
