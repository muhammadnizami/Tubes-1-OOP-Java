#include "mesinkar.h"
#include <iostream>
int main(){
	std::string wolo;
//	wolo = "abcdefg";

	std::getline (std::cin,wolo);
	mesinkar M = mesinkar();
	M.SetPitaKarakter(wolo);
	
	for(M.START();!M.EOP();M.ADV()){
		std::cout << M.GetCC();
	}

	return 0;
}
