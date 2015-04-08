import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class BilanganArabTest{
	BilanganArab A;
	public BilanganArabTest(){A = new BilanganArab();}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("BilanganArabTest");
	}

	@Test
	public void TestSatu(){
//		assertTrue(A.toString(A.toToken("4000000000")));
		assertTrue(A.toString(A.toToken("2.05")).equals("2.05"));
		assertTrue(A.toString(A.toToken("0.464")).equals("0.46"));
		assertTrue(A.toString(A.toToken("403")).equals("403"));
//		assertTrue(A.toString(A.toToken("-4000000000")));
//		assertTrue(A.toString(A.toToken("-2000000")));
//		assertTrue(A.toString(A.toToken("-0.5")));
	}
}