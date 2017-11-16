package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.Token;

public class OrganizadorMovimentos {

	public static List<Movimento> ordenarMovimentos(List<Token> tokens) {
		List<Movimento> movimentos = new ArrayList<>();

		for (int i = 0; i < tokens.size(); i++) {

			Token token = tokens.get(i);
			Direcoes direcao = Direcoes.isDirecao(token);
			if (direcao != null) {
				Double distancia = Double.valueOf(tokens.get(i + 1).getValor().toString());
				movimentos.add(new Movimento(direcao, distancia));
			}
		}

		return movimentos;
	}
}
