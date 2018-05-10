/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boniolo
 */
public class Estrela {
    List<List<Nodo>> grafo;
    
    public Estrela(List<List<Nodo>> grafo){
        this.grafo = grafo;
    }

    public List<List<Nodo>> getGrafo() {
        return grafo;
    }
    
    
    
    public List<String> busca(){
        List<Nodo> aberta = new ArrayList<>();
        List<Nodo> fechada = new ArrayList<>();
        List<String> caminho = new ArrayList<>();
        
        
        Nodo inicial = this.grafo.get(0).get(0);
        Nodo destino = this.grafo.get(9).get(9);
        
        aberta.add(inicial);
        
        
        Nodo atual = aberta.get(0);
        
        while (true){
            
            if(atual.getId().equals("9x9")){//destino)){
                
                System.out.println("");
                System.out.println("");
                System.out.println("");

               
               while(true){
                    //System.out.println(atual.getValor());
                    caminho.add(atual.getId());
                    atual = atual.getPai();
                    
                    if(atual.getId().equals("0x0")){
                        Collections.reverse(caminho);
                        aberta = new ArrayList<>();
                        fechada = new ArrayList<>();
                        atual = grafo.get(0).get(0);
                        
                        
                        for(int i = 0; i < 10; i++){
                            for(int j = 0; j < 10; j++){
                                System.out.print(grafo.get(i).get(j).getCusto()+" ");
                            }
                            System.out.println("");
                        }
                        
                        caminho.forEach((x)->{System.out.println(x);});
                        
                        return caminho;
                    }
                }
           }
            
         
            for(Nodo x : atual.getFilhos()){
                if(fechada.contains(x))
                    continue;
                
                x.setPai(atual);
                x.setValor(x.getCusto() + atual.getValor());
                aberta.add(x);
            }
            
            fechada.add(atual);
            aberta.remove(atual);
            //System.out.println(aberta.get(0).getId());
            Collections.sort(aberta);
            atual = aberta.get(0);
            
    
        }
        
    }
    
}
