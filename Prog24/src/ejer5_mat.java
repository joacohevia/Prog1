/*5. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine la primera ocurrencia de número en la matriz (un
número igual) si existe. Para ello tendrá que buscar la posición y si
está, realizar un corrimiento a izquierda y no continuar buscando. 
5,6 porque el 6 pide que elimine el mismo si esta repetido*/
public class ejer5_mat {
    public static final int MAXCOLUMNA=10;
    public static final int MAXFILA=5;
    public static final int MAX_E=2;
    public static void main(String[] args) {
        int[][] matriz = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 41, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 } };
        int num_borrar=51;
        int cont=3;
        int[]encontrado= {};
        boolean eliminar = true;
        while (cont>0 && eliminar) {
            eliminar=false;
            encontrado = buscar_num(matriz,num_borrar);                
            if ((encontrado[0] != -1)&&(encontrado[1]!=-1)) {
                eliminar(matriz,encontrado[0],encontrado[1]);
                cont--;
                eliminar=true;
                System.out.println("num eliminado "+num_borrar);
                break;
            }else
            {
                System.out.println("no hay coincidencias");
            }
        }      
        mostrarMatriz(matriz);
    }
    /* 
    siempre entra a eliminadoo
    while (cont > 0) {
            int[] encontrado = buscar_num(matriz, num_borrar);
            if (encontrado[0] != -1 && encontrado[1] != -1) {
                eliminar(matriz, encontrado[0], encontrado[1]);
                cont--;
                eliminado = true;
            } else {
                break;
            }
        }

        if (eliminado) {
            System.out.println("num eliminado " + num_borrar);
        } else {
            System.out.println("no hay coincidencias");
        }

        mostrarMatriz(matriz);
    } */

    public static void mostrarMatriz(int[][]matriz){
        for(int f=0; f<MAXFILA; f++){
            for(int c=0; c<MAXCOLUMNA; c++){
                System.out.print(matriz[f][c]+"|");
            }
            System.out.println();
        }
    }
    public static void eliminar(int[][]matriz,int fila, int columna){
            corrimiento_izq(matriz,fila,columna);
        
    }

    public static void corrimiento_izq(int[][] matriz, int fila, int columna) {
        for (int c = columna; c < MAXCOLUMNA - 1; c++) {
            matriz[fila][c] = matriz[fila][c + 1];
        }
        matriz[fila][MAXCOLUMNA - 1] = 0; 
    }

    public static int[] buscar_num(int [][]matriz, int num_borrar){
            for(int f=0; f<MAXFILA; f++){
                for(int c=0; c<MAXCOLUMNA; c++){
                    if (matriz[f][c] == num_borrar) {
                        return new int[] {f,c};
                    }
                }
            }
        
        return new int[]{-1,-1};
    }
}
