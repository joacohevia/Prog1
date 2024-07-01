/*2do Ejercicio tipo parcial
Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
N de repeticiones. Un patrón que se repite una cierta cantidad de veces consecutivas significa que el animal
puede estar pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado
con -1 (de tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo consecutivamente luego de la cantidad N.
Por ejemplo, si tenemos el siguiente arreglo de datos:
-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 23 34 55 -1 23 34 57 -1
El arreglo patrón X Y Z a analizar es X=23, Y=34, Z=55 y el N=2
-1 -1 -1 -1 -1 -1 -1 -1 23 34 55 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
El arreglo resultante sería
-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 -1 23 34 57 -1 -1 -1 -1 */

public class ej_parcial_animal {
    public static final int MAX = 21;
    public static final int SEPARADOR = -1;
    public static void main(String[] args) {
                               
                                                                  //-1,23,34,57,-1 
                                                                  //55,-1,23,34,57,-1
                                                                  //34,55,-1,23,34,57,-1
        int [] arr_disp =   {-1,12,22,44,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,57,-1};
        int [] arr_patron = {-1,-1,-1,-1,-1,-1,-1,-1,23,34,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int inicio=0,fin=-1,cant=0;
        int N=2;
        mostrar_arreglo(arr_disp);
        while (inicio<MAX) {
            inicio=buscar_inicio(arr_disp,fin+1);
            if (inicio<MAX) {
                fin=buscar_fin(arr_disp,inicio);
                if(son_igual(inicio,fin,arr_disp,arr_patron)){
                    cant++;
                    if (cant>N) {
                        eliminar_datos(arr_disp,inicio,fin);//N dice cuantas veces se elimina
                        fin=inicio;
                    }
                }
                else{
                    cant=0;//si no entra cant vuelve a cero porque deben ser CONSECUTIVAS
                }
            }
        } mostrar_arreglo(arr_disp);
    }
    public static void mostrar_arreglo(int[]arr_disp){
        for(int i=0; i<MAX-1; i++){
            System.out.print(arr_disp[i]+"|");
        } System.out.println();
    }

    public static void corrimiento_izq(int [] arr_disp, int inicio){
        for(int i=inicio; i<MAX-1; i++){
            arr_disp[i] = arr_disp[i+1];
        }
    }

    public static void eliminar_datos(int[]arr_disp, int inicio, int fin){
        for(int i=inicio; i<=fin; i++){
            corrimiento_izq(arr_disp,inicio);
        }
    }

    public static boolean comparar(int inicio, int fin, int[]arr_disp, int ini_p, int fin_p, int[]arr_patron){
        boolean aux = false;
            while (inicio<=fin && arr_disp[inicio] == arr_patron[ini_p]) {
                inicio++;
                ini_p++;
            }
            if (inicio>fin) {
                aux=true;
            }
        return aux;
    }
    public static boolean son_igual(int inicio, int fin, int [] arr_disp, int [] arr_patron){
        int ini_p=0,fin_p=-1;
        boolean aux = false;
        if (ini_p<MAX) {
                ini_p=buscar_inicio_p(arr_patron, fin_p+1);
                fin_p=buscar_fin_p(arr_patron, ini_p);
                if (fin-inicio+1==fin_p-ini_p+1 && comparar(inicio,fin,arr_disp,ini_p,fin_p,arr_patron)) {
                    aux=true;
                }
            }
        return aux;
    }


    public static int buscar_fin_p(int[]arr_patron, int ini_p){
        int fin=ini_p;
            while (fin<MAX && arr_patron[fin] != SEPARADOR) {
                fin++;
            }
        return fin-1;
    }

    public static int buscar_inicio_p(int[]arr_patron, int fin_p){
        int ini=fin_p;
            while (ini<MAX && arr_patron[ini] == SEPARADOR) {
                ini++;
            }
        return ini;
    }

   
    public static int buscar_fin(int [] arr_disp, int inicio){
        int fin=inicio;
            while (fin<MAX && arr_disp[fin] != SEPARADOR) {
                fin++;
            }
        return fin-1;
    }

    public static int buscar_inicio(int [] arr_disp, int fin){
        int ini=fin;
            while (ini<MAX && arr_disp[ini] == SEPARADOR) {
                ini++;
            }
        return ini;
    }

}
