package br.unisinos.tradutores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class AnalisadorSemantico {

	public List<Movimento> analisar(List<Token> tokens) throws Exception {
		
		if (tokens == null || tokens.isEmpty())
			return new ArrayList<>();
		
		Integer linha = 1;
		List<Exception> errosEncontrados = new ArrayList<>();
		List<Movimento> movimentos = new ArrayList<>();
		List<Token> tokensLinha = new ArrayList<>();
		
		for (Token token : tokens) {
			if(TipoToken.NEW_LINE.equals(token.getTipo())){
				
				try{
					movimentos.addAll(new AnalisadorSemanticoLinha().analisar(tokensLinha, linha));
				} catch (Exception e) {
					errosEncontrados.add(e);
				}
				
				linha++;
				tokensLinha = new ArrayList<>();
				
			} else {
				tokensLinha.add(token);
			}
		}
		
		if(!tokensLinha.isEmpty()){
			try{
				movimentos.addAll(new AnalisadorSemanticoLinha().analisar(tokensLinha, linha));
			} catch (Exception e) {
				errosEncontrados.add(e);
			}
		}
		
		if(errosEncontrados.isEmpty())
			return movimentos;
		
		throw new Exception(comporMensagemErro(errosEncontrados));
	}
 
	
	protected String comporMensagemErro(List<Exception> erros){
		StringBuilder sb = new StringBuilder("Erros encontrados: \n");
		
		for (Exception err : erros) {
			sb.append(err.getMessage());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
