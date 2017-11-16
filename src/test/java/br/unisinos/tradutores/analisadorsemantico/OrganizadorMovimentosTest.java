package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class OrganizadorMovimentosTest {
	
	@Test
	public void ordenarMovimentos1(){
		
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		List<Movimento> result  = OrganizadorMovimentos.ordenarMovimentos(tokens);
		
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

		List<Movimento> result  = OrganizadorMovimentos.ordenarMovimentos(tokens);
		
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

		List<Movimento> result  = OrganizadorMovimentos.ordenarMovimentos(tokens);
		
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

		List<Movimento> result  = OrganizadorMovimentos.ordenarMovimentos(tokens);
		
		Assert.assertEquals(expected, result);
		
	}

}
