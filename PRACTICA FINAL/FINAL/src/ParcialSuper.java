public class ParcialSuper {
    public static int MAX=25;
    public static int MAXP=2;
    public static int SEP=0;
    public static void main(String[] args) {
        int producto=22,cant=4;
        int [] pedidos={0, 0, 12, 8, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0};
        int [] almacenado={8,9};
        buscarCoincidencia(pedidos,almacenado,producto,cant);
        mostrarArr(pedidos);
    }
    public static void buscarCoincidencia(int [] ped, int [] almac,int produc,int cant){
        int ini=0,fin=-1;
        while (ini<MAX) {
            ini=buscarIni(ped,fin+1);
            if (ini<MAX) {
                fin=buscarFin(ped,ini);
                if (tieneNum(ini,fin,ped,almac)&& cant>0) {
                    agregar(fin,ped,produc);
                    cant--;
                    fin++;
                }
            }
        }
        System.out.println("Produc sin agregar: "+cant);
    }
    public static void agregar(int fin,int [] ped,int pp){
        for(int i=MAX-1; i>fin; i--){
            ped[i] = ped[i-1];
        }
        ped[fin+1] =pp;
    }
    public static boolean tieneNum(int ini,int fin,int [] ped,int [] alm){
        boolean aux=false;
        while (ini<=fin) {
            for (int i = 0; i < MAXP; i++) {
                if (alm[i] == ped[ini]) {
                    aux=true;
                }
            }
            ini++;  
        }
        return aux;
    }
    public static int buscarFin(int [] ped,int fin){
        while (fin<MAX && ped[fin]!=SEP) {
            fin++;
        }
        return fin-1;
    }
    public static int buscarIni(int [] ped,int ini){
        while (ini<MAX && ped[ini]==SEP) {
            ini++;
        }
        return ini;
    }
    public static void mostrarArr(int [] pedidos){
        for (int i = 0; i < MAX; i++) {
            System.out.print(pedidos[i]+"|");
        }
    }
}
