#include "UI.h"

int main(){
	UI _ui;

	_ui.Display("test\n");
	_ui.Display("you entered " + _ui.GetNextCmd() + "\n");
}
