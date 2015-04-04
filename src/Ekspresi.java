public class Ekspresi{
	private string expr;
	private string val;


	public Ekspresi(){
		expr="0";
		val="0";
	}
	
	public Ekspresi(string _expr){
		expr=_expr.clone();
		calculate();
	}

	public void setExpr(string _expr){

	}

	public void calculate(){

	}

	//method pembantu
	private void calculatePrefix(){

	}
	private void calculateInfix(){

	}
	private void calculatePostfix(){

	}

	public void getExpr(){

	}

	public void getVal(){

	}
}
