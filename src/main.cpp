#include "Evaluator.h"
#include "UI.h"

//g++ main.cpp Evaluator.cpp token/converter.cpp token/Token.cpp token/Arab.cpp token/Logika.cpp token/Romawi.cpp token/mesintoken.cpp katakr/mesinkata.cpp katakr/mesinkar.cpp token/Operator.cpp 

int main(){
	Evaluator E;
	UI _ui;
	while (true){
		_ui.Display(E.DoCmd(_ui.GetNextCmd()));
	}
	return 0;
}
