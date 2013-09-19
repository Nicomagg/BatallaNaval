package player;
import elementosJuego.Mapa;

public class Jugador {
	private String nombre;
	private Estadistica estadistic;
	
	public Jugador(String nom){
		this.setNombre(nom);
		setEstadistic(new Estadistica());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estadistica getEstadistic() {
		return estadistic;
	}

	public void setEstadistic(Estadistica estadistic) {
		this.estadistic = estadistic;
	}
	
	public int [] movimientoJugador( Mapa map, int x, int y, int i,int cantBarcos, int movimientos){
		
		try{
			//Verificar si la posicion ya ha sido marcada
			if(map.getEscenario(x, y).getExistencia()){
				
				//Verifico si es un barco
				if(map.getEscenario(x, y).isBarco()){
					cantBarcos--;
					System.out.println("Has dado en un Barco!!!");
					this.getEstadistic().sumBarcoBaja();
					i--;
				}else{
					System.out.println("No has dado en un barco");
					this.getEstadistic().sumMovError();
				}
				
				//cambio la existencia de la posicion
				map.getEscenario(x, y).setExistencia(false);
				
				//construir un string para imprimirlo
				StringBuilder barcosBajados = new StringBuilder();
				barcosBajados.append("Faltan derribar ");
				barcosBajados.append(cantBarcos);
				barcosBajados.append(" barcos.");
				System.out.println(barcosBajados);
				
				
				
			}else{
				System.out.println("Ya ha ingresado estas coordenadas. La posición ya está marcada");
				i--;
			}//fin condicional de existencia del elemento
		
		}catch(Exception e){
			System.out.println("Se ha ingresado valores no validos. No ingrese números mayores que el tamaño del tablero o menores que 1!!!");
			i--;
		}
		
		int[] respuesta = {i,cantBarcos};
		return respuesta;
	}
}
