/*me pide que dada una matriz donde las filas son los dias y cada sec una hora determinada, recorra
cada fila y saque promedio de cada sec, cada promedio debe ser mayor al promedio anterior y si es asi
debo evaluar que el siguiente dia cumpla con lo mismo para que sea 'true', si se cumple en un dia 
pero no en el siguiente en 'false'
 */
public class prefi_mat_mio {
    public static final int MAXC=15;
    public static final int MAXF=4;
    public static final int SEPARADOR=0;
    public static void main(String[] args) {
        int [][] matriz = {{0,625,815,900,0,562,952,300,0,365,169,254,0,0,0},
                           {0,958,67,57,221,0,596,623,600,0,587,889,984,0,0},
                           {0,0,700,257,0,0,0,854,958,388,0,954,842,925,0},
                           {0,988,899,874,0,254,258,625,200,0,568,958,210,0,0}};
        int dias_consecutivos=2;
        descomprimir(matriz,dias_consecutivos);
    }

    public static void descomprimir(int [][] matriz, int dias_consec){
        int cant=0,sies=0;
        for(int i=0; i<MAXF; i++){
            int creciente= es_creciente(matriz[i]);
            if (creciente>0) {
                cant++;
                if (cant==dias_consec) {
                    sies+=cant;
                    cant=0;
                    System.out.println("cumple en "+sies+" dias");
                }
            }else{
                cant=0;
            }
        }
    }

    public static int es_creciente(int [] mat){
        int ini=0,fin=-1,cant=0;
        float prom=0;
        boolean aux=true;
        while (ini<MAXC && aux) {
            ini=buscarInicio(mat,fin+1);
            if (ini<MAXC) {
                fin=buscarFin(mat,ini);
                    float total = prom_creciente(ini, fin, mat);
                    if (total>prom) {
                        prom=total;
                        cant=1;
                    }else{
                        cant=0;
                        aux=false;
                    }
                    
                    /*if (prom_creciente(ini,fin,mat)) {
                        cant=1;
                    }else{
                        cant=0;
                        aux=false;
                    }*/
                
            }
        }
        return cant;
    }
    //ME EQUIVOQUE EN Q UNA MISMA FUNCION COMPARE EL ANTERIOR CUANDO DEBI HACERLO EN OTRA
    //PORQ CADA VEZ Q ITERA PROM ANTERIOR VUELVE A SER 0 EMTONCES AL LLAMARLO DESDE EL 
    //ES CRECIENTE PROM ANTERIOR VA A VALER EL ANTERIOR DE LA SEC Y CUANDO TERMINE Y LLAME DE NUEVO
    //VA A VALER 0

    /*public static boolean prom_creciente(int ini,int fin,int[]mat){
        int sec=0,sum=0;
        sec=fin-ini+1;
        float prom_anterior=0;
        while (ini<=fin) {
            sum+=mat[ini];
            ini++;
        }
        float total = sum/sec;
        if (total>prom_anterior) {
            prom_anterior=total;
            return true;
        }else{
            return false;
        }
    }*/
    public static float prom_creciente(int ini,int fin,int[]mat){
        int sec=0,sum=0;
        sec=fin-ini+1;
        while (ini<=fin) {
            sum+=mat[ini];
            ini++;
        }
        float total = sum/sec;
        return total;
    }

    
    public static final int buscarInicio(int[]mat, int ini){
        while (ini<MAXC && mat[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static final int buscarFin(int[]mat, int fin){
        while (fin<MAXC && mat[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }
}

