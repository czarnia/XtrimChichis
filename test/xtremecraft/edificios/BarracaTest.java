package xtremecraft.edificios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import xtremecraft.mapa.Terreno;
import xtremecraft.mapa.Tierra;
import xtremecraft.unidades.Marine;

public class BarracaTest {
	
	public Barraca construirNuevaBarraca(Terreno tierra){
		
		Barraca unaBarraca = new Barraca(tierra);
		for(int i=0;i<unaBarraca.tiempoConstruccion;i++){
			unaBarraca.pasarTiempo();
		}
		return unaBarraca;
		
	}

	@Test
	public void getUbicacionActualDevuelveCoordenadasDelEdificio(){
		
		int fila = 1;
		int columna = 2;
		Terreno tierra = new Tierra(fila,columna);
		Barraca unaBarraca = construirNuevaBarraca(tierra);
		
		assertEquals(unaBarraca.getUbicacionActual().fila(),1);
		assertEquals(unaBarraca.getUbicacionActual().columna(),2);
		
	}
	
	
	@Test
	public void puedeUbicarseSobreRecursoNaturalDevuelveTrue(){
		
		int fila = 1;
		int columna = 2;
		Terreno tierra = new Tierra(fila,columna);
		Barraca unaBarraca = construirNuevaBarraca(tierra);
		
		assertFalse(unaBarraca.puedeUbicarseSobreRecursoNatural());
		
	}
	
	
	
	@Test
	public void edificioSeInicializaConBarraDeVidaCompleta(){
		
		int fila = 1;
		int columna = 2;
		Terreno tierra = new Tierra(fila,columna);
		Barraca unaBarraca = construirNuevaBarraca(tierra);
		
		assertEquals(unaBarraca.getVida(),100);
		
	}
	
	@Test
	public void edificioEstaElevadoDevuelveFalseParaEdificiosCreadosEnTierra(){
		
		int fila = 1;
		int columna = 2;
		Terreno tierra = new Tierra(fila,columna);
		Barraca unaBarraca = construirNuevaBarraca(tierra);
		
		assertFalse(unaBarraca.estaElevado());
		
	}
	
	@Test
	public void siElEdificioRecibeDanioSuVidaDecrece(){
		
		int fila = 1;
		int columna = 2;
		Terreno tierra = new Tierra(fila,columna);
		Barraca unaBarraca = construirNuevaBarraca(tierra);
		int valorDanio = 30;
		
		unaBarraca.recibirDanio(valorDanio);
		assertEquals(unaBarraca.getVida(),70);
		
		unaBarraca.recibirDanio(valorDanio);
		assertEquals(unaBarraca.getVida(),40);
		
	}
	
	@Test
	public void entrenarMarineDevuelveNuevaUnidadMarine(){

		Terreno tierra1 = new Tierra(1,2);
		Terreno tierra2 = new Tierra(3,4);
		Barraca unaBarraca = construirNuevaBarraca(tierra1);
		Marine nuevoMarine = unaBarraca.entrenarMarine(tierra2);
		
		assertEquals(nuevoMarine.getVida(),40);
		
	}

}
