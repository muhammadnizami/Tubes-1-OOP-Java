#ifndef mesinkata_h
#define mesinkata_h
#include "mesinkar.h"

#include <string>

//!kelas mesin kata, cara menggunakan: konstruksi, set pita karakter, lalu for(start();!End();ADV())
class mesinkata {
public:
	///constructor
	mesinkata();
	///constructor dengan parameter
	mesinkata(const std::string& _pitakar);
	///copy constructor
	mesinkata(const mesinkata& m);
	///desstructor
	~mesinkata();
	///operator assignment
	mesinkata& operator=(const mesinkata& m);
	//Getter
	///mengembalikan kata yang terakhir dibaca
	std::string GetKata() const;
	/// mengembalikan status pembacaan string input
	bool GetEnd() const;
	//Setter
	/// I.S Sembarang
	/// F.S mKar.PitaKarakter=_pitakar
	void SetPitaKarakter(const std::string& _pitakar);
	/// I.S Sembarang
	/// F.S Kata = ST
	void SetKata(const std::string& ST);
	///I.S Sembarang
	///F.S this->End = End
	void SetEnd(bool End);
	//Fungsi
	///I.S Sembarang
	///F.S mKar.CC != ' '
	void Ignore_Blank();
	///I.S PitaKarakter tidak kosong
	///F.S Kata = Kata Pertama dalam string, End = False
	void START();	//!memulai pembacaan
	///I.S !End 
	///F.S Kata = Kata Selanjutnya dalam string atau End = true jika string telah habis
	void ADV();	//!maju satu kata. prekondisi: !End()
	/// I.S !End
	/// F.S Kata = Kata Selanjutnya 
	void SalinKata();
private:
	mesinkar mKar;	
	bool End;
	std::string Kata;
};
#endif
