/*24. Se tiene un arreglo de enteros de tamaño 20 de secuencias de
números entre 1 y 9, separadas por 0. El arreglo está precargado,
y además empieza y termina con uno o más separadores 0. Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej24_sec {
    public static final int MAX=20;
    public static int [] arr_sec = {0,1,2,3,0,5,6,7,0,9,1,2,3,0,4,5,0,6,2,0};
    public static void main(String[] args) {
        int inicio=0,fin=-1,num=0;
        boolean existe=false;
        num=num_ingresado();
        if(num>0){
            while ((inicio<MAX) && (fin<MAX)) {
                inicio=buscar_inicio(fin+1);
                if (inicio<MAX) {
                    fin=buscar_fin(inicio);
                    existe=comparar_sec(num,inicio,fin);
                    if (existe) {
                        mostrar_sec(inicio,fin);
                        existe=false;
                    } 
                }
            }
        }else{
            System.out.println("Num incorrecto");
        }
    }
    public static boolean comparar_sec(int num,int inicio,int fin){
        boolean aux=false;
        while ((inicio<=fin) && (arr_sec[inicio]!=num)) {
            inicio++;
        }
        if (arr_sec[inicio]==num) {
            aux=true;
        }else{
            aux=false;
        }
        return aux;
    }
    /*otra manera
    public static boolean comparar_sec(int num, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            if (arr_sec[i] == num) {
                return true;
            }
        }
        return false;
    }*/

    public static int num_ingresado(){
        int num=0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("ingrese num de sec");
                num = Integer.valueOf(input.readLine());
            } catch (Exception e) {
                // TODO: handle exception
            }
        return num;
    }

    public static int buscar_fin(int inicio){
        int fin=inicio;
        while (fin<MAX && arr_sec[fin]!=0) {
            fin++;
        }
        return fin-1;
    }

    public static int buscar_inicio(int fin){
        int ini=fin;
        while (ini<MAX && arr_sec[ini]==0) {
            ini++;
        }
        return ini;
    }

    public static void mostrar_sec(int inicio,int fin){
        System.out.print("|"+inicio+"|"+fin+"|");
    }
}
