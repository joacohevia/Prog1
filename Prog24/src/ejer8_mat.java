import java.io.BufferedReader;
import java.io.InputStreamReader;
/*8. Hacer un programa que dada una matriz de enteros ordenada

creciente por filas de tamaño 4*5 que se encuentra precargada,
solicite al usuario un número entero y una fila, y elimine la primera
ocurrencia de número en la fila indicada (un número igual) si
existe. */

public class ejer8_mat {
     final static int MAXF=4, MAXC=5;
        public static void main(String[]args){
            int [][] matriz={   {1,2,3,4,5},
                                {1,2,3,4,5},
                                {1,2,3,4,5},
                                {1,2,3,4,5}
                            };
            int numero = solicitarNumero();
            int fila = solicitarFila();
            int col=0;
    
            mostrarMatriz(matriz);
        
            col=buscarPosCol(matriz[fila], numero, col);
            corrimientoAIzquierda(matriz[fila], col, numero);
            
            mostrarMatriz(matriz);
            }
            
        public static void corrimientoAIzquierda(int[]arr,int col, int numero){
            while(col<MAXC-1){
                arr[col]=arr[col+1];
                col++;
                }
                if(arr[col]==numero);
                    arr[col] = 0;
            }
        
    
        public static int buscarPosCol(int[]arr, int numero, int col) {
            while(col<MAXC && arr[col] != numero){
                col++;
            }
                return col;
        }
        
            public static int solicitarNumero() {
            int numero=0;
            try {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Ingrese un numero entero:");
                numero = Integer.valueOf(entrada.readLine());
                
            } catch (Exception e) {
                System.out.println(e);
            }
            return numero;
        }
        public static int solicitarFila() {
            int numero=0;
            try {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Ingrese un numero del 0 al 3:");
                numero = Integer.valueOf(entrada.readLine());
                
            } catch (Exception e) {
                System.out.println(e);
            }
            return numero;
        }
        public static void mostrarMatriz(int[][]matriz){
                    for(int i=0; i<MAXF;i++){
                        mostrarArreglo(matriz[i]);
                    } System.out.println();
        }
        public static void mostrarArreglo(int[] arr) {
            for(int i=0;i<MAXC;i++){
                System.out.print(arr[i] + "|");
            } System.out.println();
        }
    }

