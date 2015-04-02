public interface StrToken{
	//!mengembalikan true bila s dapat dikonversi ke token
	public boolean canConvert(String s);
	//!mengembalikan representasi string dari token T
	public String toString (Token T);
	//!mengembalikan representasi token dari string s
	public Token toToken(String s); 
	//!mengembalikan ekspresi reguler dari kelas turunan StrToken tersebut
	public String getRegEx();
}
