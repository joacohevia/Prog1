public class examenMio {
    public static final int SEP=0;
    public static final int MAXC=20;
    public static final int MAXF=3;
    public static final int MAXarr=3;

    public static void main(String[] args) {
        int [][] matriz =
        {{0,12,15,-18,0,5,-55,63,88,0,0,-74,-99,0,0,11,25,64,0,0}
        ,{0,0,2,-6,52,0,0,-85,87,89,0,0,1,10,20,-30,0,0,0,0},
        {0,8,-23,24,33,84,-98,0,0,21,22,-34,-36,-44,0,4,13,26,0,0}};

        char [] arr = {'A','C','T'};
        int cod=86,estanteria=1,buscado=-13;
        char letra = 'A';

        descomprimir(matriz,arr,cod,estanteria,letra,buscado);
        mostrarMat(matriz);

    }
    public static void descomprimir(int[][]matriz, char[]arr,int cod,int estanteria,char letra,int buscado){
        int pos=-1;
        if (letra != ' '&& cod>0 && estanteria>0) {
            for (int i = 0; i < MAXarr; i++) {
                if (arr[i]==letra) {
                    pos = i;
                }
            }
            if (pos>=0 && pos<MAXF) {
                buscarLugar(matriz[pos],cod,estanteria);
            }
        }
        int cant=0,mayorCant=0;
        char letraMayor=' ';
        for (int i = 0; i < MAXF; i++) {
            cant = buscarCant(matriz[i]);
            if (cant>mayorCant) {
                mayorCant = cant;
                letraMayor = arr[i];
            }
        } 

        int busq=0;
        if (buscado !=0) {
            for (int i = 0; i < MAXF; i++) {
                busq = buscar(matriz[i],buscado);
                if (busq !=0 ) {
                    if (busq > 0 ) {
                        System.out.println("el libro: "+buscado+" esta disp");
                    }
                    else if (busq < 0) {
                        System.out.println("el libro: "+buscado+" no esta disp");
                    }
                }
            }
            if (busq==0) {
                System.out.println("no esta");

            }
        }    
        System.out.println("La tematica con mas prestados es: "+letraMayor +" estanteria con cant prestados "+mayorCant);
    }
    
    public static void buscarLugar(int[] mat, int cod, int estanteria) {
        int ini=0,fin=-1,cont=0;
        while (ini<MAXC) {
            ini=buscarIni(mat,fin+1);
            if (ini<MAXC) {
                fin=buscarFin(mat,ini);
                cont++;
                if (cont==estanteria) {
                    boolean aux = insertLibro(ini, fin, cod, mat);
                    if (aux) {
                        System.out.println("insertado");
                    }
                }
            }
        }
    }
    public static boolean insertLibro(int ini,int fin,int cod,int []mat){
        boolean aux=false,sies=false;
        while (ini<=fin && !sies) {
            if (cod>mat[ini] && mat[ini]>0) //|| cod>-mat[ini]) 
            {
                ini++;
            }
            else if (cod>-mat[ini] && mat[ini]<0) {
                ini++;
            }else{
                sies=true;
            }
            // cod 16
            // 15,-15,17,-17
        }
        if (corrDer(ini,cod,mat)) {
            aux=true;
        }
        return aux;
    }
    public static boolean corrDer(int ini,int cod,int [] mat){
        boolean aux = true;
        for (int i = MAXC-1; i > ini; i--) {
            mat[i] = mat[i-1];
        }mat[ini]=cod;
        return aux;
    }

    public static int buscar(int []mat,int busq){
       int aux = 0;
       for (int i = 0; i < MAXC; i++) {
            if (mat[i]==busq || -mat[i]==busq) {
                aux = mat[i];
            }
        }
        return aux;
    }


    public static int buscarCant(int []mat){
        int ini=0,fin=-1,negativos=0,negM=0;
        while (ini<MAXC) {
            ini=buscarIni(mat,fin+1);
            if (ini<MAXC) {
                fin=buscarFin(mat,ini);
                negativos = contarNeg(mat,ini,fin);
                if (negativos>negM) {
                    negM=negativos;
                }
            }
        }
        return negM;
    }
    public static int contarNeg(int []mat,int ini, int fin){
        int cont=0;
        while (ini<=fin) {
            if (mat[ini]<0) {
                cont++;
            }
            ini++;
        }
        return cont;
    }
    public static int buscarIni(int []mat,int ini){
        while (ini<MAXC && mat[ini]==SEP) {
            ini++;
        }
        return ini;
    }
    public static int buscarFin(int []mat, int fin){
        while (fin<MAXC && mat[fin]!=SEP) {
            fin++;
        }
        return fin-1;
    }
    public static void mostrarMat(int [][]matriz){
        for (int i = 0; i < MAXF; i++) {
            mostrarArr(matriz[i]);
        }
    }
    public static void mostrarArr(int[]mat){
        for (int i = 0; i < MAXC; i++) {
            System.out.print(mat[i]+"|");
        }System.out.println();
    }
}

