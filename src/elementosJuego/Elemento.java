package elementosJuego;

public class Elemento {
	private boolean existencia = true;
	
	public boolean getExistencia() {
		return existencia;
	}

	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}
	
	public boolean isBarco(){
		return false;
	}
}
