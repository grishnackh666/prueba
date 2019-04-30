/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapido;

import java.util.ArrayList;


public class BingoAmericano extends Bingo{
    
        public BingoAmericano() {
        super(75, 25);
    }
        
        @Override
        protected boolean esAceptable(Carton carton) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int suma = 0; double promedio;
        for(int i = 0; i < this.tamaño_del_carton; i++) {
            suma += numeros.get(i);
        }
        promedio = (double) (suma / this.tamaño_del_carton);
        return (promedio > 50);
    }

    @Override
    public int Extraer_una_bola() {
        int extraer;
        do {
            extraer = super.Extraer_una_bola();
        } while(extraer == this.ultima_bola + 1);
        return extraer;
    }
}
