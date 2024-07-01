
/*Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario una posición
fila, columna y realice un corrimiento a izquierda. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejercicio3_mat {

    public static final int MAXCOLUMNA = 10;
    public static final int MAXFILA = 5;
    public static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
                { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
                { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 } };
        int fila = pedirFila();
        int columna = pedirColumna();
        procesoMatriz(mat, fila, columna);
        imprimir_matriz(mat);
    }

    private static void procesoMatriz(int[][] mat, int fila, int columna) {
        // ir a la posicion en la matriz y hacer el corrimiento de la fila
        correrIzquierda(mat[fila], columna);

    }

    private static void correrIzquierda(int[] arr, int columna) {
        for (int i = columna; i < MAXCOLUMNA - 1; i++)
            arr[i] = arr[i + 1];
    }

    public static int pedirFila() {
        int fila = -1;
        while (fila < 0 || fila > 4) {
            try {
                System.out.println("Ingrese una fila del 0 al 4:");
                fila = Integer.valueOf(entrada.readLine());

            } catch (Exception e) {
                System.out.println("error" + e);
            }
        }
        return fila;
    }

    public static int pedirColumna() {
        int columna = -1;
        while (columna < 0 || columna > 9) {
            try {

                System.out.println("Ingrese una columna del 0 al 9:");
                columna = Integer.valueOf(entrada.readLine());

            } catch (Exception e) {
                System.out.println("error" + e);
            }
        }
        return columna;
    }

    public static void imprimir_matriz(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            for (int col = 0; col < MAXCOLUMNA; col++) {
                System.out.print(mat[fila][col] + "||");
            }
            System.out.println("");
        }
    }

}