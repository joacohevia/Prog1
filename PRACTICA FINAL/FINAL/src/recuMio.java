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
public class recuMio {
    public static final int MAXC=20;
    public static final int MAXF=3;
    public static final int MAX=3;
    public static final int R=2;
    public static void main(String[] args) {
        char[][] matriz = {{'x','t','a','C','M','O','t','a','a','t','O','C','t','t','a','O','M','C','t','x'},
            {'x','r','r','r','C','C','O','O','r','r','C','r','G','G','G','r','r','x','x','x'},
            {'x','m','G','m','h','h','L','G','G','O','h','h','m','m','O','B','M','C','x','x'}
        };
        char [] cult = {'C','O','L'};
        mostrarMat(matriz);
        descomprimir(matriz,cult);        
        mostrarMat(matriz);  
    }
    public static void descomprimir(char [][] mat, char[]cult){
        int cant=0;
        for (int i = 0; i < MAXF; i++) {
            cant+=buscar_veg(mat[i],cult);
        }
        System.out.println("La cant eliminada: "+cant);
    }
    public static int buscar_veg(char[]mat,char []cult){
        int ini=0,fin=-1,cultivos=0,total=0;
        while (ini<MAXC) {
            ini=buscarIni(mat,fin+1);
            if (ini<MAXC) {
                fin=buscarFin(mat,ini);
                int sec = fin-ini+1;
                if (sec>R) {
                    cultivos = tieneCult(ini,fin,cult,mat);
                    if (cultivos>0) {
                        total+=cultivos;
                        fin=ini;
                    //la nueva sec que busque va a ser la misma pero con un valor menos
                    }
                }
            }
        }
        return total;
    }
    public static int tieneCult(int ini,int fin,char[] cult,char[]mat){
        int cant = 0;
        for (int i=ini; i<=fin; i++) {
        if (!contiene(cult, mat[i]) && esMayus(mat[ini])) { // Condición simplificada
            eliminarCult(i, mat); // Corrimiento a la izquierda
            cant++;
            i--; // Revisa el nuevo elemento en la misma posición
            fin--; // Ajusta el rango
    }
    }
    return cant;
    }
    public static boolean contiene(char[] arr, char c) {
        boolean aux=false;
        for (int j = 0; j < MAX; j++) {
            if (arr[j] == c && esMayus(c)) {
                aux=true;
            }
        }
        return aux;
    }
    public static void eliminarCult(int ini,char[]mat){
        for(int i=ini; i<MAXC-1; i++){
            mat[i] = mat[i+1];
        }
    }
    public static boolean esMayus(char cc){
        return (cc >= 'A' && cc <= 'Z');
    }
    public static int buscarIni(char []mat,int ini){
        while (ini<MAXC && !esMayus(mat[ini])) {
            ini++;
        }
        return ini;
    }
    public static int buscarFin(char[]mat,int fin){
        while (fin<MAXC && esMayus(mat[fin])) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrarMat(char[][]matriz){
        for (int i = 0; i <MAXF ; i++) {
            mostrarArr(matriz[i]);
        }
    }
    public static void mostrarArr(char[]mat){
        for(int i=0; i<MAXC; i++){
            System.out.print(mat[i]+"|");
        }System.out.println();
    }
}
