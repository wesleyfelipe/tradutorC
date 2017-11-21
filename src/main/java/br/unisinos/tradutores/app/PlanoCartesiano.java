/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.app;

import br.unisinos.tradutores.analisadorsemantico.AnalisadorSemantico;
import br.unisinos.tradutores.domain.Movimento;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

/**
 * @author Ronald Tetsuo Miura
 */
public class PlanoCartesiano extends JComponent {

    List<Movimento> movimentos;

    public PlanoCartesiano(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    private static final BasicStroke STROKE_FINO = new BasicStroke(0.1f);

    /**
     * @param g1 -
     */
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Dimension size = getSize();
        Double width = 1000.0;
        Double height = 1000.0;

        int metadeWidth = width.intValue() / 2;
        int metadeHeight = height.intValue() / 2;

        //transforma a tela num plano cartesiano 1000x1000 com a origem no centro  
        //faz com que a imagem seja distorcida proporcionalmente ao redimensionamento da janela  
        g.scale(size.width / width, size.height / height);
        g.translate(metadeWidth, metadeHeight);
        g.scale(1, -1);

        //opcoes do traço  
        g.setStroke(STROKE_FINO);
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //as coordenadas não são mais em pixels, mas relativas ao plano cartesiano definido acima  
        g.draw(new Line2D.Double(-1000.0, 0.0, 1000.0, 0.0));
        g.draw(new Line2D.Double(0.0, -1000.0, 0.0, 1000.0));
        g.setColor(Color.GREEN);
        g.fill(new Rectangle(-5, -5, 10, 10));
        g.setColor(Color.RED);
//        g.fill(new Rectangle(this.x-5, this.y-5, 10, 10));
        Font font = new Font("Arial", 0, 20);
        g.setFont(font);

        int cameraX = 0;
        int cameraY = 1;

        Double total = 0.0;

        Double x = 0.0;
        Double y = 0.0;
        Double oldX = 0.0;
        Double oldY = 0.0;

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
            oldX = x;
            oldY = y;
            x += cameraX * distanciaAtual;
            y += cameraY * distanciaAtual;

            g.drawLine(oldX.intValue(), oldY.intValue(), x.intValue(), y.intValue());

        }

//        AffineTransform affineTransform = new AffineTransform();
//        affineTransform.rotate(0, 0, 0);
//        Font rotatedFont = font.deriveFont(affineTransform);
//        g.setFont(rotatedFont);
//        g.drawString("X "+cameraX, 0, 100);
//        g.drawString("Y "+cameraY, 0, 200);
//        g.dispose();
//            /* frente */
            if (cameraY==1 && cameraX==0) {
                g.drawString("▼", x.intValue()-10, y.intValue()+10);
            }
//            /* tras */
            if (cameraY==-1 && cameraX==0) {
                g.drawString("▲", x.intValue()-10, y.intValue()+10);
            }
//            /* esquerda */
            if (cameraY==0 && cameraX==-1) {
                g.drawString("◄", x.intValue()-10, y.intValue()+7);
            }
//            /* direita */
            if (cameraY==0 && cameraX==1) {
                g.drawString("►", x.intValue()-10, y.intValue()+7);
            }
    }

}
