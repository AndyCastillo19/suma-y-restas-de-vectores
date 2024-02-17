import java.util.Scanner;

public class Suma_Y_Resta_De_Vectores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tamaño de los vectores
        System.out.print("Ingrese el tamano de los vectores: ");
        int n = scanner.nextInt();

        // Declaración de vectores
        int[] vectorA = new int[n];
        int[] vectorB = new int[n];

        // Ingreso de elementos para el vector A
        System.out.println("Ingrese los elementos del vector A:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vectorA[i] = scanner.nextInt();
        }

        // Ingreso de elementos para el vector B
        System.out.println("Ingrese los elementos del vector B:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vectorB[i] = scanner.nextInt();
        }

        // Suma de vectores
        int[] suma = new int[n];
        for (int i = 0; i < n; i++) {
            suma[i] = vectorA[i] + vectorB[i];
        }

        // Resta de vectores
        int[] resta = new int[n];
        for (int i = 0; i < n; i++) {
            resta[i] = vectorA[i] - vectorB[i];
        }

        // Mostrar resultados
        System.out.println("\nResultado de la suma:");
        mostrarVector(suma);

        System.out.println("\nResultado de la resta:");
        mostrarVector(resta);

        scanner.close();
    }

    // Método para mostrar un vector
    private static void mostrarVector(int[] vector) {
        System.out.print("[ ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}