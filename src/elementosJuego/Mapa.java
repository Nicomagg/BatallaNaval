package elementosJuego;

public class Mapa {
	private int coordX;
	private int coordY;
	private Elemento [][] escenario;
	
	public Mapa(int x, int y){
		this.setCoordX(x);
		this.setCoordY(y);
		crearMapa();
	}
	
	public Elemento getEscenario(int x, int y){
		return (escenario[x][y]);
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	private void crearMapa(){
		escenario = new Elemento [this.getCoordX()][this.getCoordY()];
		
		for(int i = 0; i<(this.getCoordX()); i++){
			for(int j=0; j<(this.getCoordY()); j++){
				escenario[i][j] = new Elemento(); 
			}
		}
		
		for(int i=0; i< 5; i++){
			int valX = (int)((Math.random()) * coordX);
			int valY = (int)((Math.random()) * coordY);
			escenario[valX][valY] = new Barcos();
		}
	}
	
	public void marcarElemento(int x, int y){
		escenario[x][y].setExistencia(false);
	}
	
	
}
