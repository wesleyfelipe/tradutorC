package br.unisinos.tradutores.analisadorlexico.geradoresToken;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorNumberToken;

public class GeradorNumberTokenTest {
	
	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.NUMBER, "1");
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = GeradorNumberToken.verify("1");
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false() {
		
		GeracaoTokenTo result = GeradorNumberToken.verify("do1");
		
		Assert.assertNull(result);
	}

}
