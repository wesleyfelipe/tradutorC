package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class AnalisadorSemanticoLinha {

	private int tokenAtual = 0;
	private Integer linha = 1;

	private List<Token> tokens;

	public List<Movimento> analisar(List<Token> tokens, Integer linha) throws Exception {

		if (tokens == null || tokens.isEmpty())
			return new ArrayList<>();

		this.tokens = tokens;
		this.tokenAtual = 0;

		comando();

		// TODO
		return new ArrayList<>();
	}

	protected void advance() {
		this.tokenAtual += 1;
	}

	private Token getTokenAtual() {
		return this.tokenAtual >= this.tokens.size() ? null : this.tokens.get(this.tokenAtual);
	}

	protected void tratarComandoDirecao(Direcoes direcao) throws Exception {
		advance();
		basico(direcao);
		advance();
		comando();
	}

	protected void tratarAberturaParentese() throws Exception {
		advance();
		comando();

		if (!TipoToken.R_PAREN.equals(getTokenAtual().getTipo())) {
			throw new Exception("LINHA: " + linha + ". Encontrado símbolo " + getTokenAtual().getValor()
					+ " onde um parêntese direito era esperado.");
		}
	}

	protected void tratarPalavraReservada() throws Exception {
		if (!"APOS".equals(getTokenAtual().getValor()) && !"ENTAO".equals(getTokenAtual().getValor()))
			throw new Exception("LINHA: " + linha + ". Encontrado símbolo " + getTokenAtual().getValor()
					+ " onde as palavras reservadas APOS ou ENTAO eram esperadas.");

		advance();
		comando();
	}

	protected void tratarTokenInvalidoEncontrado() throws Exception {
		throw new Exception("LINHA: " + linha + ". Token inválido encontrado: " + getTokenAtual().getValor() + ".");
	}

	protected void comando() throws Exception {

		if (getTokenAtual() == null)
			return;

		Direcoes direcao = Direcoes.isDirecao(getTokenAtual());

		if (direcao != null) {

			tratarComandoDirecao(direcao);

		} else if (TipoToken.L_PAREN.equals(getTokenAtual().getTipo())) {

			tratarAberturaParentese();

		} else if (TipoToken.RESERVED_WORD.equals(getTokenAtual().getTipo())) {

			tratarPalavraReservada();

		} else if (TipoToken.R_PAREN.equals(getTokenAtual().getTipo())
				|| TipoToken.NEW_LINE.equals(getTokenAtual().getTipo())) {
			return;

		} else {

			tratarTokenInvalidoEncontrado();

		}
	}

	protected void basico(Direcoes direcao) throws Exception {
		if (!TipoToken.NUMBER.equals(getTokenAtual().getTipo()))
			throw new Exception(
					"LINHA: " + linha + ". Esperado um valor numérico após o comando " + direcao.name() + ".");
	}
}
