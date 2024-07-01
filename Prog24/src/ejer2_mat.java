/*2. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, obtenga la cantidad de
números pares que tiene y la imprima. */
public class ejer2_mat {
    public static final int MAXCOLUMNA=10;
    public static final int MAXFILA=5;
    public static void main(String[] args) {
        int cant_par=0;
        int[][] matriz = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 } };
        cant_par=descomprimir(matriz);
        System.out.println("cantidad de pares es: "+cant_par);
    }
    public static int descomprimir(int [][] matriz){
        int cont=0;
        for(int fila=0; fila<MAXFILA; fila++){
            cont += cantidad_par(matriz[fila]);
        }
        return cont;
    }
    public static int cantidad_par(int [] matriz){
        int cont=0;
        for(int colum=0; colum<MAXCOLUMNA; colum++){
            if (matriz[colum] %2 ==0) {
                cont++;
            }
        }
        return cont;
    }
}
