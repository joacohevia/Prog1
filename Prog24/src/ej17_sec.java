/*17. Hacer un programa que devuelva la posición de inicio y fin de la
anteúltima secuencia de números distintos de ceros. 
empiezo desde el final por eso el buscar inicio y fin de sec esta al revez*/
public class ej17_sec {
    public static int [] arrSecuencia = {0,8,0,3,4,5,6,0,2,0};
    public static final int MAX=10;
    public static void main(String []args) {
        int inicio=MAX;
        int fin=MAX-1;
        int cant_busca_inicio_fin=2;
        while (cant_busca_inicio_fin>0){
                fin=buscar_fin(inicio-1);
                inicio=buscar_inicio(fin);
                    cant_busca_inicio_fin--;
        }
        System.out.print("Las pos de la anteultima sec son: "+inicio+"/"+fin);
    }
    public static int buscar_inicio(int fin) {
        int ini=fin;
        while(arrSecuencia[ini]!=0){
            ini--;
        }
        return ini+1;
    }
    public static int buscar_fin(int inicio) {
        int fin = inicio;
        while (arrSecuencia[fin]==0) {
            fin--;
        }
        return fin;
    }
    public static void mostrar_sec(int inicio,int fin){
        System.out.print("/"+inicio+":"+fin);
        
    }
   
}
