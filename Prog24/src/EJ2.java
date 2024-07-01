/*2. Hacer un programa que dado un arreglo ya cargado con 10
enteros, calcule el promedio y lo muestre por la consola. */
import java.util.Random;

public class EJ2 {
    public static final int MAX = 10;
    public static int [] arrCargado = new int [MAX];
    public static void main (String[]args) {
        carga_arreglo(arrCargado);
        mostrar_arreglo();
        calculo_promedio();
    }
    public static void carga_arreglo(int [] arrCargado) {
        Random r = new Random();
        for(int pos=0;pos < MAX; pos++){
            arrCargado[pos] = (r.nextInt(MAX));
        }
    }
    public static void mostrar_arreglo() {
        for(int pos=0; pos < arrCargado.length; pos++){
            System.out.println(arrCargado[pos] + " ");
        }
        System.out.println();
    }
    public static int calculo_promedio() {
        int suma = 0;
        for (int pos = 0; pos < MAX; pos++) {
            suma+=arrCargado[pos];
        }
        int promedio = suma/MAX;
        System.out.println("el prom es: "+promedio);

        int contador = 0;
        for(int pos = 0; pos < MAX; pos++) {
            if(arrCargado[pos] > promedio) {
                contador++;
            }
        }
        System.out.println("resultado: "+contador);
        return promedio;
    }
}
     /*Con el mismo arreglo del ejercicio anterior informe por pantalla
cuantos elementos del mismo están por encima del promedio
calculado.
Inicializar una variable contador en 0 para llevar la cuenta de los elementos por encima del promedio.
Recorrer el arreglo y, para cada elemento:
Comparar si el elemento es mayor que el promedio.
Si es mayor, incrementar el contador en 1.
Al finalizar el recorrido, imprimir el valor del contador, que representa la cantidad de elementos por encima del promedio. */  