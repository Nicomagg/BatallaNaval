package principal;
import java.util.ArrayList;
import java.util.Scanner;

import elementosJuego.Mapa;
import player.Jugador;
import player.Tiempo;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Conjunto de variables pero no instancias
		int dificultad = 0;
		int movimientos = 0;
		int cantBarcos = 5;
		int x = 0;
		int y = 0;
		boolean ganador = false;
		boolean error = false;
		
		//Intacio un nuevo tiempo
		Tiempo tiempoJuego = new Tiempo();
		System.out.println("Bienvenido a Batalla Naval - By Nico Maggione");
		
		//Instacio un nuevo jugador
		System.out.print("Ingrese su nombre: ");
		String nom = sc.next();
		Jugador jugador = new Jugador(nom);
		
		//Seleccion dificultad
		System.out.println("Seleccione la dificultad del juego: ");
		System.out.println("1- Fácil");
		System.out.println("2- Difícil");
		System.out.println("3- Muy Difícil");
		System.out.println("Ingrese 1, 2 o 3 para seleccionar la dificultad: ");
		
		try{
			dificultad = sc.nextInt();
		}catch(Exception e){
			System.out.println("Error, el valor ingresado no es un número");
			System.exit(1);
		};
			
		//Armado del mapa segun dificultad
		Mapa mapa = new Mapa(2,2);//Aca solo inicializo el mapa para que no me de error mas a bajo.
		switch(dificultad){
			case 1:	
				mapa = new Mapa(5,5);
				movimientos = 8;
				System.out.println("Dificultad elegida: Fácil");
				System.out.println("Se ha creado un mapa de 5x5");
				System.out.println("Posee 8 movimientos para encontrar 5 barcos");
				break;
			case 2:
				mapa = new Mapa(10,10);
				movimientos = 10;
				System.out.println("Dificultad elegida: Difícil");
				System.out.println("Se ha creado un mapa de 10x10");
				System.out.println("Posee 10 movimientos para encontrar 5 barcos");
				break;
			case 3:
				mapa = new Mapa(20,20);
				movimientos = 12;
				System.out.println("Dificultad elegida: Muy Difícil");
				System.out.println("Se ha creado un mapa de 20x20");
				System.out.println("Posee 12 movimientos para encontrar 5 barcos");
				break;
			default:
				System.out.println("Error. El número ingresado no es 1, 2 0 3");
				//Fin ejecucion
				System.exit(1);
				break;
		}
		
		System.out.println("");
		System.out.println("Para marcar una posición debe ingresar las coordenadas de la misma.");
		System.out.println("Por ejemplo: 2,2 o 10,10");
		System.out.println("No se puede ingresar como coordenada el 0");
		System.out.println("Cada barco acertado, no se descontara el movimiento");
		System.out.println("Comienzo del juego ya!!!");
		System.out.println("");
		
		//Iniciador del tiempo
		tiempoJuego.contar();
		
		//para guardar posiciones marcadas
		ArrayList<String> posicionesMarcadas = new ArrayList<String>();
		
		//Marca distintos puntos en el mapa
		for(int i = 0; i < movimientos; i++){
			
			error = false;
			//Obtengo coordenada
			System.out.print("Ingrese coordenadas: ");
			String coord = sc.next();
			try{
				String [] coordArreglo = coord.split(",");
				x = (Integer.parseInt(coordArreglo[0]))-1;
				y = (Integer.parseInt(coordArreglo[1]))-1;
			}catch(Exception e){
				System.out.println("Error. No ha respetado el formator de ingreso.");
				error = true;
			}
			
			if(!(error)){
				
				//Verifico las coordenadas en el jugador y marco la posicion
				int[] resultado = jugador.movimientoJugador(mapa, x, y, i, cantBarcos, movimientos);
				
				i = resultado[0];
				cantBarcos = resultado[1];
				posicionesMarcadas.add(coord);
				
				//imprimo los movimientos del jugador
				StringBuilder movimientosJugador = new StringBuilder();
				movimientosJugador.append("Movimientos hechos: ");
				movimientosJugador.append(posicionesMarcadas);
				System.out.println(movimientosJugador);
				
				//verifico si no gano el jugador
				if(cantBarcos==0){
					ganador = true;
					System.out.println("HA GANADOO!!! FELICITACIONES!!!");
					i = movimientos;
				}
			}else{
				i--;
			}
			
			System.out.println("Te queda "+((movimientos-1)-i)+" movimientos");
			System.out.println("");
		}//fin for Marca de posiciones
		
		//Detenemos tiempo de partida
		tiempoJuego.detener();
		
		//Verifico si el jugador perdio
		if(!(ganador)){
			System.out.println("USTED HA PERDIDO!!! Intentelo nuevamente");
		}
		
		//Datos jugador
		System.out.println("Jugador: "+jugador.getNombre());
		
		//Mostrar tiempo jugado
		System.out.println(tiempoJuego.tiempoJugado());
		
		//Mostrar resumen estadistico
		jugador.getEstadistic().resumenEstadistica();
		
		//Fin ejecucion
		System.exit(1);
	}
}
