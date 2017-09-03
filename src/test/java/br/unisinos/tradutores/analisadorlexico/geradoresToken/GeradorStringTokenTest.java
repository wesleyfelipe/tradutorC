package br.unisinos.tradutores.analisadorlexico.geradoresToken;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.geradorestoken.GeradorStringToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class GeradorStringTokenTest {

	@Test
	public void verify_true(){
		String lexema = "\"teste\"";
		Token expected = new Token(TipoToken.LITERAL_STRING, lexema);
		GeracaoTokenTo to = new GeracaoTokenTo(expected);
		
		GeracaoTokenTo result = GeradorStringToken.verify(lexema);
		
		Assert.assertEquals(to, result);
	}
	
	@Test
	public void verify_false(){
		String lexema1 = "teste\"";
		GeracaoTokenTo result1 = GeradorStringToken.verify(lexema1);
		
		String lexema2 = "\"teste";
		GeracaoTokenTo result2 = GeradorStringToken.verify(lexema2);
		
		Assert.assertNull(result1);
		Assert.assertNull(result2);
	}
}
