/* !
kelas ini bertanggungjawab melaksanakan perintah, baik pengaturan, perhitungan, maupun penyimpanan.\n
Kelas ini mengandung kelas Histori, File Manager, dan Converter. Dalam beberapa metodanya, kelas ini menggunakan mesintoken dan stack.\n
Metoda utama yang diakses dari luar kelas adalah DoCmd yaitu melaksanakan sebuah String perintah. Di dalam kelas ini juga ada metoda pembantu untuk DoCmd di antaranya Set, EvaluateExpr, dan sebagainya.\n
*/
public class CommandProcessor{
	CommandProcessor(){/*!ctor default:*/};

	//!melakukan perintah
	String DoCmd(String s, boolean addToHistory){
		/*
		dummy saja

		3. Redo Masuk histori lagi tidak sebagai duplikat komando 

		yang di-redo, mengulang n perintah sebelumnya 

		mulai dari perintah terakhir yang dimasukan. 

		4. Undo Menghapus memori terakhir 

		5. Save Menyimpan seleruh ekspresi beserta hasilnya ke file 

		6. Set Muncul menu 
		*/
		
		if (s==null || s.isEmpty()) return "";
		String [] mk = s.trim().split(" +");
		String retval = new String();
		if (mk[0].equals("Set")){
			retval = Set(s);
		}else if (mk[0].equals("ShowMem")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			retval = Mem(n);
		}else if (s.equals("Show All")){
			retval = MemAll();
		}else if (mk[0].equals("Undo")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			retval = Undo(n);
		}else if (mk[0].equals("Redo")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			retval = Redo(n);
		}else if (mk[0].equals("Save")){
			retval = Save();
		}else if (mk[0].equals("Quit")){
			retval = Quit();
		}else{
			retval = ComputeExpr(s);
		}
		return retval;
	}

	//!melakukan perintah dengan memasukkan ke histori
	String DoCmd(String Cmd){
		return DoCmd(Cmd,true);
	}
	
	//!mengulang n buah perintah
	String Redo(int n){
		return "Proses Redo " + n;
	}
	
	//!menampilkan semua perintah
	String MemAll(){
		return "Proses Show All";
	}
	//!menampilkan n buah perintah
	String Mem(int n){
		return "Proses ShowMem " + n;
	}

	//!menghapus n buah perintah
	String Undo(int n){
		return "Proses Undo " + n;
	}

	//!menghitung ekspresi, menggunakan kelas ekspresi
	String ComputeExpr(String s){
		Ekspresi e = new Ekspresi(s);
		return e.getVal();
	}

	//!menyimpan histori
	String Save(){
		return "Proses Save";
	}

	//!melakukan setting
	String Set(String s){
		return "Proses Set";
	}

	//!keluar
	String Quit(){
		return "Proses Quit";
	}
}
