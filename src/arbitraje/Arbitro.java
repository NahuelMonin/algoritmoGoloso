package arbitraje;

import java.io.Serializable;

public class Arbitro implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo;
	private int[] equiposDirigidos;
	private boolean disponible; 
	private String apellido;
	
	public Arbitro (int codigo, int cantEquipos) {
		this.codigo = codigo;
		this.equiposDirigidos = new int[cantEquipos];
		this.disponible = true;
		this.setApellido("");
	}

	public int getCodigo() {
		return codigo;
	}

	public int[] getEquiposDirigidos() {
		return equiposDirigidos.clone();
	}
	
	//suma 1 en la posicion correspondiente al equipo que dirigio.
	public void sumarEquipo (int index) {
		this.equiposDirigidos[index]++;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return "" + this.codigo + " " + apellido;
	}
}
