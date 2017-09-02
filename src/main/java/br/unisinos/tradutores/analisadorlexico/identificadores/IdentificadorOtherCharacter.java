package br.unisinos.tradutores.analisadorlexico.identificadores;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorOtherCharacter {

	private static final String EQUAL_OP = "=";
	private static final String L_PAREN = "(";
	private static final String R_PAREN = ")";
	private static final String L_BRACKET = "{";
	private static final String R_BRACKET = "}";
	private static final String COMMA = ",";
	private static final String SEMICOLON = ";";
	
	public static Token verify(String lexema) {

		if(EQUAL_OP.equals(lexema))
			return new Token(TipoToken.EQUAL_OP, lexema);
		
		if(L_PAREN.equals(lexema))
			return new Token(TipoToken.L_PAREN, lexema);
		
		if(R_PAREN.equals(lexema))
			return new Token(TipoToken.R_PAREN, lexema);
		
		if(L_BRACKET.equals(lexema))
			return new Token(TipoToken.L_BRACKET, lexema);
		
		if(R_BRACKET.equals(lexema))
			return new Token(TipoToken.R_BRACKET, lexema);
		
		if(COMMA.equals(lexema))
			return new Token(TipoToken.COMMA, lexema);
		
		if(SEMICOLON.equals(lexema))
			return new Token(TipoToken.SEMICOLON, lexema);

		return null;

	}
	
}
