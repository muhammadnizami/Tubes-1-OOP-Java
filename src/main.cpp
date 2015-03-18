#include "Evaluator.h"
#include "UI.h"



int main(){
	Evaluator E;
	UI _ui;
	while (true){
		_ui.Display(E.DoCmd(_ui.GetNextCmd()));
	}
	return 0;
}
