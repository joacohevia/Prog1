import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine la primera ocurrencia del número (un número
igual) en el arreglo (si existe). Para ello tendrá que buscar la
posición y si está, realizar un corrimiento a izquierda (queda una
copia de la última posición del arreglo en la anteúltima posición).
 */
public class ej10 {
    public static final int MAX = 10;
    public static int [] arrIzquierda = {1,5,3,4,9,6,5,8,7,10};
    public static void main(String[] args) {
        //Cargar_arreglo(arrIzquierda,MAX);
        mostrar_arr(arrIzquierda,MAX);
        corrimiento_izq(arrIzquierda,MAX);
        mostrar_arr(arrIzquierda,MAX);
    }
    /*public static void Cargar_arreglo(int [] arrIzquierda, int MAX) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int i=0;i<MAX;i++) {
                System.out.print("ingrese num para pos: "+i+":");
                int num = Integer.valueOf(input.readLine());
                arrIzquierda[i] = num;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }*/
    public static void corrimiento_izq(int [] arrIzquierda, int MAX){ 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try {boolean eliminado = true;
        int borrar =2;
            System.out.println("ingrese num a borrar");
            int buscar = Integer.valueOf(input.readLine());
            while(eliminado && borrar > 0) { 
                eliminado = false;
                for(int i = 0; i < MAX; i++) {
                    if(arrIzquierda[i] == buscar) {
                        for(int pos = i; pos < MAX - 1; pos++) {
                            arrIzquierda[pos] = arrIzquierda[pos+1];
                        }
                        eliminado = true;
                        borrar--; // Decrementar el contador de ocurrencias a eliminar
                    }
                }
            }
            /*para eliminar un solo elemento
            while((i<MAX) && (arrIzquierda[i] != buscar)){
                //indice(0,1,2)         elemento dentro del arr
                i++;
            }
           
            for(int pos=i;pos<MAX;pos++) {
                arrIzquierda[pos] = arrIzquierda[pos+1];
            }*/
            
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

