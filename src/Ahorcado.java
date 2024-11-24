import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "confabulacion";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        inicializarLetrasAdivinadas(letrasAdivinadas);

        System.out.println("----------------------------------------");

        while (!palabraAdivinada && intentos < intentosMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.print("Introduce una letra, por favor: ");

            char letra = obtenerLetraValida(scanner);
            boolean letraCorrecta = verificarLetra(palabraSecreta, letrasAdivinadas, letra);

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos.");
            }
            if (String.valueOf(letrasAdivinadas).equalsIgnoreCase(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("---------------------------------------------------------------------");
                System.out.println("¡Felicitaciones! Has acertado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("¡Qué pena! Te has quedado sin intentos. GAME OVER...");
        }
        scanner.close();
    }

    private static void inicializarLetrasAdivinadas(char[] letrasAdivinadas) {
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
    }

    private static char obtenerLetraValida(Scanner scanner) {
        String input;
        do {
            input = scanner.next().toLowerCase();
        } while (input.length() != 1 || !Character.isLetter(input.charAt(0)));
        return input.charAt(0);
    }

    private static boolean verificarLetra(String palabraSecreta, char[] letrasAdivinadas, char letra) {
        boolean letraCorrecta = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (Character.toLowerCase(palabraSecreta.charAt(i)) == letra) {
                letrasAdivinadas[i] = letra;
                letraCorrecta = true;
            }
        }
        return letraCorrecta;
    }
}
