/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.analisadorlexico;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
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
        this.declaracoes = new ArrayList();
        this.escoposFilhos = new ArrayList();
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

    public void addDeclaracao(Integer identificador, Integer id, Object valor, Token tokenAnterior) {
        Declaracao d = new Declaracao(identificador, id, valor);
        if (tokenAnterior.getValor().equals("float") || tokenAnterior.getValor().equals("int")
                || tokenAnterior.getValor().equals("char") || tokenAnterior.getValor().equals("string")
                || tokenAnterior.getValor().equals("bool") || tokenAnterior.getTipo().equals(TipoToken.COMMA)) {
            this.declaracoes.add(d);
        }
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

    public Declaracao getDeclaracao(Integer identificador) {
        for(int i=0;i<this.escoposFilhos.size();i++){
            Escopo current = current.getEscopoPai();
            if (current.findDeclaracao(identificador) != -1) {
                return current.declaracoes.get(current.findDeclaracao(identificador));
            } else {

            }
        }
    }

    public void addEscopoFilho(Escopo filho) {
        this.escoposFilhos.add(filho);
    }

}
