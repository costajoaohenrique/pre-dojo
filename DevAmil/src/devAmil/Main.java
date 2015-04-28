package devAmil;

import java.util.List;

public class Main {
	
	public void init(){

		FactoryPartida factory = new FactoryPartida();
		
		List<Partida> partidas = factory.createPartidas("arquivo.txt");
		
		for (Partida partida : partidas) {
			String ranking = partida.gerarRanking();
			System.out.println(ranking);
		}
		
	}

	public static void main(String[] args) {
		new Main().init();
	}
}
