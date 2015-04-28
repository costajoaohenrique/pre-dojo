package devAmil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FactoryPartida {

	protected List<Partida> createPartidas(String nomeArquivo) {
		List<Partida> partidas = new ArrayList<>();
		try {
			FileInputStream stream = new FileInputStream(nomeArquivo);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String linha = bufferedReader.readLine();
			while (linha != null) {
				if (linha.contains("New match")) {
					Partida partida = criarPartida(linha, bufferedReader);
					partidas.add(partida);
				}

				linha = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.print("Arquivo inexistente");
			throw new RuntimeException(e);
		} catch (IOException e) {
			System.err.print("Erro ao carregar arquivo");
			throw new RuntimeException(e);
		}

		return partidas;
	}

	private Partida criarPartida(String linha, BufferedReader bufferedReader)
			throws IOException {
		Partida partida = new Partida();
		if (linha != null) {
			partida = new Partida();
			partida.setId(linha.substring(linha.indexOf("New match ") + 1,
					linha.indexOf(" has started")).replace("ew match ", ""));

			carregarJogadores(partida, bufferedReader);

		}
		return partida;
	}

	private void carregarJogadores(Partida partida,
			BufferedReader bufferedReader) throws IOException {
		String linha = bufferedReader.readLine();

		while (linha != null
				&& !linha.contains("Match " + partida.getId() + " has ended")) {
			if (linha.contains("killed")) {
				String assassino = linha.substring(linha.indexOf(" - "),
						linha.indexOf("killed")).replace(" - ", "");
				String morto = linha.substring(linha.indexOf("killed "))
						.replace("killed ", "");
				morto = morto.substring(0, morto.indexOf(" "));
				adicionarAssassino(partida, assassino);
				adicionarMorto(partida, morto);

			}
			linha = bufferedReader.readLine();

		}
	}

	private void adicionarMorto(Partida partida, String morto) {
		List<Jogador> jogadores = partida.getJogadores();
		Jogador jogadorMorto = new Jogador();
		jogadorMorto.setId(morto);
		if (jogadores.contains(jogadorMorto)) {
			int index = jogadores.indexOf(jogadorMorto);
			jogadorMorto = jogadores.get(index);
			jogadorMorto.adicionarMorte();
		} else {
			jogadorMorto.adicionarMorte();
			jogadores.add(jogadorMorto);
		}

	}

	private void adicionarAssassino(Partida partida, String assassino) {
		if (assassino.contains("<WORLD>")) {
			return;
		}
		List<Jogador> jogadores = partida.getJogadores();
		Jogador jogadorAssassino = new Jogador();
		jogadorAssassino.setId(assassino);
		if (jogadores.contains(jogadorAssassino)) {
			int index = jogadores.indexOf(jogadorAssassino);
			jogadorAssassino = jogadores.get(index);
			jogadorAssassino.adicionarAssassinato();
		} else {
			jogadorAssassino.adicionarAssassinato();
			jogadores.add(jogadorAssassino);
		}

	}

}
