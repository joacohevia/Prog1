/*Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada permita encontrar por cada fila la
posición de inicio y fin de la secuencia cuya suma de valores sea
mayor. */
public class ejer11_mat {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUM = 20;
    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 3, 6, 0, 2, 4, 4, 0, 7, 9, 1, 0, 1, 0, 2, 6, 4, 2, 0 },
                { 0, 4, 5, 0, 0, 1, 1, 8, 0, 0, 3, 2, 0, 9, 2, 1, 0, 1, 3, 0 },
                { 0, 0, 6, 1, 3, 0, 0, 8, 9, 1, 0, 2, 1, 3, 0, 1, 5, 5, 0, 0 },
                { 0, 7, 8, 0, 0, 2, 3, 0, 0, 6, 0, 1, 1, 0, 0, 9, 4, 7, 0, 0 }
        };
        mostrarMatriz(mat);
        for (int i = 0; i < MAXFILAS; i++) {
            System.out.println("Fila " + i);
            mayorSumaDeValores(mat[i]);
        }
    }
    public static void mostrarMatriz(int[][] mat) {
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUM; j++) {
                System.out.print(mat[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static void mayorSumaDeValores(int[] arr){
        int ini = 0; int fin = -1; int suma = 0; int mayorsuma = 0; int mayorini = 0; int mayorfin = 0;
        while (ini < MAXCOLUM) {
            ini = ObtenerInicio(arr, fin + 1);
            if (ini < MAXCOLUM) {
                fin = ObtenerFin(arr,ini);
                suma = ObtenerSuma(arr,ini,fin);
                if (suma > mayorsuma) {
                    mayorsuma = suma;
                    mayorini = ini;
                    mayorfin = fin;
                }
            }
        }
        System.out.println("La mayor suma es :" + mayorsuma + " con inicio en " + mayorini + " y fin en " + mayorfin);
    }
    public static int ObtenerInicio (int [] arr, int ini){
        while (ini < MAXCOLUM && arr[ini] == 0) {
            ini++;
        }
        return ini;
    }
    public static int ObtenerFin (int [] arr, int ini){
        while (ini < MAXCOLUM && arr[ini] != 0) {
            ini++;
        }
        return ini;
    }
    public static int ObtenerSuma(int[] arr ,int ini, int fin){
        int suma = 0;
        while (ini <= fin) {
            suma += arr[ini];
            ini++;
        }
        return suma;
    }
}
