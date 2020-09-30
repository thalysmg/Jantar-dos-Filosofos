package jantar;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jantar {
   
	static Filosofo filosofos[] = new Filosofo[5];
	
	public static void main (String[] args) {
      
	  Mesa mesa = new Mesa (filosofos);
	  
	// Inicializa todos filósofos
      filosofos[0] = new Filosofo("Sócrates", mesa, 0);
      filosofos[1] = new Filosofo("Platão", mesa, 1);
      filosofos[2] = new Filosofo("Aristótoles", mesa, 2);
      filosofos[3] = new Filosofo("Tales", mesa, 3);
      filosofos[4] = new Filosofo("Parmênides", mesa, 4);
	  
      for (int filosofo = 0; filosofo < 5; filosofo++) {
         filosofos[filosofo].start();
      }
      
      try {
          Thread.sleep(10000);
          System.exit(0);
      } catch (InterruptedException ex) {
          Logger.getLogger(Jantar.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
}
