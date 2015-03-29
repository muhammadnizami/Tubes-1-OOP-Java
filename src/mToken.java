import java.util.Random;
public class mToken{
	public static void main (String [] args) throws TokenException{

		Random rn = new Random();

		Token T1 = new Token();
		Token T2 = new Token();
		Token T3 = new Token();

		//kali
		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(0);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(0);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(0);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		T3.SetBilangan(rn.nextInt()%(2000000000)-1000000000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(rn.nextInt()%(2000)-1000);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());

		T1.SetTkn(TipeToken.Kali);
		T2.SetBilangan(Float.POSITIVE_INFINITY);
		T3.SetBilangan(rn.nextInt()%(2000)-1000);
		System.out.println( T2.ToStr() + T1.ToStr() + T3.ToStr() + "=" + T1.Operasikan(T2,T3).ToStr());


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
}