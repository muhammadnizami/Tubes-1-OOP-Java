/** Responsibility
 * Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan bilangan Logika
 * Hubungan dengan kelas lain
 * mengimplementasi StrToken
 * Gambaran umum method
 * metodanya adalah implementasi metoda StrToken
*/
public class BilanganLogika implements StrToken{
	/**mengembalikan true bila s dapat dikonversi ke token*/
	public boolean canConvert(/*const*/ String s){ 	
		return s.equals("true") || s.equals("false");
	}

	/**mengembalikan representasi string dari token T*/
	public String toString (/*const*/ Token T){
		assert(T.getTkn() == TipeToken.Bilangan);
		assert(T.getTipeBilangan() == Tipe._bool);
		if (T.getBilanganBool())
			return "true";
		else	return "false";
	}
	/**mengembalikan representasi token dari string s*/
	public Token toToken(/*const*/ String s){	
		assert(canConvert(s));
		Token retval = new Token();
		if(s.equals("0") || s.equals("false"))
			retval.SetBilangan(false);
		else	retval.SetBilangan(true);
		return retval;
	}
	/**mengembalikan ekspresi reguler dari kelas turunan StrToken tersebut*/
	public String getRegEx(){
		return "(true)|(false)";
	}
}
