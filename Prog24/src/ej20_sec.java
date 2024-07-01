/*20. Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo.
 */
public class ej20_sec {
    public static int [] arrSecuencia = {0,1,2,0,2,3,2,0,6,0};
    public static final int MAX=10;
    public static int [] arr = {1,2};
    public static final int MAX_arr=2;
    public static void main(String [] args) {
        int inicio=0;
        int fin=0;
        int contador=0;
        boolean sies=false;
        while(inicio<MAX){
            inicio=buscar_inicio(fin+1);
            if (inicio<MAX) {
                fin=buscar_fin(inicio);
                contador=contador_sec(inicio,fin);
                if (contador == MAX_arr) {
                    sies=buscar_igual(inicio);//busque en ambos arr
                    if (sies) {
                        eliminar_sec(inicio,contador);
                        sies=false;
                    }
                }
            }
        }
        mostrar_arr();
    }
   
    public static void eliminar_sec(int inicio,int cont){
        while (cont>0) {
            for(int pos=inicio;pos<MAX-1;pos++){
                arrSecuencia[pos]=arrSecuencia[pos+1];
            }
            cont--;
        }
    }
    
    public static boolean buscar_igual(int inicio){
        boolean aux=false;
        int j=inicio;
        for(int i=0; i<MAX_arr; i++){
            if (arr[i]==arrSecuencia[j]) {
                aux=true;
            }
            else{
                return false;
            }
            j++;
        }
        return aux;
    }

    public static int contador_sec(int inicio, int fin) {
        int contador=0;
        for(int i=inicio; i<=fin; i++){
            contador++;
        }
        return contador;
    }

    public static int buscar_inicio(int fin) {
        int ini=fin;
        while (ini<MAX && arrSecuencia[ini]==0) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int inicio){
        int fin=inicio;
        while (fin<MAX && arrSecuencia[fin]!=0) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrar_arr(){
        for(int i=0;i<MAX;i++){
            System.out.print(arrSecuencia[i]+"|");
        }
    }

}
