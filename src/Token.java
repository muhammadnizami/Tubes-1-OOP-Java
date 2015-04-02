	/*!
		Kelas token bertanggung jawab sebagai objek yang dapat dimengerti oleh evaluator.
		Kelas token bertanggung jawab atas jenis-jenis bilangan dan operator serta perilakunya
		perilaku operator yaitu presedensi serta bagaimana operator tersebut mengoperasikan operand
	*/

public class Token implements Cloneable {
	//!ctor
	public Token(){
		Tkn=TipeToken.Bilangan;
		Val = new BilanganT();
		Val.F=0;
		Val.I=0;
		Val.B=false;
		TipeBilangan = Tipe._int;
	}
		
	//!clone
	public Token clone(){
		Token retval = new Token();
		retval.Tkn=this.Tkn;
		retval.Val.F=this.Val.F;
		retval.Val.I=this.Val.I;
		retval.Val.B=this.Val.B;
		retval.TipeBilangan=this.TipeBilangan;
		return retval;
	}
	
	//!@name getter
	//!tidak mengubah status token
	//!@{
	
	//!mengembalikan tipe token tersebut
	public TipeToken getTkn() /*const*/{
		return Tkn;
	} 
	//!prekondisi: getTkn()==TipeToken.Bilangan
	public Tipe getTipeBilangan() /*const*/{
		assert(getTkn()==TipeToken.Bilangan);
		return TipeBilangan;
	} 
	//!prekondisi: getTipeBilangan()==Tipe._int
	public int getBilanganInt() /*const*/{
		assert(getTipeBilangan()==Tipe._int);
		return Val.I;
	} 
	//!prekondisi: getTipeBilangan()==Tipe._float
	public float getBilanganFloat() /*const*/{
		assert(getTipeBilangan()==Tipe._float);
		return Val.F;
	} 
	//!prekondisi: getTipeBilangan()==Tipe._bool
	public boolean getBilanganBool() /*const*/{
		assert(getTipeBilangan()==Tipe._bool);
		return Val.B;
	} 
	//!@}
	
	//!@name setter
	//!@mengubah status token. Akan digunakan oleh yang membangun dan mengubah token, seperti converter dan sebagainya
	//!@{
	
	//!mengeset token
	public void SetTkn(TipeToken _Tkn){
		Tkn=_Tkn;
	}
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi float dan isinya f
	public void SetBilangan(float f){
		Tkn=TipeToken.Bilangan;
		TipeBilangan = Tipe._float;
		Val.F = f;
	}
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi int dan isinya i
	public void SetBilangan(int i){
		Tkn=TipeToken.Bilangan;
		TipeBilangan = Tipe._int;
		Val.I = i;
	}
	//!mengeset bilangan sekaligus tipe token menjadi bilangan dan tipe bilangan menjadi logika dan isinya l
	public void SetBilangan(boolean l){
		Tkn=TipeToken.Bilangan;
		TipeBilangan = Tipe._bool;
		Val.B = l;
	}
	//@}
	
	//!@name predikat
	//!boolean, true false. tidak mengubah status token
	//!@{
	
	//!mengembalikan true bila ( atau )
	public boolean isPunctuator() /*const*/{
		return Tkn==TipeToken.Kurungbuka || Tkn==TipeToken.Kurungtutup;
	}
	//!mengembalikan true bila ia operator uner
	public boolean isOprUner() /*const*/{
		return Tkn==TipeToken.Not;
	}
	//!mengembalikan true bila ia operator uner
	public boolean isOprBiner() /*const*/{
		return Tkn!=TipeToken.Not && Tkn!=TipeToken.Bilangan && !isPunctuator();
	}
	//!mengembalikan true bila token merupakan bilangan
	public boolean isBilangan() /*const*/{
		return Tkn==TipeToken.Bilangan;
	}

	//mengembalikan rank
	//helper function untuk isSmallerPrecedenceThan()
	public int getRank(){
		switch(getTkn()){
			case Not:
			return 7;
			
			case Kali:
			case Bagi:
			case Mod:
			case Div:
			return 6;
			
			case Tambah:
			case Kurang:
			return 5;
			
			case KurangDari:
			case LebihDari:
			case KurangDariSamaDengan:
			case LebihDariSamaDengan:
			return 4;
						
			case SamaDengan:
			case TidakSamaDengan:
			return 3;
			
			case And:
			return 2;
			
			case Xor:
			return 1;
			
			case Or:
			return 0;

			default:
			return -999;
		}
	}

	//!prekondisi: isOprUner() || isOprBiner()\n
	//!mengembalikan true bila this presedensnya kurang dari T\n
	//!presedensi standar\n
	public boolean isSmallerPrecedenceThan(/*const*/ Token T){
		assert(isOprUner() || isOprBiner());
		assert(T.isOprUner() || T.isOprBiner());
		
		return getRank() < T.getRank();
	} 
	///@}
	
	//!mengubah ke string 	(hanya akan digunakan untuk testing. Untuk penggunaan lebih lanjut,
	//!			gunakan kelas lain)
	public String ToStr(){
		switch(getTkn()){
		case Kali:
			return "*";
		case Bagi:
			return "/";
		case Div:
			return "div";
		case Tambah:
			return "+";
		case Kurang:
			return "-";
		case Kurungbuka:
			return "(";
		case Kurungtutup:
			return ")";
		case Mod:
			return "mod";
		case And:
			return "and";
		case Or:
			return "or";
		case Xor:
			return "xor";
		case Not:
			return "!";
		case Bilangan:
			String s = new String();
			switch (getTipeBilangan()){
			case _bool:
				if (getBilanganBool())
					return "true";
				else	return "false";
			case _int:
				s+=(getBilanganInt());
				break;
			case _float:
				s+=(getBilanganFloat());
				break;
			}
			return s;
		}
		return null;
	}
	
	//!@name method lain
	//!untuk digunakan oleh kalkulator atau evaluator\n
	//!saat dioperasikan, tipe bilangan dapat berubah\n
	///@{
	
	//!prekondisi: isOprBiner() && lhs.isBilangan()&& rhs.isBilangan()\n
	//!mengembalikan <lhs> <this> <rhs>\n
	public Token Operasikan(/*const*/ Token lhs, /*const*/ Token rhs) /*const*/throws TokenException{
		if (!isOprBiner())
			throw new TokenException("INVALID OPERATOR");
		if (!lhs.isBilangan()||!rhs.isBilangan())
			throw new TokenException("INVALID OPERAND");
		Token retval=lhs.clone();
		switch(getTkn()){
		case Kali:
			retval.Kalikan(rhs);
			break;
		case Bagi:
			retval.Bagikan(rhs);
			break;
		case Tambah:
			retval.Tambahkan(rhs);
			break;
		case Kurang:
			retval.Kurangkan(rhs);
			break;
		case Div:
			retval.Divkan(rhs);
			break;
		case Mod:
			retval.Modkan(rhs);
			break;
		case And:
			retval.Andkan(rhs);
			break;
		case Or:
			retval.Orkan(rhs);
			break;
		case Xor:
			retval.Xorkan(rhs);
			break;
		case KurangDari:
			retval.KurangDarikan(rhs);
			break;
		case KurangDariSamaDengan:
			retval.KurangDariSamaDengankan(rhs);
			break;
		case LebihDari:
			retval.LebihDarikan(rhs);
			break;
		case LebihDariSamaDengan:
			retval.LebihDariSamaDengankan(rhs);
			break;
		case SamaDengan:
			retval.SamaDenganKan(rhs);
			break;
		case TidakSamaDengan:
			retval.TidakSamaDengankan(rhs);
			break;
		}

		return retval;

	}
 
	
	//!prekondisi: isOprUner() && rhs.isBilangan()\n
	//!mengembalikan <this> <rhs>\n
	public Token Operasikan(/*const*/ Token rhs) /*const*/throws TokenException{
		if (!isOprUner())
			throw new TokenException("INVALID OPERATOR");
		if (!rhs.isBilangan())
			throw new TokenException("INVALID OPERAND");

		Token retval=rhs.clone();
		switch(getTkn()){
		case Not:
			retval.Notkan();
			break;
		}
		return retval;
	} 	
	
	///@}
		

	private class BilanganT{
		public int I;
		public float F;
		public boolean B;
	} 
	private TipeToken Tkn;
	private BilanganT Val;
	private Tipe TipeBilangan;

	//!method pembantu@{
	private void Kalikan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else {
			if (getTipeBilangan()==Tipe._int){
				if (dengan.getTipeBilangan()==Tipe._int){
					long tmp = getBilanganInt();
					tmp*= dengan.getBilanganInt();
				
					if (tmp>=Integer.MAX_VALUE || tmp<=Integer.MIN_VALUE)
						SetBilangan( (float) tmp);
					else	SetBilangan( (int) tmp);
				}else{
					float tmp = getBilanganInt();
					tmp*= dengan.getBilanganFloat();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}else{
				if(dengan.getTipeBilangan()==Tipe._int){
					float tmp = getBilanganFloat();
					tmp*=dengan.getBilanganInt();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}else{
					float tmp = getBilanganFloat();
					tmp*=dengan.getBilanganFloat();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}
		
		}
	
	} 
	private void Bagikan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else{
			if (dengan.getTipeBilangan()==Tipe._int){
				if(dengan.getBilanganInt() == 0){
					throw new TokenException("CANNOT DIVIDE BY ZERO");
				}
				if(getTipeBilangan()==Tipe._int){
					long tmp = getBilanganInt();
					long pembilang = dengan.getBilanganInt();
					if (tmp%pembilang == 0){
						tmp/=pembilang;
						SetBilangan((int)tmp);
					}else{
						float tmpf=(float)tmp/(float)pembilang;
						SetBilangan(tmpf);
					}
				}else{
					float tmp = getBilanganFloat();
					tmp/=dengan.getBilanganInt();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}else{
				if(dengan.getBilanganFloat() == 0){
					throw new TokenException("CANNOT DIVIDE BY ZERO");	
				}
				if(getTipeBilangan()==Tipe._int){
					double tmp = getBilanganInt();
					tmp/=dengan.getBilanganFloat();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}else{
					double tmp = getBilanganFloat();
					tmp/=dengan.getBilanganFloat();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}
		}

	} 
	private void Tambahkan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else{
			if (getTipeBilangan()==Tipe._int){
				if (dengan.getTipeBilangan()==Tipe._int){
					long tmp = getBilanganInt();
					tmp += dengan.getBilanganInt();
					if (tmp>=Integer.MAX_VALUE || tmp<=Integer.MIN_VALUE)
						SetBilangan( (float) tmp);
					else	SetBilangan( (int) tmp);
				}else{
					float tmp = dengan.getBilanganFloat();
					tmp += getBilanganInt();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}else{
				if(dengan.getTipeBilangan()==Tipe._int){
					float tmp=getBilanganFloat();
					tmp+=dengan.getBilanganInt();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}else{
					float tmp=getBilanganFloat();
					tmp+=dengan.getBilanganFloat();
					if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
						SetBilangan( (int) tmp);
					else	SetBilangan( (float) tmp);
				}
			}
		}

	} 
	private void Kurangkan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else{
			Token tmp = new Token();
			if (dengan.getTipeBilangan()==Tipe._float)
				tmp.SetBilangan(-dengan.getBilanganFloat());
			else	tmp.SetBilangan(-dengan.getBilanganInt());
			Tambahkan(tmp);
		}

	}
	private void Kurangkan () throws TokenException {
		assert (isBilangan());
		if (getTipeBilangan()==Tipe._int){
			long tmp = - getBilanganInt();
			if (tmp>=Integer.MAX_VALUE || tmp<=Integer.MIN_VALUE)
				SetBilangan((float)tmp);
			else	SetBilangan((int)tmp);
		}else if (getTipeBilangan()==Tipe._float)
			SetBilangan(-getBilanganFloat());
		else throw new TokenException ("INVALID OPERAND");
	} 
	private void Tambahkan() throws TokenException{
		assert (isBilangan());
		/*do nothing*/
	}
	private void Divkan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if ((dengan.getTipeBilangan()==Tipe._float && dengan.getBilanganFloat()==0)
			|| (dengan.getTipeBilangan()==Tipe._int && dengan.getBilanganInt()==0))
			throw new TokenException("CANNOT DIVIDE BY ZERO");

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else{
			if (getTipeBilangan()==Tipe._int &&dengan.getTipeBilangan()==Tipe._int)
					SetBilangan((int)getBilanganInt()/dengan.getBilanganInt());
			else{
				double a;
				double b;
				if (getTipeBilangan()==Tipe._float)
					a = getBilanganFloat();
				else	a = getBilanganInt();
				if (dengan.getTipeBilangan()==Tipe._float)
					b = dengan.getBilanganFloat();
				else	b = dengan.getBilanganInt();
				double tmp = (double)(long)(a/b);
				if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);				
			}
		}
	}
	private void Modkan(/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if ((dengan.getTipeBilangan()==Tipe._float && dengan.getBilanganFloat()==0)
			|| (dengan.getTipeBilangan()==Tipe._int && dengan.getBilanganInt()==0))
			throw new TokenException("CANNOT DIVIDE BY ZERO");

		if (getTipeBilangan()==Tipe._bool || dengan.getTipeBilangan()==Tipe._bool){
			throw new TokenException("INVALID OPERAND");
		}else{
			if (getTipeBilangan()==Tipe._int && dengan.getTipeBilangan()==Tipe._int){
				SetBilangan(getBilanganInt() % dengan.getBilanganInt());
			}else{
				double a;
				double b;
				if (getTipeBilangan()==Tipe._float)
					a = getBilanganFloat();
				else	a = getBilanganInt();
				if (dengan.getTipeBilangan()==Tipe._float)
					b = dengan.getBilanganFloat();
				else	b = dengan.getBilanganInt();
				double tmp = a%b;
				if (tmp<=Integer.MAX_VALUE && tmp>=Integer.MIN_VALUE && tmp==Math.floor(tmp))
					SetBilangan( (int) tmp);
				else	SetBilangan( (float) tmp);				
			}
		}
	}
	private void Andkan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()!=Tipe._bool || dengan.getTipeBilangan()!=Tipe._bool){
			if (getTipeBilangan()==Tipe._int || dengan.getTipeBilangan()==Tipe._int){
				Token tmp = dengan.clone();
				try{
					if (getTipeBilangan()==Tipe._int)IntToBool();
					if (tmp.getTipeBilangan()==Tipe._int)tmp.IntToBool();
				}catch (TokenException e){
					if (e.getMessage()=="THIS TOKEN CANNOT BE CONVERTED TO BOOL"){
						throw new TokenException("INVALID OPERAND");
					}
				}
				Andkan(tmp);
			}else{
				throw new TokenException("INVALID OPERAND");
			}
		}else{
			SetBilangan(getBilanganBool() && dengan.getBilanganBool());
		}

	} 
	private void Orkan (/*const*/ Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()!=Tipe._bool || dengan.getTipeBilangan()!=Tipe._bool){
			if (getTipeBilangan()==Tipe._int || dengan.getTipeBilangan()==Tipe._int){
				Token tmp = dengan.clone();
				try{
					if (getTipeBilangan()==Tipe._int)IntToBool();
					if (tmp.getTipeBilangan()==Tipe._int)tmp.IntToBool();
				}catch (TokenException e){
					if (e.getMessage()=="THIS TOKEN CANNOT BE CONVERTED TO BOOL"){
						throw new TokenException("INVALID OPERAND");
					}
				}
				Orkan(tmp);
			}else{
				throw new TokenException("INVALID OPERAND");
			}
		}else{
			SetBilangan(getBilanganBool() || dengan.getBilanganBool());
		}

	} 
	private void Xorkan (Token dengan)throws TokenException{
		assert(isBilangan() && dengan.isBilangan());

		if (getTipeBilangan()!=Tipe._bool || dengan.getTipeBilangan()!=Tipe._bool){
			if (getTipeBilangan()==Tipe._int || dengan.getTipeBilangan()==Tipe._int){
				Token tmp = dengan.clone();
				try{
					if (getTipeBilangan()==Tipe._int)IntToBool();
					if (tmp.getTipeBilangan()==Tipe._int)tmp.IntToBool();
				}catch (TokenException e){
					if (e.getMessage()=="THIS TOKEN CANNOT BE CONVERTED TO BOOL"){
						throw new TokenException("INVALID OPERAND");
					}
				}
				Orkan(tmp);
			}else{
				throw new TokenException("INVALID OPERAND");
			}
		}else{
			SetBilangan(getBilanganBool() ^ dengan.getBilanganBool());
		}
	}

	private void Notkan ()throws TokenException{
		assert(isBilangan());
		if (getTipeBilangan()!=Tipe._bool){
			if (getTipeBilangan()==Tipe._int)
				if(getBilanganInt()==0){
					SetBilangan(true);
					return;
				}else if (getBilanganInt()==1){
					SetBilangan(false);
					return;
				}
			throw new TokenException("INVALID OPERAND");
		}else{
			SetBilangan(!getBilanganBool());
		}
	}

	private void KurangDarikan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		if (getTipeBilangan()==Tipe._bool && dengan.getTipeBilangan()==Tipe._bool){
			if (getBilanganBool()==false && dengan.getBilanganBool()==true)
				SetBilangan(true);
			else
				SetBilangan(false);
		}else if (getTipeBilangan()==Tipe._int && dengan.getTipeBilangan()==Tipe._int){
			SetBilangan(getBilanganInt() < dengan.getBilanganInt());
		}else{
			double lhs;
			double rhs;
			if (getTipeBilangan()==Tipe._int)
					lhs = (double) getBilanganInt();
			else	lhs = (double) getBilanganFloat();
			if(dengan.getTipeBilangan()==Tipe._int)
					rhs = (double) dengan.getBilanganInt();
			else	rhs = (double) dengan.getBilanganFloat();
			SetBilangan(lhs<rhs);
		}
	}
	private void KurangDariSamaDengankan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		if (getTipeBilangan()==Tipe._bool && dengan.getTipeBilangan()==Tipe._bool){
			if (getBilanganBool()==true && dengan.getBilanganBool()==false)
				SetBilangan(false);
			else
				SetBilangan(true);
		}else if (getTipeBilangan()==Tipe._int && dengan.getTipeBilangan()==Tipe._int){
			SetBilangan(getBilanganInt() <= dengan.getBilanganInt());
		}else{
			double lhs;
			double rhs;
			if (getTipeBilangan()==Tipe._int)
					lhs = (double) getBilanganInt();
			else	lhs = (double) getBilanganFloat();
			if(dengan.getTipeBilangan()==Tipe._int)
					rhs = (double) dengan.getBilanganInt();
			else	rhs = (double) dengan.getBilanganFloat();
			SetBilangan(lhs<=rhs);
		}
		
	}
	private void LebihDarikan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		Token tmp = dengan.clone();
		tmp.KurangDarikan(this);
		assert(tmp.getTipeBilangan()==Tipe._bool);
		SetBilangan(tmp.getBilanganBool());
	}
	private void LebihDariSamaDengankan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		Token tmp = dengan.clone();
		tmp.KurangDariSamaDengankan(this);
		assert(tmp.getTipeBilangan()==Tipe._bool);
		SetBilangan(tmp.getBilanganBool());
	}
	private void SamaDenganKan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		if (getTipeBilangan()==Tipe._bool && dengan.getTipeBilangan()==Tipe._bool){
			SetBilangan(getBilanganBool() == dengan.getBilanganBool());
		}else if (getTipeBilangan()==Tipe._int && dengan.getTipeBilangan()==Tipe._int){
			SetBilangan(getBilanganInt() == dengan.getBilanganInt());
		}else{
			double lhs;
			double rhs;
			if (getTipeBilangan()==Tipe._int)
					lhs = (double) getBilanganInt();
			else	lhs = (double) getBilanganFloat();
			if(dengan.getTipeBilangan()==Tipe._int)
					rhs = (double) dengan.getBilanganInt();
			else	rhs = (double) dengan.getBilanganFloat();
			SetBilangan(lhs==rhs);
		}
		
	}
	private void TidakSamaDengankan(Token dengan){
		assert(isBilangan() && dengan.isBilangan());
		if (getTipeBilangan()==Tipe._bool && dengan.getTipeBilangan()==Tipe._bool){
			SetBilangan(getBilanganBool() != dengan.getBilanganBool());
		}else if (getTipeBilangan()==Tipe._int && dengan.getTipeBilangan()==Tipe._int){
			SetBilangan(getBilanganInt() != dengan.getBilanganInt());
		}else{
			double lhs;
			double rhs;
			if (getTipeBilangan()==Tipe._int)
					lhs = (double) getBilanganInt();
			else	lhs = (double) getBilanganFloat();
			if(dengan.getTipeBilangan()==Tipe._int)
					rhs = (double) dengan.getBilanganInt();
			else	rhs = (double) dengan.getBilanganFloat();
			SetBilangan(lhs!=rhs);
		}
		
	}
	//!@}

	//!method pembantu dari method pembantu
	private void IntToBool()throws TokenException{
		if (getTkn()==TipeToken.Bilangan)
			if (getTipeBilangan()==Tipe._int)
				if (getBilanganInt()==0){
					SetBilangan(false);
					return;
				}else if (getBilanganInt()==1){
					SetBilangan(true);
					return;
				}
			throw new TokenException("THIS TOKEN CANNOT BE CONVERTED TO BOOL");
		}

}
