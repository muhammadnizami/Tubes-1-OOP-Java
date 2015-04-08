/*!
Responsibility
Kelas ini bertugas mengkonversi seluruh kata yang valid menjadi token, baik operand maupun operator
Hubungan dengan kelas lain
Ia merupakan agregasi dari StrToken dan/atau Turunannya
Gambaran umum method
metodanya adalah toString dan toToken.*/
public class Converter{
	//!cctor,ctor,dtor
	//!@{
	//!default: operator default dan bilangan arab
	public Converter(){
		A = new BilanganArab();
		L = new BilanganLogika();
		O = new Operator();
	}
	//!@}
	
	//!mengkonversi token ke string
	public String toString(/* const*/ Token T){
		if (!T.isBilangan())
			return O.toString(T);
		else if (T.getTipeBilangan()==Tipe._bool)
			return L.toString(T);
		else	return A.toString(T);
	}
	 //!mengkonversi string ke token. melempar exception bila gagal
	public Token toToken(/* const*/ String S){
		if (O.canConvert(S))
			return O.toToken(S);
		else if (L.canConvert(S))
			return L.toToken(S);
		else	return A.toToken(S);
	}

	private BilanganArab A;
	private BilanganLogika L;
	private Operator O;
}
