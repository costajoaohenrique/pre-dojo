package devAmil;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryPartidaTest {
	@Before
	public void setUp() throws Exception {

		FileWriter arq = new FileWriter("arquivo.txt");
		PrintWriter printWriter = new PrintWriter(arq);
		printWriter.printf("23/04/2013 15:34:22 - New match 11348965 has started\n");
		printWriter.printf("23/04/2013 15:36:04 - Joao killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Renan killed Joao using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Roman killed Daniel using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Roman killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Joao by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Daniel killed Roman using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Roman killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Roman by DROWN\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Joao by DROWN\n");
		printWriter.printf("23/04/2013 15:39:22 - Match 11348965 has ended\n");
		
		printWriter.printf("23/04/2013 15:34:22 - New match 12348965 has started\n");
		printWriter.printf("23/04/2013 15:36:04 - Raniel killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Renan killed Joao using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Antonio killed Daniel using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Roman killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Antonio by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Daniel killed Roman using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Joao by DROWN\n");
		printWriter.printf("23/04/2013 15:39:22 - Match 12348965 has ended\n");
		
		
		printWriter.printf("23/04/2013 15:34:22 - New match 12348965 has started\n");
		printWriter.printf("23/04/2013 15:36:04 - Amilton killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Renan killed Joao using M16\n");
		printWriter.printf("23/04/2013 15:36:04 - Antonio killed Daniel using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Joao by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Roman killed Nick using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Antonio by DROWN\n");
		printWriter.printf("23/04/2013 15:36:04 - Daniel killed Amilton using M16\n");
		printWriter.printf("23/04/2013 15:36:33 - <WORLD> killed Joao by DROWN\n");
		printWriter.printf("23/04/2013 15:39:22 - Match 12348965 has ended\n");
		arq.close();
	}

	@Test
	public void testCreatePartidas() {
		FactoryPartida factoryPartida = new FactoryPartida();
		assertEquals(3,factoryPartida.createPartidas("arquivo.txt").size());
	}
	
	@Test
	public void testFirstPartidaFirstPlayer(){
		FactoryPartida factoryPartida = new FactoryPartida();
		Partida firstPartida = factoryPartida.createPartidas("arquivo.txt").get(0);
		firstPartida.gerarRanking();
		assertEquals("Roman" ,firstPartida.getJogadores().get(0).getId().trim() );
	}
	
	@Test
	public void testFirstPartidaLastPlayer(){
		FactoryPartida factoryPartida = new FactoryPartida();
		Partida firstPartida = factoryPartida.createPartidas("arquivo.txt").get(0);
		firstPartida.gerarRanking();
		List<Jogador> jogadores = firstPartida.getJogadores();
		assertEquals("Nick" ,jogadores.get(jogadores.size() - 1).getId().trim() );
	}
}
