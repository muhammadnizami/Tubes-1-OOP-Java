#include "FileManager.h"

//! test kelas FileManager
int main(){
	History H;
	H.Add("test","test2");
	H.Add("test","test3");
	H.Add("test","test4");
	H.Add("test","test5");
	H.Add("test");
	H.Add("test","test7");

	FileManager FM;
	FM.Save(H);
	return 0;
}
