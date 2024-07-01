/*Se registra  en una matriz V de N x M, su especie, utilizando un carácter alfabetico minúscula para las plantas
 cultivadas mientras que el resto de la vegetecion se identifican con letras mayuscula. La siguiente matriz 
 representa una huerta de 3 surcos de longitud 20, para eliminar malezas el laser solo puede accionarse cuando
  existen mas de R especies vegetales no cultivadas consecutivas. Para eliminar las plantas que no son beneficiosas
se cuenta con un arr B de tamaño 3 que indica cuales son las beneficiosas arr[]B={‘C’,’O’,’L’}.
Se pide realizar un programa JAVA que indique como quedaría la huerta luego de aplicar el laser con lo datos
 ya aportados y debe indicar la cantidad total de malezas eliminadas en toda la huerta

 matriz dada
 {'x','t','a','C','M','O','t','a','a','t','O','C','t','t','a','O','M','C','t','x'},
{'x','r','r','r','C','C','O','O','r','r','C','r','G','G','G','r','r','x','x','x'},
{'x','m','G','m','h','h','L','G','G','O','h','h','m','m','O','B','M','C','x','x'}
resultado
 {'x','t','a','C','O','t','a','a','t','O','C','t','t','a','O','C','t','x','x','x'},
{'x','r','r','r','C','C','O','O','r','r','C','r','r','r','x','x','x','x','x','x'},
{'x','m','G','m','h','h','L','O','h','h','m','m','O','C','x','x','x','x','x','x'}
cantidad de malezas eliminadas=9
 */
public class recu_mio {
    public static final int MAXC=20;
    public static final int MAXF=3;
    public static final int MAX_arr=3;
    public static final int R=2;

    public static void main(String[] args) {
        char [][] matriz = {{'x','t','a','C','M','O','t','a','a','t','O','C','t','t','a','O','M','C','t','x'},
                            {'x','r','r','r','C','C','O','O','r','r','C','r','G','G','G','r','r','x','x','x'},
                            {'x','m','G','m','h','h','L','G','G','O','h','h','m','m','O','B','M','C','x','x'}
      };
      char [] arr = {'C','O','L'};
      mostrar(matriz);
      descomprimir(matriz,arr);
      mostrar(matriz);
    }
    public static int buscar_veg(char[]mat,char[]arr){
        int ini = 0;
        int fin = -1;
        int cant=0;
        int canTotal=0;
        int sec=0;
        while (ini < MAXC) {
            ini = buscarInicio(mat, fin+1);
            if (ini<MAXC){
                fin = buscarFin(mat, ini);
                sec=fin-ini+1;
                if (sec>R) {
                    cant=buscar_arr(ini,fin,arr,mat);
                    if (cant>0) {
                        canTotal+=cant;
                        fin=ini;
                    }
                }
            }
        }
        return canTotal;
    }
    public static boolean mayuscula(char c){
    return ('A' <= c && c <= 'Z'); 
    // c  >='a' && c <= 'z' devuelve true si esta entre la A y la Z
    }
    /*public static void eliminar(int ini,int fin,char[]mat){
        for(int i=ini; i<fin; i++){
            corrimiento_izq(i,mat);
        }
    }*/
    //1_ME EQUIVOQUE EN LLAMAR A ELIMINAR EN TODA LA SEC YO SOLO QUIERO ELIMINAR UNA OCURRENCIA DE ESA SEC POR ESO
    //LO LLAMO SOLO UNA VEZ
    //2_AL BUSCAR INI Y FIN ME EQUIVOQUE LLAMANDO LA FUNCION
    //3_LUEGO DE ELIMINAR DEBO RESTAR O ACT I-- Y FIN-- PARA QUE SIGA BUSCANDO EN LA MISMA SEC
   
    public static void corrimiento_izq(int ini, char[]mat){
        for(int i=ini; i<MAXC-1; i++){
            mat[i]=mat[i+1];
        }System.out.println();
        mostrar_arr(mat);
    }

    /*public static int buscar_arr(int ini, int fin, char[] arr, char[] mat) {
        int cant = 0; 
        // Recorrer desde el índice de inicio hasta el índice de fin
        for (int i = ini; i <= fin; i++) {
            if (mayuscula(mat[i]) && !contiene(arr, mat[i])) {
                cant++; // Incrementar el contador de malezas
                if (cant > R) {
                    eliminar(ini, fin, mat);
                }
            }
        }
        return cant;
    }*/

    public static int buscar_arr(int ini,int fin,char[]arr,char[]mat) {
        int eliminado=0;
        for (int i = ini; i <= fin; i++) {
            if (!contiene(arr,mat[i]) && mayuscula(mat[i])) {
                corrimiento_izq(i, mat);
                eliminado++;
                i--;//CORREGIDO 
                fin--;
            }
        }
        return eliminado; 
    }
    
    public static boolean contiene(char[] arr, char c) {
        for (int j = 0; j < MAX_arr; j++) {
            if (arr[j] == c && mayuscula(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static int buscarFin(char[] mat, int fin) {
       while (fin<MAXC && mayuscula(mat[fin])) {//mal
        fin++;
       }
       return fin-1;
    }
    public static int buscarInicio(char[]mat,int ini){
        while (ini<MAXC && !mayuscula(mat[ini])) {//mal
            ini++;
        }
        return ini;
    }

    public static void descomprimir(char[][]matriz,char[]arr){
        int canTotal=0;
        for(int i=0;i<MAXF;i++){
            int cant=buscar_veg(matriz[i],arr);
            canTotal+=cant;
        }System.out.println("la cant total es:"+canTotal);
    }


    public static void mostrar(char[][] matriz){
        for(int i=0; i<MAXF; i++){
            mostrar_arr(matriz[i]);
        }
    }
    public static void mostrar_arr(char[]mat){
        for(int i=0; i<MAXC; i++){
            System.out.print(mat[i]+"|");
        }System.out.println();
    }
}
