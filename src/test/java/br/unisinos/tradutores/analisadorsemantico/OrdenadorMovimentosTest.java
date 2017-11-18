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
	public void getMovimentos1(){
		GrupoMovimentosTO grupo = new GrupoMovimentosTO();
		grupo.addMovimento(new Movimento(Direcoes.DIREITA, 10.0));
		grupo.addMovimento(new Movimento(Direcoes.ESQUERDA, 10.0));
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 10.0));
		
		List<Movimento> result = new OrdenadorMovimentos().getMovimentos(grupo);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void getMovimentos2(){
		GrupoMovimentosTO grupo = new GrupoMovimentosTO();
		grupo.addMovimento(new Movimento(Direcoes.DIREITA, 10.0));
		
		GrupoMovimentosTO grupo1 = new GrupoMovimentosTO();
		grupo1.addMovimento(new Movimento(Direcoes.ESQUERDA, 10.0));
		
		grupo.addGrupoFilho(grupo1);
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 10.0));
		
		List<Movimento> result = new OrdenadorMovimentos().getMovimentos(grupo);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void getMovimentos3(){
		GrupoMovimentosTO grupo = new GrupoMovimentosTO();
		grupo.addMovimento(new Movimento(Direcoes.DIREITA, 10.0));
		
		GrupoMovimentosTO grupo1 = new GrupoMovimentosTO();
		grupo1.addMovimento(new Movimento(Direcoes.ESQUERDA, 10.0));
		
		GrupoMovimentosTO grupo2 = new GrupoMovimentosTO();
		grupo2.addMovimento(new Movimento(Direcoes.FRENTE, 10.0));
		
		GrupoMovimentosTO grupo3 = new GrupoMovimentosTO();
		grupo3.addMovimento(new Movimento(Direcoes.TRAS, 10.0));
		grupo1.addGrupoFilho(grupo3);
		
		grupo.addGrupoFilho(grupo1);
		grupo.addGrupoFilho(grupo2);
		
		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.DIREITA, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 10.0));
		expected.add(new Movimento(Direcoes.TRAS, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		
		List<Movimento> result = new OrdenadorMovimentos().getMovimentos(grupo);
		
		Assert.assertEquals(expected, result);
	}

}
