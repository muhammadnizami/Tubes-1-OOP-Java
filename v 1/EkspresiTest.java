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
		Ekspresi e = new Ekspresi("(4 + 3)");
		assertEquals("error" + e.getExpr(),"7",e.getVal());
	}
	@Test
	public void TestInfix2(){
		Ekspresi e = new Ekspresi("(4 - 3)");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestInfix3(){
		Ekspresi e = new Ekspresi("(4 * 3 )");
		assertEquals("error" + e.getExpr(),"12",e.getVal());
	}
	@Test
	public void TestInfix4(){
		Ekspresi e = new Ekspresi("( 4 / 3)");
		assertEquals("error" + e.getExpr(),"1.33",e.getVal());
	}
	@Test
	public void TestInfix5(){
		Ekspresi e = new Ekspresi("(4 div 3)");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestInfix6(){
		Ekspresi e = new Ekspresi("(4 mod 3)");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestInfix7(){
		Ekspresi e = new Ekspresi("(true and false)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix8(){
		Ekspresi e = new Ekspresi("(true or false)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix9(){
		Ekspresi e = new Ekspresi("(true xor false)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix10(){
		Ekspresi e = new Ekspresi("(not true)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix11(){
		Ekspresi e = new Ekspresi("(4 < 3)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix12(){
		Ekspresi e = new Ekspresi("(4 <= 3)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix13(){
		Ekspresi e = new Ekspresi("(4 > 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix14(){
		Ekspresi e = new Ekspresi("(4 >= 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix15(){
		Ekspresi e = new Ekspresi("(3 >= 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix16(){
		Ekspresi e = new Ekspresi("(4 = 3)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix17(){
		Ekspresi e = new Ekspresi("(4 <> 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix18(){
		Ekspresi e = new Ekspresi("   (((3 + 1) <> 4) and  (3 = 3))");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix19(){
		Ekspresi e = new Ekspresi("(not  (((3 < 1) or (2 > 2))  xor ((3 <= 1) or (2 >= 2))))");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix20(){
		Ekspresi e = new Ekspresi("(((((1 * 2) + 3) -  4) div 5)>  (10 / (4 mod 3)))");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	
	@Test
	public void TestInfix21(){
		Ekspresi e = new Ekspresi("( 1.1 * 2 )");
		assertEquals("error" + e.getExpr(),"2.20",e.getVal());
	}
	@Test
	public void TestInfix22(){
		Ekspresi e = new Ekspresi("( 1.1 > 2 )");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix22KurungNoSpace(){
		Ekspresi e = new Ekspresi("(1.1 > 2)");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestInfix23(){
		Ekspresi e = new Ekspresi("( not ( 1.1 > 2 ) )");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix24(){
		Ekspresi e = new Ekspresi("( 1.4 * -2 )");
		assertEquals("error" + e.getExpr(),"-2.80",e.getVal());
	}
	@Test
	public void TestInfix25(){
		Ekspresi e = new Ekspresi("( -1.4 * -2 )");
		assertEquals("error" + e.getExpr(),"2.80",e.getVal());
	}
	@Test
	public void TestInfix26(){
		Ekspresi e = new Ekspresi("(1 < 2) or (4 < 3)");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestInfix27(){
		Ekspresi e = new Ekspresi("((((1 + 2) * 3) mod 4) - 2) ");
		assertEquals("error" + e.getExpr(),"-1",e.getVal());
	}
	@Test
	public void TestPostfix1(){
		Ekspresi e = new Ekspresi("4 3 +");
		assertEquals("error" + e.getExpr(),"7",e.getVal());
	}
	@Test
	public void TestPostfix2(){
		Ekspresi e = new Ekspresi("4 3 -");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPostfix3(){
		Ekspresi e = new Ekspresi("4 3 *");
		assertEquals("error" + e.getExpr(),"12",e.getVal());
	}
	@Test
	public void TestPostfix4(){
		Ekspresi e = new Ekspresi("4 3 /");
		assertEquals("error" + e.getExpr(),"1.33",e.getVal());
	}
	@Test
	public void TestPostfix5(){
		Ekspresi e = new Ekspresi("4 3 div");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPostfix6(){
		Ekspresi e = new Ekspresi("4 3 mod");
		assertEquals("error" + e.getExpr(),"1",e.getVal());
	}
	@Test
	public void TestPostfix7(){
		Ekspresi e = new Ekspresi("true false and");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix8(){
		Ekspresi e = new Ekspresi("true false or");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix9(){
		Ekspresi e = new Ekspresi(" true false xor");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix10(){
		Ekspresi e = new Ekspresi("not true");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix11(){
		Ekspresi e = new Ekspresi(" 4 3 <");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix12(){
		Ekspresi e = new Ekspresi(" 4 3 <=");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix13(){
		Ekspresi e = new Ekspresi("4 3 > ");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix14(){
		Ekspresi e = new Ekspresi("4 3 >= ");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix15(){
		Ekspresi e = new Ekspresi("3 3 >= ");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix16(){
		Ekspresi e = new Ekspresi("4 3 = ");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix17(){
		Ekspresi e = new Ekspresi("4 3 <> ");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix18(){
		Ekspresi e = new Ekspresi("3 1 + 4  <> 3 3 = and ");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix19(){
		Ekspresi e = new Ekspresi("3 1  <  2 2  > or  3 1  <= 2 2 >= or xor");
		assertEquals("error" + e.getExpr(),"true",e.getVal());
	}
	@Test
	public void TestPostfix20(){
		Ekspresi e = new Ekspresi("1 2 *  3 + 4 - 5 div 10  4 3 mod / >  ");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix21(){
		Ekspresi e = new Ekspresi("-5 3 -");
		assertEquals("error" + e.getExpr(),"-8",e.getVal());
	}
	@Test
	public void TestPostfix22(){
		Ekspresi e = new Ekspresi("not true false and");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix23(){
		Ekspresi e = new Ekspresi("1 2 > 3 4 > or");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
	@Test
	public void TestPostfix24(){
		Ekspresi e = new Ekspresi("1 2 3 4 5 6 7 + * - / mod <");
		assertEquals("error" + e.getExpr(),"false",e.getVal());
	}
}

