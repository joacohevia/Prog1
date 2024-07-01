/*Dado un arreglo de tamaño de arreglo MAX=20 de secuencias. En
el caso de eliminar secuencias se debe hacer corrimiento.
15. Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros.
buscar ini,fin, devolver pos ini y fin de todas las se
 */

public class ej15_sec {
    public static int MAX = 20;
    public static int [] arrSecuencia = {0,1,2,3,0,4,5,6,0,7,8,9,0,10,11,12,0,13,14,15,0};
    public static void main (String [] args) {
        int inicio=0;
        int fin=0;
        while ((inicio<MAX)) {
            inicio = buscar_inicio(fin+1);
            if(inicio<MAX) {
                fin=buscar_fin(inicio);
                mostrar_arr(inicio,fin);
            }
        }
    }
    public static int buscar_fin(int inicio) {
        int i = inicio;
        while (i<MAX && arrSecuencia[i] != 0) {
            i++;
        }
        return i-1;
    }
    public static int buscar_inicio(int fin) {
        int pos = fin;
        while(pos<MAX && arrSecuencia[pos] == 0)  {
            pos++;
        }
        return pos;
    }
    
    public static void mostrar_arr(int inicio, int fin) {
       System.out.println("."+inicio+":"+fin);
    }
}
