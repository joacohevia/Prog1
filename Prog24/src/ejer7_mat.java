/*7. Hacer un programa que dada una matriz de enteros ordenada
creciente por filas de tamaño 4*5 que se encuentra precargada,
solicite al usuario un número entero y una fila, y luego inserte el
número en la matriz en la fila indicada manteniendo su orden.
 */
public class ejer7_mat {
    public static final int MAXFIL = 4;
    public static final int MAXCOL = 5;
    public static final int MAXVALOR = 100;
    public static final int MINVALOR = 1;

    public static void main(String [] args) {
        int[][] mat =  {{ 1, 2, 3, 4, 5},
                        { 11, 12, 13, 14, 15},
                         { 21, 22, 23, 24, 25},
                        { 31, 32, 33, 34, 35}};

        imprimir_matriz_int(mat);
        System.out.println();
        int num = 36;
        int fila = 0;
        insertar_numero(mat, num, fila);
        imprimir_matriz_int(mat);
    }
   
    public static void insertar_numero(int[][] mat, int numero, int fila) {
        for(int f=0; f<MAXFIL; f++){
            if (fila<MAXFIL) {//mat[fila]por que se pasa la fila especifica
                int pos = MAXCOL - 1; // Iniciar con la última posición
                while (pos > 0 && mat[fila][pos - 1] > numero) {
                    pos--;
                }
                corrimiento_derecha(mat[fila],pos,numero);
                
            }
        }
    }
    public static void corrimiento_derecha(int[] arr, int pos,int numero) {
        for (int i = MAXCOL - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = numero;

    }
    public static void imprimir_arreglo_int(int[] arr) {
        for (int pos = 0; pos < MAXCOL; pos++) {
            System.out.print(arr[pos] + "|");
        }
        System.out.println();
    }

    public static void imprimir_matriz_int(int[][] mat) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            imprimir_arreglo_int(mat[fila]);
        }
    }
}
