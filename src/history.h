/*!
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : history.h
 * Deskripsi    : Kelas History
 * Tanggal      : 5 Maret 2015
*/

#include <iostream>
#include <cstdio>
#include "stack/stack.h"

using namespace std;

#ifndef HISTORY_H
#define HISTORY_H

class History{
    public:
        //! ctor
		History();
        History(string s, string r);
        //!cctor
        History(const History &H);
        //! dtor
        ~History();

        //!predikat
        
         //! mengeluarkan seluruh history
        string GetAllBoth();
        
        //! mengeluarkan perintah yang pernah dieksekusi
        string GetAllCmd(); 
        
         //! mengeluarkan n buah history terakhir
        string GetBoth(int n);
        
        // !mengeluarkan n buah perintah terakhir
        string GetCmd(int n); 

	//!menambahkan perintah cmd dan hasil res
	//!I.S History sudah terdefinisi
	//!F.S cmd dan res sudah ditambah ke dalam history
	void Add(string cmd, string res = "");
	
	//!menghapus n buah perintah terakhir
	//!I.S History sudah terdefinisi dan berisi >=n History
	//!F.S History yang sudah dihilangkan n buah history, history mungkin menjadi kosong
	void Delete(int n);
    
    private:
    Stack<string> MemCmd;
    Stack<string> MemRes;
};

#endif
