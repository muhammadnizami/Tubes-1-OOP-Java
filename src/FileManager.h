#ifndef FileManager_h
#define FileManager_h
#include "history.h"
#include <exception>

/*!
Responsibility\n
kelas ini bertugas menyimpan histori ke berkas\n
Hubungan dengan kelas lain\n
kelas ini menggunakan kelas Histori pada salah satu metodanya\n
Gambaran umum method\n
kelas ini memiliki metoda Save\n
*/
class FileManager{
public:

	//!menyimpan ke berkas dengan tambahan informasi tanggal dan jam
	void Save(History H);
		
};

//!exception yang dilempar oleh FileManager
class FileManagerException: public std::exception{
public:
	virtual const char* what() const throw(){
		return "FileManagerException happened";
	}
};

#endif
