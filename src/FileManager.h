#ifndef FileManager_h
#define FileManager_h
#include "history.h"
#include <exception>

/*!
Responsibility
kelas ini bertugas menyimpan histori ke berkas
Hubungan dengan kelas lain
kelas ini menggunakan kelas Histori pada salah satu metodanya
Gambaran umum method
kelas ini memiliki metoda Save
*/
class FileManager{
public:
	void Save(History H);
		
};

class FileManagerException: public std::exception{
public:
	virtual const char* what() const throw(){
		return "FileManagerException happened";
	}
};

#endif
