public class recu_mat_biblio {
    public static final int MAXCOL=20;
    public static final int MAXFIL=3;
    public static void main(String[] args) {
        int [][]hileras={{0,12,15,-18,0,5,-55,63,88,0,0,-74,-99,0,0,11,25,64,0,0,},
                         {0,0,2,-6,52,0,0,-85,87,89,0,0,1,10,20,-30,0,0,0,0,},
                         {0,8,-23,24,33,-84,-98,0,0,-21,22,-34,36,-44,0,4,-13,26,0,0,}};
        char[]generos={'A','C','T'};
        int codLibro=27;//ingresarCodigoLibro()
        char genero='T';//inicarGenero()
        int nroEstanteria=2;//indicarEstanteria()
        int ini=0;
        int fin=-1;
        int masPrestamos=0;
        int filaMasPrestados=0;
        int estante=0;
        int fila=obtenerFila(generos,genero);
        while((ini<MAXCOL)&&(estante!=nroEstanteria)){
            ini=buscarInicio(fila,hileras,fin);
            if(ini<MAXCOL){
                fin=buscarFin(hileras,fila,ini);
                estante++;   
            }
        if(estante==nroEstanteria){
            int pos=buscarPosInsercionLibro(codLibro,hileras,fila,ini,fin);
            insertaLibro(codLibro,hileras,fila,pos);
            fin=fin+1;
            }
        }
        for(int i=0;i<MAXFIL;i++){
            int cantPrestados=0;
            for(int j=0;j<MAXCOL;j++){
                if(hileras[i][j]<0){
                    cantPrestados++;
                }
                
            }
            if(cantPrestados>masPrestamos){
                masPrestamos=cantPrestados;
                filaMasPrestados=i;
            }
            
        }
        System.out.println("fila con mas prestamos "+filaMasPrestados);
        
        }

    public static int obtenerFila(char[]generos,char genero){
        int fila=0;
        int pos=0;
        while(generos[pos]!=genero){
            pos++;
        }
        fila=pos;
        return fila;
    }     

    public static int buscarInicio(int fila,int[][]hileras,int fin){
        int ini=fin+1;
        while((ini<MAXCOL)&&(hileras[fila][ini]==0)){
            ini++;
        }
        return ini;
    }

    public static int  buscarFin( int[][]hileras,int fila,int ini){
        int fin =ini;
        while((fin<MAXCOL)&&(hileras[fila][fin]!=0)){
            fin++;
        }
        return fin-1;
    }

     

    public static int buscarPosInsercionLibro(int codLibro, int[][]hileras,int fila,int ini, int fin){
        int pos=ini;
        int nro=hileras[fila][pos];
        if(nro<0){
            nro=signoNroConvertido(nro);
                   
        }
        while((signoNroConvertido(nro)<codLibro)&&(pos<fin)){ 
           
            pos++;
            nro=hileras[fila][pos];
           
           
        }
        return pos;
    }

    public static void insertaLibro(int codLibro,int [][]hileras,int fila,int pos){
        corrimientoDerecha(hileras,fila,pos);
        hileras[fila][pos]=codLibro;
        for(int i=0;i<MAXCOL;i++){
            System.out.print(hileras[fila][i]);
        }
    }

    public static void corrimientoDerecha(int[][]hileras, int fila, int pos){
        for(int i=MAXCOL-1;i>pos;i--){
                 hileras[fila][i]=hileras[fila][i-1];
           }
    }
    
    public static int signoNroConvertido(int nro){
        
        if(nro<0){
            nro=nro*-1;
        }
       return nro;
   }
}