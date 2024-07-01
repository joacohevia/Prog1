/* 1. Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado
de valores entre 1 y 12. Luego mostrar cómo quedó cargado. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EJ1 {
    public static void main (String []args){
        final int MAX=15;
        int numero=0;
        int [] arrNum = new int [MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int pos = 0;pos < MAX; pos++){
                System.out.println("Numero entre 1 y 12: "+ pos + ":");
                numero = Integer.valueOf(entrada.readLine());//lo q ingreso el usuario
                while(numero<1 || numero>12){
                    System.out.println("numero incorrecto, marque otro");
                    numero = Integer.valueOf(entrada.readLine());
                }
                arrNum[pos]=numero;/*arrNumber es el nombre del arreglo.
                [pos] es la posición del arreglo que se está asignando.
                numero, es el valor que se está asignando a la posición [pos] del arreglo. */
            }
            for(int pos = 0; pos < MAX; pos++){
                System.out.println("arreglo["+pos+"]"+arrNum[pos]);
            }
        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
