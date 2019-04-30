
package rapido;

import java.util.ArrayList;
import java.util.Collections;


public abstract class Bingo {
    private ArrayList<Integer> bombo = new ArrayList<Integer>();
    private ArrayList<Integer> bolas_extraidas = new ArrayList<Integer>();
    private ArrayList<Carton> cartones = new ArrayList<Carton>();
    private ArrayList<Carton> cartonesBingo = new ArrayList<Carton>();
    protected  int ultima_bola;
    private static final int bola_mayor;
    protected  static final int tamaño_del_carton;
    public boolean finalizado;

    protected Bingo(int bola_mayor, int tamaño_del_carton) {
        this.bola_mayor = bola_mayor;
        this.tamaño_del_carton = tamaño_del_carton;
        this.ultima_bola = 0;
        
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
             this.ultima_bola = bolaExtraida;
             this.bolas_extraidas.add(bolaExtraida);
             this.bombo.remove(0);
             for(Carton crt : this.cartones) {
                if(crt.isBingo(this.bolas_extraidas)) {
                this.cartonesBingo.add(crt);
            }
        }
        return bolaExtraida; 
    }
 
    protected abstract boolean esAceptable(Carton carton);
    
    public Carton generarCarton() {
        Carton carton;
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        do {
            Collections.shuffle(this.bombo);
            for(int i = 0; i < this.tamaño_del_carton; i++) {
                numeros.add(this.bombo.get(i));
            }
            carton = new Carton(numeros, this.tamaño_del_carton);
        } while(this.cartones.contains(carton) && esAceptable(carton));
        this.cartones.add(carton);
        return carton;
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
   
    public static int getBola_mayor() {
        return bola_mayor;
    }

    public static int getTamaño_del_carton() {
        return tamaño_del_carton;
    }
    
}