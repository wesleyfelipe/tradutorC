package br.unisinos.tradutores.analisadorlexico;

import org.junit.Assert;
import org.junit.Test;

public class AnalisadorLexicoTest {

	@Test
	public void removeComentarios(){
		
		String code1 = "int i = 0;/** comentario */";
		String experado = "int i = 0;";
		String result1 = AnalisadorLexico.removerComentarios(code1);
		
		String code2 = "int i = 0;/** \ncomentario int i = 2; \n */";
		String result2 = AnalisadorLexico.removerComentarios(code2);
		
		String code3 = "int i = 0;//comentario";
		String result3 = AnalisadorLexico.removerComentarios(code3);
		
		String code4 = "int i = 0;//comentario \n int j = 0;";
		String experado4 = "int i = 0;\n int j = 0;";
		String result4 = AnalisadorLexico.removerComentarios(code4);
		
		String code5 = "int i = 0;/** \ncomentario int i = 2; \n */ int j = 0;";
		String experado5 = "int i = 0; int j = 0;";
		String result5 = AnalisadorLexico.removerComentarios(code5);
		
		Assert.assertEquals(experado, result1);
		Assert.assertEquals(experado, result2);
		Assert.assertEquals(experado, result3);
		Assert.assertEquals(experado4, result4);
		Assert.assertEquals(experado5, result5);
	}
	
	
}
