package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

}
