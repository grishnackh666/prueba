
package rapido;

import java.util.ArrayList;


public class Carton {
    private final ArrayList<Integer> numero = new ArrayList<Integer>();
    private int tamaño;
    private int[] bolas_extraidas;
    
    
    public Carton(int...numero) {
        for(int number : numero){
            this.numero.add(number);
        }
        this.tamaño = this.numero.size();
    }

    public boolean Comprobar_carton(Carton carton){
       int c = 0;
        for(int to: this.bolas_extraidas) {
            for(int yo: carton.getNumero()){
                if(yo==to){
                c++;
            }
         }
     }
        if(c==carton.getTamaño()){
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
