public class final2 {
        public static final int MAXFILA = 3;
        public static final int MAXCOLUMNA = 23;
        public static final double probabilidad_letra = 0.4;
        public static final int MAXVALOR = 9;
        public static final int MINVALOR = 1;

        public static void main(String[] args) {
            char[][] matriz = {
                {'-','S','u','p','e','r',' ','s','e','c','r','e','t','o',':','-','-','-','-','-','-','-','-'},
                {'!','!','n','o',' ','c','o','r','t','a','r',' ','f','o','r',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ','c','o','n',' ','r','e','t','u','r','n','!','!','!','!','!','!','!','!','!','!','!','!'}
            };
            System.out.println("MATRIZ");
            imprimir_matriz_int(matriz);
            System.out.println("LA MATRIZ DESPUES DE LA ENCRIPTACION");
            procesar_encriptacion(matriz);
            imprimir_matriz_int(matriz);
        }

        public static void procesar_encriptacion(char[][] matriz) {
            int canttotalpixeles = 0;
            for (int fila = 0; fila < MAXFILA; fila++) {
                int pixelestotales = encriptar_matriz(matriz[fila]);
                canttotalpixeles = canttotalpixeles + pixelestotales;
            }
            System.out.println("la cantidad total pixeles es " + canttotalpixeles);
        }

        public static int encriptar_matriz(char[] arr) {
            int ini = 0, fin = -1, totalencriptacion = 0,contador=0;
            while (ini < MAXCOLUMNA) {
                ini = buscar_inicio(arr, fin + 1);  // Busca la siguiente secuencia de letras
                if (ini < MAXCOLUMNA) {
                    fin = buscar_fin(arr, ini);  // Encuentra el final de esa secuencia
                    int cantidad = encriptacion(arr, ini, fin);  // Encripta esa secuencia
                    if (cantidad>0) {//si incripto hizo corrimiento a der emtonces modifico fin
                        contador++; //aca cuento porque dice la cantidad de palabras una sec forma una palabra
                        //totalencriptacion = totalencriptacion+cantidad;
                        fin+=cantidad;//a fin le agrego la cantidad de veces que modifique
                    }
                }
            }
            return contador;
        }

        public static int encriptacion(char[] arr, int ini, int fin) {
            int cantencriptacion = 0;
            for (int i = ini; i <= fin; i++) {
                if (esvocal(arr[i])) {
                    arr[i] = (char) (arr[i] + 5); // Desplaza vocales
                    //cantencriptacion++; solo cuento en las que se hizo corrDer para actualizar fin
                } else if (esconsonante(arr[i])) {
                        corrimiento_derecha(arr, i);
                        //arr[i + 1] = arr[i]; // Cuando haces corrDer si no le decis que agregue algo agrega el valor anterior
                        //en este caso va a agregar una S emtonces te va a quedar SS
                        fin++; // Ajustar el rango del final
                        i++;// emtonces el prox i empieza desde u sino va a empezar siempre desde S y la va a seguir duplicando
                        cantencriptacion++;
                    
                    }
            }
            return cantencriptacion;
        }
        public static void corrimiento_derecha(char[] arr, int pos) {
            for (int i = MAXCOLUMNA - 1; i > pos; i--) {
                arr[i] = arr[i - 1];
            }
        }

        public static boolean noesletra(char c) {
            //si esta en este rango
                    //97 <= 101 && 101 <= 122
                    return ((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z' )); 
                    // c  >='a' && c <= 'z'
        }

        public static boolean esconsonante(char c) {
            return !esvocal(c);
        }

        public static boolean esvocal(char c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }

        public static int buscar_inicio(char[] arr, int pos) {
            while (pos < MAXCOLUMNA && !noesletra(arr[pos]))
                pos++;
            return pos;
        }
        
        public static int buscar_fin(char[] arr, int pos) {
            while (pos < MAXCOLUMNA && noesletra(arr[pos])){
                pos++;
            }
            return pos - 1;
        }

        public static void imprimir_matriz_int(char[][] mat) {
            for (int fila = 0; fila < MAXFILA; fila++) {
                imprimir_arreglo(mat[fila]);
                System.out.println("");
            }
        }

        public static void imprimir_arreglo(char[] arr) {
            for (int pos = 0; pos < MAXCOLUMNA; pos++) {
                System.out.print(arr[pos] + "|");
            }
            System.out.print("\n");
        }
    }
