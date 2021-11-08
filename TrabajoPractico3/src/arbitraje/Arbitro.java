package arbitraje;

public class Arbitro {
	private int codigo;
	private int[] equiposDirigidos;
	private boolean disponible; 
	
	public Arbitro (int codigo, int cantEquipos) {
		this.codigo = codigo;
		this.equiposDirigidos = new int[cantEquipos];
		this.disponible = true;
	}

	public int getCodigo() {
		return codigo;
	}

	public int[] getEquiposDirigidos() {
		return equiposDirigidos.clone();
	}
	
	public void sumarEquipo (int index) {
		this.equiposDirigidos[index]++;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Numero de arbitro: " + this.codigo;
	}

}
