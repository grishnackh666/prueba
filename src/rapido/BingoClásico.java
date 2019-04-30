/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapido;

import java.util.ArrayList;

public class BingoClásico extends Bingo{
        private final int limiteCartones;
        private int numCartonesGenerados;

        public BingoClásico(int limiteCartones) {
        super(90, 15);
        this.limiteCartones = limiteCartones;
        this.numCartonesGenerados = 0;
    }
        
        @Override
        public boolean esAceptable(Carton carton) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0; i < this.tamaño_del_carton; i++) {
            if (numeros.get(i) == numeros.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Carton generarCarton() {
        if (this.numCartonesGenerados < this.limiteCartones) {
            this.numCartonesGenerados++;
            return super.generarCarton();
        }
        return null;
    }
        
}