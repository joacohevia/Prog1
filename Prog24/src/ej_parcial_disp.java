/*1. Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica
con recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con
valores entre 0 y 255. Se desea implementar un algoritmo de compresión que comprima aquellas porciones
de la imagen distintas del color negro (0 en la escala de valores del pixel). Se debe implementar la solución
para un arreglo (luego dicha solución se reutilizará en un futuro para cada fila de la matriz). Para ello, se pide
realizar un programa en JAVA que, dado un arreglo de tamaño M, para cada secuencia delimitada por uno o
mas pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (todos los elementos de la
secuencia deben ser iguales), comprima la secuencia poniendo en la primera posición el valor del pixel que se
repite y a continuación el valor negado de la cantidad de ocurrencias. El arreglo empieza y termina con un
separador 0 (color negro). Implementar usando las buenas prácticas de programación estructurada vistas en
la cátedra.
Ejemplo:
Arreglo que tiene una fila de la imagen:
0 67 67 67 67 67 67 67 67 0 14 0 33 33 33 33 0 5 98 0
El arreglo quedaría de la siguiente forma, para un X=3:
0 67 -8 0 14 0 33 -4 0 5 98 0 0 0 0 0 0 0 0 0 */
public class ej_parcial_disp {
    public static final int MAX=20;
    public static final int SEPARADOR=0;
    public static final int X=3;
    public static void main(String[] args) {
        int [] arr_imagen={0,67,67,67,67,67,67,67,67,0,14,0,33,33,33,33,0,5,98,0};
        int inicio=0,fin=-1,sec=0;
        mostrar_arreglo(arr_imagen);
        while (inicio<MAX) {
            inicio=buscar_inicio(arr_imagen,fin+1);
            if (inicio<MAX) {
                fin=buscar_fin(arr_imagen,inicio);
                sec = fin-inicio+1;
                //cant=cant_rep()busca q todos los elemento del arr sean igual y da cantidad
                if (sec>X && son_igual(arr_imagen,inicio,fin)) {
                    comprimir(inicio,fin,arr_imagen,sec);
                    fin=inicio;
                }
            }
        }
        mostrar_arreglo(arr_imagen);
    }
    /*  public static int cantRep(int[] arreglo, int ini, int fin) {
        int cantRep = 0, numero=0;
        while (ini <= fin) {
            numero=arreglo[ini];
            if (numero == arreglo[ini]) {
                cantRep++;
            }
            ini++;
        }
        return cantRep;
    } */


    public static int buscar_fin(int[]arr_imagen, int inicio){
        int fin=inicio;
            while (fin<MAX && arr_imagen[fin]!=SEPARADOR) {
                fin++;
            }
        return fin-1;
    }

    public static int buscar_inicio(int[]arr_imagen,int fin){
        int ini=fin;
            while (ini<MAX && arr_imagen[ini] == SEPARADOR) {
                ini++;
            }
        return ini;
    }

    public static boolean son_igual(int[] arregloImagen, int inicio, int fin) {
        boolean aux=false;
            while (inicio<=fin && arregloImagen[inicio]==arregloImagen[inicio+1]){
                //en la pos 8 compara 8+1=pos 9 emtonces se rompe porque no son iguales y ini vale 8 igual que fin
                inicio++;
            }
            if (inicio==fin) { //if (inicio>fin) dos arr
            aux=true;
            }
        return aux;
        }

        
    public static void mostrar_arreglo(int[]arr_imagen){
        for(int i=0; i<MAX-1; i++){
            System.out.print(arr_imagen[i]+"|");
        }
        System.out.println();
    }

    public static void corrimiento_izq(int [] arr_imagen, int inicio){
        for(int i=inicio; i<MAX-1; i++){
            arr_imagen[i] = arr_imagen[i+1];
        }
    }
    
    public static void comprimir(int inicio,int fin, int[]arr_imagen, int sec){
        for(int i=inicio; i<fin-1; i++){//fin-1 para que me deje DOS 67(ya deja uno al ser i<fin)
            corrimiento_izq(arr_imagen, inicio);
        }
        arr_imagen[inicio+1]=sec*-1;
    }
}
