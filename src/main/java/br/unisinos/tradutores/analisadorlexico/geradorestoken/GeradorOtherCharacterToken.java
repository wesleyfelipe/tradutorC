package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class GeradorOtherCharacterToken {

	private static final String EQUAL_OP = "=";
	private static final String L_PAREN = "(";
	private static final String R_PAREN = ")";
	private static final String L_BRACKET = "{";
	private static final String R_BRACKET = "}";
	private static final String COMMA = ",";
	private static final String SEMICOLON = ";";

	public static GeracaoTokenTo verify(String lexema) {

		Token token = null;

		if (isEqualOp(lexema))
			token = new Token(TipoToken.EQUAL_OP, lexema);

		if (isLParen(lexema))
			token = new Token(TipoToken.L_PAREN, lexema);

		if (isRParen(lexema))
			token = new Token(TipoToken.R_PAREN, lexema);

		if (isLBracket(lexema))
			token = new Token(TipoToken.L_BRACKET, lexema);

		if (isRBracket(lexema))
			token = new Token(TipoToken.R_BRACKET, lexema);

		if (isComma(lexema))
			token = new Token(TipoToken.COMMA, lexema);

		if (isSemicolon(lexema))
			token = new Token(TipoToken.SEMICOLON, lexema);

		return token == null ? null : new GeracaoTokenTo(token);
	}

	protected static Boolean isEqualOp(String lexema) {
		return EQUAL_OP.equals(lexema);
	}

	protected static Boolean isLParen(String lexema) {
		return L_PAREN.equals(lexema);
	}

	protected static Boolean isRParen(String lexema) {
		return R_PAREN.equals(lexema);
	}

	protected static Boolean isLBracket(String lexema) {
		return L_BRACKET.equals(lexema);
	}

	protected static Boolean isRBracket(String lexema) {
		return R_BRACKET.equals(lexema);
	}

	protected static Boolean isComma(String lexema) {
		return COMMA.equals(lexema);
	}

	protected static Boolean isSemicolon(String lexema) {
		return SEMICOLON.equals(lexema);
	}

}
