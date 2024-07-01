/* 4. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y una posición fila, columna. Con estos datos tendrá que
realizar un corrimiento a derecha (se pierde el último valor en
dicha fila) y colocar el número en la matriz en la posición fila,
columna indicada. */
public class ejer4_mat {
    public static final int MAXCOLUMNA=10;
    public static final int MAXFILA=5;
    public static void main(String[] args) {
        int[][] matriz = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 } };
        int num_colum=2;
        int num_fila=3;
        int num_ingresado=50;
        insertar(matriz,num_fila,num_colum,num_ingresado);
        mostrar_mat(matriz);
    }
    public static void mostrar_mat(int[][]matriz){
        for(int f=0; f<MAXFILA; f++){
            mostrar_arr(matriz[f]);
            System.out.println();
        }
    }
    public static void mostrar_arr(int[]matriz){
        for(int i=0; i<MAXCOLUMNA; i++){
            System.out.print(matriz[i]+"|");
        }
    }

    public static void insertar(int[][] matriz, int num_fila, int num_colum, int num_ingresado) {
        for (int c = MAXCOLUMNA - 1; c > num_colum; c--) {
            matriz[num_fila][c] = matriz[num_fila][c - 1];
        }
        matriz[num_fila][num_colum] = num_ingresado;
    }

}
