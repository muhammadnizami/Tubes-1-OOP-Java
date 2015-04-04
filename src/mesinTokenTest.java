import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class mesinTokenTest{

	public mesinTokenTest(){}
	public static void main(String [] args){
		org.junit.runner.JUnitCore.main("mesinTokenTest");
	}

	@Test
	public void Test1(){
		String test = "( 3   ( 3 + < true  -3  div mod )";
		MesinToken MT = new MesinToken(test);
		MT.START();
		assert(MT.GetCToken().getTkn()==TipeToken.Kurungbuka);
		MT.ADV();
		assert(MT.GetCToken().getTkn()==TipeToken.Bilangan);
		assert(MT.GetCToken().getBilanganInt()==3);
		MT.ADV();
		assert(MT.GetCToken().getTkn()==TipeToken.Kurungbuka);
		MT.ADV();
		assert(MT.GetCToken().getBilanganInt()==3);
		MT.ADV();
		assert(MT.GetCToken().getTkn()==TipeToken.Tambah);
		MT.ADV();
		assert(MT.GetCToken().getTkn()==TipeToken.KurangDari);
		MT.ADV();
		assert(MT.GetCToken().getBilanganBool()==true);
		MT.ADV();
		assert(MT.GetCToken().getBilanganInt()== -3 );
		MT.ADV();
		assert(MT.GetCToken().getTkn()== TipeToken.Div );
		MT.ADV();
		assert(MT.GetCToken().getTkn()== TipeToken.Mod );
		MT.ADV();
		assert(MT.GetCToken().getTkn()== TipeToken.Kurungtutup );
		MT.ADV();
		assert(MT.getEnd());
		
	}

}
