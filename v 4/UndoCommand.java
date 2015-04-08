public class UndoCommand implements Command{
	private int n;

	public UndoCommand(int _n){
		n = _n;
	}
	
	public void execute(){
		System.out.println("Proses Undo " + n);
	}
}
