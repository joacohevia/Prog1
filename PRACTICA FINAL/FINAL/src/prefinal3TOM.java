public class prefinal3TOM {
        public static final int MAXFILA = 3;
        public static final int MAXCOLUMNA = 20; 
        public static final int SEPARADOR = 0;
        public static final int N = 3;
        
        public static void main(String[] args) {
            int [][] matriz =
            {   {0,12,15,-18,0,5,-55,63,88,0,0,-74,-99,0,0,11,25,64,0,0},
                {0,0,2,-6,52,0,0,-85,87,89,0,0,1,10,20,-30,0,0,0,0},
                {0,8,-23,24,33,84,-98,0,0,21,22,-34,-36,-44,0,4,13,26,0,0}
            };
            System.out.println("MATRIZ");
            imprimir_matriz_int(matriz);

            char[] arr = {'a', 'c', 't'};  // Letras asociadas a cada fila
            int r = 75;  // Ejemplo de un valor para insertar
            char letra = 'a';
            int estanteria =1;
            int numero =12;
            System.out.println("ARREGLO");
            imprimir_arreglbo(arr);
            
            procesar_fila(matriz, arr, r,letra,estanteria,numero);
            System.out.println("MATRIZ DESPUES DEL CAMBIO");
            imprimir_matriz_int(matriz);
        }

        public static void procesar_fila(int[][] matriz, char[] arr, int r,char letra,int estanteria,int numero) {
            int mayor = 0;
            char letramayor = ' ';  // Inicializamos la variable para la letra mayor
            int pos = obtenerposletra(arr, letra);
            if(pos<MAXFILA){
                //inserte un libro 
                agregar_libro(matriz[pos], r,estanteria);
            }
            
            
            //para el metodo obtener el mayor de libros prestados
            for(int i=0;i<MAXFILA;i++){
                int cantidad = cantlibrosprestados(matriz[i]);
                if(cantidad>mayor){
                    mayor = cantidad;
                    letramayor = arr[i];
                }
            }
            if(sediobajanumero(matriz[pos], numero)){
                letramayor = arr[pos];
                System.out.println("la letra " + letramayor + " se dio de baja el libro " + numero);
            }else{
                System.out.println("la letra " + letramayor + " no se pudo dar de baja el libro " + numero + " porque está prestado");
            }

            
        
            System.out.println("la letra identificadora " + letramayor + " cuenta con la cantidad de libros prestados " + mayor);
        }
        public static boolean sediobajanumero(int[]arr,int numero){
            int ini=0,fin=-1;
            boolean sediobaja  = false;;
            while(ini<MAXCOLUMNA && !sediobaja){
                ini = buscar_inicio(arr, fin+1);
                if(ini<MAXCOLUMNA){
                    fin = buscar_fin(arr, ini);
                    if(noprestado(arr, numero)){
                        darbaja_numero(arr, numero);
                        sediobaja  = true;
                        fin=ini;
                    }
                }
            }
            return sediobaja;
        }

        //-CHEQUEAR ESTOS DOS METODOS-------------------------------------

        //este metodo no me elimina el numero 12 , pero seria el metodo correcto para eliminar el numero 12
        //pero pierdo el numero -18 ajjajajaja
        /* 
        public static void darbaja_numero(int[] arr, int numero) {
            // Busca la posición del número en el arreglo
            int pos = buscar_pos_numero(arr, numero);
            System.out.println("Buscando el número " + numero + " en la posición: " + pos);
        
            // Si encontramos la posición y el número es el que queremos eliminar
            if (pos != -1 && arr[pos] == numero) {
                corrimiento_izquierda(arr, pos);  // Elimina el número realizando el corrimiento
                System.out.println("El número " + numero + " ha sido dado de baja.");
            }
        }
            */

        //este metodo me elimina el numero 12 pero me elimina el -18 nada que ver jaja
        //pero este metodo seria para eliminar todos los 12 de cada fila no estaria muy bien
         
        public static void darbaja_numero(int[] arr, int numero) {
            // Busca la posición del número en el arreglo
            int pos = buscar_pos_numero(arr, numero);
            boolean seelimino = false;
            System.out.println("Buscando el número " + numero + " en la posición: " + pos);
            
            while (pos != -1 ) {  // Repetir mientras se siga encontrando el número
                if (arr[pos] == numero) {  // Asegurarse de que el número es positivo
                    corrimiento_izquierda(arr, pos);  // Elimina el número realizando el corrimiento
                    System.out.println("El número " + numero + " ha sido dado de baja.");
                }
                // Busca el siguiente número después del corrimiento
                pos = buscar_pos_numero(arr, numero);
            }
        }
    //--------------------------------------------------------------------------------------------
        
        public static boolean noprestado(int[]arr,int numero){
            boolean noprestado = false;
            int i=0;
            while(i<MAXCOLUMNA){
                if(arr[i]>0 && arr[i]==numero){
                    noprestado = true;
                }      
                i++;      
            }
            return noprestado;
        }
    
        
        public static int buscar_pos_numero(int[]arr,int numero){
            int pos=0;
            while(pos<MAXCOLUMNA && arr[pos]!=numero){
                pos++;
            }
            if(pos<MAXCOLUMNA && arr[pos]==numero){
                return pos;
            }else{
                return -1;
            }
        }

        public static void corrimiento_izquierda(int[] arr, int pos) {
            System.out.println("Corrimiento desde posición: " + pos);
            for (int i = pos; i < MAXCOLUMNA-1; i++) {
                arr[i] = arr[i+1];
            }
         
        }
        
    
        public static int cantlibrosprestados(int[]arr){
            int ini=0,fin=-1,cantidadtotal=0;
            while(ini<MAXCOLUMNA){
                ini = buscar_inicio(arr,fin+1);
                if(ini<MAXCOLUMNA){
                    fin = buscar_fin(arr, ini);
                    int cantidad = cantidadprestados(arr, ini, fin);
                    if(cantidad>cantidadtotal){
                        cantidadtotal = cantidad;
                    }
                }
            }
            return cantidadtotal;
        }
        public static int cantidadprestados(int[]arr,int ini,int fin){
            int cantidad=0;
            for(int i=ini;i<=fin;i++){
                if(arr[i]<0){
                    cantidad++;
                }
            }
            return cantidad;    
        }

        public static void agregar_libro(int[] arr, int r,int estanteria) {
            int ini = 0, fin = -1,cont=0;
            boolean seagrego = false;
            while (ini < MAXCOLUMNA && !seagrego) {
                ini = buscar_inicio(arr, fin + 1);
                if (ini < MAXCOLUMNA) {
                    fin = buscar_fin(arr, ini);
                    cont++;
                    if(cont == estanteria){
                        insertar_elemento(arr, ini, fin, r);
                        seagrego = true;
                        fin++;//en este caso no hace falta pero lo agrego igual, como se hizo corrDer 
                        //la sec es mas grande
                    }
                }
            }
        }
        
        public static int  obtenerposletra(char[]arr,char letra){
            boolean esletraa = false;
            int i=0;
            int pos=-1;
            while(i<N && !esletraa){
                if(arr[i]==letra){
                    pos = i;
                    esletraa = true;
                }
                i++;
            }
            return pos;
        }

        public static void insertar_elemento(int[] arr, int ini, int fin, int r) {
            corrimiento_derecha(arr, fin);// aca estabas pasando ini y tenias q pasar fin para que lo agregue al final
            arr[fin + 1] = r;
        }

        public static void corrimiento_derecha(int[] arr, int pos) {
            for (int i = MAXCOLUMNA - 1; i > pos; i--) {
                arr[i] = arr[i - 1];
            }
        }

        public static void imprimir_matriz_int(int[][] mat) {
            for (int fila = 0; fila < MAXFILA; fila++) {
                imprimir_arreglo(mat[fila]);
                System.out.println("");
            }
        }

        public static void imprimir_arreglo(int[] arr) {
            for (int pos = 0; pos < MAXCOLUMNA; pos++) {
                System.out.print(arr[pos] + "|");
            }
            System.out.print("\n");
        }

        public static void imprimir_arreglbo(char[] arr) {
            for (int pos = 0; pos < N; pos++) {
                System.out.print(arr[pos] + "|");
            }
            System.out.print("\n");
        }

        public static int buscar_inicio(int[] arr, int pos) {
            while (pos < MAXCOLUMNA && arr[pos] == SEPARADOR) {
                pos++;
            }
            return pos;
        }

        public static int buscar_fin(int[] arr, int pos) {
            while (pos < MAXCOLUMNA && arr[pos] != SEPARADOR) {
                pos++;
            }
            return pos - 1;
        }
    }
