package br.unisinos.tradutores.app;

import java.util.List;

import br.unisinos.tradutores.domain.Coordenada;
import br.unisinos.tradutores.domain.Movimento;

public class CalculadorDistancia {

	public static Coordenada calcularDistanciaPercorrida(List<Movimento> movimentos) {
		int cameraX = 0;
		int cameraY = 1;
		
		Double total = 0.0;
		
		Double x = 0.0;
		Double y = 0.0;
		
		Double distanciaAtual = 0.0;
		
		for (int i = 0; i < movimentos.size(); i++) {
			distanciaAtual = movimentos.get(i).getDistancia();
			total += distanciaAtual;
			switch (movimentos.get(i).getDirecao().toString()) {
			case "FRENTE":
				break;

			case "TRAS":
				cameraX = cameraX * (-1);
				cameraY = cameraY * (-1);
				break;

			case "ESQUERDA":
				int temp = (-1) * cameraY;
				cameraY = cameraX;
				cameraX = temp;
				break;

			case "DIREITA":
				int temp2 = (-1) * cameraX;
				cameraX = cameraY;
				cameraY = temp2;
				break;

			default:
				break;

			}

			x += cameraX * distanciaAtual;
			y += cameraY * distanciaAtual;
		}
		return new Coordenada(x, y, total);
	}

}
