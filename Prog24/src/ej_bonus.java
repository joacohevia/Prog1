
public class ej_bonus {
    public static double [] arr_sec = {0,3,24,7,1,203.56,0,99,2,87.5,0,12,8,3,5,1233.4,0};
    public static final int MAX = 17;
    public static void main(String[] args) {
        int inicio=0, fin=-1, prod=0;
        boolean desc=false;
        double aplicado=0;
		while(inicio<MAX) {
			inicio=buscarInicio(fin+1);
            if (inicio<MAX) {
                fin=buscarFin(inicio);
                desc=descuentos(inicio,fin);
                if (desc) {
                    aplicado=aplica_desc(inicio,fin);
                    if (aplicado>0) {
                        prod=cuantos_proc(inicio,fin);
                    }
                }
            }
            System.out.println("|"+aplicado+"|"+prod+"|"); 
		}
    }


    public static int cuantos_proc(int inicio,int fin){
        int ini=inicio;
            while (fin>ini) {
                fin--;
            }
        return ini;
    }

    public static double aplica_desc(int inicio,int fin){
        double desc;
        double desc_total=0;
            if (fin<MAX-1) {
            desc = arr_sec[fin];
            desc_total = desc*0.10;
            }
        return desc_total;
    }

    public static boolean descuentos(int inicio,int fin) {
        boolean aux=false;
        int ini=inicio+1;//empieza desde procd
            for(int i=ini; i<fin; i++){
                if (arr_sec[i]>=2 && arr_sec[i]%2==0) {
                    aux=true;
                    break;
                }
            }
        return aux;
    }

    public static int buscarFin(int inicio){
        int fin=inicio;
            while ((fin<MAX)&&(arr_sec[fin]!=0)) {
                fin++;
            }
        return fin-1;
    }

    public static int buscarInicio(int fin) {
        int ini=fin;
        while ((ini<MAX)&&(arr_sec[ini]==0)) {
            ini++;
        }
        return ini;
    }
}