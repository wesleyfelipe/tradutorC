package br.unisinos.tradutores.analisadorsemantico;

import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class AnalisadorSemantico {

	private int tokenAtual = 0;

	private List<Token> tokens;

	public void analisar(List<Token> tokens) throws Exception {

		if (tokens == null || tokens.isEmpty())
			return;

		this.tokens = tokens;
		this.tokenAtual = 0;

		comando();
	}
	
	protected void advance() {
		this.tokenAtual += 1;
	}
	
	private Token getTokenAtual() {
		return this.tokenAtual >= this.tokens.size() ? null : this.tokens.get(this.tokenAtual);
	}


	protected void comando() throws Exception {

		if (getTokenAtual() == null)
			return;

		Direcoes direcao = Direcoes.isDirecao(getTokenAtual());

		if (direcao != null) {

			advance();
			basico(direcao);
			advance();
			comando();

		} else if (TipoToken.L_PAREN.equals(getTokenAtual().getTipo())) {

			advance();
			comando();

			if (!TipoToken.R_PAREN.equals(getTokenAtual().getTipo())) {
				throw new Exception("Encontrado símbolo " + getTokenAtual().getValor()
						+ " onde um parêntese direito era esperado.");
			}

		} else if (TipoToken.RESERVED_WORD.equals(getTokenAtual().getTipo())) {
			
			if (!"APOS".equals(getTokenAtual().getValor()) && !"ENTAO".equals(getTokenAtual().getValor()))
				throw new Exception("Encontrado símbolo " + getTokenAtual().getValor()
						+ " onde as palavras reservadas APOS ou ENTAO eram esperadas.");

			advance();
			comando();

		}
	}

	protected void basico(Direcoes direcao) throws Exception {
		if (!TipoToken.NUMBER.equals(getTokenAtual().getTipo()))
			throw new Exception("Esperado um valor numérico após o comando " + direcao.name() + ".");
	}
}
