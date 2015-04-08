import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class BilanganLogikaTest{
	BilanganLogika L;
	public BilanganLogikaTest(){L = new BilanganLogika();}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("BilanganLogikaTest");
	}

	@Test
	public void testTrueToToken(){
		assertTrue(L.toToken("true").getBilanganBool()==true);
	}

	@Test
	public void testFalseToToken(){
		assertTrue(L.toToken("false").getBilanganBool()==false);
	}

	@Test
	public void testFalseToString(){
		Token T = new Token();
		T.SetBilangan(false);
		assertTrue(L.toString(T)=="false");
	}

	@Test
	public void testTrueToString(){
		Token T = new Token();
		T.SetBilangan(true);
		assertTrue(L.toString(T)=="true");
	}

	@Test
	public void testRegEx(){
		String str ="truefalse true false    true false";
		Pattern pattern = Pattern.compile(L.getRegEx());
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			assertTrue(L.canConvert(matcher.group(0)));
		}		
	}
}
