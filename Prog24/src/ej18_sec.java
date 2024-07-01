/*Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño. */
public class ej18_sec {
    public static int [] arrSecuencia = {0,2,3,0,7,8,5,0,6,0};
    public static final int MAX = 10;
    public static void main(String [] args) {
        int inicio=0;
        int fin=0;
        int inicio_max=0;
        int fin_max=0;
        int comparacion=0;
        int longitud=0;
        while (inicio<MAX) {
            inicio = buscar_inicio(fin+1);
            if (inicio<MAX) {
                fin=buscar_fin(inicio);
                 longitud = fin - inicio + 1;
                if (longitud > comparacion) {
                    comparacion = longitud;
                    inicio_max = inicio;
                    fin_max = fin;
                }
                //un contador que empiece desde
                //principio a fin y cuente cuantas pos y las almacene
            }
        }
        System.out.print("/"+inicio_max+"/"+fin_max);
    }
    public static int buscar_inicio(int fin) {
        int ini=fin;
        while(ini<MAX && arrSecuencia[ini]==0 ){
            ini++;
        }
    return ini;
    }
    public static int buscar_fin(int inicio){
        int fin = inicio;
        while (fin<MAX && arrSecuencia[fin] !=0) {
            fin++;
        }
    return fin-1;
    }
    
}
