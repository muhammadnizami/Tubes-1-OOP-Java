/*
 * Nama         : Ignatius Alriana Haryadi Moel
 * NIM          : 13513051
 * Nama File    : history.h
 * Deskripsi    : Kelas History
 * Tanggal      : 5 Maret 2015
*/

#include <iostream>
#include <cstdio>
#include "history.h"

using namespace std;

//! ctor
History::History(){

}

History::History(string s,string r){
    MemCmd.Push(s);
    MemRes.Push(r);
};

//!cctor
History::History(const History &H){
    MemRes = H.MemRes;
    MemCmd = H.MemCmd;
};

//! dtor
History::~History(){
   
};

//!predikat
string History::GetAllBoth(){ //! mengeluarkan seluruh history 
    string tmp;
    Stack<string> tmpcmd;
    Stack<string> tmpres;
    while (!MemCmd.Empty() && ! MemRes.Empty()){
        string a,b;
        MemCmd.Pop(&a);MemRes.Pop(&b);
        tmpcmd.Push(a);tmpres.Push(b);
    }
    while (!tmpcmd.Empty() && ! tmpres.Empty()){
	string a,b;
        tmpcmd.Pop(&a);tmpres.Pop(&b);
        MemCmd.Push(a);MemRes.Push(b);
        tmp += a + (b!=""?" = " + b:"") + "\n";
    }
    return tmp;
};

string History::GetAllCmd(){ //! mengeluarkan perintah yang pernah dieksekusi 
    string tmp;
    Stack<string> tmpcmd;
    while (!MemCmd.Empty()){
        string a;
        MemCmd.Pop(&a);
        tmpcmd.Push(a);
    }
    while (!tmpcmd.Empty()){
	string a;
        tmpcmd.Pop(&a);
        MemCmd.Push(a);
        tmp +=a + "\n";
    }
    return tmp;
};

string History::GetBoth(int n){ //! mengeluarkan n buah history terakhir 
    string tmp;
    Stack<string> tmpcmd;
    Stack<string> tmpres;
    while (!MemCmd.Empty() && ! MemRes.Empty() && n--){
        string a,b;
        MemCmd.Pop(&a);MemRes.Pop(&b);
        tmpcmd.Push(a);tmpres.Push(b);
    }
    while (!tmpcmd.Empty() && ! tmpres.Empty()){
	string a,b;
        tmpcmd.Pop(&a);tmpres.Pop(&b);
        MemCmd.Push(a);MemRes.Push(b);
        tmp +=a + (b!=""?" = " + b:"") + "\n";
    }
    return tmp;
};

string History::GetCmd(int n){ //! mengeluarkan n buah perintah terakhir
    string tmp;
    Stack<string> tmpcmd;
    while (!MemCmd.Empty() && n--){
        string a;
        MemCmd.Pop(&a);
        tmpcmd.Push(a);
    }
    while (!tmpcmd.Empty()){
	string a;
        tmpcmd.Pop(&a);
        MemCmd.Push(a);
        tmp +=a + "\n";
    }
    return tmp;
};

void History::Add(string cmd, string res){
    MemCmd.Push(cmd);
    MemRes.Push(res);
};

void History::Delete(int n){
    while (!MemCmd.Empty() && !MemRes.Empty() && n--){
	string dum;
        MemCmd.Pop(&dum);
        MemRes.Pop(&dum);
    }
}
