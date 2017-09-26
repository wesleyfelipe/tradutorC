package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.analisadorlexico.tokenbuilder.StringTokenBuilder;

public class StringTokenTestBuilder {

	@Test
	public void verify_true(){
		String lexema = "\"teste\"";
		Token expected = new Token(TipoToken.LITERAL_STRING, lexema);
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = StringTokenBuilder.verify(lexema);
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false(){
		String lexema1 = "teste\"";
		GeracaoTokenTo result1 = StringTokenBuilder.verify(lexema1);
		
		String lexema2 = "\"teste";
		GeracaoTokenTo result2 = StringTokenBuilder.verify(lexema2);
		
		Assert.assertNull(result1);
		Assert.assertNull(result2);
	}
}
