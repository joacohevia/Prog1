/*1. Un dispositivo fitness almacena día a día, en una matriz de NxM, los entrenamientos de running que realiza un
atleta. Cada entrenamiento consiste en realizar pasadas de K kilómetros registrando cada 1 km el tiempo en segundos
que tardó. De cada entrenamiento se registra la actividad en secuencias separadas por cero/s, cada secuencia
representa una pasada. Por ejemplo, en la siguiente matriz, el sexto y séptimo día el atleta hizo 1 sola pasada, el
tercer día realizó 5 pasadas (secuencias) y en el resto de los días, 4 pasadas en cada uno. También se puede ver que
en la primera pasada del primer día de entrenamiento el atleta recorrió 4 km, tardando 300, 298, 298 y 297 segundos
en cada kilómetro recorrido.
0 300 298 298 297 0 240 233 245 240 0 257 254 254 0 234 230 222 0 0
0 310 302 284 271 0 280 263 263 0 0 0 264 264 0 234 230 0 0 0
0 310 302 294 0 0 250 243 0 245 0 257 255 253 0 234 229 0 0 0
0 315 320 395 398 0 351 333 353 0 0 0 334 354 0 454 490 499 0 0
0 410 400 397 0 0 250 243 0 0 0 257 255 253 0 234 229 220 0 0
0 0 420 430 430 450 420 0 0 0 0 0 0 0 0 0 0 0 0 0
0 415 425 435 420 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Por otra parte, el entrenador brinda al atleta la planificación semanal donde especifica los días (se numeran del 1 al 7)
en los cuales debe hacer un entrenamiento progresivo (el arreglo es rellenado con 0 cuando no hay más días
indicados). Un entrenamiento progresivo consiste en realizar pasadas en donde cada kilómetro es recorrido a mayor o
igual velocidad que el anterior (en menor o igual tiempo). Por ejemplo, dado un arreglo:
1 2 5 0 0 0 0
En este caso el entrenamiento progresivo debe ser el primer, segundo y quinto día de la semana y se debe cumplir en
todos los intervalos (secuencias) de cada día. Los días no incluidos en este arreglo son de entrenamiento libre.
Con esta información, el entrenador quiere saber si el atleta cumplió o no con el entrenamiento. Se pide realizar un
programa en JAVA que dada una matriz de NxM, un arreglo de tamaño N y un porcentaje P: (a) elimine del
arreglo aquellos días en los cuales se cumplió con el entrenamiento establecido; (b) informe al entrenador si el atleta
ha cumplido con el entrenamiento en al menos P por ciento de los días que se le asignó el entrenamiento progresivo.
Para este ejemplo, el atleta cumplió con el entrenamiento progresivo 2 de los 3 días (día 2 y 5), por lo que su
porcentaje de cumplimiento fue de 2/3=0.66 o 66% de lo requerido. En este caso, para un P=0.5 (50%) el atleta
cumplió con lo pedido por el entrenador. */
public class recu_atleta {
    public static final int MAXCOL=20;
    public static final int MAXFIL=7;
    public static final int SEPARADOR=0;
    public static final int MAX_Arr=7;
    public static void main(String[] args) {
        int[][] matriz={
            {0,300,298,298,297,0,240,233,245,240,0,257,254,254,0,234,230,222,0,0},
            {0,310,302,284,271,0,280,263,263,0,0,0,264,264,0,234,230,0,0,0},
            {0,310,302,294,0,0,250,243,0,245,0,257,255,253,0,234,229,0,0,0},
            {0,315,320,395,398,0,351,333,353,0,0,0,334,354,0,454,490,499,0,0},
            {0,410,400,397,0,0,250,243,0,0,0,257,255,253,0,234,229,220,0,0},
            {0,0,420,430,430,450,420,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,415,425,435,420,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
            };
        int [] arr = {1,2,5,0,0,0,0};
        descomprimir(matriz,arr);
        mostrar_arr_dia(arr);
    }
    public static void descomprimir(int[][] mat, int[] arr) {
        int totalDias = 0;
        int diasCumplidos = 0;
        double P = 0.5;
        for (int i = 0; i < MAX_Arr && arr[i] != 0; i++) {
            totalDias++;
            int dia = arr[i] - 1; // Convertir el día de entrenamiento al índice de la matriz
            if (arr_tiempo(mat[dia])) {
                System.out.println("El día " + arr[i] + " cumplió con el entrenamiento progresivo");
                arr[i] = 0; // Eliminar día del arreglo si se cumplió
                diasCumplidos++;
            } else {
                System.out.println("El día " + arr[i] + " no cumplió con el entrenamiento progresivo");
            }
        }
        if (totalDias > 0) {
            double porcentajeCumplido = (double) diasCumplidos/totalDias;
            if (porcentajeCumplido >= P) {
                System.out.println("cumplio: " + porcentajeCumplido + "|" + diasCumplidos + "|" + totalDias);
            } else {
                System.out.println("no cumplio");
            }
        } else {
            System.out.println("no hay dias asignados para entrenamiento progresivo");
        }
    }

    public static boolean arr_tiempo(int[]mat){
        int ini=0,fin=-1;
        boolean sec_decendente = true;
        while (ini<MAXCOL && sec_decendente) {
            ini=buscar_ini(mat,fin+1);
            if (ini<MAXCOL) {
                fin=buscar_fin(mat,ini);
                if(!decrece(ini,fin,mat)){
                    sec_decendente = false;
                }
            }
        }
        
        return sec_decendente;
    }
    public static boolean decrece(int ini,int fin, int []mat){
        while (ini<fin && mat[ini] >= mat[ini+1]) {
            ini++;
        }
        if (ini==fin) {
            return true;
        }
        return false;
    }
   
    public static int buscar_ini(int[]mat, int ini){
        while (ini<MAXCOL && mat[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int []mat,int fin){
        while (fin<MAXCOL && mat[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrar_mat(int[][]matriz){
        for(int f=0; f<MAXFIL; f++){
            mostrar_arr(matriz[f]);
        }
    }
    
    public static void mostrar_arr(int [] arr){
        for (int pos = 0; pos < MAXCOL ; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }
    public static void mostrar_arr_dia(int[]arr){
        for(int i=0; i<MAX_Arr; i++){
            System.out.print(arr[i]+"|");
        }
    }

}
