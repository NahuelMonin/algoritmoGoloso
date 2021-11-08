package arbitraje;

public class Partido {
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
		
		sb.append(equipoA).append(" - ").append(equipoB).append(System.lineSeparator());
		sb.append(arbitro).append(System.lineSeparator());
		return sb.toString();
	}
}
