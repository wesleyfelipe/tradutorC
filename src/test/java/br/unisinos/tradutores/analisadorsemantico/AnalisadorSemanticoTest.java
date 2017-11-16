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
	public void analisar1() throws Exception {

		List<Token> tokens = new ArrayList<Token>();

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test
	public void analisar2() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 20.0));

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test
	public void analisar3() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test
	public void analisar4() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test
	public void analisar5() throws Exception {

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

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);
	}

	@Test
	public void analisar6() {

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

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);
	}

	@Test
	public void analisar7() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "30"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ENTAO"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "40"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));
		expected.add(new Movimento(Direcoes.FRENTE, 30.0));
		expected.add(new Movimento(Direcoes.ESQUERDA, 40.0));

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test
	public void analisar8() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));

		List<Movimento> expected = new ArrayList<>();
		expected.add(new Movimento(Direcoes.ESQUERDA, 20.0));
		expected.add(new Movimento(Direcoes.FRENTE, 10.0));

		Exception ex = null;
		try {
			new AnalisadorSemantico().analisar(tokens);
		} catch (Exception e) {
			ex = e;
		}
		Assert.assertNull(ex);

	}

	@Test(expected = Exception.class)
	public void analisar9() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		
		new AnalisadorSemantico().analisar(tokens);

	}
	
	@Test(expected = Exception.class)
	public void analisar10() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.NUMBER, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		
		new AnalisadorSemantico().analisar(tokens);

	}
	
	@Test(expected = Exception.class)
	public void analisar11() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.L_PAREN, "("));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.NEW_LINE, "\n"));
		tokens.add(new Token(TipoToken.R_PAREN, ")"));
		
		new AnalisadorSemantico().analisar(tokens);

	}
	
	@Test(expected = Exception.class)
	public void analisar12() throws Exception {

		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(TipoToken.RESERVED_WORD, "FRENTE"));
		tokens.add(new Token(TipoToken.NUMBER, "10"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "APOS"));
		tokens.add(new Token(TipoToken.RESERVED_WORD, "ESQUERDA"));
		tokens.add(new Token(TipoToken.NEW_LINE, "\n"));
		tokens.add(new Token(TipoToken.NUMBER, "20"));
		
		new AnalisadorSemantico().analisar(tokens);

	}
}
