package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorReservedWordTest {

	@Test
	public void verify_true(){
		Token expected = new Token(TipoToken.RESERVED_WORD, "while");
		
		Token result = IdentificadorReservedWord.verify("while");
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void verify_false() {
		
		Token result = IdentificadorReservedWord.verify("do1");
		
		Assert.assertNull(result);
	}
}
