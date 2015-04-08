/**
Calculator.java adalah sebuah kelas utama\n
Kelas ini bertugas meneruskan masukan dari user untuk dihitung sebagai ekspresi atau command yang harus dilakukan 
*/
public class Calculator{
	private String input;
	
	//*Default Contructor
	public Calculator(){
	}
	
	//*Contructor with parameter
	public Calculator( String _input){
		input = _input;
	}
	
	public String DoExp(){
		Ekspresi exp = new Ekspresi(input);
		return exp.getVal();
	}
	
	public String DoCmd(){
		CommandProcessor cmd = new CommandProcessor();
		return  cmd.DoCmd(input);
	}
}