package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.Token;

public class OrdenadorMovimentos {

	private Integer index = 0;

	private List<Token> tokens;

	GrupoMovimentosTO grupoAtual = new GrupoMovimentosTO();

	private Boolean avancar() {
		if (this.index + 1 >= tokens.size())
			return Boolean.FALSE;

		this.index++;
		return Boolean.TRUE;
	}

	private Token getTokenAtual() {
		return this.tokens.get(this.index);
	}

	public List<Movimento> ordenarMovimentos(List<Token> tokens) {

		this.index = 0;
		this.tokens = tokens;
		this.grupoAtual = new GrupoMovimentosTO();

		return ordenarMovimentos();
	}

	private Movimento buildMovimento(Direcoes direcao) {
		avancar();

		Double distancia = Double.valueOf(getTokenAtual().getValor().toString());
		return new Movimento(direcao, distancia);

	}

	private List<Movimento> ordenarMovimentos() {

		Direcoes direcao = Direcoes.isDirecao(getTokenAtual());

		if (direcao != null) {

			this.grupoAtual.addMovimento(buildMovimento(direcao));

		} else if("APOS".equals(getTokenAtual().getValor())){
			 
			avancar();
			
			direcao = Direcoes.isDirecao(getTokenAtual());
			this.grupoAtual.addMovimentoApos(buildMovimento(direcao));
			
		}

		if (avancar())
			return ordenarMovimentos();

		return getMovimentos(getGrupoPai(this.grupoAtual));
	}

	protected GrupoMovimentosTO getGrupoPai(GrupoMovimentosTO grupo) {
		GrupoMovimentosTO temp = grupo.getGrupoPai();
		if (temp == null)
			return grupo;

		return getGrupoPai(temp);
	}

	protected List<Movimento> getMovimentos(GrupoMovimentosTO grupo) {
		List<Movimento> movimentos = new ArrayList<>();
		if (grupo == null)
			return movimentos;

		movimentos.addAll(grupo.getMovimentos());
		for (GrupoMovimentosTO gr : grupo.getGruposFilhos())
			movimentos.addAll(getMovimentos(gr));

		return movimentos;

	}

}
