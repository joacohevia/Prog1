import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 8. Implementar un método que realice un corrimiento a izquierda en
un arreglo ordenado de tamaño MAX=10 a partir de una posición.
 */
public class ej8 {
    public static final int MAX = 10;
    public static int [] arrIzquierda = new int [MAX];
    public static void main(String[] args) {
        Cargar_arreglo(arrIzquierda,MAX);
        mostrar_arr(arrIzquierda,MAX);
        corrimiento_izq(arrIzquierda,MAX);
        mostrar_arr(arrIzquierda,MAX);
    }
    public static void Cargar_arreglo(int [] arrIzquierda, int MAX) {
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
    }
    public static void corrimiento_izq(int [] arrIzquierda, int MAX){ 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("ingrese num pos");
            int pos_ingresada = Integer.valueOf(input.readLine());
            if(pos_ingresada>=0 && pos_ingresada<MAX-1) {
                for(int i=pos_ingresada; i<MAX-1; i++) {
                    arrIzquierda[i] = arrIzquierda[i+1];
                }
            }
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


