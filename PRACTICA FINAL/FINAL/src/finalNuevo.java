/*Segun el enunciado pide: dada una matriz donde cada fila es una especie
y dentro de cada especie hay sec de ADN separadas por espacios = ' ' es decir
que cada columna tiene ADN de INDIVIDUOS de una misma especie. La primera y la ultima
fila tine 2 INDIVIDUOS. Me dan un arr donde la primera sec esta el error y la siguiente sec la solucion
debo encontrar los errores y cambiarlos o pisarlos por las soluciones y informar la cantidad de 
veces que modifico errores 
 */

public class finalNuevo {
    public static final char SEP= ' ';
    public static final int MAXF=3;
    public static final int MAXC=20;
    public static final int MAXarr=20;
    public static void main(String[] args) {
        char [][] matriz = {{' ','A','T','C','G','C','C',' ','A','A','T','C','G','C','A',' ',' ',' ',' ',' '},
        {' ','T','C','C','A','G',' ','A','C','C','T','A',' ','C','C','A','A','C',' ',' '},
        {' ','G','G','A','T','C','A','G','G',' ','A','A','C','T','C','G','T','A',' ',' '}
    };
    char [] patron = {' ','C','C',' ','C','T',' ','A','A','C',' ','T','A','C',' ',' ',' ',' ',' ',' '};

    mostrarMat(matriz);
    //System.out.println("---");
    //mostrarArr(patron);
    descomprimir(matriz,patron);
    mostrarMat(matriz);
    }
    public static void descomprimir(char[][]matriz,char[]patron){
        int cant=0;
        for (int i = 0; i < MAXF; i++) {
            cant+=buscarError(matriz[i],patron);
        }
        System.out.println("cant de cambios: "+cant);
    }
    public static int buscarError(char[]mat,char[]pat){
        int iniE=0,iniS=0,finE=-1,finS=-1,cant=0,total=0;
        while (iniE<MAXarr) {
            iniE=buscarIni(pat,finE+1);
            if (iniE<MAXarr) {
                finE=buscarFin(pat,iniE);
                finS = finE;//para que busque iniS desde la ultima sec
                iniS=buscarIni(pat,finS+1);
                finS=buscarFin(pat,iniS);
                cant+=buscarSec(iniE,iniS,finE,finS,mat,pat);
                if (cant>0) {
                    System.out.print("->");
                    mostrarArr(mat);
                    total++;
                }
                finE = finS+1;//para que vuelva a buscar desde el finS q es la ultima pos
            }
        }
        return total;
    }
    
    public static int buscarSec(int iniE,int iniS,int finE,int finS,char[]mat,char[]pat){
        int ini=0,fin=-1, aux=0;
        while (ini<MAXC) {
            ini=buscarIni(mat,fin+1);
            if (ini<MAXC) { 
                fin=buscarFin(mat,ini);
                int cc = coincidePatron(mat,ini,fin,pat,iniE,finE);
                if (cc>0) {
                    tieneError(iniS,finS,cc,fin,mat,pat);
                    aux++;
                }
            }
        }
        return aux;
    }
    
    
    public static int coincidePatron(char[] mat, int ini, int fin, char[] patron, int iniError, int finError) {
        int aux = 0;
        int sec=finError-iniError+1;
        int inicioAux = iniError;
        int cont=0;
        for (int i = ini; i <=fin; i++) {
            if (mat[i] == patron[iniError]) {
                cont++;
                iniError++;
                if (cont==sec) {
                    aux=i-sec+1;
                    //i es la ultima pos que coincidio, por eso le resta sec que es el tamaño de 
                    //la sec de ERROR mas 1 para que de bien
                }
            }else{
                //si no son iguales vuelve a los valores predeterminados(tiene que ser consecutivo)
                cont=0;
                iniError=inicioAux;
            }
        }
        return aux;
    }
    public static void tieneError(int iniS, int finS, int ini, int fin, char[] mat, char[] pat) {
        for (int i = ini; i <= fin; i++) {
            if(iniS<=finS){
            mat[i] = pat[iniS];
            iniS++;
            }
        }
        //System.out.println("------");
        //mostrarArr(mat);
    }
   
    public static int buscarIni(char[]mat,int ini){
        while (ini<MAXC && mat[ini]==SEP) {
            ini++;
        }
        return ini;
    }

    public static int buscarFin(char []mat,int fin){
        while (fin<MAXC && mat[fin]!=SEP) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrarMat(char [][]matriz){
        for (int i = 0; i < MAXF; i++) {
            mostrarArr(matriz[i]);
        }
    }
    public static void mostrarArr(char[]mat){
        for (int i = 0; i < MAXC; i++) {
            System.out.print(mat[i]+"|");
        }System.out.println();
    }
    
}
