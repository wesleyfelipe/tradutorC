package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.NumberTokenBuilder;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class NumberTokenTestBuilder {
	
	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.NUMBER, "1");
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = NumberTokenBuilder.verify("1");
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false() {
		
		GeracaoTokenTo result = NumberTokenBuilder.verify("do1");
		
		Assert.assertNull(result);
	}

}
