/*/*
Ejercicio tipo Parcial
Un reconocido supermercado de venta online ha decidido incorporar productos a modo de
promoción en aquellos pedidos que cumplen con ciertos requisitos. Cada producto está
identificado con un valor numérico mayor a 0. Los pedidos recibidos se almacenan en un
arreglo P de tamaño MAXP que comienza y finaliza con uno o más 0. Cada pedido está
compuesto por una serie de productos y separados entre sí también por uno o más 0. A
modo de ejemplo, en el siguiente arreglo P, el primer pedido está compuesto por los
productos 12, 9 y 18. En total hay 4 pedidos.

|0|0 |12 |9 |18 |0 |15 |5 |4 |7 |10 |0 |8 |9 |12 |0 |19| 10| 9 |0 |0 |0 |0 |0 |0
Se pide realizar un programa en Java que permita incorporar un producto promocionado R
en aquellos pedidos que posean al menos uno de los productos almacenados en un arreglo
T de tamaño MAXT (ordenado en forma ascendente). Debido a que solo se cuenta con una
cantidad C del producto promocionado R, sólo serán incorporados en los primeros pedidos
que cumplan con el requisito antes mencionado. La incorporación del producto se realiza al
final del pedido.
Continuando con el ejemplo, dado un arreglo T = {8, 9} con MAXT = 2, un producto
promocionado R = 22 y una cantidad C = 2, el arreglo resultante será:

|0 |0 |12 |9 |18 |22 |0 |15| 5 |4 |7 |10 |0 |8 |9 |12 |22 |0 |19 |10 |9 |0 |0 |0 |0

Por último, se debe indicar cuántos productos R quedaron sin agregar a los pedidos. En
dicho ejemplo no quedaron productos por agregar.
IMPORTANTE: Asumir que siempre hay lugar suficiente en el arreglo para insertar
elementos. El ejemplo es meramente ilustrativo. La solución planteada debe permitir
resolver el problema para cualquier arreglo P y T o valores R y C. Aplicar los conceptos y
buenas prácticas vistos en clase.
 */
//DUDAS: A Q SE REF Q SIEMPRE HAY LUGAR SUF?? */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej_parcial_supermercado {
    public static int[] arr_p = {0, 0, 12, 8, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0};
    public static final int MAX_p = 25;
    public static int[] arr_t = {9, 8};
    public static final int MAX_t = 2;

    public static void main(String[] args) {
        int inicio = 0, fin = -1, produc, cant = 5; // maximo de inserciones
        produc = productos_en_promocion();
        if (produc > 0) {
            while (inicio < MAX_p) {
                inicio = buscar_inicio(fin + 1);
                if (inicio < MAX_p) {
                    fin = buscar_fin(inicio);
                    if (buscar_produc(inicio, fin) && cant > 0) {
                        corrimiento_der(fin, produc);
                        cant--; 
                        fin++;
                    }
                }
            }
            mostrarArreglo();
            System.out.println("Número sin agregar: " + cant);
        }
    }

    public static void mostrarArreglo() {
        for (int i = 0; i < MAX_p; i++) {
            System.out.print("|" + arr_p[i] + "|");
        }
        System.out.println();
    }

    public static void corrimiento_der(int fin, int produc) {
        for (int i = MAX_p - 1; i > fin; i--) {
            arr_p[i] = arr_p[i - 1];
        }
        arr_p[fin + 1] = produc; 
    }

    /*
      public static boolean buscar_produc(int inicio, int fin) {
      boolean aux=false;
        for (int i = inicio; i <= fin; i++) {
            for (int t = 0; t < MAX_t; t++) {
                if (arr_p[i] == arr_t[t]) {
                    aux=true; 
                }
            }
        }
        return aux; // Producto no encontrado
    }
    */
    public static boolean buscar_produc (int inicio,int fin) {
        boolean aux=false;
        while (inicio<=fin) {
            int t =0;
            while (t<MAX_t) {
                if (arr_p[inicio]==arr_t[t]) {
                    aux=true;
                }
                t++;  
            }
            inicio++;
        }
        return aux;
    }
  
    

    public static int productos_en_promocion() {
        int produc = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese producto en promoción:");
            produc = Integer.valueOf(input.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produc;
    }

    public static int buscar_fin(int inicio) {
        int fin = inicio;
        while (fin < MAX_p && arr_p[fin] != 0) {
            fin++;
        }
        return fin-1;
    }

    public static int buscar_inicio(int fin) {
        int ini = fin;
        while (ini < MAX_p && arr_p[ini] == 0) {
            ini++;
        }
        return ini;
    }
}
