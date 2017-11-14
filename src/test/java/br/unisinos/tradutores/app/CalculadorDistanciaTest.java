package br.unisinos.tradutores.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;

public class CalculadorDistanciaTest {
	
	@Test
	public void calcular1(){
		List<Movimento> movimentos = new ArrayList<>();
		Double expected = 0.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular2(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.DIREITA, 10.0));
		movimentos.add(new Movimento(Direcoes.FRENTE, 20.0));
		
		Double expected = 30.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular3(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.FRENTE, 10.0));
		movimentos.add(new Movimento(Direcoes.FRENTE, 20.0));
		
		Double expected = 30.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular4(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 10.0));
		movimentos.add(new Movimento(Direcoes.TRAS, 10.0));
		
		Double expected = 0.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular5(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		
		Double expected = 100.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular6(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		
		Double expected = 141.42;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular7(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));
		movimentos.add(new Movimento(Direcoes.TRAS, 150.0));
		
		Double expected = -50.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular8(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		
		Double expected = 141.42;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular9(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		
		Double expected = 141.42;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular10(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		
		Double expected = 200.0;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular11(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		
		Double expected = 223.6068;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular12(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));
		
		Double expected = 223.6068;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular13(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.FRENTE, 300.0));
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		
		Double expected = 316.22777;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular14(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.TRAS, 700.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
		movimentos.add(new Movimento(Direcoes.TRAS, 200.0));
		
		Double expected = 509.90195;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void calcular15(){
		List<Movimento> movimentos = new ArrayList<>();
		movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 700.0));
		movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
		movimentos.add(new Movimento(Direcoes.DIREITA, 200.0));
		
		Double expected = 900.00;
		
		Double result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		Assert.assertEquals(expected, result);
	}

}
