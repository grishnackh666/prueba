
package rapido;

import java.util.ArrayList;
import java.util.Collections;


public class Carton {
    private ArrayList<Integer> numero = new ArrayList<Integer>();
    private int tamaño;
    
    
    public Carton(int tamaño,ArrayList <Integer> numeros) {
        Collections.sort(numero);
        this.numero = numero;
        this.tamaño = tamaño;
    }

    public boolean isBingo(ArrayList<Integer> bolasExtraidas) {
        return this.numero.containsAll(bolasExtraidas);
    }
    
    
    
    public boolean Comprobar_carton(ArrayList <Integer> bolas_extraidas){
       int c = 0;
        for(int to: bolas_extraidas) {
            for(int yo: this.getNumero()){
                if(yo==to){
                c++;
            }
         }
     }
        if(c==this.getTamaño()){
                return true;
        }else{
              return false;
            }
    }

    public ArrayList<Integer> getNumero() {
        return numero;
    }
    public void imprimirNumero(){
        System.out.println ("los numeros son: ");
        for(int numero : this.numero){
            System.out.print(numero+",");
        }
        System.out.println ("");
    }

    public int getTamaño() {
        return tamaño;
    }
    void add(ArrayList<Integer> nmeros_carton) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
