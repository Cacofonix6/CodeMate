import java.util.*;
import java.io.IOException;

public class Gui{
	public Gui(){
	}
	
	//Creates instance of Gui class, asks for file name then runs start()
	public static void main(String args[]) throws IOException{
		Gui g = new Gui();
		System.out.println("Current Dir: "+g.getClass().getClassLoader().getResource("").getPath());
		System.out.println("Enter file name (Parser.java)");
		Scanner sc = new Scanner(System.in);
		String name = g.getClass().getClassLoader().getResource("").getPath()+sc.nextLine();
		sc.close();
		g.start(name);
	}
	
	//Creates instance of Parser and calls start()
	private void start(String file) throws IOException{
		//parser p = new parser();
		parser.start(file);
	}
}