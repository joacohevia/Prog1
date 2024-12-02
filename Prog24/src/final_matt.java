public class final_matt {
    public static final int H=3; //largo de sec
    public static final int E=50;// hasta alcanzar nubosidad 50
    public static int S=8;
    public static int P=20;

    public static int MAXF=24;
    public static int MAXC=10;
    public static int MAXarr=24;
    public static int SEPARADOR=0;
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//segun S=8 empieza a las 8
            {0, 42, 33, 25, 0, 0, 65, 65, 0, 0},
            {0, 0, 0, 0, 26, 34, 42, 85, 94, 0},
            {0, 91, 11, 2, 0, 53, 48, 27, 0, 0},//11
            {0, 68, 25, 11, 0, 0, 85, 20, 21, 0},
            {0, 0, 31, 42, 27, 52, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 12, 24, 31, 0, 0},
            {0, 0, 0, 0, 0, 85, 4, 2, 0, 0},//15
            {0, 0, 88, 85, 0, 26, 25, 12, 0, 0},
            {0, 0, 15, 52, 52, 0, 6, 5, 3, 0},//17
            {0, 0, 0, 0, 0, 84, 32, 12, 28, 0},
            {0, 0, 0, 0, 8, 56, 32, 12, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// termina a las P=20;
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int [] horas = {4,5,9,11,15,17,21,22,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        descomprimir(matriz,horas);
        imprimir_matriz(matriz);
    }
    public static void descomprimir(int [][] mat,int []horas){
        for (int i = S; i < P; i++) {
            if (buscar_en_arr(horas, i)) {
                buscarSec(mat[i],horas);
            }
        }
    }
    public static boolean buscar_en_arr(int []horas,int fila){
        for(int i=0; i<MAXarr && horas[i]!=0; i++){
            if (horas[i]== fila) {
                return true;
            }
        }
        return false;
    }
    public static void buscarSec(int []mat,int[]horas){
        int ini=0,fin=-1;
        while (ini<MAXC) {
            ini=buscar_ini(mat,fin+1);
            if (ini<MAXC) {
                fin=buscar_fin(mat,ini);
                int sec = fin-ini+1;
                if (sec>=H) {
                    if (decrece(ini,fin,mat)) {
                        limiteBorrar(ini,fin,mat);
                        fin=ini;
                    }
                }
            }
        }
    }
    public static void corrimientoIzq(int [] mat,int ini){
        for (int i = ini; i < MAXC-1; i++) {
            mat[i]=mat[i+1];
        }
    }
    /* OTRA SOLUCION
    public static void limiteBorrar(int ini, int fin, int[] mat) {
        int suma = 0;
        while (ini <= fin && suma <= E) {
            suma += mat[ini]; // Incrementa suma con el valor actual
            corrimientoIzq(mat, ini); // Realiza el corrimiento desde ini
            fin--; // Ajusta el límite fin porque la secuencia se reduce
        }
    }
    */
    public static void limiteBorrar(int ini,int fin,int []mat){
        int suma=0;
        while (suma<=E && mat[ini] != 0) {
            suma+=mat[ini];//LE ASIGNO 42->A 42 LE ASIGNO 33 ->42+33<=50? NO
            corrimientoIzq(mat, ini);//BORRO 42-> BORRO 33
        }
    }
    
    public static boolean decrece(int ini,int fin,int[]mat){
        boolean aux=false;
        while (ini<fin && mat[ini]>mat[ini+1]) {
            ini++;
        }
        if (ini==fin) {
            aux=true;
        }
        return aux;
    }

    public static void imprimir_arreglo(int [] arr){
        for (int pos = 0; pos < MAXC; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }
    public static void imprimir_matriz(int [][] arr){
        for (int pos = 0; pos < MAXF; pos++){
            imprimir_arreglo(arr[pos]);;
        }
        System.out.print("\n");
    }
    public static int buscar_ini(int[]mat, int ini){
        while (ini<MAXC && mat[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int []mat,int fin){
        while (fin<MAXC && mat[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }
}
