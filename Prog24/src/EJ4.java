/*Hacer un programa que dado un arreglo de caracteres de tamaño
10 que se encuentra cargado, invierta el orden del contenido. Este
intercambio no se debe realizar de manera explícita, hay que
hacer un método que incluya una iteración de intercambio.
cargar arreglo desde el usuario de tamaño 10,invertit el orden del 
contenido */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EJ4 {
    public static final int MAX = 10;
    public static int [] arreglo = new int [MAX];
    public static void main(String []args) {
        Cargar_arreglo(arreglo,MAX);
        invertir_arr(arreglo,MAX);
        mostrar_arr(arreglo,MAX);
    }

    public static void Cargar_arreglo(int [] arreglo, int MAX) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int pos=0;pos<MAX;pos++){
                System.err.println("ingrese num: "+pos+":");
                int numero = Integer.valueOf(input.readLine());
                arreglo[pos] = numero;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void invertir_arr(int[] arreglo2, int MAX) {
        int ult = MAX-1;
        int aux;
        for(int pos=0;pos<MAX/2;pos++) {
            aux = arreglo[pos];
            arreglo[pos] = arreglo[ult];
            arreglo[ult] = aux;
            ult--;
        }
    }
    public static void mostrar_arr(int[] arreglo2, int MAX) {
        for(int pos=0;pos<MAX;pos++){
            System.err.println("en la pos: "+pos+" esta: "+ arreglo[pos]);
        }
    }


}
