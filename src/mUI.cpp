#include "UI.h"

//! test kelas UI
int main(){
	UI _ui;

	_ui.Display("test\n");
	_ui.Display("you entered " + _ui.GetNextCmd() + "\n");
}
