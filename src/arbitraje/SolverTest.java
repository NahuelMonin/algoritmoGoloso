package arbitraje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class SolverTest {
	
	private Instancia crearEjemplo() {
		
		Equipo[] equipos = new Equipo[4];
		equipos[0] = new Equipo("River Plate", 0);
		equipos[1] = new Equipo("Boca Jrs", 1);
		equipos[2] = new Equipo("Independiente", 2);
		equipos[3] = new Equipo("Racing", 3);
		
		HashMap<Integer, Arbitro> arbitros = new HashMap<Integer, Arbitro>();
		arbitros.put(1, new Arbitro(1,equipos.length));
		arbitros.put(2, new Arbitro(2,equipos.length));
		
		ArrayList<Partido> partidosFecha1 = new ArrayList<Partido>();
		partidosFecha1.add(new Partido(equipos[0], equipos[1]));
		partidosFecha1.add(new Partido(equipos[2], equipos[3]));
		
		
		ArrayList<Partido> partidosFecha2 = new ArrayList<Partido>();
		partidosFecha2.add(new Partido(equipos[0], equipos[3]));
		partidosFecha2.add(new Partido(equipos[2], equipos[1]));
		
		
		ArrayList<Partido> partidosFecha3 = new ArrayList<Partido>();
		partidosFecha3.add(new Partido(equipos[0], equipos[2]));
		partidosFecha3.add(new Partido(equipos[1], equipos[3]));
		
		ArrayList<FechaTorneo> fechasTorneo = new ArrayList<FechaTorneo>();
		fechasTorneo.add(new FechaTorneo (1, partidosFecha1 ));
		fechasTorneo.add(new FechaTorneo (2, partidosFecha2 ));
		fechasTorneo.add(new FechaTorneo (3, partidosFecha3 ));
		
		Instancia torneo = new Instancia(fechasTorneo, arbitros);
		
		return torneo;
		
	}
	@Test
	public void asignarArbitroTest() {
		Instancia torneo = crearEjemplo();
		Solver solucion = new Solver(torneo);
		solucion.asignarArbitros();
		//solucion.getInstancia().g
		
	}

}
