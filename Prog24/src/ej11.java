import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ej11 {
    /*Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine todas las ocurrencia de número en el arreglo.
Mientras exista (en cada iteración tiene que buscar la posición
dentro del arreglo) tendrá que usar la posición para realizar un
corrimiento a izquierda (quedarán tantas copias de la última
posición del arreglo como cantidad de ocurrencias del número). 

Suponer a partir de lo resuelto en el ejercicio anterior (11) que
el elemento a eliminar coincide con el último que hay en el arreglo.
¿Qué pasa en este caso? ¿Cómo daría una solución al problema?*/
public static final int MAX = 10;
public static int [] arrIzquierda = {1,2,3,2,4,6,2,9,7,2};
    public static void main(String[] args) {
        mostrar_arr(arrIzquierda,MAX);
        corrimiento_izq(arrIzquierda,MAX);
        mostrar_arr(arrIzquierda,MAX);
    }

    public static void corrimiento_izq(int [] arrIzquierda, int MAX){ 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {int borrar=MAX;
            boolean eliminado=true;
            System.out.println("numeros a eliminar");
            int buscarNum = Integer.valueOf(input.readLine());
            while (eliminado && borrar>0) {
                eliminado=false;
                for(int i=0;i<MAX;i++) {
                    if(arrIzquierda[i]==buscarNum) {
                        if(arrIzquierda[MAX-1]==buscarNum){
                            MAX--;//ej12
                        }
                        for(int pos=i;pos<MAX-1;pos++) {
                            arrIzquierda[pos] = arrIzquierda[pos+1];
                        }
                        eliminado = true;
                        borrar--;
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }
    public static void mostrar_arr(int [] arrIzquierda, int MAX) {
        for(int i =0;i<MAX;i++) {
            System.out.print("/"+arrIzquierda[i]+"/");
        }
    }
}
