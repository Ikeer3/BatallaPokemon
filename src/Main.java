import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Datos Pokémon 1
        String pokemon1 = "Charmander";
        int vidaChar = 100;
        int mpChar = 50;
        int danhoGolpeChar = 20;
        int defensaChar = 10;
        String golpeEspecialChar = "Ascuas";
        int danhoEspecialChar = 50;
        int mpGolpeEspecialChar = 25;


        // Datos Pokémon 2
        String pokemon2 = "Bulbasaur";
        int vidaBul = 100;
        int mpBul = 30;
        int danhoGolpeBul = 15;
        int defensaBul = 10;
        String golpeEspecialBul = "Hierba Lazo";
        int danhoEspecialBul = 40;
        int mpGolpeEspecialBul = 10;

        Scanner batalla = new Scanner(System.in);

        boolean turnoPokemon = true;

        while (vidaChar > 0 && vidaBul > 0) {
            System.out.println("\nContendientes: ");
            System.out.println("Nombre: " + pokemon1 + "\n" + "Vida: " + vidaChar);
            System.out.println("Nombre: " + pokemon2 + "\n" + "Vida: " + vidaBul);

            if (turnoPokemon) {
                System.out.println("\nEs turno de " + pokemon1);
                System.out.println("\nQuieres que use el ataque normal o el especial? ");
                System.out.println("Elige normal o especial: ");
                String decisionPokemon = batalla.next();

                while (!decisionPokemon.equals("normal") && !decisionPokemon.equals("especial")) {
                    System.out.println("Opción no válida: " + decisionPokemon);
                    System.out.println("Escribe normal o especial: ");
                    decisionPokemon = batalla.next();
                }

                if (decisionPokemon.equals("normal")) {
                    int danhoTotal = danhoGolpeChar - defensaBul;
                    vidaBul -= danhoTotal;
                    System.out.println(pokemon1 + " le hace " + danhoTotal + " puntos de daño a " + pokemon2);
                }
                if (mpChar < mpGolpeEspecialChar) {
                    System.out.println(pokemon1 + " no tiene suficientes puntos de combate");
                    System.out.println(pokemon1 + " pierde el turno");
                } else if (decisionPokemon.equals("especial")) {
                    int danhoTotal = danhoEspecialChar - defensaBul;
                    vidaBul -= danhoTotal;
                    System.out.println(pokemon1 + " usa " + golpeEspecialChar + ". "
                            + pokemon1 + " le hace " + danhoTotal + " puntos de daño a "
                            + pokemon2);
                    mpChar -= mpGolpeEspecialChar;
                    System.out.println("A " + pokemon1 + " le quedan " + mpChar + " puntos de combate");
                }
            } else {
                System.out.println("\nEs turno de " + pokemon2);
                System.out.println("\nQuieres que use el ataque normal o el especial? ");
                System.out.println("Elige normal o especial: ");
                String decisionPokemon = batalla.next();

                while (!decisionPokemon.equals("normal") && !decisionPokemon.equals("especial")) {
                    System.out.println("Opción no válida: " + decisionPokemon);
                    System.out.println("Escribe normal o especial: ");
                    decisionPokemon = batalla.next();
                }

                if (decisionPokemon.equals("normal")) {
                    int danhoTotal = danhoGolpeBul - defensaChar;
                    vidaChar -= danhoTotal;
                    System.out.println(pokemon2 + " le hace " + danhoTotal + " puntos de daño a " + pokemon1);
                }
                if (mpBul < mpGolpeEspecialBul) {
                    System.out.println(pokemon2 + " no tiene suficientes puntos de combate");
                    System.out.println(pokemon2 + " pierde el turno");
                } else if (decisionPokemon.equals("especial")) {
                    int danhoTotal = danhoEspecialBul - defensaChar;
                    vidaChar -= danhoTotal;
                    System.out.println(pokemon2 + " usa " + golpeEspecialBul + ". "
                            + pokemon2 + " le hace " + danhoTotal + " puntos de daño a "
                            + pokemon1);
                    mpBul -= mpGolpeEspecialBul;
                    System.out.println("A Bulbasaur le quedan " + mpBul + " puntos de combate");
                }
            }
            if (vidaChar == 0) {
                System.out.println(pokemon1 + " ha quedado fuera de combate");
                System.out.println(pokemon2 + " GANA!!");
            } else if (vidaBul == 0) {
                System.out.println(pokemon2 + " ha quedado fuera de combate");
                System.out.println(pokemon1 + " GANA!!");
            }
            turnoPokemon = !turnoPokemon;
        }
    }
}