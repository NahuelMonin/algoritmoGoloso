package arbitraje;

import java.io.Serializable;

public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int codigo;
	
	public Equipo (String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
