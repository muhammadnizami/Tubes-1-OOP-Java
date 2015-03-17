#ifndef UI_h
#define UI_h

#include <string>
#include <iostream>
class UI{ 	//placeholder
		//kalau metode input dan output user diganti,
		//kelas ini dahulu yang diganti
	public:

	UI(std::istream& _in=std::cin,std::ostream& _out=std::cout):in(_in),out(_out){}

	std::string GetNextCmd(){out<<"> ";std::string a; getline(in,a);return a;}
	void Display(std::string dsp){out<<dsp<<std::endl;};

	private:
	std::istream& in;
	std::ostream& out;

};

#endif
