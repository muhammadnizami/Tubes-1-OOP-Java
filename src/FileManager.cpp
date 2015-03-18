#include "FileManager.h"

#include <fstream>
#include <ctime>

void FileManager::Save(History H){
	time_t rawtime;
	time (&rawtime);

	std::fstream fs;
	try{
		fs.open(ctime(&rawtime),std::fstream::out);
		fs<<H.GetAllBoth();
		fs.close();
	}catch(ios_base::failure){
		throw FileManagerException();
	}
}
