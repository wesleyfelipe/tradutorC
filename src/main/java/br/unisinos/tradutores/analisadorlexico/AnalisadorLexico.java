package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorId;
import br.unisinos.tradutores.analisadorlexico.identificadores.IdentificadorNumber;
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
		for (String lex : lexemas) {
			tokens.add(analisarLexema(lex));
		}
		return tokens;
	}
	
	//TODO incompleto
	protected static Token analisarLexema(String lexema){
		Token token = null;
		
		token = IdentificadorReservedWord.verify(lexema);
		if(token != null)
			return token;
		
		token = IdentificadorNumber.verify(lexema);
		if(token != null)
			return token;
		
		token = IdentificadorId.verify(lexema);
		if(token != null)
			return token;
		
		return new Token(TipoToken.UNKNOWN, lexema);
	}

	protected static String removerComentarios(String code) {
		return code.replaceAll(REGEX_COMENTARIOS, "");
	}
}
