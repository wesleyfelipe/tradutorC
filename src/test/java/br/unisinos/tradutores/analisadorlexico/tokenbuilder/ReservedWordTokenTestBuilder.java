package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.ReservedWordTokenBuilder;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class ReservedWordTokenTestBuilder {

	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.RESERVED_WORD, "ENTAO");
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = ReservedWordTokenBuilder.verify("ENTAO");
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false() {
		
		GeracaoTokenTo result = ReservedWordTokenBuilder.verify("do1");
		
		Assert.assertNull(result);
	}
}
