/*
Una tienda de libros en línea ha decidido ofrecer libros adicionales como regalo en aquellos pedidos que 
cumplen con ciertos criterios. Cada libro está identificado por un valor numérico mayor a 0. Los pedidos 
se almacenan en un arreglo P de tamaño MAXP que comienza y finaliza con uno o más 0. Cada pedido está 
compuesto por una serie de libros separados por uno o más 0.
Ejemplo de arreglo P:
|0|0|101|202|303|0|404|505|0|606|707|0|808|909|0|0|0|0|0
En este ejemplo, hay cuatro pedidos.
Se pide realizar un programa en Java que permita incorporar un libro promocional R en aquellos pedidos que tengan
 al menos uno de los libros cuyo identificador sea menor o igual a un valor K dado. Debido a que solo se cuenta
con una cantidad C del libro promocional R, solo serán incorporados en los primeros pedidos que cumplan
con el requisito antes mencionado. La incorporación del libro se realiza al final del pedido.
Por ejemplo, dado un valor K = 300, un libro promocional R = 999 y una cantidad C = 2, el arreglo resultante será:
|0|0|101|202|303|999|0|404|505|0|606|707|0|808|909|0|0|0|0|0
Se debe indicar cuántos libros R quedaron sin agregar a los pedidos. En este ejemplo,
no quedaron libros por agregar.
 */
public class ej_parcial_libros {
    public static final int MAX=19;
    public static final int SEPARADOR=0;

    public static void main(String[] args) {
        int[]arr_libros = {0,0,101,202,303,0,404,505,0,606,707,0,808,909,0,0,0,0,0};
        int ini=0,fin=-1,produc=123,cant=2,num=800;
        mostrar_arreglo(arr_libros);
        while (ini<MAX) {
            ini=buscar_inicio(arr_libros,fin+1);
            if (ini<MAX) {
                fin=buscar_fin(arr_libros,ini);
                if (buscar_produc(ini,fin,arr_libros,num)&& cant>0) { 
                    agregar(fin,arr_libros,produc);
                    cant--;
                    fin++;
                }
            }
        }
        mostrar_arreglo(arr_libros);
        System.out.print("Productos sin agregar: "+cant);
    }
    public static void agregar(int fin,int[]arr_libros,int produc){
        for(int i=MAX-1; i>fin; i--){
            arr_libros[i]=arr_libros[i-1];
        }arr_libros[fin + 1] = produc;
    }
    
    
    public static boolean buscar_produc(int ini, int fin,int[]arr_libros,int num){
        boolean aux=false;
            while (ini<=fin) {
                if (arr_libros[ini]<=num) {
                    aux=true;
                }
                ini++;
            }
        return aux;
    }

    public static void mostrar_arreglo(int[]arr_libros){
        for(int i=0; i<MAX; i++){
            System.out.print(arr_libros[i]+"|");
        }System.out.println();
    }

    public static int buscar_fin(int[]arr_libros,int ini){
        int fin=ini;
        while (fin<MAX && arr_libros[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }

    public static int buscar_inicio(int[]arr_libros,int fin){
        int ini=fin;
        while (ini<MAX && arr_libros[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
}