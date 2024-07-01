/*Buscar un elemento en un arreglo de caracteres ya cargado de
tamaño 10 y mostrar la/s posición/es del elemento, en caso de no
estar indicarlo también. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EJ3 {
    public static final char MAX = 10;
    public static char [] arrBuscar = {'a','b','c','d','e','f','g','h','i','j'};
    public static void main (String []args) {
        char buscar= ' ';
        mostrar_arr();
        buscar=buscar_pos(buscar);
        obtener_pos(arrBuscar,buscar);

    }
    public static void mostrar_arr() {
        for(int i=0; i < MAX; i++) {
            System.out.println(arrBuscar[i] + " " +"pos " + i);
        }
    }
    public static char buscar_pos(char buscar) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.err.println("Ingrese caracter a buscar");
            buscar = entrada.readLine().charAt(0);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return buscar;
    }
    public static void obtener_pos(char [] arrBuscar, char buscar) {
        char carac = ' ';
        for(int pos = 0; pos < MAX; pos++){
           if(arrBuscar[pos]==buscar) {
               System.err.println("El elemento se encuentra en la pos "+ pos);
               carac = buscar;
           }
        }
        if(carac == ' '){
            System.err.println("El elemento no se encuentra");
        }

    }
}
