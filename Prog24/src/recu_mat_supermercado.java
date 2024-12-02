public class recu_mat_supermercado {
    public static final int MAXC=15;
    public static final int MAXFIL=3;
    public static final int SEPARADOR=0;
    public static final int MAX_Arr=4;
    public static void main(String[] args) {
       int [][]matriz = {{0,0,150,200,165,0,154,352,240,256,0,900,750,0,0},
                        {0,940,105,265,845,215,0,245,765,348,0,741,125,541,0},
                        {0,851,543,625,845,914,0,754,184,452,637,917,0,0,0}};
       int [] A1 = {1,2,0,0};
       int [] A2 = {3,0,0,0};
       int X=400;
       calcular_prom(matriz,A1,A2,X);
    }
    public static void calcular_prom(int [][]matriz,int[]arr1,int []arr2, int X){
        int promedio=0;
            for(int i=0; i<MAX_Arr && arr1[i]!=SEPARADOR; i++){
                int j = arr1[i]-1;
                promedio = calcular_dia(matriz[j]);
                System.out.println("El mes "+arr1[i]+" su prom es: "+promedio);
            }
            for(int i=0; i<MAX_Arr && arr2[i]!=SEPARADOR; i++){
                int j2 = arr2[i]-1;
                if (calcular_mes(matriz[j2],X)) {
                    System.out.println("cumplio");
                }
                else{
                    System.out.println("no cumplio");
                }
            }
        
    }
    
    public static int calcular_dia(int[]arr){
        int ini=0,fin=-1,dias=0,num_mayor=0;
        while (ini<MAXC) {
            ini=buscar_ini(arr,fin+1);
            if (ini<MAXC) {
                fin=buscar_fin(arr,ini);
                int num = buscar_mayor(ini,fin,arr);
                num_mayor+=num;
                dias++;
            }
        }
        int T = num_mayor/dias;
        return T;
    }
    public static int buscar_mayor(int ini,int fin,int[]arr){
        int mayor=0;
        while (ini<fin) {
            if (arr[ini]>mayor) {
                mayor=arr[ini];
            }
            ini++;
        }
        return mayor;
    }
    public static boolean calcular_mes(int[]arr2,int X){
        int ini=0,fin=-1;
        while (ini<MAXC) {
            ini=buscar_ini(arr2,fin+1);
            if (ini<MAXC) {
                fin=buscar_fin(arr2,ini);
                if (!es_mayor(ini,fin,arr2,X)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean es_mayor(int ini,int fin, int[]arr2, int X){
        int sec=0,sum=0;
        sec = fin-ini+1;
        while (ini<=fin) {
            sum+=arr2[ini];
            ini++;    
        }
        float total = sum/sec;
        //System.out.println(total);
        if (total>X) {
            return true;
        }else{
            return false;
        }
    }

    public static int buscar_ini(int [] arr,int ini){
        while (ini<MAXC && arr[ini]==SEPARADOR) {
            ini++;
        }
        return ini;
    }
    public static int buscar_fin(int [] arr, int fin){
        while (fin<MAXC && arr[fin]!=SEPARADOR) {
            fin++;
        }
        return fin-1;
    }
}
