package br.unisinos.tradutores.domain;

public enum Direcoes {
	
	FRENTE, TRAS, ESQUERDA, DIREITA;
	
	public static Direcoes isDirecao(Token t) {
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
	
	private static Boolean isTokenDirecao(Token token, Direcoes direcao) {
		return direcao != null && token != null && direcao.toString().equals(token.getValor());
	}


}
