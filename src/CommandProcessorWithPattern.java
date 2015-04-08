/**
 * kelas ini bertanggungjawab melaksanakan perintah, baik pengaturan, perhitungan, maupun penyimpanan.
 * Kelas ini mengandung kelas Histori, File Manager, dan Converter. 
 * Dalam beberapa metodanya, kelas ini menggunakan mesintoken dan stack.
 * Metoda utama yang diakses dari luar kelas adalah DoCmd yaitu melaksanakan sebuah String perintah. 
 * Di dalam kelas ini juga ada metoda pembantu untuk DoCmd di antaranya Set, EvaluateExpr, dan sebagainya.
*/
public class CommandProcessorWithPattern{
	/**Ctor default*/
	private CommandInvoker CI;
	public CommandProcessorWithPattern(){CI = new CommandInvoker();}

	/**melakukan perintah*/
	public void DoCmd(String s, boolean addToHistory){
		/*
		dummy saja

		3. Redo Masuk histori lagi tidak sebagai duplikat komando 

		yang di-redo, mengulang n perintah sebelumnya 

		mulai dari perintah terakhir yang dimasukan. 

		4. Undo Menghapus memori terakhir 

		5. Save Menyimpan seleruh ekspresi beserta hasilnya ke file 

		6. Set Muncul menu 
		*/
		Command cmd = null;		

		if (s==null || s.isEmpty()) return;
		String [] mk = s.trim().split(" +");
		String retval = new String();
		if (mk[0].equals("Set")){
		}else if (mk[0].equals("ShowMem")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			cmd = new ShowMemCommand(n);
		}else if (s.equals("Show All")){
		}else if (mk[0].equals("Undo")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			cmd = new UndoCommand(n);
		}else if (mk[0].equals("Redo")){
			int n = 0;
			if (mk.length>1) n = Integer.parseInt(mk[1]);
			cmd = new RedoCommand(n);
		}else if (mk[0].equals("Save")){
			cmd = new SaveCommand();
		}else{
			cmd = new HitungEkspresiCommand(s);
		}
		
		CI.storeAndExecute(cmd);
		
	}
	/**melakukan perintah dengan memasukkan ke histori*/
	public void DoCmd(String Cmd){
		DoCmd(Cmd,true);
	}
}
