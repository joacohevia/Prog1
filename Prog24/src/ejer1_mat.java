/*1. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, invierta el orden del contenido
por fila. Este intercambio no se debe realizar de manera explícita,
hay que hacer un método que incluya una iteración de
intercambio. */
public class ejer1_mat {
    public static final int MAXCOLUMNA=10;
    public static final int MAXFILA=5;
    public static void main(String [] args){
        int[][] matriz = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 } };
        descomprimir(matriz);
        mostrar_mat(matriz);
    }
    public static void mostrar_mat(int[][]matriz){
        for(int fila=0; fila<MAXFILA; fila++){
            mostrar_arr(matriz[fila]);
            System.out.println();
        }
    }
    public static void mostrar_arr(int [] matriz){
        for(int i=0; i<MAXCOLUMNA; i++){
            System.out.print(matriz[i]+"|");
        }
    }

    public static void descomprimir(int [][]matriz){
        for(int i=0; i<MAXFILA; i++){
            invertir(matriz[i]);
        }
    }
    public static void invertir(int[]mat){
        int aux,ult=MAXCOLUMNA-1;
        for(int c=0; c<MAXCOLUMNA/2; c++){
            aux=mat[c];
            mat[c]=mat[ult];
            mat[ult]=aux;
            ult--;
        }
    }
}
