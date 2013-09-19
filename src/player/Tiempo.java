package player;

import java.util.Timer;
import java.util.TimerTask;

public class Tiempo{
    private Timer timer = new Timer(); 
    private int segundos=0;

    class Contador extends TimerTask{
        public void run(){
            segundos++;
        }
    }

    public void contar(){
        this.segundos=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
    }

    public void detener(){
        timer.cancel();
    }

    public int getSegundos(){
        return this.segundos;
    }
    
    public StringBuilder tiempoJugado(){
    	
    	int hora = (int)(this.getSegundos()/3600);
    	int min = (int)((this.getSegundos()%3600)/60);
    	int seg = (int)((this.getSegundos()%3600)%60);
    	StringBuilder result = new StringBuilder();
    	result.append("El tiempo de juego fue: ");
    	result.append(hora);
    	result.append(":");
    	result.append(min);
    	result.append(":");
    	result.append(seg);
    	return result;
    }
}
