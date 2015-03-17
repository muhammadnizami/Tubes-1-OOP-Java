#include "Evaluator.h"
#include "stack/stack.h"
#include "token/mesintoken.h"
#include <cassert>

string Evaluator::DoCmd(string s){
	/*


	3. Redo Masuk histori lagi tidak sebagai duplikat komando 

	yang di-redo, mengulang n perintah sebelumnya 

	mulai dari perintah terakhir yang dimasukan. 

	4. Undo Menghapus memori terakhir 

	5. Save Menyimpan seleruh ekspresi beserta hasilnya ke file 

	6. Set Muncul menu 
	*/
	mesinkata mk(s);
	mk.START();
	if (mk.GetKata()=="Set" || Status != depan){
		return Set(s);
	}else if (mk.GetKata()=="ShowMem"){
		return "not implemented";
	}else if (s=="Show All"){
		return "not implemented";
	}else if (mk.GetKata()=="Undo"){
		return "not implemented";
	}else if (mk.GetKata()=="Redo"){
		return "not implemented";
	}else if (mk.GetKata()=="Save"){
		return "not implemented";
	}else if (mk.GetKata()=="Quit"){
		Quit();
	}else{
		return ComputeExpr(s);
		
	}
}
#include<cstdlib>
void Evaluator::Quit(){
	exit(0);
}

string Evaluator::Set(string s){
	//sebuah finite state machine
	TipeToken tkn;
	switch(Status){
		case depan:
		Status = _Set;
		return "(PERINGATAN: ekspresi yang ditulis sebelumnya bisa jadi tidak valid\n/****SET****/\n1. Mode Operator\n2. String Operator\n3. Mode Bilangan\n0. Cancel";
		case _Set:
		if (s=="1"){
			Status = SetModeOpr;
			return "Mode Operator:\n1. Prefix\n2. Infix\n3. Postfix";
		}else if (s=="2"){
			Status = SetStringOpr;
			return "String Operator:\n1. Kali\n2. Bagi\n3. Tambah\n4. Kurang\n5. Div\n6. Mod\n7. Kurungbuka\n8. Kurungtutup\n9. And\n10. Or\n11. Not";
		}else if (s=="3"){
			Status = SetModeBilangan;
			return "Set Mode Bilangan:\n1. Arab\n2. Romawi\n3. Logika";
		}else if (s=="0"){
			Status = depan;
			return "";
		}else return "unknown option";
		case SetModeOpr:
		if (s=="1"){
			M = prefix;
			Status = depan;
			return "mode operator diset prefix";
		}else if (s=="2"){
			M = infix;
			Status = depan;
			return "mode operator diset infix";
		}else if (s=="3"){
			M = postfix;
			Status = depan;
			return "mode operator diset postfix";
		}else return "unknown option";
		case SetStringOpr:
		if (s=="1"){
			Status = Set_Kali;
		}else if (s=="2"){
			Status = Set_Bagi;
		}else if (s=="3"){
			Status = Set_Tambah;
		}else if (s=="4"){
			Status = Set_Kurang;
		}else if (s=="5"){
			Status = Set_Div;
		}else if (s=="6"){
			Status = Set_Mod;
		}else if (s=="7"){
			Status = Set_Kurungbuka;
		}else if (s=="8"){
			Status = Set_Kurungtutup;
		}else if (s=="9"){
			Status = Set_And;
		}else if (s=="10"){
			Status = Set_Or;
		}else if (s=="11"){
			Status = Set_Not;
		}else return "unknown option";
		return "masukkan string (alfanumerik/simbol, unik, bukan bilangan)";
		case SetModeBilangan:
		if (s=="1"){
			C.SetMode(C._Arab);
			Status = depan;
			return "mode bilangan diset bilangan Arab";
		}else if (s=="2"){
			C.SetMode(C._Romawi);
			Status = depan;
			return "mode bilangan diset bilangan Romawi";
		}else if (s=="3"){
			C.SetMode(C._Logika);
			Status = depan;
			return "mode bilangan diset bilangan Logika";
		}else return "unknown option";

		//yang di bawah ini memang fall-through
		//supaya mudah
		case Set_Kali:
		case Set_Bagi:
		case Set_Tambah:
		case Set_Kurang:
		case Set_Div:
		case Set_Mod:
		case Set_Kurungbuka:
		case Set_Kurungtutup:
		case Set_And:
		case Set_Or:
		case Set_Not:
		switch(Status){
			case Set_Kali:
			tkn=Kali;
			break;
			case Set_Bagi:
			tkn=Bagi;
			break;
			case Set_Tambah:
			tkn=Tambah;
			break;
			case Set_Kurang:
			tkn=Kurang;
			break;
			case Set_Div:
			tkn=Div;
			break;
			case Set_Mod:
			break;
			tkn=Mod;
			case Set_Kurungbuka:
			break;
			tkn=Kurungbuka;
			break;
			case Set_Kurungtutup:
			tkn=Kurungtutup;
			break;
			case Set_And:
			tkn=And;
			break;
			case Set_Or:
			tkn=Or;
			break;
			case Set_Not:
			tkn=Not;
			break;
		}
		try{
			Status = depan;
			C.SetStrOperator(s,tkn);
		}catch(ConverterException){return "Invalid string representation. Kembali ke awal";}
		return "Operator berhasil diganti";
	}
}
#include <cstring>
string Evaluator::ComputeExpr(string s){
	try{
		switch(M){
			case prefix:
				return ComputeExprPrefix(s);
				break;
			case infix:
				return ComputeExprInfix(s);
				break;
			case postfix:
				return ComputeExprPostfix(s);
				break;
		}
	}catch(TokenException e){
		if (!strcmp(e.what(),"CANNOT DIVIDE BY ZERO"))
			return string("MATH ERROR: ") + e.what();
		else
			return string("SYNTAX ERROR: ") + e.what();
	}catch(ConverterException e){
		return string("SYNTAX ERROR: ") +  e.what();
	}
}

string Evaluator::ComputeExprPrefix(string s){
	/*algoritma: postfix dibalik (dari kanan)*/
	Stack<Token> st0;
	mesintoken mt(s,C);
	for (mt.START();!mt.GetEnd();mt.ADV()){
		st0.Push(mt.GetCToken());
	}

	Stack<Token> st;

	while(!st0.Empty()){
		Token CToken;
		st0.Pop(&CToken);
		if (CToken.isBilangan()){
			st.Push(CToken);
		}else{
			if (CToken.isOprUner()){
				Token t1,th;
				st.Pop(&t1);
				th=CToken.Operasikan(t1);
				st.Push(th);
			}else{
				Token t1,t2,th;
				st.Pop(&t1);
				st.Pop(&t2);
				th=CToken.Operasikan(t1,t2);
				st.Push(th);
			}
		}
	}
	if (st.GetSize()==1){
		Token res;
		st.Pop(&res);
		return C.toString(res);
	}else
		return "syntax error";
}

string Evaluator::ComputeExprInfix(string s){
	/*
	kamus:
	take two stacks
	1. operatorStack { for operators and parenthesis }
	2. operandStack

	algoritma:
	while character exists to be read
    1. if character is operand push or (. push on the operandStack //salah. harusnya kalo ( ke operatorStack
    2. else if character is operator
       2.1 while the top of the operatorStack is not of smaller precedence than this character     
       2.2 pop from operatorStack
       2.3 pop two operands from operandStack
       2.4 store op1 op op2 on the operandStack
       back to 2.1
    3. else if character is )
       [do the same as 2.2 - 2.4 till you encounter (]

	else // no more character left to read
	    pop operators till operator stack is not empty 
	    pop top 2 operands and push op1 op op2 on the operand stack

	return the top value from operandStack

	[http://stackoverflow.com/questions/13421424/how-to-evaluate-an-infix-expression-in-just-one-scan-using-stacks]
	*/

	Stack<Token> operatorStack,operandStack;
	mesintoken mt(s,C);

	for (mt.START();!mt.GetEnd();mt.ADV()){
		if (mt.GetCToken().isBilangan())
			operandStack.Push(mt.GetCToken());
		else if ( mt.GetCToken().getTkn() == Kurungbuka)
			operatorStack.Push(mt.GetCToken());
		else if (mt.GetCToken().isOprUner() || mt.GetCToken().isOprBiner()){
			while(!operatorStack.Empty()){
				Token top;
				operatorStack.Pop(&top);
				if(top.getTkn()!=Kurungbuka && !top.isSmallerPrecedenceThan(mt.GetCToken())){
					if (top.isOprUner()){
						Token oprnd;
						if (operandStack.Empty()) return "syntax error";
						operandStack.Pop(&oprnd);
						operandStack.Push(top.Operasikan(oprnd));
					} else { assert(top.isOprBiner());
						Token op1, op2;
						if (operandStack.Empty()) return "syntax error";
						operandStack.Pop(&op2);
						if (operandStack.Empty()) return "syntax error";
						operandStack.Pop(&op1);
						operandStack.Push(top.Operasikan(op1,op2));
					}
				}else{
					operatorStack.Push(top);
					break;
				}
			}
			operatorStack.Push(mt.GetCToken());
		}else if (mt.GetCToken().getTkn()==Kurungtutup){
			if (operandStack.Empty()) return "syntax error";
			while(!operatorStack.Empty()){
				Token top;
				operatorStack.Pop(&top);
				if(top.getTkn()!=Kurungbuka){
					Token op;
					if (operandStack.Empty()) return "syntax error";
					operandStack.Pop(&op);
					if (op.isOprUner()){
						operandStack.Push(top.Operasikan(op));
					} else { assert(top.isOprBiner());
						Token op1;
						if (operandStack.Empty()) return "syntax error";
						operandStack.Pop(&op1);
						operandStack.Push(top.Operasikan(op1,op));
					}
				}else{
					break;
				}
			}
		}
	}

	while (!operatorStack.Empty()){
		Token op1,op,op2;
		operatorStack.Pop(&op);

		if (op.isOprUner()){
			operandStack.Pop(&op1);
			operandStack.Push(op.Operasikan(op1));
		}else{
			if(!op.isOprBiner()) return "syntax error";
			operandStack.Pop(&op2);
			operandStack.Pop(&op1);
			operandStack.Push(op.Operasikan(op1,op2));
		}
	}
	Token res;
	operandStack.Pop(&res);
	return C.toString(res);

}

string Evaluator::ComputeExprPostfix(string s){
	/*algoritma dari Wikipedia:
	The algorithm for evaluating any postfix expression is fairly straightforward:

	While there are input tokens left
		Read the next token from input.
		If the token is a value
			Push it onto the stack.
		Otherwise, the token is an operator (operator here includes both operators and functions).
			It is known a priori that the operator takes n arguments.
			If there are fewer than n values on the stack
				(Error) The user has not input sufficient values in the expression.
			Else, Pop the top n values from the stack.
			Evaluate the operator, with the values as arguments.
			Push the returned results, if any, back onto the stack.
	If there is only one value in the stack
		That value is the result of the calculation.
	Otherwise, there are more values in the stack
		(Error) The user input has too many values.
	*/
	Stack<Token> st;
	mesintoken mt(s,C);

	for (mt.START();!mt.GetEnd();mt.ADV()){
		if (mt.GetCToken().isBilangan()){
			st.Push(mt.GetCToken());
		}else{
			if (mt.GetCToken().isOprUner()){
				Token t1,th;
				st.Pop(&t1);
				th=mt.GetCToken().Operasikan(t1);
				st.Push(th);
			}else{
				Token t1,t2,th;
				st.Pop(&t2);
				st.Pop(&t1);
				th=mt.GetCToken().Operasikan(t1,t2);
				st.Push(th);
			}
		}
	}
	if (st.GetSize()==1){
		Token res;
		st.Pop(&res);
		return C.toString(res);
	}else
		return "syntax error";
}
