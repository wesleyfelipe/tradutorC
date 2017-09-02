package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

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
	
	@Test
	public void analisar1(){
		String code = "int i = 0;";
		
		List<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TipoToken.RESERVED_WORD, "int"));
		expected.add(new Token(TipoToken.ID, "i"));
		expected.add(new Token(TipoToken.EQUAL_OP, "="));
		expected.add(new Token(TipoToken.NUMBER, "0"));
		expected.add(new Token(TipoToken.SEMICOLON, ";"));
		
		
		List<Token> result = AnalisadorLexico.analisar(code);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void analisar2(){
		String code = "int calcular()\n{ return 1 + 1; \n\t}";
		
		List<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TipoToken.RESERVED_WORD, "int"));
		expected.add(new Token(TipoToken.FUNCTION, "calcular"));
		expected.add(new Token(TipoToken.L_PAREN, "("));
		expected.add(new Token(TipoToken.R_PAREN, ")"));
		expected.add(new Token(TipoToken.L_BRACKET, "{"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "return"));
		expected.add(new Token(TipoToken.NUMBER, "1"));
		expected.add(new Token(TipoToken.ARITHMETICAL_OP, "+"));
		expected.add(new Token(TipoToken.NUMBER, "1"));
		expected.add(new Token(TipoToken.SEMICOLON, ";"));
		expected.add(new Token(TipoToken.R_BRACKET, "}"));
		
		List<Token> result = AnalisadorLexico.analisar(code);
		
		Assert.assertEquals(expected, result);
		
	}
	
	
}
