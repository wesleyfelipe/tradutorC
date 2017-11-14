package br.unisinos.tradutores.domain;

public class Movimento {
	
	private Direcoes direcao;
	
	private Double distancia;
	
	public Movimento(Direcoes direcao, Double distancia) {
		super();
		this.direcao = direcao;
		this.distancia = distancia;
	}

	public Direcoes getDirecao() {
		return direcao;
	}
	
	public void setDirecao(Direcoes direcao) {
		this.direcao = direcao;
	}
	
	public Double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
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
		Movimento other = (Movimento) obj;
		if (direcao != other.direcao)
			return false;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movimento [direcao=" + direcao + ", distancia=" + distancia + "]";
	}
	
}
