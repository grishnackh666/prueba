
package rapido;

import java.util.ArrayList;
import java.util.Collections;


public abstract class Bingo {
    private ArrayList<Integer> bombo = new ArrayList<Integer>();
    private ArrayList<Integer> bolas_extraidas = new ArrayList<Integer>();
    private ArrayList<Carton> cartones = new ArrayList<Carton>();
    private ArrayList<Carton> cartonesBingo = new ArrayList<Carton>();
    protected  int ultima_bola;
    private static int bola_mayor;
    protected  static int tamaño_del_carton;
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
        
        ArrayList<Integer> nmeros_carton = new ArrayList<Integer>();
        for(int j=0; j<numeros.size(); j++){
               nmeros_carton.add(numeros.get(j));
               numeros.remove(j);  
               //System.out.println(nmeros_carton[j]);
        }
        
        //carton.add(nmeros_carton);
        int contador = 0;
        
        Carton carto = new Carton(2, nmeros_carton);
        boolean yaesta = false;
        //carto.imprimirNumero();
        for(Carton n: cartones){
            for(int i = 0; i<carto.getTamaño(); i++){
                try{
                    if(carto.getNumero().get(i) == n.getNumero().get(i)){
                        contador++;
                    }
                }catch(Exception e){
                }
            }
            if(contador == carto.getTamaño()){
                yaesta = true;
            }
        }
        if(!yaesta){
            this.cartones.add(carto);
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