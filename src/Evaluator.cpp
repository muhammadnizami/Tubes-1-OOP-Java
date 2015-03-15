#include "Evaluator.h"
#include "stack/stack.h"
#include "token/mesintoken.h"

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
	}catch(TokenException te){
		return te.what();
	}catch(ConverterException ce){
		return ce.what();
	}
}

string Evaluator::ComputeExprPrefix(string s){
	return "not implemented";
}

string Evaluator::ComputeExprInfix(string s){
	return "not implemented";
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
	mesintoken mt(s);

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
		return "(Error) The user input has too many values.";
}