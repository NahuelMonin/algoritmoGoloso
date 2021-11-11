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
			//Al inicio de cada fecha, todos los arbitros deben estar disponibles.
			todosDisponibles(arbitrosDisponibles);

			for (Partido partidoActual : fechaActual.getPartidos()) {
				//para el partido actual, selecciona el mejor arbitro disponible
				seleccionado = buscarCandidato(partidoActual, arbitrosDisponibles);
				partidoActual.setArbitro(seleccionado);
			}
		}
		
	}

	private Arbitro buscarCandidato(Partido partido, Collection<Arbitro> arbitrosDisponibles) {
		Arbitro candidato = null; // arbitro a asignar
		Integer sumaPartidos = null; // cant veces que dirigio a los equipos del partidos.
		
		//guardamos los codigos de los equipos (son las posiciones en el array de Arbitro).
		int A = partido.getEquipoA().getCodigo();
		int B = partido.getEquipoB().getCodigo();

		for (Arbitro arbitro : arbitrosDisponibles) {
			//Chequeamos que el arbitro este disponible para la fecha del partido.
			if (arbitro.isDisponible()) {
				//Sumamos la cantidad de veces que ya dirigio a los equipos del partido actual. 
				int sumaPartidosDirigidos = arbitro.getEquiposDirigidos()[A] + arbitro.getEquiposDirigidos()[B];

				//El ciclo compara con cada arbitro y guarda la mejor opcion encontrada hasta el momento.				
				if (sumaPartidos == null || sumaPartidosDirigidos < sumaPartidos) {
					candidato = arbitro;
					sumaPartidos = sumaPartidosDirigidos;
				}
			}
		}
		// Una vez que termino de recorre y encontro al mejor candidato
		// Suma al registro de equipos dirigidos del arbitro los equipos de este partido
		// Y cambia su disponibilidad para los siguientes partidos de la fecha.
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
	
	public Instancia getInstancia() {
		return this.instancia;
	}
	
	@Override
	public String toString() {
		return instancia.toString();
	}

}
