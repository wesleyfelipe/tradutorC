package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.ReservedWordTokenBuilder;

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
