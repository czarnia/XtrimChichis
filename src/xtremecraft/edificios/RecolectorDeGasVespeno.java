package xtremecraft.edificios;

import xtremecraft.recursos.VolcanGasVespeno;

public class RecolectorDeGasVespeno extends Recolector {
	
	private VolcanGasVespeno volcan;
	
	protected RecolectorDeGasVespeno(VolcanGasVespeno unVolcanDeGasVespeno, int fila, int columna){
		
		super(fila,columna);
		this.volcan = unVolcanDeGasVespeno;
		
	}

	public void aumentarReservasEnTurno(){
		
		this.reservas += this.volcan.explotar(this.aumentoDeReservaEnTurno);
		
	}
		
}