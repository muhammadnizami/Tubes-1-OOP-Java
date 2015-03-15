#ifndef mesinkata_h
#define mesinkata_h
#include "mesinkar.h"

#include <string>

//kelas mesin kata, cara menggunakan: konstruksi, set pita karakter, lalu for(start();!End();ADV())
class mesinkata {
public:
	mesinkata();
	mesinkata(const std::string& _pitakar);
	mesinkata(const mesinkata& m);
	~mesinkata();
	mesinkata& operator=(const mesinkata& m);
	//Getter
	std::string GetKata() const;
	bool GetEnd() const;
	//Setter
	void SetPitaKarakter(const std::string& _pitakar);
	void SetKata(const std::string& ST);
	void SetEnd(bool End);
	//Fungsi
	void Ignore_Blank();
	void START();
	void ADV();	//maju satu kata. prekondisi: !End()
	void SalinKata();
private:
	mesinkar mKar;	
	bool End;
	std::string Kata;
};
#endif