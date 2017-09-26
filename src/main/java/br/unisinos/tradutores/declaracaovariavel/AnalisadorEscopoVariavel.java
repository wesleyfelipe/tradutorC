/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.declaracaovariavel;

import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

/**
 *
 * @author rudim
 */
public class AnalisadorEscopoVariavel {

	private Escopo escopo;

	public List<Token> analisar(List<Token> tokens) {
		this.escopo = new Escopo(null);
		return corrigeCodigo(tokens);
	}

	public List<Token> corrigeCodigo(List<Token> tokens) {
		if (tokens.isEmpty()) {
			System.out.println("Lista de tokens esta vazia!");
		} else {
			Escopo currentEscopo = this.escopo;
			for (int i = 0; i < tokens.size(); i++) {
				Token token = tokens.get(i);
				if (token.getTipo().equals(TipoToken.L_BRACKET)) {
					Escopo filho = new Escopo(currentEscopo);
					currentEscopo.addEscopoFilho(currentEscopo);
					currentEscopo = filho;
				} else if (token.getTipo().equals(TipoToken.R_BRACKET)) {
					currentEscopo = currentEscopo.getEscopoPai();
				} else if (token.getTipo().equals(TipoToken.ID)) {
					Integer identificador = i;
					Object valor = token.getValor();
					Token tokenAnterior = tokens.get((i - 1));
					if (tokenAnterior.getValor().equals("float") || tokenAnterior.getValor().equals("int")
							|| tokenAnterior.getValor().equals("char") || tokenAnterior.getValor().equals("string")
							|| tokenAnterior.getValor().equals("bool")
							|| tokenAnterior.getTipo().equals(TipoToken.COMMA)) {
						int nextId = currentEscopo.getNextId();
						Declaracao d = new Declaracao(identificador, nextId, valor);
						currentEscopo.addDeclaracao(d);
						token.setValor(nextId);

					} else if (token.getTipo().equals(TipoToken.ID)) {
						Declaracao d = currentEscopo.getDeclaracao(currentEscopo, valor);
						if (d == null) {
							token.setValor(-1);
						} else {
							token.setValor(d.getId());
						}
					}

				}
			}
		}
		return tokens;
	}

}
