package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorArithmeticalOp;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorFunction;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorId;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorNumber;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorOtherCharacter;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorReservedWord;

public class AnalisadorLexico {

	private static final String REGEX_COMENTARIOS = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";

	public static List<Token> analisar(String code) {
		String codeClean = removerComentarios(code);
		List<String> lexemas = SeparadorLexemas.separarLexemas(codeClean);
		return analisarLexemas(lexemas);
	}

	protected static List<Token> analisarLexemas(List<String> lexemas) {
		List<Token> tokens = new ArrayList<Token>();
		for (int i = 0; i < lexemas.size(); i++) {
			tokens.add(analisarLexema(i, lexemas));
		}
		return tokens;
	}

	// TODO incompleto lembrar dos arrays e includes de arquivos .h
	protected static Token analisarLexema(int position, List<String> lexemas) {
		Token token = null;
		String lexema = lexemas.get(position);
		String proximoLexema = null;
		
		if(lexemas.size() > position + 1)
			proximoLexema = lexemas.get(position + 1);
		

		token = IdentificadorReservedWord.verify(lexema);
		if (token != null)
			return token;

		token = IdentificadorArithmeticalOp.verify(lexema);
		if (token != null)
			return token;

		token = IdentificadorNumber.verify(lexema);
		if (token != null)
			return token;

		token = IdentificadorFunction.verify(lexema, proximoLexema);
		if (token != null)
			return token;

		token = IdentificadorId.verify(lexema);
		if (token != null)
			return token;

		token = IdentificadorOtherCharacter.verify(lexema);
		if (token != null)
			return token;

		return new Token(TipoToken.UNKNOWN, lexema);
	}

	protected static String removerComentarios(String code) {
		return code.replaceAll(REGEX_COMENTARIOS, "");
	}
}
