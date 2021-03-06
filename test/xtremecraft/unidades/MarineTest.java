package xtremecraft.unidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import xtremecraft.mapa.Aire;
import xtremecraft.mapa.Terreno;
import xtremecraft.mapa.Tierra;

public class MarineTest {
	
	@Test
	public void testMarineInicializadoConVidaCompleta(){

		Terreno unaCelda=new Tierra(1,1);
		Marine miniSamus = new Marine(unaCelda);

		assertEquals(miniSamus.getVida(),40);
	}
	
	@Test
	public void marinePuedeUbicarseSobreRecursoNaturalDevuelveFalse(){

		Terreno unaCelda=new Tierra(1,1);
		Marine miniSamus = new Marine(unaCelda);
		
		assertFalse(miniSamus.puedeUbicarseSobreRecursoNatural());
	}
	
	@Test
	public void goliatGetVisionDevuelveRadioDeVisionDelGoliat(){

		Terreno unTerreno = new Tierra(1,1);
		Marine miniSamus = new Marine(unTerreno);

		assertEquals(miniSamus.getRadioVision(),7);
	}
	
	
	@Test
	public void siUnMarineAtacaAOtroPorAireLeSacaSeisDeVida(){

		Terreno unTerreno = new Tierra(1,2);
		Terreno otroTerreno = new Aire(1,3);
		Marine miniSamus = new Marine(unTerreno);
		Espectro miniMasterChief = new Espectro(otroTerreno);
		
		miniSamus.atacar(miniMasterChief);
		
		assertEquals(miniMasterChief.vitalidad.devolverValor(), 114);
	}
	
	@Test
	public void siUnMarineAtacaAOtroPorTierraLeSacaSeisDeVida(){

		Terreno unTerreno = new Tierra(1,2);
		Terreno otroTerreno = new Tierra(1,3);
		Marine miniSamus = new Marine(unTerreno);
		Marine miniMasterChief = new Marine(otroTerreno);
		
		miniSamus.atacar(miniMasterChief);
		
		assertEquals(miniMasterChief.vitalidad.devolverValor(), 34);
	}
	
	@Test
	public void siUnMarineAtacaAOtroFueraDeSuRangoNoLeHaceDaño(){

		Terreno unTerreno = new Tierra(1,2);
		Terreno otroTerreno = new Tierra(1,10);
		Marine miniSamus = new Marine(unTerreno);
		Marine miniMasterChief = new Marine(otroTerreno);
		
		miniSamus.atacar(miniMasterChief);
		
		assertEquals(miniMasterChief.vitalidad.devolverValor(),40);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void siIntentoCrearUnaUnidadEnunTerrenoOcupadaSeLanzaExcepcion(){

		Terreno unTerreno=new Tierra(1,1);
		Marine miniSamus = new Marine(unTerreno);
		unTerreno.ubicar(miniSamus);
		@SuppressWarnings("unused")
		Marine miniMasterChief = new Marine(unTerreno);
		
	}
	
	@Test
	public void moverACeldaCambiaLasCoordenadasActualesDeLaUnidad(){

		Terreno unTerreno = new Tierra(1,1);
		Terreno otroTerreno = new Tierra(1,2);
		Marine miniSamus = new Marine(unTerreno);
		miniSamus.actualizarUbicacion(otroTerreno);
		
		assertEquals(miniSamus.getUbicacionActual().columna(),2);
		assertEquals(miniSamus.getUbicacionActual().fila(),1);
		
		
	}
	
}
