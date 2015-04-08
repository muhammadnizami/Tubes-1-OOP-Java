public class RedoCommand implements Command{
	private int n;

	public RedoCommand(int _n){
		n = _n;
	}
	
	public void execute(){
		System.out.println("Proses Redo " + n);
	}
}
