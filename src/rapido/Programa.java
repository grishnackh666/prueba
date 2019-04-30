
package rapido;

import static rapido.Bingo.imprimeArrayBingos;


public class Programa {
    public static void main(String[] args) {
        Bingo[] bingos = new Bingo[5];
        
        Bingo bingo = new BingoClásico();
        Bingo bing = new BingoAmericano();
        
        bingos[0] = new BingoClásico();
        bingos[1] = new BingoClásico();
        bingos[2] = new BingoClásico();
        bingos[3] = new BingoClásico();
        bingos[4] = new BingoClásico();
        
        imprimeArrayBingos(bingos);

               
        while(bingo.isFinalizado()==false){
            
             int ball = bingo.Extraer_una_bola();
            System.out.println("bola: "+ball);
        }
        for(Carton to: bingo.getCartones_ganadores()){
            System.out.println("carton ganador: "+to.getNumero());
        }
    }
}
