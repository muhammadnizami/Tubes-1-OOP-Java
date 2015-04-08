import java.util.Stack;
public class Ekspresi{
	private String expr;
	private String val;

	/**Ctor*/
	public Ekspresi(){
		expr="0";
		val="0";
	}
	/**Ctor dengan parameter*/
	public Ekspresi(String _expr){
		expr=_expr;
		calculate();
	}

	public void setExpr(String _expr){
		expr = _expr;
		calculate();
	}
	/**Menghitung ekspresi, menggunakan mesin token dan stack*/
	public void calculate(){

		try{
			MesinToken MT = new MesinToken(expr);
			MT.START();
			switch(TentukanModeEkspresi(MT)){
				case prefix:
				calculatePrefix();
				break;
				case infix:
				calculateInfix();
				break;
				case postfix:
				calculatePostfix();
				break;
				case unknown:
				val = "SYNTAX ERROR";
				break;
			}		
		}catch(TokenException e){
			if (e.getMessage().equals("CANNOT DIVIDE BY ZERO")){
				val= "MATH ERROR: " + e.getMessage();
				return;
			}else{
				val= "SYNTAX ERROR: " + e.getMessage();
				return;
			}
		}catch(ConverterException e){
			val= "SYNTAX ERROR: " +  e.getMessage();
			return;
		}

	}

	//method pembantu
	private enum ModeEkspresi {prefix,infix,postfix,unknown};
	private ModeEkspresi TentukanModeEkspresi(MesinToken MT) throws ConverterException{
		if (MT.getEnd()) return ModeEkspresi.unknown;
		switch(MT.GetCToken().getTkn()){
			case Bilangan:
			return ModeEkspresi.postfix;
			case Kurungbuka:
			return ModeEkspresi.infix;
			case Not:
			MT.ADV();
			return TentukanModeEkspresi(MT);
			default:
			return ModeEkspresi.prefix;
		}
	}
	/**Menghitung ekspresi prefix*/
	private void calculatePrefix() throws TokenException, ConverterException{
		/*algoritma: postfix dibalik (dari kanan)*/
		Stack<Token> st0 = new Stack<Token>();
		MesinToken mt = new MesinToken(expr);
		for (mt.START();!mt.getEnd();mt.ADV()){
			st0.push(mt.GetCToken());
		}

		Stack<Token> st = new Stack<Token>();

		while(!st0.empty()){
			Token CToken;
			CToken = st0.pop();
			if (CToken.isBilangan()){
				st.push(CToken);
			}else{
				if (CToken.isOprUner()){
					Token t1,th;
					if (st.empty()) {val = "SYNTAX ERROR"; return;}
					t1 = st.pop();
					th=CToken.Operasikan(t1);
					st.push(th);
				}else{
					Token t1,t2,th;
					if (st.empty()) {val = "SYNTAX ERROR"; return;}
					t1 = st.pop();
					if (st.empty()) {val = "SYNTAX ERROR"; return;}
					t2 = st.pop();
					th=CToken.Operasikan(t1,t2);
					st.push(th);
				}
			}
		}
		if (st.size()==1){
			Token res;
			res = st.pop();
			Converter C = new Converter();
			val = C.toString(res);
			return;
		}else{
			val = "syntax error";
			return;
		}
				
	}
	/**Menghitung ekspresi Infix*/
	private void calculateInfix() throws TokenException, ConverterException{
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

		Stack<Token> operatorStack = new Stack<Token>();
		Stack<Token> operandStack = new Stack<Token>();
		MesinToken mt = new MesinToken(expr);

		for (mt.START();!mt.getEnd();mt.ADV()){
			if (mt.GetCToken().isBilangan())
				operandStack.push(mt.GetCToken());
			else if ( mt.GetCToken().getTkn() == TipeToken.Kurungbuka)
				operatorStack.push(mt.GetCToken());
			else if (mt.GetCToken().isOprUner() || mt.GetCToken().isOprBiner()){
				while(!operatorStack.empty()){
					Token top;
					top=operatorStack.pop();
					if(top.getTkn()!=TipeToken.Kurungbuka && !top.isSmallerPrecedenceThan(mt.GetCToken())){
						if (top.isOprUner()){
							Token oprnd;
							if (operandStack.empty()) {val= "syntax error";return;}
							oprnd=operandStack.pop();
							operandStack.push(top.Operasikan(oprnd));
						} else { assert(top.isOprBiner());
							Token op1, op2;
							if (operandStack.empty()) {val= "syntax error";return;}
							op2=operandStack.pop();
							if (operandStack.empty()) {val= "syntax error";return;}
							op1=operandStack.pop();
							operandStack.push(top.Operasikan(op1,op2));
						}
					}else{
						operatorStack.push(top);
						break;
					}
				}
				operatorStack.push(mt.GetCToken());
			}else if (mt.GetCToken().getTkn()==TipeToken.Kurungtutup){
				if (operandStack.empty()) {val= "syntax error";return;}
				while(!operatorStack.empty()){
					Token top;
					top=operatorStack.pop();
					if(top.getTkn()!=TipeToken.Kurungbuka){
						Token op;
						if (operandStack.empty()) {val= "syntax error";return;}
						op=operandStack.pop();
						if (top.isOprUner()){
							operandStack.push(top.Operasikan(op));
						} else { assert(top.isOprBiner());
							Token op1;
							if (operandStack.empty()) {val= "syntax error";return;}
							op1=operandStack.pop();
							operandStack.push(top.Operasikan(op1,op));
						}
					}else{
						break;
					}
				}
			}
		}

		while (!operatorStack.empty()){
			Token op1,op,op2;
			op=operatorStack.pop();

			if (op.isOprUner()){
				op1=operandStack.pop();
				operandStack.push(op.Operasikan(op1));
			}else{
				if(!op.isOprBiner()) {val= "syntax error";return;}
				op2=operandStack.pop();
				op1=operandStack.pop();
				operandStack.push(op.Operasikan(op1,op2));
			}
		}
		Token res;
		res=operandStack.pop();
		Converter C = new Converter();
		val= C.toString(res);return;

	}
	final boolean prefixUnerTetapDiDepan = true;
	/**Menghitung ekspresi postfix*/
	private void calculatePostfix() throws TokenException, ConverterException{
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
		Stack<Token> st = new Stack<Token>();
		MesinToken mt = new MesinToken(expr);

		for (mt.START();!mt.getEnd();mt.ADV()){
			if (mt.GetCToken().isBilangan()){
				st.push(mt.GetCToken());
			}else{
				if (mt.GetCToken().isOprUner()){
					if (prefixUnerTetapDiDepan){
						Token op = mt.GetCToken();
						mt.ADV();
						if (mt.getEnd()) {val = "SYNTAX ERROR"; return;}
						st.push(op.Operasikan(mt.GetCToken()));
					}else{
						Token t1,th;
						if (st.empty()) {val = "SYNTAX ERROR"; return;}
						t1 = st.pop();
						th=mt.GetCToken().Operasikan(t1);
						st.push(th);
					}
				}else{
					Token t1,t2,th;
					if (st.empty()) {val = "SYNTAX ERROR"; return;}
					t2 = st.pop();
					if (st.empty()) {val = "SYNTAX ERROR"; return;}
					t1 = st.pop();
					th=mt.GetCToken().Operasikan(t1,t2);
					st.push(th);
				}
			}
		}
		if (st.size()==1){
			Token res;
			res = st.pop();
			Converter C = new Converter();
			val = C.toString(res);return;
		}else
			{val = "SYNTAX ERROR"; return;}

	}
	/**Getter*/
	public String getExpr(){
		return expr;
	}
	/**Getter*/
	public String getVal(){
		return val;
	}
}
