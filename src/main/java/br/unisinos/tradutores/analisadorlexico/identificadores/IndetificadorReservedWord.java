package br.unisinos.tradutores.analisadorlexico.identificadores;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.ReservedWord;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IndetificadorReservedWord {

	//TODO incompleto
	public static Token verify(String lexema) {

		String lex = lexema.trim();

		if (isDoWord(lexema) || isWhileWord(lexema))
			return new Token(TipoToken.RESERVED_WORD, lex);

		return null;

	}

	protected static Boolean isDoWord(String lexema) {
		return isReservedWord(lexema, ReservedWord.DO);
	}

	protected static Boolean isWhileWord(String lexema) {
		return isReservedWord(lexema, ReservedWord.WHILE);
	}

	protected static Boolean isReservedWord(String lexema, ReservedWord type) {
		return type.getValue().equals(lexema);
	}
}
