package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class AnalisadorSemantico {

	private int tokenAtual = 0;

	private List<Token> tokens;

	private List<Movimento> movimentos = new ArrayList<>();

	public List<Movimento> analisar(List<Token> tokens) throws Exception {

		if (tokens == null || tokens.isEmpty())
			return new ArrayList<>();

		this.tokens = tokens;
		this.movimentos = new ArrayList<>();
		this.tokenAtual = 0;

		comando();

		return this.movimentos;
	}

	protected void comando() throws Exception {

		if (getTokenAtual() == null)
			return;

		Direcoes direcao = isDirecao(getTokenAtual());

		if (direcao != null) {

			advance();
			basico(direcao);
			advance();
			comando();

		} else if (TipoToken.L_PAREN.equals(getTokenAtual().getTipo())) {

			advance();
			comando();

			if (!TipoToken.R_PAREN.equals(getTokenAtual().getTipo())) {
				throw new Exception("Encontrado símbolo " + getTokenAtual().getValor() + " onde um parêntese direito era esperado.");
			}

		} else if (TipoToken.RESERVED_WORD.equals(getTokenAtual().getTipo())) {
			if ("APOS".equals(getTokenAtual().getValor())) {
//				advance();
//				comando();
			} else if ("ENTAO".equals(getTokenAtual().getValor())) {
//				advance();
//				comando();
			} else {
				throw new Exception("Encontrado símbolo " + getTokenAtual().getValor()
						+ " onde as palavras reservadas APOS ou ENTAO eram esperadas.");
			}
			advance();
			comando();

		}
	}

	private Direcoes isDirecao(Token t) {
		if (isTokenDirecao(t, Direcoes.ESQUERDA))
			return Direcoes.ESQUERDA;

		if (isTokenDirecao(t, Direcoes.DIREITA))
			return Direcoes.DIREITA;

		if (isTokenDirecao(t, Direcoes.TRAS))
			return Direcoes.TRAS;

		if (isTokenDirecao(t, Direcoes.FRENTE))
			return Direcoes.FRENTE;

		return null;
	}

	private Token getTokenAtual() {
		return this.tokenAtual >= this.tokens.size() ? null : this.tokens.get(this.tokenAtual);
	}

	protected void basico(Direcoes direcao) throws Exception {

		Token t = getTokenAtual();

		if (TipoToken.NUMBER.equals(t.getTipo())) {
			Double distancia = Double.valueOf(t.getValor().toString());
			addMovimento(direcao, distancia);

		} else {
			throw new Exception("Esperado um valor numérico após o comando " + direcao.name() + ".");
		}
	}

	private void addMovimento(Direcoes direcao, Double distancia) {
		this.movimentos.add(new Movimento(direcao, distancia));
	}

	private Boolean isTokenDirecao(Token token, Direcoes direcao) {
		return direcao != null && token != null && direcao.toString().equals(token.getValor());
	}

	protected void advance() {
		this.tokenAtual += 1;
	}
}
