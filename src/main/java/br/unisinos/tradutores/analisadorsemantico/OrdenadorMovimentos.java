package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.Token;

public class OrdenadorMovimentos {

	public static List<Movimento> ordenarMovimentos(List<Token> tokens) {
		List<Movimento> movimentos = new ArrayList<>();

		Boolean inverter = Boolean.FALSE;

		for (int i = 0; i < tokens.size(); i++) {

			Token token = tokens.get(i);
			Direcoes direcao = Direcoes.isDirecao(token);
			if (direcao != null) {

				Double distancia = Double.valueOf(tokens.get(i + 1).getValor().toString());
				Movimento movimento = new Movimento(direcao, distancia);

				if (inverter) {

					Movimento movimentoAnterior = movimentos.get(movimentos.size()-1);
					movimentos.set(movimentos.size()-1, movimento);
					movimentos.add(movimentoAnterior);
					inverter = Boolean.FALSE;
				} else {
					movimentos.add(movimento);
				}

			} else if ("APOS".equals(token.getValor())) {
				inverter = Boolean.TRUE;
			}

		}

		return movimentos;
	}

}
