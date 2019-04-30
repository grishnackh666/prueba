
package rapido;

import java.util.ArrayList;
import java.util.Collections;


public abstract class Bingo {
    private ArrayList<Integer> bombo = new ArrayList<Integer>();
    private ArrayList<Integer> bolas_extraidas = new ArrayList<Integer>();
    private ArrayList<Carton> cartones = new ArrayList<Carton>();
    private int ultima_bola=0;
    private static final int bola_mayor=30;
    private static final int tamaño_del_carton=9;

    public Bingo() {
        for(int i=1;i<=bola_mayor;i++){
            this.bombo.add(i);
        }
    }
    
    protected Carton Generar_un_cartón(){
        //ArrayList<Integer> carton = new ArrayList<Integer>(); 
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        
        for(int i=1; i<=30; i++){
            numeros.add(i);
            //System.out.println(numeros.get(i-1));
        }
        Collections.shuffle(numeros);
        
        int[]nmeros_carton = new int[tamaño_del_carton];
        for(int j=0; j<tamaño_del_carton; j++){
               nmeros_carton[j] = numeros.get(j);
               numeros.remove(j);  
               //System.out.println(nmeros_carton[j]);
        }
        
        //carton.add(nmeros_carton);
        
        Carton carto = new Carton(nmeros_carton);
        //carto.imprimirNumero();
        for(Carton n: cartones){
            for(int m: carto){
                if(n!=m){
                   cartones.add(carto); 
                }
            }
        }
        
        return carto;
    }

    
    
    public int Extraer_una_bola(){
        int bolaExtraida;
             java.util.Collections.shuffle(this.bombo);
             bolaExtraida = this.bombo.get(0);
             this.bolas_extraidas.add(bolaExtraida);
             this.bombo.remove(0);
        return bolaExtraida; 
    }
 
    public ArrayList<Integer> getBombo() {
        return bombo;
    }
    public ArrayList<Integer> getBolas_extraidas() {
        return bolas_extraidas;
    }
    public ArrayList<Carton> getCartones() {
        return cartones;
    }
    public ArrayList<Carton> getCartones_ganadores() {
        return cartones_ganadores;
    }
    public boolean isFinalizado() {
        return finalizado;
    }
    public static int getBola_mayor() {
        return bola_mayor;
    }

    public static int getTamaño_del_carton() {
        return tamaño_del_carton;
    }
    
    
}