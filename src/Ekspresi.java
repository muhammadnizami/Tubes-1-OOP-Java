import java.util.Stack;
public class Ekspresi{
	private String expr;
	private String val;


	public Ekspresi(){
		expr="0";
		val="0";
	}
	
	public Ekspresi(String _expr){
		expr=_expr;
		calculate();
	}

	public void setExpr(String _expr){
		expr = _expr;
		calculate();
	}

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
	private void calculateInfix(){

	}
	private void calculatePostfix(){

	}

	public String getExpr(){
		return expr;
	}

	public String getVal(){
		return val;
	}
}
