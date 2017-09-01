package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IndetificadorStringTest {

	@Test
	public void verify_true(){
		String lexema = "\"teste\"";
		Token expected = new Token(TipoToken.LITERAL_STRING, lexema);
		
		Token result = IndetificadorString.verify(lexema);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void verify_false(){
		String lexema1 = "teste\"";
		Token result1 = IndetificadorString.verify(lexema1);
		
		String lexema2 = "\"teste";
		Token result2 = IndetificadorString.verify(lexema2);
		
		Assert.assertNull(result1);
		Assert.assertNull(result2);
	}
}
