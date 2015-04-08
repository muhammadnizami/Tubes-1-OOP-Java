import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class testConverter{
	Converter C;
	public testConverter(){C = new Converter();}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("testConverter");
	}

	@Test
	public void TestToStringsOperator(){
		
		TestToString(TipeToken.Kali,"*");
		TestToString(TipeToken.Bagi,"/");
		TestToString(TipeToken.Tambah,"+");
		TestToString(TipeToken.Kurang,"-");
		TestToString(TipeToken.Div,"div");
		TestToString(TipeToken.Mod,"mod");
		TestToString(TipeToken.Kurungbuka,"(");
		TestToString(TipeToken.Kurungtutup,")");
		TestToString(TipeToken.And,"and");
		TestToString(TipeToken.Or,"or");
		TestToString(TipeToken.Xor,"xor");
		TestToString(TipeToken.Not,"not");
		TestToString(TipeToken.KurangDari,"<");
		TestToString(TipeToken.KurangDariSamaDengan,"<=");
		TestToString(TipeToken.LebihDari,">");
		TestToString(TipeToken.LebihDariSamaDengan,">=");
		TestToString(TipeToken.SamaDengan,"=");
		TestToString(TipeToken.TidakSamaDengan,"<>");
	}

	private void TestToString(TipeToken _tkn, String seharusnyaSamaDengan){
		Token T = new Token();
		T.SetTkn(_tkn);
		assertTrue(C.toString(T).equals(seharusnyaSamaDengan));
	}

	@Test
	public void TestToStringsBilangan(){
		Token T = new Token();
		T.SetBilangan(123);
		assertTrue(C.toString(T).equals("123"));
		T.SetBilangan(-123);
		assertTrue(C.toString(T).equals("-123"));
		T.SetBilangan(true);
		assertTrue(C.toString(T).equals("true"));
		T.SetBilangan(false);
		assertTrue(C.toString(T).equals("false"));
	}

	@Test
	public void TestToTokens(){
		TestToToken(TipeToken.Kali,"*");
		TestToToken(TipeToken.Bagi,"/");
		TestToToken(TipeToken.Tambah,"+");
		TestToToken(TipeToken.Kurang,"-");
		TestToToken(TipeToken.Div,"div");
		TestToToken(TipeToken.Mod,"mod");
		TestToToken(TipeToken.Kurungbuka,"(");
		TestToToken(TipeToken.Kurungtutup,")");
		TestToToken(TipeToken.And,"and");
		TestToToken(TipeToken.Or,"or");
		TestToToken(TipeToken.Xor,"xor");
		TestToToken(TipeToken.Not,"not");
		TestToToken(TipeToken.KurangDari,"<");
		TestToToken(TipeToken.KurangDariSamaDengan,"<=");
		TestToToken(TipeToken.LebihDari,">");
		TestToToken(TipeToken.LebihDariSamaDengan,">=");
		TestToToken(TipeToken.SamaDengan,"=");
		TestToToken(TipeToken.TidakSamaDengan,"<>");
		TestToToken(TipeToken.Bilangan,"123");
		TestToToken(TipeToken.Bilangan,"-123");
		TestToToken(TipeToken.Bilangan,"true");
		TestToToken(TipeToken.Bilangan,"false");
		TestToToken(TipeToken.Bilangan,"9.444");
		TestToToken(TipeToken.Bilangan,"+333");
		
	}

	private void TestToToken(TipeToken seharusnyaTipenya, String str ){
		assertTrue(C.toToken(str).getTkn()==seharusnyaTipenya);
	}

}
