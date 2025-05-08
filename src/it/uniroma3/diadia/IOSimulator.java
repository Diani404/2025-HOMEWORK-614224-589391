package it.uniroma3.diadia;
import java.util.ArrayList;
import java.util.Scanner;

public class IOSimulator implements IO{

	private final String[] IN = {"prendi pass","vai sud","prendi lanterna","vai est","vai est","vai ovest","vai nord","posa pass","vai nord","vai ovest"};
	private ArrayList<String> out;
	
	public IOSimulator() {
		out = new ArrayList<>();
	}

	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
		out.add(msg);
	}
	
	@Override
	public String leggiRiga() {
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}
	
	public String[] getComandi() {
		return IN;
	}
}
