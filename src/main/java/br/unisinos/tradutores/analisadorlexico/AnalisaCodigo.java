/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.analisadorlexico;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import static br.unisinos.tradutores.arquivo.Arquivo.lerArquivo;

/**
 *
 * @author rudim
 */
public class AnalisaCodigo {

    private String code;
    private List<Token> tokens;
    private Integer id = 0;
    private Escopo escopo;

    public AnalisaCodigo(String caminhoArquivo) {
        this.code = lerArquivo(caminhoArquivo);
        this.escopo = new Escopo(null);
        AnalisadorLexico al = new AnalisadorLexico();
        this.tokens = al.analisar(this.code);
        this.corrigeCodigo();
        this.printTokenList();
    }

    public void corrigeCodigo() {
        if (tokens.isEmpty()) {
            System.out.println("Lista de tokens esta vazia!");
        } else {
            Escopo currentEscopo = this.escopo;
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                if (token.getTipo().equals(TipoToken.L_BRACKET)) {
                    Escopo filho= new Escopo(currentEscopo);
                    currentEscopo.addEscopoFilho(currentEscopo);
                    currentEscopo=filho;
                } else if (token.getTipo().equals(TipoToken.R_BRACKET)) {
                    currentEscopo=currentEscopo.getEscopoPai();
                } else if (token.getTipo().equals(TipoToken.ID)) {
                    currentEscopo.addDeclaracao(i, id, token.getValor(), this.tokens.get((i - 1)));
                    this.id++;
                }
            }
        }
    }

    public void printTokenList() {
        System.out.println("======= Lista de Tokens Identificados ========");
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.getTipo().equals(TipoToken.ID)) {
                Declaracao d = this.escopo.getDeclaracao(i);
                System.out.println("Token [" + i + "]: [" + token.getTipo() + "," + d.getId() + "]");
            } else {
                System.out.println("Token [" + i + "]: [" + token.getTipo() + "," + token.getValor() + "]");
            }
        }

    }

}
