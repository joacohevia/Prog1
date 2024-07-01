/*Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, obtenga la cantidad de números pares
que tiene y la imprima. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EJ6 {
    public static int MAX = 10;
    public static int [] arrPar = new int [MAX];
    public static void main(String[]args) {
        int cantidad;
        Cargar_arreglo(arrPar,MAX);
        cantidad = buscar_par(arrPar,MAX);
        mostrar_arr(arrPar,MAX,cantidad);
    }
    public static void Cargar_arreglo(int[] arrPar, int MAX) {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       try {
        for(int pos=0;pos<MAX; pos++) {
            System.out.println("ingrese num para la pos: "+pos);
            int num = Integer.valueOf(input.readLine());
            arrPar[pos] = num;
        }
       } catch (Exception e) {
        System.err.println(e);
       }
    }
    public static int buscar_par(int[] arrPar, int MAX) {
        int numPar;
        int cantPar=0;
        for(int pos=0;pos<MAX;pos++){
            numPar = arrPar[pos];
            if(numPar %2 ==0){
                cantPar++;
            } 
        }
        return cantPar;
    }
    public static void mostrar_arr(int[] arrPar, int MAX, int cantidad) {
        for(int pos=0;pos<MAX;pos++) {
            System.out.println("en la pos: "+pos+" tiene num: "+arrPar[pos]);
        }
        System.out.println("tine esta cant de pares: "+ cantidad);
    }   
}
