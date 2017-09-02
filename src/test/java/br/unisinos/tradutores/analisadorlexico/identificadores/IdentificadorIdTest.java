package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorIdTest {

	@Test
	public void verify_true(){
		String lexema = "abcg";
		Token expected = new Token(TipoToken.ID, lexema);
		
		Token result = IdentificadorId.verify(lexema);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void verify_false(){
		String lexema1 = "teste(";
		Token result1 = IdentificadorId.verify(lexema1);
		
		String lexema2 = "1gtr";
		Token result2 = IdentificadorId.verify(lexema2);
		
		String lexema3 = "gtr()";
		Token result3 = IdentificadorId.verify(lexema3);
		
		String lexema4 = ";";
		Token result4 = IdentificadorId.verify(lexema4);
		
		Assert.assertNull(result1);
		Assert.assertNull(result2);
		Assert.assertNull(result3);
		Assert.assertNull(result4);
	}
}
