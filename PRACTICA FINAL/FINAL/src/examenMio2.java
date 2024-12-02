public class examenMio2 {
    public static void main(String[] args) {
        int FILAS = 4;
        int cols = 6;
        int [][] mat = {
            {3,5,6,4,5,5},
            {1,6,2,6,6,3},
            {4,9,5,4,8,2},
            {3,3,2,3,7,5}
        };
        int i = 1; int j=1;
        int suma = mat[0][0];
        while (i<FILAS && j<cols && suma<FILAS*cols) {
            suma+=mat[i][j];
            if (mat[i][j] % mat[i-1][j-1]==0) {
                int aux = mat[i][j];
                int auxx = mat[i-1][j-1];
                i++;
            }
            j++;
        }
        System.out.println("i= "+i+"; j= "+j+"; suma= "+suma);
    }
}
