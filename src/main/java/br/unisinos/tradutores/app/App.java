package br.unisinos.tradutores.app;

import java.util.List;

import br.unisinos.tradutores.analisadorlexico.AnalisadorLexico;
import br.unisinos.tradutores.analisadorsemantico.AnalisadorSemantico;
import br.unisinos.tradutores.arquivo.Arquivo;
import br.unisinos.tradutores.domain.Coordenada;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.Token;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) throws Exception {
        
        //Leitura do arquivo
        String sourceFile = "./src/main/resources/Teste.c";
        String code = Arquivo.lerArquivo(sourceFile);

        //Análise sintática
        List<Token> tokens = new AnalisadorLexico().analisar(code);
        printTokenList(tokens);

        //Análise semantica e extração dos movimentos em ordem de execução
        List<Movimento> movimentos = new AnalisadorSemantico().analisar(tokens);
        
        
        //Cálculo da distância percorrida
        Coordenada coordenada = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
        System.out.println("===============================================");
        System.out.println("Distância percorrida: " + coordenada.getDistancia());
        System.out.println("Coordenada X: " + coordenada.getX());
        System.out.println("Coordenada Y: " + coordenada.getY());
        
        PlanoCartesiano plano = new PlanoCartesiano(movimentos);
        JFrame f = new JFrame();
        f.getContentPane().add(plano);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 700);
        f.setVisible(true);
        

    }

    public static void printTokenList(List<Token> tokens) {
        System.out.println("======= Lista de Tokens Identificados ========");
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.getValor().toString().equals("\n") || token.getValor().toString().equals("\r")) {
                System.out.println("Token [" + i + "]: [" + token.getTipo() + ", \\n]");
            } else {
                System.out.println("Token [" + i + "]: [" + token.getTipo() + "," + token.getValor() + "]");

            }
        }

    }
}
