import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class EkspresiTest{
	public EkspresiTest(){}

	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("EkspresiTest");
	}
	
	@Test
	public void TestPrefix1(){
		Ekspresi e = new Ekspresi("+ 4 3");
		assert(e.getVal().equals("7"));
	}
	@Test
	public void TestPrefix2(){
		Ekspresi e = new Ekspresi("not and < 4 3 true");
		assert(e.getVal().equals("true"));
	}
	@Test
	public void TestPrefix3(){
		Ekspresi e = new Ekspresi(">= 3 3");
		assert(e.getVal().equals("true"));
	}
	@Test
	public void TestPrefix4(){
		Ekspresi e = new Ekspresi("div 4 3");
		assert(e.getVal().equals("1"));
	}
	@Test
	public void TestPrefix5(){
		Ekspresi e = new Ekspresi("not and < 4 3 true");
		assert(e.getVal().equals("true"));
	}
	@Test
	public void TestPrefix6(){
		Ekspresi e = new Ekspresi("* -3 9");
		assert(e.getVal().equals("-27"));
	}
	@Test
	public void TestInfix1(){
		Ekspresi e = new Ekspresi("( 1.1 * 2 )");
		assert(e.getVal().equals("2.20"));
	}
	@Test
	public void TestInfix2(){
		Ekspresi e = new Ekspresi("( 1.1 > 2 )");
		assert(e.getVal().equals("false"));
	}
	@Test
	public void TestInfix2KurungNoSpace(){
		Ekspresi e = new Ekspresi("(1.1 > 2)");
		assert(e.getVal().equals("false"));
	}
	@Test
	public void TestInfix3(){
		Ekspresi e = new Ekspresi("( not ( 1.1 > 2 ) )");
		assert(e.getVal().equals("true"));
	}
	@Test
	public void TestInfix4(){
		Ekspresi e = new Ekspresi("( 1.4 * -2 )");
		assert(e.getVal().equals("-2.80"));
	}
	@Test
	public void TestInfix5(){
		Ekspresi e = new Ekspresi("( -1.4 * -2 )");
		assert(e.getVal().equals("2.80"));
	}
	@Test
	public void TestPostfix1(){
		Ekspresi e = new Ekspresi("-5 3 -");
		assert(e.getVal().equals("-8"));
	}
	@Test
	public void TestPostfix2(){
		Ekspresi e = new Ekspresi("not true false and");
		assert(e.getVal().equals("false"));
	}
}

