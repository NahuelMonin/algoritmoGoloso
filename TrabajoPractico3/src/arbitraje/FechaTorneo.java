package arbitraje;

import java.util.ArrayList;

public class FechaTorneo {
	private int numFecha;
	private ArrayList<Partido> partidos;
		
	public FechaTorneo(int numFecha, ArrayList<Partido> listaPartidos) {
		this.numFecha = numFecha;
		this.partidos = listaPartidos;
	}
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("FECHA NUMERO: " + numFecha).append(System.lineSeparator());
		for (Partido partido : partidos) {
			sb.append(partido.toString()).append(System.lineSeparator());
		}
		return sb.toString();
	}
}
