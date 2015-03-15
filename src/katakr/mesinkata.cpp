#include "mesinkata.h"
#include "mesinkar.h"
#include <string>
#include <cassert>
const int MAX =10;
#define BLANK ' '
mesinkata::mesinkata():mKar(),End(false){
}
mesinkata::mesinkata(const std::string& _pitakar):mKar(_pitakar),End(false){
}
mesinkata::mesinkata(const mesinkata& m):End(false){
	Kata = m.Kata;
	mKar = m.mKar;
}
mesinkata::~mesinkata(){
//defaults only
}
mesinkata& mesinkata::operator=(const mesinkata& m){
	Kata = m.Kata;
	mKar = m.mKar;
	End = m.End;
	return *this;
}

//Getter
std::string mesinkata::GetKata() const{
	return Kata;
}
bool mesinkata::GetEnd() const{
	return End;
}
//Setter
void mesinkata::SetPitaKarakter(const std::string& _pitakar){
	mKar.SetPitaKarakter(_pitakar);
}
void mesinkata::SetKata(const std::string& ST){
	Kata = ST;
}
void mesinkata::SetEnd(bool end) {
	End = end;
}
//Fungsi//fungsi
void mesinkata::Ignore_Blank(){
	while(mKar.GetCC()==BLANK) mKar.ADV();
}
void mesinkata::START(){
	SetEnd(false);
	mKar.START();
	ADV();
}	
void mesinkata::ADV(){
	assert(!GetEnd());
	Ignore_Blank();
	assert(!GetEnd());
	if (mKar.EOP())
		SetEnd(true);
	else
		SalinKata();
}
void mesinkata::SalinKata(){
	std::string ST;
	assert(!mKar.EOP()); //debug
	for(;;){
		assert(!mKar.EOP()); //debug
		ST += mKar.GetCC();
		mKar.ADV();
		if(mKar.EOP()||mKar.GetCC()==BLANK) break;
	}
	assert(!GetEnd());
	SetKata(ST);
}