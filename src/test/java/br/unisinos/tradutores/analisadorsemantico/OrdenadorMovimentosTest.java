package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class OrdenadorMovimentosTest {
	
	@Test
	public void ordenarMovimentos1(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos2(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.NEW_LINE, "\n"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos3(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos4(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos5(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "TRAS"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos6(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "TRAS"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		

		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos7(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "TRAS"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		
		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos8(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "TRAS"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		
		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void ordenarMovimentos9(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "DIREITA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "TRAS"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		
		List<Movimento> result  = new OrdenadorMovimentos().ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}
}
