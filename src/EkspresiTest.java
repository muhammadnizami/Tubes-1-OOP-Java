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
}

