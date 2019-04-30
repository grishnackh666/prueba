/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapido;

import java.util.ArrayList;


public class BingoAmericano extends Bingo{
    private int bola_mayor=75;
    private ArrayList<Integer> bola = new ArrayList<Integer>();
    private int tamaño_del_carton=25;
        
        public BingoAmericano() {
        for(int i=1;i<=bola_mayor;i++){
            this.bola.add(i);
        }
        }
        
        
}
