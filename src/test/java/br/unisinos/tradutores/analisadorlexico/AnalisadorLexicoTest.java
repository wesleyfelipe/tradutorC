package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class AnalisadorLexicoTest {

	
	@Test
	public void analisar1(){
		String code = "FRENTE 10 ENTAO ESQUERDA 20";
		
		List<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		expected.add(new Token(TipoToken.NUMBER, "10"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		expected.add(new Token(TipoToken.NUMBER, "20"));
		
		
		List<Token> result = new AnalisadorLexico().analisar(code);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void analisar2(){
		String code = "DIREITA 30 APOS ESQUERDA 20 \n\t";
		
		List<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		expected.add(new Token(TipoToken.NUMBER, "30"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		expected.add(new Token(TipoToken.NUMBER, "20"));
		
		List<Token> result = new AnalisadorLexico().analisar(code);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void analisar3(){
		String code = "(DIREITA 30) APOS ESQUERDA 20 \n\t";
		
		List<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TipoToken.L_PAREN, "("));
		expected.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		expected.add(new Token(TipoToken.NUMBER, "30"));
		expected.add(new Token(TipoToken.R_PAREN, ")"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		expected.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		expected.add(new Token(TipoToken.NUMBER, "20"));
		
		List<Token> result = new AnalisadorLexico().analisar(code);
		
		Assert.assertEquals(expected, result);
	}
		
}
