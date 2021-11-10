package arbitraje;

import java.io.Serializable;

public class Partido implements Serializable{

	private static final long serialVersionUID = 1L;
	private Equipo equipoA;
	private Equipo equipoB;
	private Arbitro arbitro;
	
	public Partido (Equipo A, Equipo B) {
		this.equipoA = A;
		this.equipoB = B;
		this.arbitro = null;
	}

	public Equipo getEquipoA() {
		return equipoA;
	}

	public Equipo getEquipoB() {
		return equipoB;
	}
	
	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(equipoA).append(" - ").append(equipoB).append(" // �rbitro: ");
		sb.append(arbitro);
		return sb.toString();
	}
}
