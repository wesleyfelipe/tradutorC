package br.unisinos.tradutores.app;

import br.unisinos.tradutores.domain.Coordenada;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;

public class CalculadorDistanciaTest {

    @Test
    public void calcular1() {
        List<Movimento> movimentos = new ArrayList<>();

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(0.0), result.getDistancia());
        Assert.assertEquals(new Double(0.0), result.getX());
        Assert.assertEquals(new Double(0.0), result.getY());
    }

    @Test
    public void calcular2() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.DIREITA, 10.0));
        movimentos.add(new Movimento(Direcoes.FRENTE, 20.0));

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(30.0), result.getDistancia());
        Assert.assertEquals(new Double(30.0), result.getX());
        Assert.assertEquals(new Double(0.0), result.getY());
    }

    @Test
    public void calcular3() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.FRENTE, 10.0));
        movimentos.add(new Movimento(Direcoes.FRENTE, 20.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(30.0), result.getDistancia());
        Assert.assertEquals(new Double(0.0), result.getX());
        Assert.assertEquals(new Double(30.0), result.getY());
    }

    @Test
    public void calcular4() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 10.0));
        movimentos.add(new Movimento(Direcoes.TRAS, 10.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(20.0), result.getDistancia());
        Assert.assertEquals(new Double(0.0), result.getX());
        Assert.assertEquals(new Double(0.0), result.getY());
    }

    @Test
    public void calcular5() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(100.0), result.getDistancia());
        Assert.assertEquals(new Double(-100.0), result.getX());
        Assert.assertEquals(new Double(0.0), result.getY());
    }

    @Test
    public void calcular6() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(200.0), result.getDistancia());
        Assert.assertEquals(new Double(-100.0), result.getX());
        Assert.assertEquals(new Double(100.0), result.getY());
    }

    @Test
    public void calcular7() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));
        movimentos.add(new Movimento(Direcoes.TRAS, 150.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(250.0), result.getDistancia());
        Assert.assertEquals(new Double(0.0), result.getX());
        Assert.assertEquals(new Double(-50.0), result.getY());

    }

    @Test
    public void calcular8() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(200.0), result.getDistancia());
        Assert.assertEquals(new Double(100.0), result.getX());
        Assert.assertEquals(new Double(100.0), result.getY());
    }

    @Test
    public void calcular9() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(200.0), result.getDistancia());
        Assert.assertEquals(new Double(100.0), result.getX());
        Assert.assertEquals(new Double(-100.0), result.getY());
    }

    @Test
    public void calcular10() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(400.0), result.getDistancia());
        Assert.assertEquals(new Double(0.0), result.getX());
        Assert.assertEquals(new Double(-200.0), result.getY());
    }

    @Test
    public void calcular11() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(300.0), result.getDistancia());
        Assert.assertEquals(new Double(100.0), result.getX());
        Assert.assertEquals(new Double(-200.0), result.getY());
    }

    @Test
    public void calcular12() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        movimentos.add(new Movimento(Direcoes.FRENTE, 100.0));

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(300.0), result.getDistancia());
        Assert.assertEquals(new Double(200.0), result.getX());
        Assert.assertEquals(new Double(-100.0), result.getY());
    }

    @Test
    public void calcular13() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.FRENTE, 300.0));
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(600.0), result.getDistancia());
        Assert.assertEquals(new Double(-100.0), result.getX());
        Assert.assertEquals(new Double(-300.0), result.getY());
    }

    @Test
    public void calcular14() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.TRAS, 700.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 100.0));
        movimentos.add(new Movimento(Direcoes.TRAS, 200.0));

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(1100.0), result.getDistancia());
        Assert.assertEquals(new Double(-100.0), result.getX());
        Assert.assertEquals(new Double(600.0), result.getY());
    }

    @Test
    public void calcular15() {
        List<Movimento> movimentos = new ArrayList<>();
        movimentos.add(new Movimento(Direcoes.TRAS, 100.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 700.0));
        movimentos.add(new Movimento(Direcoes.ESQUERDA, 100.0));
        movimentos.add(new Movimento(Direcoes.DIREITA, 200.0));

        Coordenada result = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        Assert.assertEquals(new Double(1100.0), result.getDistancia());
        Assert.assertEquals(new Double(900.0), result.getX());
        Assert.assertEquals(new Double(0.0), result.getY());
    }
}
