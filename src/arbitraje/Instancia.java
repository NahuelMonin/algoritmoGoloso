package arbitraje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
