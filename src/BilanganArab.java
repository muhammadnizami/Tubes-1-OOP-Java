/**
 * Responsibility
 * Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan bilangan arab
 * Hubungan dengan kelas lain
 * mengimplementasi StrToken
 * Gambaran umum method
 * metodanya adalah implementasi metoda StrToken
*/
public class BilanganArab implements StrToken{
	/**mengembalikan true bila s dapat dikonversi ke token*/
	public boolean canConvert(String s){
		int i=0;
		int n=s.length();
		boolean dotExists = false;
		if (s.charAt(i)=='-') i++;
		if (s.charAt(i)=='+') i++;
		for (;i<n;i++)
			if(s.charAt(i)=='.'){
				if(dotExists){
					return false;
				}else	dotExists=true;
			}else if (s.charAt(i)<'0' || s.charAt(i)>'9')
				return false;
		return true;
	}
	/**mengembalikan representasi string dari token T*/
	public String toString (Token T){
		assert(T.getTkn()==TipeToken.Bilangan);

		String ss = new String();

		switch(T.getTipeBilangan()){
			case _bool:
			if (T.getBilanganBool())
				return "1";
			else	return "0";
			case _int:
				ss = Integer.toString(T.getBilanganInt());
				break;
			case _float:
				ss = String.format("%.2f", T.getBilanganFloat());
				break;
		}

		return ss;
	}
	/**mengembalikan representasi token dari string s*/
	public Token toToken(String ss){
		
		assert(canConvert(ss));
		String s;
		if (ss.charAt(0)=='+') s=ss.substring(1,ss.length());
		else s=ss;
		float vf;
		vf = Float.parseFloat(s);
		Token tkn = new Token();
		if (vf >= Integer.MIN_VALUE && vf <=Integer.MAX_VALUE && vf == Math.floor(vf)){
			int vi;
			vi = Integer.parseInt(s);
			tkn.SetBilangan(vi);
		}else
			tkn.SetBilangan(vf);
		return tkn;
	}
	/**mengembalikan ekspresi reguler dari kelas turunan StrToken tersebut*/
	public String getRegEx(){
		return "((\\+|\\-)?[0-9]?\\.?[0-9])";
	}
}
