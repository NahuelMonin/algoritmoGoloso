package arbitraje;

public class Equipo {
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
