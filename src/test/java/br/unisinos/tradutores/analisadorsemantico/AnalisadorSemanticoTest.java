package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class AnalisadorSemanticoTest {
	
	@Test
	public void analisar1() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		
		List<Movimento> movimentos = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertTrue(movimentos.isEmpty());
		
	}

	@Test
	public void analisar2() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 20.0));
		
		List<Movimento> results = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertEquals(expected, results);
		
	}
	
	@Test
	public void analisar3() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		
		List<Movimento> results = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertEquals(expected, results);
		
	}
	
	@Test
	public void analisar4() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		
		List<Movimento> results = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertEquals(expected, results);
		
	}
	
	@Test
	public void analisar5() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "30"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "40"));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 20.0));
		expected.add(new Movimento(Direcoes.FRENTE, 30.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 40.0));
		
		List<Movimento> results = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertEquals(expected, results);
	}
	
public void analisar6() throws Exception{
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "30"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "40"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 20.0));
		expected.add(new Movimento(Direcoes.FRENTE, 30.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 40.0));
		
		List<Movimento> results = new AnalisadorSemantico().analisar(tokens);
		
		Assert.assertEquals(expected, results);
		
	}
}
