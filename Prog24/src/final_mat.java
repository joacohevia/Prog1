/*Uso S=8 y P=20 para definir los parametros en q me voy en mover en la matriz
es decir en esos parametros dados yo voy a poder eliminar las sec de los arr de la mat
Emtonces recorro la matriz desde S y si coincide con un elemento del arr_horarios emtonces
recorro la matriz por arr_mat
-busco las sec
-comparo la q la long sea >=H
-que sea decreciente
--Recorro la sec y busco si: su primer elemento es >=E=50
o si la suma de cuantos dan 50, y sino elimino todos
*/
public class final_mat {
    public static final int E=50;
    public static final int MAXC=10;
    public static final int P=20;//20 es P q seria max del rango horario, y empesaria desde S=8;
    public static final int S=8;
    public static final int MAX_arr=8;
    public static void main(String[]args){
        int [][] matriz={{0,43,27,11,0},
                         {0,20,19,18}};

        int [] arr_horarios = {9,11,15,17,};
        descomprimir(matriz,arr_horarios);
    }
    public static void descomprimir(int [][]matriz,int [] arr_horarios){
        for(int fila=S; fila<P;fila++){
            if (buscar_en_arr(arr_horarios,fila)) {
                //buscar_sec ->recorrer_sec(arr_horarios, fila);
            }
        }
    }

    public static boolean buscar_en_arr(int []arr_horarios,int fila){
        for(int i=0; i<MAX_arr; i++){
            if (arr_horarios[i]== fila) {
                return true;
            }
        }
        return false;
    }

    public static int eliminar(int ini,int fin,int[]mat){
        boolean sies=false;
        int i=ini,cant=0,suma=0;
        while (i<=fin && !sies) {
            if (i==ini && mat[i]>=E) {//i==ini porque en la segunda ejecucion si no entro aca
                cant=1;               //no va a entrar mas ya que i va a vale la segunda pos y se va a comparar 
                sies=true;             // con ini q va a valer la pos 1
            }
            else if (suma<=E) {
                suma+=mat[i];
                cant+=1;
            }
            i++;
        }
        return cant;
    }
    //otra forma mas clara. En la primera iteracion suma vale 43 asiq elimina una pos
    // en la segunda iteracion vale 43 + el q le sigue asiq eliminar de nuevo, cuando
    //quiere volver a entrar es mayor a 50 asiq no vuelve a entrar
    
    public static void recorrer_sec(int []mat, int ini){
        int suma=0;
        while (suma<=E && mat[ini] != 0) {
            suma+=mat[ini];
            corrimiento_izq(mat,ini);
        }
    }

    public static void corrimiento_izq(int [] mat, int ini){
        for(int i=ini; i<MAXC-1; i++){
            mat[ini]=mat[ini+1];
        }
    }
}

