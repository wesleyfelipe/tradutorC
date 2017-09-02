package br.unisinos.tradutores.analisadorlexico.geradoresToken;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorIdToken;

public class GeradorIdTokenTest {

	@Test
	public void verify_true() {
		String lexema = "abcg";
		Token expected = new Token(TipoToken.ID, lexema);
		GeracaoTokenTo to = new GeracaoTokenTo(expected);

		GeracaoTokenTo result = GeradorIdToken.verify(lexema);

		Assert.assertEquals(to, result);
	}

	@Test
	public void verify_false() {
		String lexema1 = "teste(";
		GeracaoTokenTo result1 = GeradorIdToken.verify(lexema1);

		String lexema2 = "1gtr";
		GeracaoTokenTo result2 = GeradorIdToken.verify(lexema2);

		String lexema3 = "gtr()";
		GeracaoTokenTo result3 = GeradorIdToken.verify(lexema3);

		String lexema4 = ";";
		GeracaoTokenTo result4 = GeradorIdToken.verify(lexema4);

		Assert.assertNull(result1);
		Assert.assertNull(result2);
		Assert.assertNull(result3);
		Assert.assertNull(result4);
	}
}
