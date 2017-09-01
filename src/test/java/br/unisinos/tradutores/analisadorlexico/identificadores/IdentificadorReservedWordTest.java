package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.identificadores.IndetificadorReservedWord;

public class IdentificadorReservedWordTest {


	@Test
	public void isWhileWord_true() {
		
		Boolean result = IndetificadorReservedWord.isWhileWord("while");
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void isWhileWord_false() {
		
		Boolean result = IndetificadorReservedWord.isWhileWord("do");
		
		Assert.assertFalse(result);
	}
}
