package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.separadores.SeparadorLexemas;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.NumberTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.OtherCharacterTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.ReservedWordTokenBuilder;

public class AnalisadorLexico {

	public List<Token> analisar(String code) {
		List<String> lexemas = SeparadorLexemas.separarLexemas(code);
		return analisarLexemas(lexemas);
	}

	protected List<Token> analisarLexemas(List<String> lexemas) {
		List<Token> tokens = new ArrayList<Token>();

		for (int i = 0; i < lexemas.size(); i++) {

			GeracaoTokenTo to = analisarLexema(i, lexemas);
			tokens.add(to.getToken());

			if (to.getSkipNext())
				i++;
		}

		return tokens;
	}

	protected GeracaoTokenTo analisarLexema(int position, List<String> lexemas) {
		String lexema = lexemas.get(position);
		String proximoLexema = lexemas.size() > position + 1 ? lexemas.get(position + 1) : null;

		return analisarLexema(lexema, proximoLexema);
	}

	protected GeracaoTokenTo analisarLexema(String lexema, String proximoLexema) {

		GeracaoTokenTo token = ReservedWordTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = NumberTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = OtherCharacterTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		return new GeracaoTokenTo(new Token(TipoToken.UNKNOWN, lexema));
	}
}
