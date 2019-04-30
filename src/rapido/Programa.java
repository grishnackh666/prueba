
package rapido;

import java.util.ArrayList;


public class Programa {
    public static void main(String[] args) {
        ArrayList<Bingo> bingos = new ArrayList<>();
        
        BingoClásico bingoC = new BingoClásico(5);
        BingoAmericano bingoA = new BingoAmericano();
        bingos.add(bingoA);
        bingos.add(bingoC);
        
        ArrayList<Carton> CartonClasico = new ArrayList<>();
        ArrayList<Carton> CartonAmericano = new ArrayList<>();
        
        for (int i = 0; i < bingos.size(); i++) {
            for (int y = 0; y < 5; y++) {
                if (bingos.get(i).getClass() == BingoClásico.class) {
                    CartonClasico.add(bingos.get(i).Generar_un_cartón());
                } else {
                    CartonAmericano.add(bingos.get(i).Generar_un_cartón());
                }
            }
        }

        for (int i = 0; i < CartonClasico.size(); i++) {
            System.out.println("la cantidad es: ");
            System.out.println(CartonClasico.get(i).toString());
        }
        for (int i = 0; i < CartonAmericano.size(); i++) {
            System.out.println("la cantidad es: ");
            System.out.println(CartonClasico.get(i).toString());
        }
        for (int i = 0; i < bingos.size(); i++) {
            while (bingos.get(i).finalizado) {
                System.out.println(bingos.get(i).Extraer_una_bola());
            }
        }
    }
}
