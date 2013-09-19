package player;

public class Estadistica {
	private int movimientosErroneos = 0;
	private int barcosBajados = 0;
	
	public int getMovimientosErroneos() {
		return movimientosErroneos;
	}
	
	public void sumMovError(){
		this.movimientosErroneos++;
	}
	
	public int getBarcosBajados() {
		return barcosBajados;
	}
	
	public void sumBarcoBaja(){
		this.barcosBajados++;
	}
	
	public void resumenEstadistica(){
		//Mostrar estadisticas de barcos bajados en el juego
		StringBuilder estadisticaBarcBajas = new StringBuilder();
		estadisticaBarcBajas.append("Cantidad de barcos dados de baja: ");
		estadisticaBarcBajas.append(this.getBarcosBajados());
		System.out.println(estadisticaBarcBajas);
		
		//Mostrar estadisticas del juego
		StringBuilder estadisticaMovError = new StringBuilder();
		estadisticaMovError.append("Cantidad de movimientos erroneos: ");
		estadisticaMovError.append(this.getMovimientosErroneos());
		System.out.println(estadisticaMovError);
	}
}
