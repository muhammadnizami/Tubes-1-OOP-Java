#ifndef Evaluator_h
#define Evaluator_h
#include "token/converter.h"
#include <string>
#include "history.h"

using std::string;

/* !
kelas ini bertanggungjawab melaksanakan perintah, baik pengaturan, perhitungan, maupun penyimpanan.\n
Kelas ini mengandung kelas Histori, File Manager, dan Converter. Dalam beberapa metodanya, kelas ini menggunakan mesintoken dan stack.\n
Metoda utama yang diakses dari luar kelas adalah DoCmd yaitu melaksanakan sebuah string perintah. Di dalam kelas ini juga ada metoda pembantu untuk DoCmd di antaranya Set, EvaluateExpr, dan sebagainya.\n
*/
class Evaluator{
public:
	Evaluator(){/*!ctor default:*/ M = prefix; Status = depan;};
	
	//!melakukan perintah
	string DoCmd(string, bool addToHistory = true); 
	
	//!mengulang n buah perintah
	string Redo(int);
	
	//!menampilkan semua perintah
	string MemAll();
	//!menampilkan n buah perintah
	string Mem(int);

	//!menghapus n buah perintah
	string Undo(int);

	//!menghitung ekspresi, menggunakan mesin token dan stack
	string ComputeExpr(string);
	
	//!menghitung ekspresi prefix
	string ComputeExprPrefix(string);
	
	//!menghitung ekspresi infix
	string ComputeExprInfix(string);
	
	//!menghitung ekspresi postfix
	string ComputeExprPostfix(string);

	//!menyimpan histori
	string Save();

	//!melakukan setting
	string Set(string s);

	//!keluar
	void Quit();

private:
	enum modeOpr{
		prefix,
		infix,
		postfix
	};

	modeOpr M;
	Converter C;
	History H;

	enum {depan,_Set,SetModeOpr,SetStringOpr,SetModeBilangan,
			Set_Kali,
			Set_Bagi,
			Set_Tambah,
			Set_Kurang,
			Set_Div,
			Set_Mod,
			Set_Kurungbuka,
			Set_Kurungtutup,
			Set_And,
			Set_Or,
			Set_Not,}
		Status;


};

#endif
