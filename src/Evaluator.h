#ifndef Evaluator_h
#define Evaluator_h
#include "token/converter.h"
#include <string>
#include "history.h"

using std::string;

class Evaluator{
public:
	Evaluator(){/*default:*/ M = prefix; Status = depan;};
	string DoCmd(string, bool addToHistory = true);

	string Redo(int);

	string MemAll();

	string Mem(int);

	string Undo(int);

	string ComputeExpr(string);//menghitung ekspresi
	string ComputeExprPrefix(string);
	string ComputeExprInfix(string);
	string ComputeExprPostfix(string);

	string Save();

	string Set(string s);

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
