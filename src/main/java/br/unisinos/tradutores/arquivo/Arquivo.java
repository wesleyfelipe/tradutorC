/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.tradutores.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rudim
 */
public class Arquivo {
    
public static String lerArquivo(String caminho)    {
    String arquivo="";
    try {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        while(br.ready()){
            String linha = br.readLine();
            arquivo +=linha+"\r\n";
        }
        br.close();
        return arquivo;
    } catch (IOException ex) {
        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        return arquivo;
    }
}
    
}
