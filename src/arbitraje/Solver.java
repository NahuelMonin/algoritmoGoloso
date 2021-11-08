package arbitraje;

import java.util.Collection;

public class Solver {

	private Instancia instancia;

	public Solver(Instancia torneo) {
		this.instancia = torneo;
	}

	public void asignarArbitros() {
		Collection<Arbitro> arbitrosDisponibles = this.instancia.getArbitros();
		Arbitro seleccionado = null;

		for (FechaTorneo fechaActual : this.instancia.getFechasTorneo()) {
			todosDisponibles(arbitrosDisponibles);

			for (Partido partidoActual : fechaActual.getPartidos()) {
				seleccionado = asignarArbitro(partidoActual, arbitrosDisponibles);
				partidoActual.setArbitro(seleccionado);
			}
		}

	}

	private Arbitro asignarArbitro(Partido partido, Collection<Arbitro> arbitrosDisponibles) {
		Arbitro candidato = null; // arbitro a asignar
		Integer sumaPartidos = null; // cant veces que dirigio a los equipos del partidos.

		int A = partido.getEquipoA().getCodigo();
		int B = partido.getEquipoB().getCodigo();

		for (Arbitro arbitro : arbitrosDisponibles) {
			if (arbitro.isDisponible()) {
				int sumaPartidosDirigidos = arbitro.getEquiposDirigidos()[A] + arbitro.getEquiposDirigidos()[B];

				if (sumaPartidos == null || sumaPartidosDirigidos < sumaPartidos) {
					candidato = arbitro;
					sumaPartidos = sumaPartidosDirigidos;
				}
			}
		}
		// Suma al registro de equipos dirigidos del arbitro los equipos de este partido
		// y cambia su disponibilidad para los siguientes partidos de la fecha.
		candidato.sumarEquipo(A);
		candidato.sumarEquipo(B);
		candidato.setDisponible(false);

		return candidato;
	}

	private void todosDisponibles(Collection<Arbitro> arbitrosDisponibles) {

		for (Arbitro arbitro : arbitrosDisponibles) {
			arbitro.setDisponible(true);
		}
	}
	
	@Override
	public String toString() {
		return instancia.toString();
	}

}
