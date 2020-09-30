package jantar;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Jantar {

	static int[] estado = new int[5];
	static Semaphore mutex = new Semaphore(1);
	
    static Semaphore[] semaforos = new Semaphore[5]; //semaforo para cada filosofo

    static Filosofo[] filosofos = new Filosofo[5]; //array de Filosofos

    public static void main(String[] args) {

        //todos os filosofos iniciam pensando
        for (int i = 0; i < estado.length; i++) {
            estado[i] = 0;
        }

        // Inicializa todos filósofos
        filosofos[0] = new Filosofo("Sócrates", 0);
        filosofos[1] = new Filosofo("Platão", 1);
        filosofos[2] = new Filosofo("Aristótoles", 2);
        filosofos[3] = new Filosofo("Tales", 3);
        filosofos[4] = new Filosofo("Parmênides", 4);
        
        //saber quais garfos pertence aos filosofos
        for (int i = 0; i < filosofos.length; i++) {            
            System.out.println("garfo " + i + " - filosofo  " + i + " - garfo " + (i + 1) % 5);            
        }
        
        System.out.println("");        
        
        
        // Seta o semaforo de cada filosofo para 0
        for (int i = 0; i < semaforos.length; i++) {
            semaforos[i] = new Semaphore(0);
        }

        // Inicia a tentativa de cada filosofo              
        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
        }

        try {
            Thread.sleep(10000);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jantar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}