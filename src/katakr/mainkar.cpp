/*!Driver untuk mengetes kelas mesinkarakter*/
#include "mesinkar.h"
#include <iostream>
#include <cassert>
int main(){
	std::string wolo;
//	wolo = "abcdefg";

	std::getline (std::cin,wolo);
	mesinkar M = mesinkar();
	M.SetPitaKarakter(wolo);
	
	for(M.START();!M.EOP();M.ADV()){
		std::cout << M.GetCC();
	}
	
	mesinkar M1 = mesinkar(wolo);
	
	int i=0;
	for (M1.START(); !M1.EOP(); M1.ADV()){
		assert(!M1.EOP());
		assert(M1.GetCC()==wolo[i]);
		assert(M1.GetCC()==wolo[i]);
		i++;
	}
	
	mesinkar M2 = M1;
	i=0;
	for (M2.START(); !M2.EOP(); M2.ADV()){
		assert(!M2.EOP());
		assert(M2.GetCC()==wolo[i]);
		assert(M2.GetCC()==wolo[i]);
		i++;
	}
	
	M2 = M1;
	i=0;
	for (M2.START(); !M2.EOP(); M2.ADV()){
		assert(!M2.EOP());
		assert(M2.GetCC()==wolo[i]);
		assert(M2.GetCC()==wolo[i]);
		i++;
	}

	return 0;
}
