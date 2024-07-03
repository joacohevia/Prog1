/*Extra recuperatorio
El servicio de inteligencia de una potencia mundial desea revitalizar su sistema de
encriptación de mensajes de texto. Cada texto que debe ser encriptado es almacenado en
una matriz de caracteres de NxM, donde cada fila representa un renglón del mensaje.
El texto puede contener cualquier tipo de carácter: letras, dígitos, caracteres especiales o de
puntuación. El sistema de encriptación sólo debe encriptar las palabras compuestas por
letras (minúsculas o mayúsculas).
El mecanismo de encriptación elegido consiste en:
● Desplazar cada vocal tantas posiciones en el abecedario como caracteres tenga la
palabra.
● Duplicar cada consonante.
Por ejemplo, dada la palabra “secreto”, cuya longitud es 7, debe ser encriptada como
“sslccrrlttv”, dado que las consonantes se duplicaron, la vocal ‘e’ se desplazó 7 posiciones
pasando a ser una ‘l’ y la vocal ‘o’ pasó a ser una ‘v’.
Se pide implementar en Java un programa que encripte una matriz de caracteres de NxM
e informe la cantidad total de palabras encriptadas.
Por ejemplo, dada la siguiente matriz con el mensaje original:
- S u p e r s e c r e t o : - - - - - - - -
¡ ¡ n o c o r t a r f o r
c o n r e t u r n ! ! ! ! ! ! ! ! ! ! ! !
la matriz con el mensaje encriptado sería:
- S S z p p j r r s s l c c r r l t t v : -
¡ ¡ n n q c c u r r t t g r r f f r r r
c c r n n r r k t t { r r n n ! ! ! ! ! !
y la cantidad de palabras encriptadas sería 7.
Asumir que siempre se tiene espacio suficiente para realizar las inserciones (si se pierden
otros caracteres no importa) y que cada fila de texto empieza y termina siempre con uno o
más carácteres que no se corresponden con una letra.
Para desplazar un caracter n posiciones, puedo sumarle a un char la cantidad de
posiciones que lo quiero desplazar.
char c = ‘a’;
c = (char)(c + 5); // c pasa a almacenar ‘f’ */
public class recu_mat_vocal {
        public final static int MAXF = 3;
        public final static int MAXC = 23;
        public static void main(String[] args) {
            char[][] matriz = {{'-','S','u','p','e','r',' ','s','e','c','r','e','t','o',':','-','-','-','-','-','-','-','-'},
                               {'¡','¡','n','o',' ','c','o','r','t','a','r',' ','f','o','r',' ',' ',' ',' ',' ',' ',' ',' '},
                               {' ','c','o','n',' ','r','e','t','u','r','n','!','!','!','!','!','!','!','!','!','!','!','!'}};                          
            mostrar(matriz);
            procesar(matriz); //generico
            mostrar(matriz);
        }
        public static void procesar(char[][] matriz){  // desarmo texto en renglones
            int cantEncriptadas = 0;
            for (int i=0; i<MAXF; i++){
                cantEncriptadas += encriptarRenglon(matriz[i]);
            }
            System.out.println("La cantidad de palabras encriptadas es " + cantEncriptadas);
    
        }
        public static int encriptarRenglon(char[] fila){
            int ini = 0;
            int fin = -1;
            int cantEncriptadas = 0;
            int cantModif = 0;
            while (ini < MAXC) {
                ini = buscarInicio(fila, fin+1);
                if (ini<MAXC){
                    fin = buscarFin(fila, ini);
                    cantModif = encriptarPalabra(fila, ini, fin);
                    if (cantModif>0) {
                        fin += cantModif;//mas la cant modificada
                        cantEncriptadas++;    
                    }
                }
            }        
            return  cantEncriptadas;
    
        }
    
        public static int encriptarPalabra(char[] fila, int ini, int fin){
            int cantModifConsonante = 0;
            int tamanio = fin - ini +1;
            while (ini <= fin){
                if (esVocal(fila[ini])){
                      fila[ini] = (char) (fila[ini] + tamanio); 
                      ini++;  
                } else {
                    correrADerecha(fila, ini);
                    ini += 2;//porq repite la misma letra SS
                    cantModifConsonante++;
                    fin++;//como mod ini mod fin
                }
            }
    
            return cantModifConsonante;
    
        }   
        public static void correrADerecha(char[] arr, int pos) {
            for (int i = MAXC - 1; i > pos; i--){
                arr[i] = arr[i - 1];  
            }
        }
        public static boolean esVocal(char c){
                switch (c) {
                 case 'a':case 'e':case 'i':case 'o':case 'u':
                 case 'A':case 'E':case 'I':case 'O':case 'U':
                    return true;
            } 
            return false; 
        }
        public static boolean esLetra(char c){
                    //si esta en este rango
                    //97 <= 101 && 101 <= 122
            return ((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z' )); 
                // c  >='a' && c <= 'z'
        }
    
        // funciones habituales
        public static int buscarInicio(char[] arr, int pos) {
            while (pos < MAXC && !esLetra(arr[pos]))
                pos++;
            return pos;
        }
    
        public static int buscarFin(char[] arr, int pos) {
            while (pos < MAXC && esLetra(arr[pos]))
                pos++;
            return pos - 1;
        }
    
      
        public static void mostrar(char[][] matriz) {
            for (int i = 0; i < MAXF; i++) {
                for (int j = 0; j < MAXC; j++)
                    System.out.print(matriz[i][j] + " | ");
                System.out.println();
            }
        }
    }
    

