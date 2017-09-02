package br.unisinos.tradutores.analisadorlexico.geradoresToken;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorReservedWordToken;

public class GeradorReservedWordTokenTest {

	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.RESERVED_WORD, "while");
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = GeradorReservedWordToken.verify("while");
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false() {
		
		GeracaoTokenTo result = GeradorReservedWordToken.verify("do1");
		
		Assert.assertNull(result);
	}
}
