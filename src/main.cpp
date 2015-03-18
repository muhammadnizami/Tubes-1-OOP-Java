#include "Evaluator.h"
#include "UI.h"


//! main program ini yang di-compile dan di-link saat make
//! memakai kelas Evaluator dan UI
int main(){
	Evaluator E;
	UI _ui;
	while (true){
		_ui.Display(E.DoCmd(_ui.GetNextCmd()));
	}
	return 0;
}
