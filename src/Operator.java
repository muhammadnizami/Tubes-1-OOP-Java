import java.util.EnumMap;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.regex.Pattern;

/** kelas implementasi
* Kelas ini merupakan implementasi kelas StrToken dengan konversi sesuai aturan penulisan operator.
*/
public class Operator implements StrToken{
	private EnumMap<TipeToken, String> Opr;
	private Map<String,TipeToken> Tkn;
	
	public Operator(){
		Opr = new EnumMap<TipeToken,String>(TipeToken.class);
		Opr.put(TipeToken.Kali,"*");
		Opr.put(TipeToken.Bagi,"/");
		Opr.put(TipeToken.Tambah,"+");
		Opr.put(TipeToken.Kurang,"-");
		Opr.put(TipeToken.Div,"div");
		Opr.put(TipeToken.Mod,"mod");
		Opr.put(TipeToken.Kurungbuka,"(");
		Opr.put(TipeToken.Kurungtutup,")");
		Opr.put(TipeToken.And,"and");
		Opr.put(TipeToken.Or,"or");
		Opr.put(TipeToken.Xor,"xor");
		Opr.put(TipeToken.Not,"not");
		Opr.put(TipeToken.KurangDari,"<");
		Opr.put(TipeToken.LebihDari,">");
		Opr.put(TipeToken.KurangDariSamaDengan,"<=");
		Opr.put(TipeToken.LebihDariSamaDengan,">=");
		Opr.put(TipeToken.SamaDengan,"=");
		Opr.put(TipeToken.TidakSamaDengan,"<>");
		
		Tkn = new HashMap<String,TipeToken>();
		for (Map.Entry<TipeToken,String> entry : Opr.entrySet()){
			Tkn.put(entry.getValue(),entry.getKey());
		}		
		
	}
	
	/**mengembalikan Opr.put(_tkn]
	*/
	public String GetString(TipeToken _tkn){
		return Opr.get(_tkn);
	}

	/**mengembalikan true bila s dapat dikonversi ke token */
	public boolean canConvert(/*const*/ String s){
		return Opr.containsValue(s);
	}
	
	/**mengembalikan representasi string dari token T*/
	public String toString (/*const*/ Token T){
		return Opr.get(T.getTkn());
	}
	
	/**mengembalikan representasi token dari string s*/
	public Token toToken(/*const*/ String s){
		assert(canConvert(s));
		Token retval = new Token();
		retval.SetTkn(Tkn.get(s));
		return retval;
	}

	/**mengembalikan ekspresi reguler dari kelas turunan StrToken tersebut*/
	public String getRegEx(){
		String regex = new String();
		for (Map.Entry<String,TipeToken> entry : Tkn.entrySet()){
			regex += "(" + Pattern.quote(entry.getKey()) + ")|";
		}
		regex = regex.substring(0,regex.length()-1);
		return regex;
	}

}
