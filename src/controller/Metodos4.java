package controller;
import java.util.concurrent.Semaphore;
import model.Piloto;

public class Metodos4 extends Thread {
	Semaphore carrosPista;
	static int correndo[] = new int[5];
	private int carro, equipe, volta;	
	static Piloto[] piloto = new Piloto[14];
	
	public Metodos4(Semaphore carrosPista, int carro, int equipe) {
		this.carro = carro;
		this.equipe = equipe;
		this.carrosPista = carrosPista;
	}
	
	public void run() {
		try {
			carrosPista.acquire();
			voltas(carro, equipe);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			carrosPista.release();
		}
	}

	private void voltas(int carro, int equipe) {
		int menor = (int) ((Math.random()*201)+100);
		
		for (int i = 0; i < 2; i++) {
			volta = (int) ((Math.random()*201)+100);
			if (volta < menor) {
				menor = volta;
			}
			
			
			
			
		}
	}
}