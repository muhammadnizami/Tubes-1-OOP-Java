import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.*;
public class CommandProcessorTest{
	CommandProcessor C;
	public CommandProcessorTest(){C = new CommandProcessor();}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("CommandProcessorTest");
	}

	@Test
	public void TestRedo(){
		assertTrue(C.DoCmd("Redo").equals("Proses Redo 0"));
	}
	@Test
	public void TestRedo1(){
		assertTrue(C.DoCmd("Redo 1").equals("Proses Redo 1"));
	}
	@Test
	public void TestRedo4(){
		assertTrue(C.DoCmd("Redo 4").equals("Proses Redo 4"));
	}
	@Test
	public void TestRedo132(){
		assertTrue(C.DoCmd("Redo 132").equals("Proses Redo 132"));
	}
	@Test
	public void TestMemAll(){
		assertTrue(C.DoCmd("Show All").equals("Proses Show All"));
	}
	@Test
	public void TestMem(){
		assertTrue(C.DoCmd("ShowMem").equals("Proses ShowMem 0"));
	}
	@Test
	public void TestMem1(){
		assertTrue(C.DoCmd("ShowMem 1").equals("Proses ShowMem 1"));
	}
	@Test
	public void TestMem4(){
		assertTrue(C.DoCmd("ShowMem 4").equals("Proses ShowMem 4"));
	}
	@Test
	public void TestMem132(){
		assertTrue(C.DoCmd("ShowMem 132").equals("Proses ShowMem 132"));
	}
	@Test
	public void TestUndo(){
		assertTrue(C.DoCmd("Undo").equals("Proses Undo 0"));
	}
	@Test
	public void TestUndo1(){
		assertTrue(C.DoCmd("Undo 1").equals("Proses Undo 1"));
	}
	@Test
	public void TestUndo4(){
		assertTrue(C.DoCmd("Undo 4").equals("Proses Undo 4"));
	}
	@Test
	public void TestUndo132(){
		assertTrue(C.DoCmd("Undo 132").equals("Proses Undo 132"));
	}
	@Test
	public void TestComputeExpr(){
		assertTrue(C.DoCmd("(4 + 3)").equals("7"));
		assertTrue(C.DoCmd("< 2 3").equals("true"));
	}
	@Test
	public void TestSave(){
		assertTrue(C.DoCmd("Save").equals("Proses Save"));
	}
	@Test
	public void TestSet(){
		assertTrue(C.DoCmd("Set").equals("Proses Set"));
	}
	@Test
	public void Quit(){
		assertTrue(C.DoCmd("Quit").equals("Proses Quit"));
	}
}
