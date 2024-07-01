/*El servicio de inteligencia secreto MD5 desea implementar un sistema de encriptación de documentos
ultrasecretos. Dichos documentos son almacenados en matrices de caracteres en donde cada fila representa
un renglón del mismo. Todos los renglones tienen M caracteres y comienzan y terminan con uno o más
espacios.
Se desea principalmente encriptar los nombres propios (comienzan con mayúscula) que aparezcan en el
documento, ya que seguramente harán referencia a información sensible como ciudades, espías propios o
agentes enemigos. El mecanismo de encriptación consiste en realizar una simple inversión de los caracteres
y la duplicación de las vocales minúsculas sólo de los nombres propios (secuencias) presentes en el
documento. Se pide (a) implementar el mecanismo de encriptación antes descrito sobre una matriz de NxM e
(b) informar, al finalizar la ejecución del mismo, la cantidad de secuencias encriptadas.
Por ejemplo, dada la siguiente matriz:
e l a g e n t e
J a m e s B o s e
e n c u e n t r a e n
C o l o n i a
Con 3 secuencias encriptadas, la matriz encriptada resultante sería:
e l a g e n t e
s e e m a a J o o B s e
e n c u e n t r a e n
a a i i n o o l o o C
Puede asumir que hay espacio suficiente para incorporar los caracteres que deba. El ejemplo es meramente
ilustrativo y para que sea más fácil la interpretación del enunciado. El programa realizado en JAVA
debe ser flexible para procesar cualquier matriz de NxM. */
public class recu_mat_encrip {
    public static final int MAXCOL=16;
    public static final int MAXFIL=4;
    public static final int SEPARADOR= ' ';
    public static void main(String[] args) {
        char [][] matriz = {
            {' ','e','l',' ','a','g','e','n','t','e',' ',' ',' ',' ',' ',' '},
            {' ','J','a','m','e','s',' ','B','o',' ','s','e',' ',' ',' ',' '},
            {' ','e','n','c','u','e','n','t','r','a',' ','e','n',' ',' ',' '},
            {' ','C','o','l','o','n','i','a',' ',' ',' ',' ',' ',' ',' ',' '}
        };
        mostrar_matriz(matriz);
        descomprimir(matriz);
        mostrar_matriz(matriz);
    }
    public static void descomprimir(char[][]matriz){
        int cantidad=0;
        for(int i=0; i<MAXFIL; i++){
            cantidad+= encriptar(matriz[1]);
        }
        System.out.println("se encriptaron: "+cantidad);
    }
    public static int encriptar(char[]arr){
        int ini=0,fin=-1,encriptado=0,cantT=0;
        while (ini<MAXCOL) {
            ini=buscar_ini(arr,fin+1);
            if (ini<MAXCOL) {
                fin=buscar_fin(arr,ini);
                if (Es_mayus(arr[ini])) {
                    encriptado = encriptacion(ini, fin, arr);
                    fin+=encriptado;//PREGUNTARR
                    cantT++;
                }
            }
        }
        return cantT;
    }
  
    public static int encriptacion(int ini,int fin,char[]arr){
        int cant=0;
            invertir(ini,fin,arr);
            cant+=duplicar_vocales(ini,fin,arr);
            return cant;
        }
    
    public static int duplicar_vocales(int ini, int fin,char []arr) {
        int cont=0;
        while (ini <= fin) {
            if (es_vocal(arr[ini])) {
                desplazar_derecha(arr,ini);
                cont++;
                ini++;
                fin++;//mueve doble para no duplicar el duplicado
            }
            ini++;
        }
        return cont;
    }
    public static void desplazar_derecha(char[] arr, int ini) {
        for (int i = MAXCOL-1; i > ini; i--) {
            arr[i] = arr[i-1];
        }
    }

    public static void invertir(int ini, int fin, char[]arr) {
        while (ini < fin) {
            char temp = arr[ini];
            arr[ini] = arr[fin];
            arr[fin] = temp;
            ini++;
            fin--;
        }
    }

   
    public static boolean es_vocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static boolean Es_mayus(char arr) {
        return arr >= 'A' && arr <= 'Z';
    }
 
    public static int buscar_ini(char[] arr,int ini){
        while (ini<MAXCOL && arr[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(char[] arr, int fin){
        while (fin<MAXCOL && arr[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }

    public static void mostrar_matriz(char[][] matriz) {
        for (int i = 0; i < MAXFIL; i++) {
            mostrar_arr(matriz[i]);
        }
    }
    
    private static void mostrar_arr(char [] mat) {
        for (int j = 0; j < MAXCOL; j++){
            System.out.print(mat[j] + " | ");
        }
        System.out.println();
    }
}
