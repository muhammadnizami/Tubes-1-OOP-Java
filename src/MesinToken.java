import java.io.*;


//!Responsibility\n
//!Membaca ekspresi token per token\n
//!Kelas ini menggunakan std::string. Kelas ini mewarisi Mesin Kata. Kelas ini mengandung kelas converter.\n
//!Method kelas ini meliputi konstruktor yang menerima string pita karakter, START(), ADV(), GetCToken(). Start memulai mesin, ADV memajukan satu token, dan GetCToken() mengakses token yang sedang dibaca.\n

class MesinToken{
	//! membentuk mesin token dengan pita karakter ST
	public MesinToken (/* const*/ String ST){
		kata = ST.split(" +");
		CVT = new Converter();
	}
	//! membentuk mesin token dengan pita karakter ST dan converter cvt
	public MesinToken (/* const*/ String ST, /* const*/ Converter _cvt){
		kata = ST.split(" +");
		CVT = _cvt;
	}

	//!Getter@{
	//! prekondisi: !GetEnd()
	public Token GetCToken() /* const*/{
		return CToken.clone();
	}
	//!@}

	//!@name override\n
	//!method-method ini mengoverride dengan menambahkan konversi ke token dan disimpan di CToken
	//!@{
	//! prekondisi pita karakter tidak kosong
	public void START(){
		i=0;
		CToken = CVT.toToken(kata[i]);
		End = false;
	} 
	//! prekondisi: !GetEnd()
	public void ADV(){
		i++;
		if (i>=kata.length) End = true;
		else	CToken = CVT.toToken(kata[i]);

	}
	public boolean getEnd() /*const*/{
		return End;
	}
	//!@}

	private Converter CVT;
	private String [] kata;
	private Token CToken;
	private int i;
	private boolean End;
}
