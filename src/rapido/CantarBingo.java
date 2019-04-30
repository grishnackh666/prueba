/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapido;

import java.util.ArrayList;

public class CantarBingo extends Bingo {
    
        private ArrayList<Carton> cartones_ganadores = new ArrayList<Carton>();
            private boolean finalizado;

            
            
            
            
    @Override
    public int Extraer_una_bola(){
        int bolaExtraida;
        if(this.bombo.isEmpty()){
            this.finalizado = true;
        }
        
        if(finalizado == false){
             java.util.Collections.shuffle(this.bombo);
             bolaExtraida = this.bombo.get(0);
             this.bolas_extraidas.add(bolaExtraida);
             this.bombo.remove(0);
             
             for(Carton carton : this.cartones){
                 if(this.Comprobar_carton(carton)){
                     this.cartones_ganadores.add(carton);
                     this.finalizado = true;
                 }
             }
        }else{
            bolaExtraida = 0;
        }
        
        return bolaExtraida; 
    }
}
