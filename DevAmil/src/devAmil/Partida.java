package devAmil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Partida {

	private String id;

	private List<Jogador> jogadores = new ArrayList<>();

	public String gerarRanking() {
		Collections.sort(jogadores, new Comparator<Jogador>() {
			public int compare(Jogador o1, Jogador o2) {
				if (o1.getQuantidadeAssassinatos() == o2
						.getQuantidadeAssassinatos()) {
					return o1.getQuantidadeMortes() - o2.getQuantidadeMortes();
				} else {
					return o2.getQuantidadeAssassinatos()
							- o1.getQuantidadeAssassinatos();

				}
			};
		});

		StringBuilder sb = new StringBuilder();
		sb.append("++++++++++++ Partida " + id + " ++++++++++++ ");
		sb.append("\n");
		sb.append("\n");
		for (Jogador jogador : jogadores) {
			sb.append("Jogador: ");
			sb.append(jogador.getId());
			sb.append(" Assassinatos: ");
			sb.append(jogador.getQuantidadeAssassinatos());
			sb.append(" Mortes: ");
			sb.append(jogador.getQuantidadeMortes());
			sb.append("\n");
		}

		return sb.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
