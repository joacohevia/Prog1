/*Ejercicio tipo parcial
Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la
de eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por
ejemplo, artículos (el, la, las, los...), preposiciones (a, ante, con, por...), etc.
Dado un texto almacenado en un arreglo de caracteres de tamaño MAX_A, donde cada palabra está delimitada
por espacios, comas (,) o puntos (.) se pide eliminar todas las stopwords almacenadas en otro arreglo de
caracteres de tamaño MAX_S que se encuentra delimitado por espacios.
Por ejemplo, dado un texto almacenado en un arreglo A:

l|a| |c|a|s|a| |r|o|j|a|,| |a| |l|a| |v|u|e|l|t|a| |d|e| |l|a| |e|s|q|u|i|n|a|.|

Y una lista de stopwords S

a| |l|o| |l|o|s| |d|e| |l||a| |l|a|s|

El arreglo A debería quedar de la siguiente forma luego de la eliminación de stopwords:
c|a|s|a| |r|o|j|a|,|  |v|u|e|l|t|a|e|s|q|u|i|n|a . */

public class ej_parcial_stop {
    public static final int MAX_S = 20;
    public static final int MAX_P = 42;
    public static final char SEPARADOR1 = ',';
    public static final char SEPARADOR2 = '.';
    public static final char SEPARADOR3 = ' ';

    public static void main(String[] args) {
        char[] arrPalabras = {' ', 'l', 'a', ' ', 'c', 'a', 's', 'a', ' ', 'r', 'o', 'j', 'a', ',', ' ', 'a', ' ', 'l', 'a', ' ',
                'v', 'u', 'e', 'l', 't', 'a', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'e', 's', 'q', 'u', 'i', 'n', 'a', '.', ' '};
        char[] arrStopwords = {' ', 'a', ' ', 'l', 'o', ' ', 'l', 'o', 's', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'l', 'a', 's', ' '};
        int inicio = 0, fin = -1;
        //SIEMPRE ES MEJOR DEJAR EL MAIN CON UNA FUNCION (EJ=RECORRER) Y HACER LO Q SIGUE EN ESA FUNCION
        while (inicio < MAX_P) {
            inicio = buscarInicio(arrPalabras, fin + 1);
            if (inicio < MAX_P) {
                fin = buscarFin(arrPalabras, inicio);
                if (buscarIgual(inicio, fin, arrPalabras, arrStopwords)) {
                    eliminarStop(arrPalabras, inicio, fin);
                    fin = inicio; // para empezar a buscar de nuevo desde el inicio
                }
            }
        }

        mostrarArr(arrPalabras, MAX_P);
    }

    public static void eliminarStop(char[] arrPalabras, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            correrAIzquierda(arrPalabras, ini);
        }arrPalabras[MAX_P - 1] = ' '; // Llenar el último espacio con un espacio
    }

    public static void correrAIzquierda(char[] arrPalabras, int ini) {
        for (int i = ini; i < MAX_P - 1; i++) {
            arrPalabras[i] = arrPalabras[i + 1];
        }
    }

    public static boolean buscarIgual(int inicio, int fin, char[] arrPalabras, char[] arrStopwords) {
        int inicioS = 0, finS = -1;
        boolean sies = false;

        while (inicioS < MAX_S) {
            inicioS = buscarInicioS(finS + 1, arrStopwords);
            if (inicioS < MAX_S) {
                finS = buscarFinS(inicioS, arrStopwords);
                if ((fin - inicio + 1 == finS - inicioS + 1) && (sonIgual(inicio, fin, arrPalabras, inicioS, finS, arrStopwords))) {
                    sies = true;
                }
            }
        }
        return sies;
    }
    public static boolean sonIgual(int inicio, int fin, char[] arrPalabras, int inicioS, int finS, char[] arrStopwords) {
        boolean aux=false;
            while (inicio<=fin && arrPalabras[inicio] == arrStopwords[inicioS]) {
                inicio++;
                inicioS++;
            }
        if (inicio>fin) {
            aux=true;
        }
        return aux;
    }

    public static int buscarFinS(int inicioS, char[] arrStopwords) {
        int finS = inicioS;
        while (finS < MAX_S && arrStopwords[finS] != SEPARADOR3) {
            finS++;
        }
        return finS - 1;
    }

    public static int buscarInicioS(int finS, char[] arrStopwords) {
        int ini = finS;
        while (ini < MAX_S && arrStopwords[ini] == SEPARADOR3) {
            ini++;
        }
        return ini;
    }

    public static int buscarInicio(char[] arrPalabras, int fin) {
        int ini = fin;
        while (ini < MAX_P && (arrPalabras[ini] == SEPARADOR1 || arrPalabras[ini] == SEPARADOR2 || arrPalabras[ini] == SEPARADOR3)) {
            ini++;
        }
        return ini;
    }

     public static int buscarFin(char[] arrPalabras, int inicio) {
        int fin = inicio;
        while (fin < MAX_P && arrPalabras[fin] != SEPARADOR1 && arrPalabras[fin] != SEPARADOR2 && arrPalabras[fin] != SEPARADOR3) {
            fin++;
        }
        return fin - 1;
    }
    public static void mostrarArr(char[] arrPalabras, int MAX_P) {
        for (int i = 0; i < MAX_P - 1; i++) {
            System.out.print(arrPalabras[i] + "|");
        }
        System.out.println();
    }

   
}
