/*Hacer un programa que invierta el orden de la última secuencia
en un arreglo. */
public class ej23_sec {
    public static int [] arr_sec = {0,1,2,0,3,0,4,5,6,0};
    public static final int MAX=10;           //6,5,4
                                             //6,4,5
    public static void main(String[] args) {
        int inicio=MAX;
        int fin=MAX-1;
        int cant=1;
        while (cant>0) {
            inicio=buscarInicio(fin-1);//vale 9
            fin=buscar_fin(inicio);//empieza desde [7] y va hacia adelante buscando 0
            cant--;
        }
        invertir_sec(inicio,fin);
        mostrarArreglo();
    }
    public static void invertir_sec(int inicio,int fin){
        int aux=0;
        while (inicio<fin) {
            aux = arr_sec[inicio];
            arr_sec[inicio]=arr_sec[fin];
            arr_sec[fin]=aux;
            inicio++;
            
            
        }
    }
    public static void mostrarArreglo(){
        for(int i=0;i<MAX;i++){
            System.out.print(arr_sec[i]+"|");
        }
    }

    public static int buscarInicio(int fin) {
        int ini=fin;
            while (ini<=MAX && arr_sec[ini]!=0) {
                ini--;
            }
        return ini+1;
    }

    public static int buscar_fin(int inicio){
        int fin=inicio;
            while (fin<=MAX && arr_sec[fin]!=0) {
                fin++;
            }
        return fin-1;
    }

}
