/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.declaracaovariavel;

/**
 *
 * @author rudim
 */
public class Declaracao {
    private Integer identificador;
    private Integer id;
    private Object valor;

    public Declaracao(Integer identificador, Integer id, Object valor) {
        this.identificador = identificador;
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
}
