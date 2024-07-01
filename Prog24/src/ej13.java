/*13. Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente) de tamaño MAX=10. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ej13 {
    public static int MAX=10;
    public static int [] arrIzquierda = {10,9,8,7,6,5,4,3,2,1};
    public static void main (String [] args){
        mostrar_arr();
        int numero;
        numero = solicitar_num();
        insertar_elemento(numero);
        mostrar_arr();
    }
    public static int solicitar_num() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int ingreso=0;
        try {
            System.out.println("ingrese num a ingresar");
            ingreso = Integer.valueOf(input.readLine());
           
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ingreso;
    }
    public static void insertar_elemento(int numero){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int posicion=0;
        try {
            System.out.println("ingrese pos para el num");
            posicion = Integer.valueOf(input.readLine());
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        int pos = posicion;
        for(int i=MAX-1;i>pos;i--){
            arrIzquierda[i] = arrIzquierda[i-1];
        }
        arrIzquierda[pos]=numero;
    }

    public static void mostrar_arr() {
        for(int i =0;i<MAX;i++) {
            System.out.print("/"+arrIzquierda[i]+"/");
        }
    }
}
