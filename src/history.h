/*
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
        // ctor
		History();
        History(string s, string r);
        //cctor
        History(const History &H);
        // dtor
        ~History();

        //predikat
        string GetAllBoth(); // mengeluarkan seluruh history
        string GetAllCmd(); // mengeluarkan perintah yang pernah dieksekusi
        string GetBoth(int n); // mengeluarkan n buah history terakhir
        string GetCmd(int n); // mengeluarkan n buah perintah terakhir

	void Add(string cmd, string res = ""); //menambahkan perintah cmd dan hasil res
	void Delete(int n); //menghapus n buah perintah terakhir
    
    private:
    Stack<string> MemCmd;
    Stack<string> MemRes;
};

#endif
