package arbitraje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Instancia {


	private ArrayList<FechaTorneo> fechasTorneo;
	private HashMap<Integer, Arbitro> arbitros;
	
	public Instancia(ArrayList<FechaTorneo> fechasTorneo, HashMap<Integer, Arbitro> arbitros) {
		this.fechasTorneo = fechasTorneo;
		this.arbitros = arbitros;
	}
	
	public ArrayList<FechaTorneo> getFechasTorneo() {
		return fechasTorneo;
	}
	
	public Collection<Arbitro> getArbitros() {
		return arbitros.values();
	}
	public void generarJSON (String archivo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		try {
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Arbitro getArbitroNumero(int key) {
		return this.arbitros.get(key);
	}
	
	public static Instancia leerJSON(String archivo) {
		Gson gson = new Gson();
		Instancia ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, Instancia.class);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cantidad de arbitros: " + arbitros.size()).append(System.lineSeparator());
		for (Arbitro arbitro : arbitros.values()) {
			sb.append(arbitro.toString()).append(" ");
		}
		sb.append(System.lineSeparator());
		sb.append("=============================").append(System.lineSeparator());
		for (FechaTorneo fecha : fechasTorneo) {
			sb.append(fecha.toString());
		}
		return sb.toString();
	}
} 
