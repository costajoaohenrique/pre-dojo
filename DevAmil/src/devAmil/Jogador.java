package devAmil;

public class Jogador {

	private String id;

	private int quantidadeAssassinatos;

	private int quantidadeMortes;

	public int getQuantidadeAssassinatos() {
		return quantidadeAssassinatos;
	}

	public void setQuantidadeAssassinatos(int quantidadeAssassinatos) {
		this.quantidadeAssassinatos = quantidadeAssassinatos;
	}

	public int getQuantidadeMortes() {
		return quantidadeMortes;
	}

	public void setQuantidadeMortes(int quantidadeMortes) {
		this.quantidadeMortes = quantidadeMortes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void adicionarMorte(){
		quantidadeMortes += 1;
	}
	
	public void adicionarAssassinato(){
		quantidadeAssassinatos += 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantidadeAssassinatos;
		result = prime * result + quantidadeMortes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
