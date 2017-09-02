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

		if(isEqualOp(lexema))
			return new Token(TipoToken.EQUAL_OP, lexema);
		
		if(isLParen(lexema))
			return new Token(TipoToken.L_PAREN, lexema);
		
		if(isRParen(lexema))
			return new Token(TipoToken.R_PAREN, lexema);
		
		if(isLBracket(lexema))
			return new Token(TipoToken.L_BRACKET, lexema);
		
		if(isRBracket(lexema))
			return new Token(TipoToken.R_BRACKET, lexema);
		
		if(isComma(lexema))
			return new Token(TipoToken.COMMA, lexema);
		
		if(isSemicolon(lexema))
			return new Token(TipoToken.SEMICOLON, lexema);

		return null;
	}
	
	protected static Boolean isEqualOp(String lexema){
		return EQUAL_OP.equals(lexema);
	}
	
	protected static Boolean isLParen(String lexema){
		return L_PAREN.equals(lexema);
	}
	
	protected static Boolean isRParen(String lexema){
		return R_PAREN.equals(lexema);
	}
	
	protected static Boolean isLBracket(String lexema){
		return L_BRACKET.equals(lexema);
	}
	
	protected static Boolean isRBracket(String lexema){
		return R_BRACKET.equals(lexema);
	}
	
	protected static Boolean isComma(String lexema){
		return COMMA.equals(lexema);
	}
	
	protected static Boolean isSemicolon(String lexema){
		return SEMICOLON.equals(lexema);
	}
	
}
