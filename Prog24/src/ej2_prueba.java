public class ej2_prueba {
    public static void main(String[] args) {
        final int max = 3;
        char[][] mat = {
            {'f','c','a'},
            {'e','f','g'},
            {'c','g','e'}
        };
        int i = 0,j=1,contador=0;

        while (i < max-1 && j<max-1) {
            if (mat[i][j]>= mat[i][j+1]) {
                i++;
                contador+= i;
            }
            else if (mat[i][j]<= mat[i+1][j]) {
                j++;
                contador+=j;
            }else{
                i++; j++;
            }
        }
        System.out.println(i+" "+j+" "+contador);//1,2,3
    }
 
    /*public static void corrimiento_izq(int[] arr, int pos, int max) {
        for (int i = pos; i < max - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static void mostrar_arreglo(int[] arr, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }*/
}


