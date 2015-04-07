import java.util.Random;
public class mToken{

	static Random rn = new Random();

	public static void main (String [] args) throws TokenException{

		mToken mT = new mToken();
		mT.testSetBilangan();
		mT.testKali();
		mT.testKurangDari();
		mT.testKurangDariSamaDengan();
		mT.testLebihDari();
		mT.testLebihDariSamaDengan();
		mT.testBagi();
		mT.testSamaDengan();
		mT.testTidakSamaDengan();
		mT.testXor();


		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();

		//Div
		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(0);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(0.05f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(4e+09f);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(12e+09f);
		T3.SetBilangan(4e+09f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(rn.nextInt()%(2000)-1000);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Div);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());
		//Mod
		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(0);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(1000);
		T3.SetBilangan(0.125f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(4e+09f);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(12e+09f);
		T3.SetBilangan(4e+09f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(rn.nextInt()%(2000)-1000);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Mod);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		//tambah	
		T1.SetTkn(TipeToken.Tambah);
		T2.SetBilangan(1);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Tambah);
		T2.SetBilangan(1);
		T3.SetBilangan(-1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Tambah);
		T2.SetBilangan(-1);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Tambah);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(2000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(4e+09f);
		T3.SetBilangan(2000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(4e+09f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(1.5f);
		T3.SetBilangan(0.5f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(1.5f);
		T3.SetBilangan(-0.4f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(1);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(Integer.MIN_VALUE);
		T3.SetBilangan(Integer.MAX_VALUE);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kurang);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(Float.POSITIVE_INFINITY);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		//And
		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(1);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(0);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(1);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(false);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(true);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(false);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(true);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(0);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(1);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(0);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(1);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(false);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(true);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(false);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.And);
		T2.SetBilangan(true);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		//Or
		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(1);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(0);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(1);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(false);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(true);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(false);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(true);
		T3.SetBilangan(1);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(0);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(1);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(0);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(1);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(false);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(true);
		T3.SetBilangan(false);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(false);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Or);
		T2.SetBilangan(true);
		T3.SetBilangan(true);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Not);
		T2.SetBilangan(false);
		System.out.println( "not " + T2.ToStr() + "="	+T1.Operasikan(T2).ToStr());

		T1.SetTkn(TipeToken.Not);
		T2.SetBilangan(true);
		System.out.println( "not " + T2.ToStr() + "="	+T1.Operasikan(T2).ToStr());

		T1.SetTkn(TipeToken.Not);
		T2.SetBilangan(0);
		System.out.println( "not " + T2.ToStr() + "="	+T1.Operasikan(T2).ToStr());

		T1.SetTkn(TipeToken.Not);
		T2.SetBilangan(1);
		System.out.println( "not " + T2.ToStr() + "="	+T1.Operasikan(T2).ToStr());
	}
	public void testSetBilangan() throws TokenException{
		Token T = new Token();
		T.SetBilangan(10.003f);
		assert(T.getTipeBilangan()==Tipe._float);
		T.SetBilangan(10);
		assert(T.getTipeBilangan()==Tipe._int);
		T.SetBilangan(false);
		assert(T.getTipeBilangan()==Tipe._bool);

	}
	public void testBagi() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		
		//bagi
		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(0);
		System.out.print( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" );
		try{
			System.out.println( T1.Operasikan(T2,T3).ToStr());
		}catch(TokenException e){
			System.out.println( "error: " + e.getMessage() );
		}

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(0);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(2000000000);
		T3.SetBilangan(0.05f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(4e+09f);
		T3.SetBilangan(1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(12e+09f);
		T3.SetBilangan(4e+09f);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(rn.nextInt()%(2000)-1000);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Bagi);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

	}
	public void testKali() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();

		//kali
		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		assert(T1.Operasikan(T2,T3).getBilanganInt()==0);

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(0);
		assert(T1.Operasikan(T2,T3).getBilanganInt()==0);

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(0);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		assert(T1.Operasikan(T2,T3).getBilanganInt()==0);

		T1.SetTkn(TipeToken.Kali);
		long tmp1 = rn.nextInt()%(2000000000)-1000000000;
		long tmp2 = rn.nextInt()%(2000000000)-1000000000;
		T2.SetBilangan(tmp1);
		T3.SetBilangan(tmp2);
		T1 = T1.Operasikan(T2,T3);
		if (T1.getTipeBilangan()==Tipe._int)
			assert(T1.getBilanganInt()==tmp1*tmp2);
		else	assert(T1.getBilanganFloat()==((float)tmp1*(float)tmp2));

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(rn.nextInt()%(2000)-1000);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());
	}

	public void testKurangDari() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		Token Thas;
		T1.SetTkn(TipeToken.KurangDari);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
	}

	public void testKurangDariSamaDengan() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		Token Thas;
		T1.SetTkn(TipeToken.KurangDariSamaDengan);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
	}

	public void testLebihDari() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		T1.SetTkn(TipeToken.LebihDari);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
	}

	public void testLebihDariSamaDengan() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		T1.SetTkn(TipeToken.LebihDariSamaDengan);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
	}

	public void testSamaDengan() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		T1.SetTkn(TipeToken.SamaDengan);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==false);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);

		T2.SetBilangan(0.5f);
		T3.SetBilangan(0.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		
	}

	public void testTidakSamaDengan() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();
		T1.SetTkn(TipeToken.TidakSamaDengan);

		//int dan int
		T2.SetBilangan(10);
		T3.SetBilangan(20);
		assert(T1.Operasikan(T2,T3).getTipeBilangan()==Tipe._bool);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T3.SetBilangan(10);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);

		//int dan float besar
		T2.SetBilangan(10);
		T3.SetBilangan(200000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//int dan float biasa
		T2.SetBilangan(10);
		T3.SetBilangan(9.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);

		//float dan float
		T2.SetBilangan(10.5f);
		T3.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		assert(T1.Operasikan(T3,T2).getBilanganBool()==true);
		T2.SetBilangan(2000000000000f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);

		T2.SetBilangan(0.5f);
		T3.SetBilangan(0.5f);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		
	}

	public void testXor() throws TokenException{
		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();

		T1.SetTkn(TipeToken.Xor);
		
		T2.SetBilangan(true);
		T3.SetBilangan(true);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
		
		T2.SetBilangan(true);
		T3.SetBilangan(false);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		
		T2.SetBilangan(false);
		T3.SetBilangan(true);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==true);
		
		T2.SetBilangan(false);
		T3.SetBilangan(false);
		assert(T1.Operasikan(T2,T3).getBilanganBool()==false);
	}

}
