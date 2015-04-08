public class ShowMemCommand implements Command{
	private int n;

	public ShowMemCommand(int _n){
		n = _n;
	}
	
	public void execute(){
		System.out.println("Proses ShowMem " + n);
	}
}
