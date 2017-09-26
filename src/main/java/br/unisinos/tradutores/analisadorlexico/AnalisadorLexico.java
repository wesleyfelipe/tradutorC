package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.separadores.SeparadorLexemas;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.ArithmeticalOpTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.IdTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.IdentificadorFunctionTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.LogicOpTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.NumberTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.OtherCharacterTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.RelationalOpTokenBuilder;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.ReservedWordTokenBuilder;

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

		GeracaoTokenTo token = ReservedWordTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = ArithmeticalOpTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = RelationalOpTokenBuilder.verify(lexema, proximoLexema);
		if (token != null)
			return token;

		token = LogicOpTokenBuilder.verify(lexema, proximoLexema);
		if (token != null)
			return token;

		token = NumberTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = IdentificadorFunctionTokenBuilder.verify(lexema, proximoLexema);
		if (token != null)
			return token;

		token = IdTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		token = OtherCharacterTokenBuilder.verify(lexema);
		if (token != null)
			return token;

		return new GeracaoTokenTo(new Token(TipoToken.UNKNOWN, lexema));
	}

	protected String removerComentarios(String code) {
		return code.replaceAll(REGEX_COMENTARIOS, "");
	}
}
