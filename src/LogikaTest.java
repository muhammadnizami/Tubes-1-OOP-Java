import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class LogikaTest{
	Logika L;
	public LogikaTest(){L = new Logika();}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("LogikaTest");
	}

	@Test
	public void testTrueToToken(){
		assert(L.toToken("true").getBilanganBool()==true);
	}

	@Test
	public void testFalseToToken(){
		assert(L.toToken("false").getBilanganBool()==false);
	}

	@Test
	public void testFalseToString(){
		Token T = new Token();
		T.SetBilangan(false);
		assert(L.toString(T)=="false");
	}

	@Test
	public void testTrueToString(){
		Token T = new Token();
		T.SetBilangan(true);
		assert(L.toString(T)=="true");
	}

	@Test
	public void testRegEx(){
		String str ="truefalse true false    true false";
		Pattern pattern = Pattern.compile(L.getRegEx());
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			assert(L.canConvert(matcher.group(0)));
		}		
	}
}
