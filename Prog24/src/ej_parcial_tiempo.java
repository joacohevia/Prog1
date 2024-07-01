/*
Una estación meteorológica recolecta datos de temperatura, humedad y presión en diferentes intervalos del día.
Cada lectura de datos se representa como una secuencia de tres valores enteros: 
temperatura, humedad y presión, separados por el valor -1 (valor no válido para esta lógica). 
El operador quiere analizar las condiciones climáticas y para ello ingresa un patrón específico de temperatura, 
humedad y presión junto con una cantidad N de repeticiones. Un patrón que se repite una cierta cantidad de veces 
consecutivas indica una condición climática significativa como una ola de calor, un frente frío, etc. 
Dado un valor N y el patrón específico en un arreglo inicializado con -1 (de tamaño igual al arreglo que 
tiene los datos), hacer un programa en JAVA que:
Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo consecutivamente luego de la cantidad N.
Por ejemplo, si tenemos el siguiente arreglo de datos:

-1 30 40 1010 -1 30 40 1010 -1 30 40 1010 -1 29 41 1009 -1
El arreglo patrón a analizar es temperatura=30, humedad=40, presión=1010 y N=2.
El arreglo resultante sería:
-1 30 40 1010 -1 30 40 1010 -1 -1 29 41 1009 -1
 */
public class ej_parcial_tiempo {
    public static int MAX = 17;
    public static int SEPARADOR = -1;

    public static void main(String[] args) {
        int[]arr_tiempo={-1,30,40,1010,-1,30,40,1010,-1,30,40,1010,-1,29,41,1009,-1};
        int[]arr_patron={-1,-1,-1,-1,-1,30,40,1010,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int ini=0,fin=-1,N=2,contador=0;
        mostrar_arreglo(arr_tiempo);
        while (ini<MAX) {
            ini=buscar_inicio(arr_tiempo,fin+1);
            if (ini<MAX) {
                fin=buscar_fin(arr_tiempo,ini);
                if (son_igual(ini,fin,arr_tiempo,arr_patron)) {
                    contador++;
                    if (contador>N) {
                        eliminar(ini,fin,arr_tiempo);
                        fin=ini;
                    }
                } else{
                    contador=0;
                }
            }
        }mostrar_arreglo(arr_tiempo);
    }
    public static void mostrar_arreglo(int[]arr_tiempo){
        for(int i=0; i<MAX; i++){
            System.out.print(arr_tiempo[i]+"|");
        }
        System.out.println();
    }

    public static void corrimiento_izq(int[]arr_tiempo,int ini){
        for(int i=ini; i<MAX-1; i++){
            arr_tiempo[i]=arr_tiempo[i+1];
        }
    }

    public static void eliminar(int ini,int fin, int[]arr_tiempo){
        for(int i=ini; i<=fin; i++){
            corrimiento_izq(arr_tiempo,ini);
        }
    }

    public static boolean comparar(int ini, int ini_p, int fin, int[]arr_tiempo,int[]arr_patron){
        boolean aux=false;
            while (ini<=fin && arr_tiempo[ini]==arr_patron[ini_p]) {
                ini++;
                ini_p++;
            }
            if (ini>fin) {
                aux=true;
            }
        return aux;
    }


    public static boolean son_igual(int ini,int fin, int[]arr_tiempo,int[]arr_patron){
        boolean aux = false;
        int ini_p=0,fin_p=-1;
            if (ini_p<MAX) {
                ini_p=buscar_inicio(arr_patron, fin_p+1);
                fin_p=buscar_fin(arr_patron, ini_p);
                if (fin_p-ini_p+1==fin-ini+1 && comparar(ini,ini_p,fin,arr_tiempo,arr_patron)) {
                    aux=true;
                }
            }
        return aux;
    }

    public static int buscar_fin(int[]arr_tiempo,int ini){
        int fin=ini;
        while (fin<MAX && arr_tiempo[fin]!= SEPARADOR) {
            fin++;
        }
        return fin-1;
    }

    public static int buscar_inicio(int[]arr_tiempo, int fin){
        int ini=fin;
        while (ini<MAX && arr_tiempo[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
}
