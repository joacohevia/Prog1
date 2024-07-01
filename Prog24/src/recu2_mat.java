/*Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una
plataforma tecnológica con recursos limitados. Cada imagen (representada por una matriz
de NxM) está compuesta por píxeles con valores entre 0 y 255. Se tiene implementado un
algoritmo de eliminación que elimina aquellas porciones de la imagen distintas del color
negro (0 en la escala de valores del pixel). Dicho algoritmo procede de la siguiente manera:
por cada una de las filas de la matriz, toma cada secuencia delimitada por uno o mas
pixeles de color negro (valor 0) y elimina aquellos valores de píxeles que sean mayores
a un valor Y dado, manteniendo el orden de los restantes valores de píxeles.
Cada fila de la matriz empieza y termina con uno o más pixeles negros.
Se pide implementar el algoritmo de compresión que elimine los píxeles mayores al
valor Y y realice el corrimiento a la izquierda para llenar los espacios vacíos.
Asumir que cada fila posee suficientes lugares como para realizar el corrimiento.
Ejemplo de matriz con Y = 50:
0 67 25 0 14 0 33 68 44 0 5 98 0 0 0 0 0 0 0 0
0 0 25 25 0 55 3 0 75 44 44 0 60 1 0 0 0 0 0 0
0 44 44 44 0 15 0 88 9 0 12 0 0 0 0 0 0 0 0 0

La matriz resultante quedaría de la siguiente forma:
0 25 0 14 0 33 44 0 5 0 0 0 0 0 0 0 0 0 0 0
0 0 25 25 0 3 0 44 44 0 1 0 0 0 0 0 0 0 0 0
0 44 44 44 0 15 0 9 0 12 0 0 0 0 0 0 0 0 0 0
Además se debe informar la cantidad total de píxeles eliminados y la fila en la
cual se encuentra la mayor cantidad de píxeles eliminados (la primera, si
hubiese más de una). En este ejemplo, la cantidad total de píxeles eliminados fue 7
y la fila con más píxeles eliminados fue la fila 1. */
public class recu2_mat {
    public static final int MAXFIL = 3;
    public static final int MAXCOL = 20;
    public static final int Y=50;
    public static final int SEPARADOR=0;
    public static void main(String[] args) {
        int [][] matriz = {{0,67,25,0,14,0,33,68,44,0,5,98,0,0,0,0,0,0,0,0},
                            {0,0,25,25,0,55,3,0,75,44,44,0,60,1,0,0,0,0,0,0},
                            {0,44,44,44,0,15,0,88,9,0,12,0,0,0,0,0,0,0,0,0}
                          };
    descomprimir(matriz);
    }

    public static void descomprimir(int[][]matriz){
        int total_eliminados=0,max_eliminado=0,max_fila=0;
        for(int fila=0; fila<MAXFIL; fila++){
            int eliminado = buscar_arr(matriz[fila]);
            total_eliminados+=eliminado;
            if (eliminado>max_eliminado) {
                max_eliminado=eliminado;
                max_fila=fila;
            }
        }
        if (total_eliminados>0) {
            System.out.println("Total eliminados: "+total_eliminados+" en la fila: "+max_fila);
        }else{
            System.out.println("No se elimino ningun elemento");
        }
        mostrar_matriz(matriz);
    }

    public static int buscar_arr(int[]arr){
        int ini=0,fin=-1,buscar=0,eliminado=0;
        while (ini<MAXCOL) {
            ini=buscar_inicio(arr,fin+1);
            if (ini<MAXCOL) {
                fin=buscar_fin(arr,ini);
                buscar = buscar_coincidencia(arr,ini,fin);
                if (buscar>0) {
                    eliminar(arr,buscar);
                    eliminado++;
                    fin=ini;
                }
            }
        }
        return eliminado;
    }
    public static int buscar_coincidencia(int[]arr,int ini,int fin){
        while (ini<=fin) {
            if (arr[ini]>Y) {
                return ini;
            }
            ini++;
        }

        return -1;
    }
    public static void eliminar(int[]arr,int ini){
        for(int i=ini; i<MAXCOL-1; i++){
            arr[i]=arr[i+1];
        }
        arr[MAXCOL - 1] = 0;
    }
    public static int buscar_inicio(int[]arr,int ini){
        while (ini<MAXCOL && arr[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int[]arr,int fin){
        while (fin<MAXCOL && arr[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrar_matriz(int[][]matriz){
        for(int f=0; f<MAXFIL; f++){
            ver_matriz(matriz[f]);
        }
        System.out.println();
    }
    public static void ver_matriz(int []arr){
        for(int i=0; i<MAXCOL; i++){
            System.out.print(arr[i]+"|");
        }
        System.out.println();

    }

}

