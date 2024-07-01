public class prefinal_mat {
    public static final int N = 3;
    public static final int M = 15;
    public static final int SEP = 0;
    
    public static void main(String[] args) {
      
        int[][] mat = {{0,0,150,200,165,0,154,352,240,256,0,900,750,0,0},
                       {0,940,105,265,845,215,0,245,765,348,0,741,125,541,0},
                       {0,851,543,625,845,914,0,754,184,452,637,917,0,0,0}
                      };
        
        int[] A1 = {1,2,0};
        int[] A2 = {3,0,0};
        
        int X = 600;
        generarEstadAnuales(mat, A1, A2, X);
    }
      
    public static int buscarInicio(int[] arr, int pos){
      
      while(pos < M && arr[pos] == SEP){
        pos++;
      }
      
      return pos;
      
    }
    
    public static int buscarFin(int[] arr, int pos){
      
      while(pos < M && arr[pos] != SEP){
        pos++;
      }
      
      return pos-1;
      
    }
    
    public static int mayorSec(int[] arrSec, int ini, int fin){
      int mayorActual = arrSec[ini];
      for(int i = ini+1; i <= fin; i++){
        if(arrSec[i] > mayorActual){
          mayorActual = arrSec[i];
        }
      }
      
      return mayorActual;
    }
    
    public static double promedioMayElemSec(int[] arrSec){
      
      int ini = 0, fin = -1;
      int suma = 0, dias = 0;
      
      while(ini < M){
        ini = buscarInicio(arrSec, fin + 1);
        if(ini < M){
          fin = buscarFin(arrSec, ini);
          //Procesamiento de la secuencia
          suma += mayorSec(arrSec, ini, fin);
          dias++;
        }
      }
      
      if(dias != 0){
        return (double) suma / (double) dias;
      }
      else{
        return -1.0;
      }
    }
    
    public static boolean estaElemento(int[] arrMes, int mes){
      
      int i = 0;
      while(arrMes[i] != SEP && arrMes[i] != mes){
        i++;
      }
      
      return arrMes[i] != SEP;
      
    }
    
    public static double promedioSec(int[] arrSec, int ini, int fin){
      
      int suma = 0;
      int longSec = fin - ini + 1;
      for(int i = ini; i <= fin; i++){
        suma+= arrSec[i];
      }
      return (double) suma / (double) longSec;
    }
    
    public static boolean buenPromedio(int[] arrSec, int X){
      
       int ini = 0, fin = -1;
       boolean buen = true;
       
       while(ini < M && buen ){
         ini = buscarInicio(arrSec, fin+1);
         if(ini < M){
           fin = buscarFin(arrSec, ini);
           //Procesamiento de la secuencia
           if(promedioSec(arrSec,ini,fin) <= X){
             buen = false;
           }
         }
       }
      
       return buen;
      
    }
    
    public static void generarEstadAnuales(int[][] mat, int[] A1, int[] A2, int X){
      
      for(int fila = 0; fila < N; fila++){
        if( estaElemento(A1, fila+1)){
          System.out.println("El promedio de los mayores numeros de cada sec da: "+ promedioMayElemSec(mat[fila]));               
        }
        else if( estaElemento(A2, fila+1)){
          if(buenPromedio(mat[fila], X)){
            System.out.println("El promedio diario supera al valor dado");
          }
          else{
            System.out.println("El promedio diario no supera al valor dado");
          }
        }
      }
    }
    
  }
