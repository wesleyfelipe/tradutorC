package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Movimento;

public class GrupoMovimentosTO {

	private GrupoMovimentosTO grupoPai;

	private List<GrupoMovimentosTO> gruposFilhos = new ArrayList<>();

	private List<Movimento> movimentos = new ArrayList<>();

	public GrupoMovimentosTO addGrupoFilho(GrupoMovimentosTO grupo) {
		grupo.setGrupoPai(this);
		this.gruposFilhos.add(grupo);
		return grupo;
	}

	public void addMovimento(Movimento movimento) {
		this.movimentos.add(movimento);
	}

	public void addMovimentos(List<Movimento> movimentos) {
		this.movimentos.addAll(movimentos);
	}

	public GrupoMovimentosTO getGrupoPai() {
		return grupoPai;
	}

	public void setGrupoPai(GrupoMovimentosTO grupoPai) {
		this.grupoPai = grupoPai;
	}

	public List<GrupoMovimentosTO> getGruposFilhos() {
		return gruposFilhos;
	}

	public void setGruposFilhos(List<GrupoMovimentosTO> gruposFilhos) {
		this.gruposFilhos = gruposFilhos;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

}
