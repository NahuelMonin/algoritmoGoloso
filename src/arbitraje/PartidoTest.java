package arbitraje;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartidoTest {
	@Test
	public void partidoSinArbitroTest () {
		Partido nuevo = crearPartido();
		assertTrue(nuevo.getArbitro() == null);
	}
	@Test
	public void setArbitroTest() {
		Partido nuevo = crearPartido();

		Arbitro arbitro = new Arbitro (0 , 2);
		nuevo.setArbitro(arbitro);
		assertEquals(arbitro.getCodigo(), nuevo.getArbitro().getCodigo());
	}
	@Test
	public void arbitroDirigioTest() {
		Partido nuevo = crearPartido();
		
		Arbitro arbitro = new Arbitro (0 , 2);
		nuevo.setArbitro(arbitro);
		arbitro.sumarEquipo(nuevo.getEquipoA().getCodigo());
		arbitro.sumarEquipo(nuevo.getEquipoB().getCodigo());
		int [] equipos = {1,1};
		assertArrayEquals(equipos, arbitro.getEquiposDirigidos());
	}
	
	@Test
	public void arbitroNoDirigioTest() {

		Arbitro arbitro = new Arbitro (0,2);
		
		int[] equipos = {0,0};
		assertArrayEquals(equipos, arbitro.getEquiposDirigidos());
	}
	private Partido crearPartido() {
		Equipo equipo1 = new Equipo ("Boca", 0);
		Equipo equipo2 = new Equipo ("River", 1);
		Partido ret = new Partido (equipo1 , equipo2);
	
		return ret;
	}
}
