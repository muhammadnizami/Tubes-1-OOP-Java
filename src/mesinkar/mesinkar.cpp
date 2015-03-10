/*
NAMA/NIM : 135135061/Lucky Cahyadi Kurniawan
FILE     : mesinkar.h
TANGGAL  : 5 Maret 2014
*/
#include "mesinkar.h"
#include <string>
#include <assert.h>

mesinkar::mesinkar(){
	std::string L = "default";
	std::string& LT=L;
	SetIdxChar(0);
	SetCC('#');
	SetEnd(false);
	SetPitaKarakter(LT);
}
mesinkar::~mesinkar(){
}
//Getter
char mesinkar::GetCC(){
   return CC;
}
bool mesinkar::GetEnd(){
   return End;
}
std::string mesinkar::GetPitaKarakter(){
	return PitaKarakter;
}
int mesinkar::GetIdxChar(){
	return idxChar;
}
//Setter
void mesinkar::SetCC(char CT){
   	CC=CT;
}
void mesinkar::SetEnd(bool ET){
   	End=ET;
}
void mesinkar::SetPitaKarakter(std::string& ST){
	assert(!ST.empty());
	std::string STemp=ST;
	PitaKarakter=STemp;
}
void mesinkar::SetIdxChar(int i){
	idxChar=i;
}
//Fungsi
void mesinkar::START(){
	SetIdxChar(0);
	SetCC(GetPitaKarakter().at(GetIdxChar()));
	SetEnd(false);
}
void mesinkar::ADV(){
	int temp = GetIdxChar();
	temp++;
	SetIdxChar(temp);
	SetCC(GetPitaKarakter().at(GetIdxChar()));
}
bool mesinkar::EOP(){
	return (GetEnd()==true);
}
