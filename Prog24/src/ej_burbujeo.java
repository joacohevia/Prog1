public class ej_burbujeo {
    public static final int MAX = 12;
    public static int[] arr = {0,3,1,2,0,5,4,6,0,4,3,0};
    public static void main(String[] args) {
                int inicio = 0;
                int fin = -1;
                while (inicio < MAX) {
                    inicio = buscarInicio(fin + 1);
                    if (inicio < MAX) {
                        fin = buscarFin(inicio);
                        if (fin < MAX) {
                            burbujeo(arr, inicio, fin);
                        }
                    }
                }
        
                mostrarArreglo(arr);
            }
            public static int buscarInicio(int pos) {
                while (pos < MAX && arr[pos] == 0) {
                    pos++;
                }
                return pos;
            }
            public static int buscarFin(int pos) {
                while (pos < MAX && arr[pos] != 0) {
                    pos++;
                }
                return pos - 1;
            }
            public static void burbujeo(int[] arr, int inicio, int fin) {
                int temp;
                for (int i = inicio; i < fin; i++) {
                    for (int j = inicio; j < fin - (i - inicio); j++) {
                        if (arr[j] > arr[j + 1]) {
                            temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            }
            public static void mostrarArreglo(int[] arr) {
                for (int i = 0; i < MAX; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
        
    

