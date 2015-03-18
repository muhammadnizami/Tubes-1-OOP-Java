#ifndef UI_h
#define UI_h

#include <string>
#include <iostream>

//*placeholder
//*kalau metode input dan output user diganti,
//*kelas ini terlebih dahulu yang diganti
class UI{ 	
	public:

	UI(std::istream& _in=std::cin,std::ostream& _out=std::cout):in(_in),out(_out){}

	std::string GetNextCmd(){out<<"> ";std::string a; getline(in,a);return a;}//!mendapatkan perintah.
	void Display(std::string dsp){out<<dsp<<std::endl;};//!menampilkan respon

	private:
	std::istream& in;
	std::ostream& out;

};

#endif
