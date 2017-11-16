/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.domain;

/**
 *
 * @author rudim
 */
public class Coordenada {

private Double x;    
private Double y;    
private Double distancia;

    public Coordenada(Double x, Double y, Double distancia) {
        this.x = x;
        this.y = y;
        this.distancia = distancia;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }



}
