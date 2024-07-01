/*Hacer un programa que elimine los valores pares en un arreglo
de tamaño MAX=10. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej14 {
    public static int MAX=10;
    public static int [] arrPares = {0,1,2,3,4,5,6,7,8,9};
    public static void main (String [] args) {
        //cargar_arr();
        mostrar_arr();
        //int pedido;
        //pedido = pedir_num();
        //eliminar_par(pedido); todo lo que esta en comentario es para que el usuario ingrese num
        eliminar_par();
        mostrar_arrM();
    }

    /*public static void cargar_arr() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                for(int i=0;i<MAX;i++){
                    System.out.println("ingrese num para la pos " +i+":");
                    int pos= Integer.valueOf(input.readLine());
                    arrPares[i] = pos;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
    }*/

    public static int pedir_num() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int ingreso=0;
            try {
                System.out.print("ingrese num par a borrar");
                ingreso = Integer.valueOf(input.readLine());
                if (ingreso % 2 !=0) {
                    System.out.println("no es par");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            return ingreso;
    }

    public static void eliminar_par() {
        for(int i=0;i<MAX;i++){
            while (arrPares[i] %2 == 0) {
                arrPares[i] = arrPares[i+1];
            }
        }
    }

    public static void mostrar_arr(){
        for(int i=0; i<MAX; i++) {
            System.out.print("/"+arrPares[i]+"/");
        }
    }
    public static void mostrar_arrM(){
        for(int i=0; i<MAX; i++) {
            System.out.println("/"+arrPares[i]+"/");
        }
    }
}
