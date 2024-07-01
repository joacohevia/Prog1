
/*7. Implementar un método que realice un corrimiento a derecha en
un arreglo ordenado de tamaño MAX=10 a partir de una posición. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ej7 {
    public static final int MAX = 10;
    public static int [] arrCorrimiento = new int [MAX];
    public static void main(String[] args) {
        Cargar_arreglo(arrCorrimiento,MAX);
        corrimiento_der(arrCorrimiento,MAX);
        mostrar_arr(arrCorrimiento,MAX);
    }

    public static void Cargar_arreglo(int[] arrCorrimiento, int MAX) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
         for(int pos=0;pos<MAX; pos++) {
             System.out.println("ingrese num para la pos: "+pos);
             int num = Integer.valueOf(input.readLine());
             arrCorrimiento[pos] = num;
         }
        } catch (Exception e) {
         System.err.println(e);
        }
     }
    
     public static void corrimiento_der(int [] arrCorrimiento, int MAX) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese pos del corrimiento");
            int ingreso = Integer.valueOf(input.readLine());
            if(ingreso >=0 && ingreso < MAX-1) {
                for(int i=MAX-1; i > ingreso; i--) {
                    arrCorrimiento[i] = arrCorrimiento[i-1];
                }
                System.out.println("ingrese num para la posicion");
                int num = Integer.valueOf(input.readLine());
                arrCorrimiento[ingreso] = num; //arrCorrimiento[0] = num; esto es para el ej 9 
                                                //pide insertar el num al princio del arr
                
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

