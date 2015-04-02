import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;


public class OperatorTest{
	public OperatorTest(){}

	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("OperatorTest");
	}

	@Test
	public void TestToStrings(){
		
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
		TestToString(TipeToken.TidakSamaDengan,"!=");
	}

	private void TestToString(TipeToken _tkn, String seharusnyaSamaDengan){
		Operator O = new Operator();
		Token T = new Token();
		T.SetTkn(_tkn);
		assert(O.toString(T).equals(seharusnyaSamaDengan));
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
		TestToToken(TipeToken.TidakSamaDengan,"!=");
		
	}

	private void TestToToken(TipeToken seharusnyaTipenya, String str ){
		Operator O = new Operator();
		assert(O.toToken(str).getTkn()==seharusnyaTipenya);
	}

	@Test
	public void TestRegEx(){
		Operator O = new Operator();
		String str = " +-*/div  mod  and or xor  < > = <> <= >=   ";
		Pattern pattern = Pattern.compile(O.getRegEx());
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){

			assert(O.canConvert(matcher.group(0)));
		}
	}

}
