#ifndef Evaluator_h
#define Evaluator_h
#include "token/converter.h"
#include <string>

using std::string;

class Evaluator{
public:
	enum modeOpr{
		prefix,
		infix,
		postfix
	};

	string DoCmd(string);

	string Redo(int);

	string MemAll();

	string Mem(int);

	string Undo(int);

	string ComputeExpr(string);//menghitung ekspresi
	string ComputeExprPrefix(string);
	string ComputeExprInfix(string);
	string ComputeExprPostfix(string);

	string Save();

	string Set();

private:
	modeOpr M;
	Converter C;

	enum {depan,_Set,SetModeOpr,SetStringOpr,SetModeBilangan} Status;


};

#endif