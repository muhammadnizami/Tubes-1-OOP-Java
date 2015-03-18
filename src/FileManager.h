#ifndef FileManager_h
#define FileManager_h
#include "history.h"
#include <exception>
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
