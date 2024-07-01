/*19. Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej19_sec {
    public static int [] arrSecuencia = {0,2,3,4,0,1,2,0,6,0};
    public static final int MAX=10;
    public static void main(String []args) {
        int inicio=0;
        int fin=0;
        int cont;
        int num_ingresado;
        num_ingresado = ingreso_num();
        //ingresa el N, busco la longitud, elimino esa misma long
        while (inicio<MAX) {
            inicio=buscar_inicio(fin+1);
            if (inicio<MAX) {
                fin=buscar_fin(inicio);
                cont=contador_sec(inicio,fin);
                if (num_ingresado == cont) {
                    eliminar_sec(inicio,fin);
                }
            }
        }
        mostrar_arr();
    }
    private static void mostrar_arr() {
        for(int i=0; i<MAX; i++){
            System.out.print("/"+arrSecuencia[i]+"/");
        }
    }
    public static int ingreso_num(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int ingreso=0;
        try {
            System.out.println("ingrese el num de sec que quiere eliminar");
            ingreso = Integer.valueOf(input.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ingreso;
    }

    public static void eliminar_sec(int inicio,int fin) {
        int ini=inicio;
        for(int i = ini; i<MAX-1; i++) {
            arrSecuencia[i]=arrSecuencia[i+1];
        }
    }

    public static int contador_sec(int inicio,int fin){
        int contador=0;
        for(int pos=inicio; pos<=fin; pos++) {
            contador++;
        }
        return contador;
    }
    
    public static int buscar_inicio(int fin){
        int inicio=fin;
        while (inicio<MAX && arrSecuencia[inicio]==0) {
            inicio++;
        }
    return inicio;
    }

    public static int buscar_fin(int inicio) {
        int fin = inicio;
        while (fin<MAX && arrSecuencia[fin]!=0) {
            fin++;
        }

    return fin-1;
    }

}
