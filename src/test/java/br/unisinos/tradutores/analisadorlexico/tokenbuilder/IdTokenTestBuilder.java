package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.IdTokenBuilder;

public class IdTokenTestBuilder {

	@Test
	public void verify_true() {
		String lexema = "abcg";
		Token expected = new Token(TipoToken.ID, lexema);
		GeracaoTokenTo to = new GeracaoTokenTo(expected);

		GeracaoTokenTo result = IdTokenBuilder.verify(lexema);

		Assert.assertEquals(to, result);
	}

	@Test
	public void verify_false() {
		String lexema1 = "teste(";
		GeracaoTokenTo result1 = IdTokenBuilder.verify(lexema1);

		String lexema2 = "1gtr";
		GeracaoTokenTo result2 = IdTokenBuilder.verify(lexema2);

		String lexema3 = "gtr()";
		GeracaoTokenTo result3 = IdTokenBuilder.verify(lexema3);

		String lexema4 = ";";
		GeracaoTokenTo result4 = IdTokenBuilder.verify(lexema4);

		Assert.assertNull(result1);
		Assert.assertNull(result2);
		Assert.assertNull(result3);
		Assert.assertNull(result4);
	}
}
