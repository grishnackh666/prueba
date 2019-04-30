/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapido;

import java.util.ArrayList;

public class BingoClásico extends Bingo{
        private int bola_mayor=90;
        private ArrayList<Integer> bolas = new ArrayList<Integer>();
        private int tamaño_del_carton=15;

        public BingoClásico() {
        for(int i=1;i<=bola_mayor;i++){
            this.bolas.add(i);
        }
        
        @Override;
        protected Carton Generar_un_cartón(){
            
        }
        
    }
        
        
        
        
        

}
