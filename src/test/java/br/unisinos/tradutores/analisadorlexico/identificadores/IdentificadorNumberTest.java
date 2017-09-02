package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorNumberTest {
	
	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.NUMBER, "1");
		
		Token result = IdentificadorNumber.verify("1");
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void verify_false() {
		
		Token result = IdentificadorNumber.verify("do1");
		
		Assert.assertNull(result);
	}

}
