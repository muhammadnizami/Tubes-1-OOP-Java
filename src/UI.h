#ifndef UI_h
#define UI_h

#include <string>
#include <iostream>

//*placeholder\n
//*kalau metode input dan output user diganti,\n
//*kelas ini terlebih dahulu yang diganti\n
class UI{ 	
	public:

	UI(std::istream& _in=std::cin,std::ostream& _out=std::cout):in(_in),out(_out){}
	
	//!mendapatkan perintah.
	std::string GetNextCmd(){out<<"> ";std::string a; getline(in,a);return a;}
	
	//!menampilkan respon
	void Display(std::string dsp){out<<dsp<<std::endl;};

	private:
	std::istream& in;
	std::ostream& out;

};

#endif
