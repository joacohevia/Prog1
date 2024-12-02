public class ej_parcial_prac {
    /*dado un arr de sec de tamañio max en forma ascendente se pide invertir aquellas que contengan un
     * num dado para las q no rellenar con otro nunm dado
     */
        public static final int MAX = 16;
        public static final int SEPARADOR = 0;
        public static void main(String[] args) {
          
            int[] arr = {0,2,3,4,0,1,5,0,0,3,12,13,0,1,2,0};
            int numeroBuscado = 3;
            int numeroReemplazar = -1;
            mostrarArreglo(arr);
            modificarSecuencias(arr, numeroBuscado, numeroReemplazar);
            mostrarArreglo(arr);
          }

          public static void modificarSecuencias(int[] arr, int numeroBus, int numeroReem){
          
            int ini = 0;
            int fin = -1;
            
            while( ini < MAX ){
              ini = inicSec(arr, fin+1);
              if(ini < MAX){
                fin = finSec(arr, ini);
                //Procesamiento de la secuencia
                if (estaNumSecOrd(arr, ini, fin, numeroBus) ){
                  invertirSec(arr, ini, fin);
                }
                else{
                  rellenarSecNum(arr, ini, fin, numeroReem);
                }
              }
            }
          }

          public static void rellenarSecNum(int[] arr, int ini, int fin, int num){
          
            for(int i = ini; i <= fin; i++){
              arr[i] = num;
            }
            
          }
          
          public static void invertirSec(int[] arr, int ini, int fin){
            
             int i = ini;
             int j = fin;
             while(i < j){
               int aux = arr[i];
               arr[i] = arr[j];
               arr[j] = aux;
               i++;
               j--;
             }
          }
          
          public static boolean estaNumSecOrd(int[] arr, int ini, int fin, int num){
             int i = ini;
             while (i <= fin && arr[i] < num){
               i++;
             }
              if(i <= fin && arr[i] == num){
                return true;
              }
              else 
                  return false;
            /*
              }
              else
                   return false;
            */
            
          }
        
        public static void mostrarArreglo(int[] arr){
          
          for (int i = 0; i < MAX; i++){
            System.out.print(arr[i] + " ");
          }
          
          System.out.println();
          
        }
        
        public static int inicSec(int[] arr, int pos){
          while(pos < MAX && arr[pos] == SEPARADOR){
            pos++;
          }
          
          return pos;
        }
        
        
        public static int finSec(int[] arr, int pos){
          while(pos < MAX && arr[pos] != SEPARADOR){
            pos++;
          }
          
          return pos-1;
        }
        
       
        
       
        
      
      }

      

