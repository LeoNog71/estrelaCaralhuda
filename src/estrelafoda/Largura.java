/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sun.misc.Queue;

/**
 *
 * @author nogueira
 */
public class Largura {
    List<List<Nodo>> grafo;
    
    public Largura(List<List<Nodo>> grafo){
        this.grafo = grafo;
    }

    public List<List<Nodo>> getGrafo() {
        return grafo;
    }
    public List<String> largura(String destino) throws InterruptedException{
        
                
        Nodo inicial = this.grafo.get(0).get(0);
        List<String> caminho = new ArrayList<>();
        Queue<Nodo> fila = new Queue<>();
        fila.enqueue(inicial);
        Nodo atual = fila.dequeue();
        while(true){
            
             //System.out.println(atual.getId());
            
            if(atual.getId().equals(destino)){
                while(true){
                    //System.out.println(atual.getValor());
                    caminho.add(atual.getId());
                    atual = atual.getPai();

                    if(atual.getId().equals("0x0")){

                        Collections.reverse(caminho);
                        atual = grafo.get(0).get(0);


                        return caminho;
                    }
                }
            }
                
            for(Nodo x: atual.getFilhos()){
               
                x.setPai(atual);
                fila.enqueue(x);
            }
            atual = fila.dequeue();
            

            
        }
        
        //return caminho;
    }
}
