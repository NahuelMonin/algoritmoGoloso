package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lectura {

	File archivo = new File ("Calendario.txt");
	String calendario;
	
	public Lectura () {
		try {
			FileInputStream fis = new FileInputStream(archivo);
			Scanner scanner = new Scanner (fis);
			calendario = "";
			while (scanner.hasNextLine()) {
				calendario += scanner.nextLine() + "\n";
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getCalendario () {
		return calendario; 
	}
	
}
