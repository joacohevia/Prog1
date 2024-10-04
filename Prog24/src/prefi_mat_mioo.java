public class prefi_mat_mioo {
    public static final int MAXC=15;
    public static final int MAXF=6;
    public static final int SEPARADOR=0;
    public static void main(String[] args) {
        int [][] matriz = {{0,625,815,900,0,562,952,300,0,365,169,254,0,0,0},
        {0,958,67,57,221,0,596,623,600,0,587,889,984,0,0},
        {0,0,700,257,0,0,0,854,958,388,0,954,842,925,0},
        {0,988,899,874,0,254,258,625,200,0,568,958,210,0,0},
     {0,958,67,57,221,0,596,623,600,0,587,889,984,0,0},
        {0,0,700,257,0,0,0,854,958,388,0,954,842,925,0}};
int dias_consecutivos=2;
descomprimir(matriz,dias_consecutivos);
    }
    public static void descomprimir(int [][] matriz, int dias_consec){
        int cant=0,sies=0;
        
        for(int i=0; i<MAXF; i++){
            if (es_creciente(matriz[i])) {
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

    public static boolean es_creciente(int [] mat){
        int ini=0,fin=-1,cant=0;
        float prom=0;
        boolean aux=true,sies=false;
        while (ini<MAXC && aux) {
            ini=buscarInicio(mat,fin+1);
            if (ini<MAXC) {
                fin=buscarFin(mat,ini);
                    float total = prom_creciente(ini, fin, mat);
                    if (total>prom) {
                        prom=total;
                        sies=true;
                    }else{
                        aux=false;
                        sies=false;
                    }
                    
                    /*if (prom_creciente(ini,fin,mat)) {
                        cant=1;
                    }else{
                        cant=0;
                        aux=false;
                    }*/
                
            }
        }
        return sies;
    }

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

