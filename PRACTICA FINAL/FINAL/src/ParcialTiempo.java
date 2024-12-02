public class ParcialTiempo {
    public static int MAX = 17;
    public static int SEP = -1;
    public static void main(String[] args) {
        int [] tiempo = {-1,30,40,1010,-1,30,40,1010,-1,30,40,1010,-1,29,41,1009,-1};
        int [] patron = {-1,-1,-1,-1,-1,30,40,1010,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int N = 2;
        buscarCoincidencia(tiempo,patron,N);
        mostrarArr(tiempo);
    }

    public static void buscarCoincidencia(int [] tiempo, int [] patron,int N){
        int ini=0,fin=-1,contador=0;
        while (ini<MAX) {
            ini=buscarIni(tiempo,fin+1);
            if (ini<MAX) {
                fin=buscarFin(tiempo,ini);
                if (sonIgual(ini,fin,patron,tiempo)) {
                    contador++;
                    if (contador>N) {
                        eliminarSec(ini,fin,tiempo);
                        fin=ini;
                    }
                } else{
                    contador = 0;
                }
            }
        }
    }
    public static void mostrarArr(int []tiempo){
        for(int i=0; i<MAX; i++){
            System.out.print(tiempo[i]+"|");
        }
        System.out.println();
    }
    public static void eliminarSec(int ini,int fin, int[]tiempo){
        for(int i=ini; i<=fin; i++){
            corrimientoIzq(ini,tiempo);
        }
    }
    public static void corrimientoIzq(int ini,int[]tiempo){
        for(int i=ini; i<MAX-1; i++){
            tiempo[i] = tiempo[i+1];
        }
    }
    public static boolean sonIgual(int ini, int fin, int []patron,int [] tiempo){
        int iniP=0,finP=-1,sec=0;
        boolean aux=false;
        sec = fin-ini+1;
        if(iniP<MAX) {
            iniP = buscarIni(patron, finP+1);
            finP = buscarFin(patron, iniP);
            int sec2 = finP-iniP+1;
            if (sec == sec2 && iguales(ini,fin,iniP,tiempo,patron)) {
                aux = true;
            }   
        }
        return aux;
    }
    public static boolean iguales(int ini,int fin,int iniP,int []tiempo,int[]patron){
        boolean aux = false;
        while (ini<=fin && tiempo[ini]==patron[iniP]) {
            ini++;
            iniP++;
        }
            if (ini>fin) {
                aux=true;
            }
        
        return aux;
    }
    public static int buscarIni(int []tiempo,int ini){
        while (ini<MAX && tiempo[ini] == SEP) {
            ini++;
        }
        return ini;
    }
    public static int buscarFin(int []tiempo, int fin){
        while (fin<MAX && tiempo[fin] != SEP) {
            fin++;
        }
        return fin-1;
    }
}
