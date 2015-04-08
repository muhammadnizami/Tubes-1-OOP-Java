public class HitungEkspresiCommand implements Command{
	private String s;
	public HitungEkspresiCommand(String _s){s = _s;};
	public void execute(){
		Ekspresi e = new Ekspresi(s);
		System.out.println(e.getVal());
	}
}
