package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void isSeparador_true(){
		
		Assert.assertTrue(AnalisadorLexico.isSeparador(";"));
		Assert.assertTrue(AnalisadorLexico.isSeparador("\""));
		Assert.assertTrue(AnalisadorLexico.isSeparador(":"));
	}
	
	@Test
	public void isSeparador_false(){
		
		Assert.assertFalse(AnalisadorLexico.isSeparador("a"));
		Assert.assertFalse(AnalisadorLexico.isSeparador("8"));
		Assert.assertFalse(AnalisadorLexico.isSeparador(">"));
	}
	
	@Test
	public void separarLexemas1(){
		String code = "int  = 0;";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("int");
		lexemas.add("=");
		lexemas.add("0");
		lexemas.add(";");
		
		List<String> resultList = AnalisadorLexico.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas2(){
		String code = "int=0;";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("int");
		lexemas.add("=");
		lexemas.add("0");
		lexemas.add(";");
		
		List<String> resultList = AnalisadorLexico.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas3(){
		String code = "int i =0;\n if(true){i= 1}";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("int");
		lexemas.add("i");
		lexemas.add("=");
		lexemas.add("0");
		lexemas.add(";");
		lexemas.add("if");
		lexemas.add("(");
		lexemas.add("true");
		lexemas.add(")");
		lexemas.add("{");
		lexemas.add("i");
		lexemas.add("=");
		lexemas.add("1");
		lexemas.add("}");
		
		List<String> resultList = AnalisadorLexico.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas4(){
		String code = "String palavra = \"meu texto\"; ";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("String");
		lexemas.add("palavra");
		lexemas.add("=");
		lexemas.add("\"meu texto\"");
		lexemas.add(";");
		
		List<String> resultList = AnalisadorLexico.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
}
