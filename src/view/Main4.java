package view;
import java.util.concurrent.Semaphore;
import controller.Metodos4;
import model.Piloto;

public class Main4 {
	
	public static void main (String[] args) {
		Semaphore carrosPista = new Semaphore(5);
		Semaphore carrosEquipe = new Semaphore(1);
		
		for (int carro = 0; carro < 2; carro++) {
			try {
				carrosEquipe.acquire();
				for (int equipe = 0; equipe < 7; equipe ++) {
					if (carro == 0) {
						Thread corredor = new Metodos4(carrosPista, carro+1, equipe+1);
						corredor.start();
					} else {
						Thread corredor = new Metodos4(carrosPista, carro+7, equipe+1);
						corredor.start();
					}
					
					
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				carrosEquipe.release();
			}
			
		}
		
		
	}
}