package br.unisinos.tradutores.analisadorlexico.separadores;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.separadores.SeparadorLexemas;

public class SeparadorLexemasTest {
	
	@Test
	public void isSeparador_true(){
		
		Assert.assertTrue(SeparadorLexemas.isSeparador(";"));
		Assert.assertTrue(SeparadorLexemas.isSeparador("\""));
		Assert.assertTrue(SeparadorLexemas.isSeparador(":"));
	}
	
	@Test
	public void isSeparador_false(){
		
		Assert.assertFalse(SeparadorLexemas.isSeparador("a"));
		Assert.assertFalse(SeparadorLexemas.isSeparador("8"));
		Assert.assertFalse(SeparadorLexemas.isSeparador(">"));
	}
	
	@Test
	public void separarLexemas1(){
		String code = "int  = 0;";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("int");
		lexemas.add("=");
		lexemas.add("0");
		lexemas.add(";");
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
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
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
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
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
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
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas5(){
		String code = "String palavra = \"meu \n texto\"; ";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("String");
		lexemas.add("palavra");
		lexemas.add("=");
		lexemas.add("\"meu \n texto\"");
		lexemas.add(";");
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas6(){
		String code = "switch(a):\t\ncase 1:\nb = 0;\ndefault:\nb=8; ";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("switch");
		lexemas.add("(");
		lexemas.add("a");
		lexemas.add(")");
		lexemas.add(":");
		lexemas.add("case");
		lexemas.add("1");
		lexemas.add(":");
		lexemas.add("b");
		lexemas.add("=");
		lexemas.add("0");
		lexemas.add(";");
		lexemas.add("default");
		lexemas.add(":");
		lexemas.add("b");
		lexemas.add("=");
		lexemas.add("8");
		lexemas.add(";");
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas7_stringInvalida(){
		String code = "String palavra = \"meu \n texto; ";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("String");
		lexemas.add("palavra");
		lexemas.add("=");
		lexemas.add("\"meu \n texto; ");
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}
	
	@Test
	public void separarLexemas8(){
		String code = "char letra = 'a'; ";
		
		List<String> lexemas = new ArrayList<String>();
		lexemas.add("char");
		lexemas.add("letra");
		lexemas.add("=");
		lexemas.add("'a'");
		lexemas.add(";");
		
		List<String> resultList = SeparadorLexemas.separarLexemas(code);
		
		Assert.assertEquals(lexemas, resultList);
		
	}

}
