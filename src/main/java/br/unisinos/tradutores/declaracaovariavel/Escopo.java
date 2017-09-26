/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.declaracaovariavel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudim
 */
public class Escopo {

    private Escopo escopoPai;
    private List<Declaracao> declaracoes;
    private List<Escopo> escoposFilhos;

    public Escopo(Escopo pai) {
        this.escopoPai = pai;
        this.declaracoes = new ArrayList<>();
        this.escoposFilhos = new ArrayList<>();
    }

    public Escopo getEscopoPai() {
        return escopoPai;
    }

    public List<Declaracao> getDeclaracoes() {
        return declaracoes;
    }

    public List<Escopo> getEscoposFilhos() {
        return escoposFilhos;
    }

    public void addDeclaracao(Declaracao d) {
        this.declaracoes.add(d);
    }

    public int findDeclaracao(Integer identificador) {
        if (this.declaracoes.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < this.declaracoes.size(); i++) {
                if (this.declaracoes.get(i).getId() == identificador) {
                    return i;
                }
            }
            return -1;
        }
    }

    public void addEscopoFilho(Escopo filho) {
        this.escoposFilhos.add(filho);
    }

    public int getNextId() {
        return this.declaracoes.size();
    }

    public Declaracao getDeclaracao(Escopo escopo, Object valor) {
        if (escopo == null) {
            return null;
        }
        for (int i = 0; i < escopo.declaracoes.size(); i++) {
            if (escopo.declaracoes.get(i).getValor().equals(valor) || escopo.declaracoes.get(i).getValor().equals("&"+valor)) {
                return escopo.declaracoes.get(i);
            }
        }
        return getDeclaracao(escopo.getEscopoPai(),valor);
    }
}
