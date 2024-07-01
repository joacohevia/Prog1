public class recu_mat_decom_pixel {
    final static int COLUMNAS=20;
    final static int FILAS=3;
    final static int SEPARADOR=0;
    final static int X=3;
    public static void main(String[] args){
        int[][] imagen={
            {0,-8,67,0,14,0,-4,33,0,5,98,0,0,0,0,0,0,0,0,0},
            {0,0,25,25,0,-5,3,0,25,44,44,0,-4,1,0,0,0,0,0,0},
            {0,44,44,44,0,-7,15,0,-4,9,0,12,0,0,0,0,0,0,0,0}
        };
        imprimir_matriz(imagen);
        descomprimir_matriz(imagen);
        imprimir_matriz(imagen);
    }
    public static void descomprimir_matriz(int [][] imagen){
        int maxDescomprimidosFila=0;
        int maxFila=0;
        int totalDescomprimidos=0;
        for (int fila=0; fila<FILAS; fila++){
            int descomprimidosFila = descomprimir_fila(imagen[fila]);
            totalDescomprimidos+=descomprimidosFila;
            if (descomprimidosFila>maxDescomprimidosFila){
                maxDescomprimidosFila = descomprimidosFila;
                maxFila = fila;
            }

        }
        if (totalDescomprimidos>0){
            System.out.println("Total: "+totalDescomprimidos+" Fila: "+maxFila);
        }else{
            System.out.println("No hubo pixeles para descomprimir en la imagen");
        }
    }
    public static int descomprimir_fila(int[]arr){
        int totalDescomprimidos=0;
        int ini=0, fin=-1;
        while (ini<COLUMNAS){
            ini = obtener_inicio_secuencia(arr, fin+1);
            if (ini<COLUMNAS){
                fin = obtener_fin_secuencia(arr, ini);
                //Evaluar condicion
                int cantidad = -arr[ini];
                if (cantidad>0){
                    int pixel = arr[ini+1];
                    //Modificar la secuencia si es necesario
                    descomprimir_secuencia(arr,ini,cantidad,pixel);
                    totalDescomprimidos+=cantidad;    
                    fin++;//Se suman los agregados y se descuentan las dos existentes para  posicion y cantidad
                }
      
            }
        }
        return totalDescomprimidos;
    }
    public static void descomprimir_secuencia(int[] arr, int pos, int cantidad, int pixel){
        arr[pos]=pixel;  //Reemplazo ini[-8] por un 67
        cantidad = cantidad - 2;//emtonces tengo dos 67 me faltan poner 6
        while (cantidad>0){
            corrimiento_derecha(arr, pos,pixel);
            cantidad--;
            //arr[pos]=pixel;
            //puedo ponerlo aca o en el corrimiento
        }

    }
    public static void corrimiento_derecha(int[] arr, int pos, int pixel){
        for (int i=COLUMNAS-1; i>pos; i--){
            arr[i] = arr[i-1];
        }arr[pos]=pixel;
        
    }
    public static void imprimir_arreglo(int [] arr){
        for (int pos = 0; pos < COLUMNAS; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }
    public static void imprimir_matriz(int [][] arr){
        for (int pos = 0; pos < FILAS; pos++){
            imprimir_arreglo(arr[pos]);;
        }
        System.out.print("\n");
    }
    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<COLUMNAS && arrEnteros[ini]!=SEPARADOR)
            ini++;
        return ini-1;
    }
    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
        while (ini<COLUMNAS && arrEnteros[ini]==SEPARADOR)
            ini++;
        return ini;
    }

}
