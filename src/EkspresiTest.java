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
		assertEquals("error" + e.getExpr(),"7",e.getVal());
	}
	@Test
	public void TestPrefix2(){
		Ekspresi e = new Ekspresi("- 4 3");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPrefix3(){
		Ekspresi e = new Ekspresi("* 4 3");
		assertEquals("error" + e.getExpr(),"12",e.getVal());
	}
	@Test
	public void TestPrefix4(){
		Ekspresi e = new Ekspresi("/ 4 3");
		assertEquals("error" + e.getExpr(),"1.33",e.getVal());
	}
	@Test
	public void TestPrefix5(){
		Ekspresi e = new Ekspresi("div 4 3");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPrefix6(){
		Ekspresi e = new Ekspresi("mod 4 3");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPrefix7(){
		Ekspresi e = new Ekspresi("and true false");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix8(){
		Ekspresi e = new Ekspresi("or true false");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix9(){
		Ekspresi e = new Ekspresi("xor true false");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix10(){
		Ekspresi e = new Ekspresi("not true");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix11(){
		Ekspresi e = new Ekspresi("< 4 3");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix12(){
		Ekspresi e = new Ekspresi("<= 4 3");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix13(){
		Ekspresi e = new Ekspresi("> 4 3");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix14(){
		Ekspresi e = new Ekspresi(">= 4 3");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix15(){
		Ekspresi e = new Ekspresi(">= 3 3");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix16(){
		Ekspresi e = new Ekspresi("= 4 3");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix17(){
		Ekspresi e = new Ekspresi("<> 4 3");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPrefix18(){
		Ekspresi e = new Ekspresi("and <> + 3 1 4 = 3 3");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix19(){
		Ekspresi e = new Ekspresi("not xor or < 3 1 > 2 2 or <= 3 1 >= 2 2");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPrefix20(){
		Ekspresi e = new Ekspresi("> div - + * 1 2 3 4 5 / 10 mod 4 3");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	
	@Test
	public void TestInfix1(){
		Ekspresi e = new Ekspresi("( 1.1 * 2 )");
		assertEquals("error" + e.getExpr(),"2.20",e.getVal());
	}
	@Test
	public void TestInfix2(){
		Ekspresi e = new Ekspresi("( 1.1 > 2 )");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix2KurungNoSpace(){
		Ekspresi e = new Ekspresi("(1.1 > 2)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix3(){
		Ekspresi e = new Ekspresi("( not ( 1.1 > 2 ) )");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix4(){
		Ekspresi e = new Ekspresi("( 1.4 * -2 )");
		assertEquals("error" + e.getExpr(),"-2.80",e.getVal());
	}
	@Test
	public void TestInfix5(){
		Ekspresi e = new Ekspresi("( -1.4 * -2 )");
		assertEquals("error" + e.getExpr(),"2.80",e.getVal());
	}
	@Test
	public void TestInfix6(){
		Ekspresi e = new Ekspresi("(1 < 2) or (4 < 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix7(){
		Ekspresi e = new Ekspresi("((((1 + 2) * 3) mod 4) - 2) ");
		assertEquals("error" + e.getExpr(),"-1",e.getVal());
	}
	@Test
	public void TestPostfix1(){
		Ekspresi e = new Ekspresi("-5 3 -");
		assertEquals("error" + e.getExpr(),"-8",e.getVal());
	}
	@Test
	public void TestPostfix2(){
		Ekspresi e = new Ekspresi("not true false and");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix3(){
		Ekspresi e = new Ekspresi("1 2 > 3 4 > or");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix4(){
		Ekspresi e = new Ekspresi("1 2 3 4 5 6 7 + * - / mod <");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
}

