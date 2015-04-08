/**
Main.java adalah sebuah kelas utama\n
*/

import java.io.Console;

public class Main{
	
	public static void main(String[] args) throws Exception {
		String input;
        do {
			Console console = System.console();
			if (console == null) {
				System.out.println("Unable to fetch console");
				return;
			}
			input = console.readLine();
			if(!input.equals("Exit")){
				Calculator Calc = new Calculator(input);
				console.printf("%s\n", Calc.DoExp());
			}
		} while (!input.equals("Exit"));
    }
	
}