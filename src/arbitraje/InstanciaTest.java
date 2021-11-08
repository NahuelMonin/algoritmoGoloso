package arbitraje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class InstanciaTest {

	@Test
	public void vacioTest() {
		Instancia torneo = crearTorneo();
		
		assertFalse(torneo.getArbitros().size() == 0);
		assertFalse(torneo.getFechasTorneo().size() == 0);
	}
	
	@Test
	public void nullTest() {
		
		Instancia torneo = crearTorneo();	
		for (FechaTorneo fecha : torneo.getFechasTorneo()) {
			for (Partido partido : fecha.getPartidos()) {
				assertTrue (partido.getArbitro() == null);
			}
		}
	}
	@Test
	public void algoritmoNoNullTest () {
		Instancia torneo = crearTorneo();	
		Solver solucion = new Solver (torneo);
		solucion.asignarArbitros();
		
		for (FechaTorneo fecha : torneo.getFechasTorneo()) {
			for (Partido partido : fecha.getPartidos()) {
				assertTrue (partido.getArbitro() != null);
			}
		}
	}
	
	public Instancia crearTorneo () {
		
		Equipo[] equipos = new Equipo[6];
		equipos[0] = new Equipo("River Plate", 0);
		equipos[1] = new Equipo("Boca Jrs", 1);
		equipos[2] = new Equipo("Independiente", 2);
		equipos[3] = new Equipo("Racing", 3);
		equipos[4] = new Equipo("San Lorenzo", 4);
		equipos[5] = new Equipo("Huracan", 5);
		
		HashMap<Integer, Arbitro> arbitros = new HashMap<Integer, Arbitro>();
		arbitros.put(0, new Arbitro(0,6));
		arbitros.put(1, new Arbitro(1,6));
		arbitros.put(2, new Arbitro(2,6));
		
		ArrayList<Partido> partidosFecha1 = new ArrayList<Partido>();
		partidosFecha1.add(new Partido(equipos[0], equipos[1]));
		partidosFecha1.add(new Partido(equipos[2], equipos[3]));
		partidosFecha1.add(new Partido(equipos[4], equipos[5]));
		
		ArrayList<Partido> partidosFecha2 = new ArrayList<Partido>();
		partidosFecha2.add(new Partido(equipos[0], equipos[2]));
		partidosFecha2.add(new Partido(equipos[4], equipos[1]));
		partidosFecha2.add(new Partido(equipos[5], equipos[3]));
		
		ArrayList<Partido> partidosFecha3 = new ArrayList<Partido>();
		partidosFecha3.add(new Partido(equipos[0], equipos[4]));
		partidosFecha3.add(new Partido(equipos[5], equipos[2]));
		partidosFecha3.add(new Partido(equipos[3], equipos[1]));
		
		ArrayList<Partido> partidosFecha4 = new ArrayList<Partido>();
		partidosFecha4.add(new Partido(equipos[0], equipos[5]));
		partidosFecha4.add(new Partido(equipos[3], equipos[4]));
		partidosFecha4.add(new Partido(equipos[1], equipos[2]));
		
		ArrayList<Partido> partidosFecha5 = new ArrayList<Partido>();
		partidosFecha5.add(new Partido(equipos[0], equipos[3]));
		partidosFecha5.add(new Partido(equipos[1], equipos[5]));
		partidosFecha5.add(new Partido(equipos[2], equipos[4]));
		
		ArrayList<FechaTorneo> fechasTorneo = new ArrayList<FechaTorneo>();
		fechasTorneo.add(new FechaTorneo (1, partidosFecha1 ));
		fechasTorneo.add(new FechaTorneo (2, partidosFecha2 ));
		fechasTorneo.add(new FechaTorneo (3, partidosFecha3 ));
		fechasTorneo.add(new FechaTorneo (4, partidosFecha4 ));
		fechasTorneo.add(new FechaTorneo (5, partidosFecha5 ));
		
		Instancia ret = new Instancia (fechasTorneo, arbitros);
		
		return ret;
	}
}
