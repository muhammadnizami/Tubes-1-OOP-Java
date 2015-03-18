#ifndef Evaluator_h
#define Evaluator_h
#include "token/converter.h"
#include <string>
#include "history.h"

using std::string;

/* !
kelas ini bertanggungjawab melaksanakan perintah, baik pengaturan, perhitungan, maupun penyimpanan.
Kelas ini mengandung kelas Histori, File Manager, dan Converter. Dalam beberapa metodanya, kelas ini menggunakan mesintoken dan stack.
Metoda utama yang diakses dari luar kelas adalah DoCmd yaitu melaksanakan sebuah string perintah. Di dalam kelas ini juga ada metoda pembantu untuk DoCmd di antaranya Set, EvaluateExpr, dan sebagainya.
*/
class Evaluator{
public:
	Evaluator(){/*!default:*/ M = prefix; Status = depan;};
	string DoCmd(string, bool addToHistory = true); //!melakukan perintah

	string Redo(int);//!mengulang n buah perintah

	string MemAll();//!menampilkan semua perintah

	string Mem(int);//!menampilkan n buah perintah

	string Undo(int);//!menghapus n buah perintah

	string ComputeExpr(string);//!menghitung ekspresi, menggunakan mesin token dan stack
	string ComputeExprPrefix(string);//!menghitung ekspresi prefix
	string ComputeExprInfix(string);//!menghitung ekspresi infix
	string ComputeExprPostfix(string);//!menghitung ekspresi postfix

	string Save();//!menyimpan histori

	string Set(string s);//!melakukan setting

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
