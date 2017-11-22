package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Direcoes;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class OrdenadorMovimentos {

    private Integer index = 0;

    private List<Token> tokens;

    private List<Movimento> movimentos = new ArrayList<>();

    private Boolean avancar() {
        if (this.index + 1 >= tokens.size()) {
            return Boolean.FALSE;
        }

        this.index++;
        return Boolean.TRUE;
    }

    private Token getTokenAtual() {
        return this.tokens.get(this.index);
    }

    private Token getProximoToken() {
        return (this.index + 1 >= this.tokens.size()) ? null : this.tokens.get(this.index + 1);
    }

    public List<Movimento> ordenarMovimentos(List<Token> tokens) {

        this.index = 0;
        this.tokens = tokens;
        
        return ordenarMovimentos();

    }

    private Movimento buildMovimento(Direcoes direcao) {
        avancar();

        Double distancia = Double.valueOf(getTokenAtual().getValor().toString());
        return new Movimento(direcao, distancia);

    }

    private List<Movimento> ordenarMovimentos() {

        Direcoes direcao = Direcoes.isDirecao(getTokenAtual());

        if (direcao != null) {

            Movimento movimento = buildMovimento(direcao);

            Token temp = getProximoToken();
            if (temp != null && "APOS".equals(temp.getValor())) {
                avancar();
                ordenarMovimentos();
            }

            movimentos.add(movimento);

        }
        if (avancar()) {
            return ordenarMovimentos();
        }

        return movimentos;
    }
}
