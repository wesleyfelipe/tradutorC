package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorArithmeticalOpToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorIdentificadorFunctionToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorLogicOpToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorIdToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorNumberToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorOtherCharacterToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorRelationalOpToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorReservedWordToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.separadores.SeparadorLexemas;

public class AnalisadorLexico {

	private static final String REGEX_COMENTARIOS = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";

	public List<Token> analisar(String code) {
		String codeClean = removerComentarios(code);
		List<String> lexemas = SeparadorLexemas.separarLexemas(codeClean);
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
		String proximoLexema = null;

		if (lexemas.size() > position + 1)
			proximoLexema = lexemas.get(position + 1);

		return analisarLexema(lexema, proximoLexema);
	}

	protected GeracaoTokenTo analisarLexema(String lexema, String proximoLexema) {
		
		GeracaoTokenTo token = GeradorReservedWordToken.verify(lexema);
		if (token != null)
			return token;

		token = GeradorArithmeticalOpToken.verify(lexema);
		if (token != null)
			return token;

		token = GeradorRelationalOpToken.verify(lexema, proximoLexema);
		if (token != null)
			return token;
		
		token = GeradorLogicOpToken.verify(lexema, proximoLexema);
		if(token != null)
			return token;

		token = GeradorNumberToken.verify(lexema);
		if (token != null)
			return token;

		token = GeradorIdentificadorFunctionToken.verify(lexema, proximoLexema);
		if (token != null)
			return token;

		token = GeradorIdToken.verify(lexema);
		if (token != null)
			return token;

		token = GeradorOtherCharacterToken.verify(lexema);
		if (token != null)
			return token;

		return new GeracaoTokenTo(new Token(TipoToken.UNKNOWN, lexema));
	}

	protected String removerComentarios(String code) {
		return code.replaceAll(REGEX_COMENTARIOS, "");
	}
}
