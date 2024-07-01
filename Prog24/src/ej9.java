/*9. Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, solicite al usuario un número entero y
lo agregue al principio del arreglo (posición 0). Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del
arreglo) y colocar el número en el arreglo en la posición indicada. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej9 {
    public static int [] arrCorrimiento = {1,2,3,4,2,6,7,8,9,10};
    public static final int MAX = 10;
    public static void main(String []args) {
        int numero;
        numero = ingresar_num();
        buscar_corrimiento(numero);
        mostrar_arr();
    }
    public static int ingresar_num() {
        int num=-1;
        try {BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ingrese num para la primera pos");
            num = Integer.valueOf(input.readLine());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }
    public static void buscar_corrimiento(int numero){
        int num_insert = numero;
        for(int pos= MAX-1; pos>MAX;pos--) {
            arrCorrimiento[pos] = arrCorrimiento[pos-1];
        }
        arrCorrimiento[0]=num_insert;
    } 
    public static void mostrar_arr() {
        for(int pos =0; pos<MAX; pos++){
            System.out.print("/"+arrCorrimiento[pos]+"/");
        }
    }   
    
}
