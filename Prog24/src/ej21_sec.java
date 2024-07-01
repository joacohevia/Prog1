/*21. Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos. */
public class ej21_sec {
    public static final int MAX=10;
    public static int[]arr_sec = {0,1,2,0,6,5,4,0,6,0};
    public static void main(String[] args) {
		int inicio=0, fin=0, longitud=0;
		boolean sies=false;
		while((inicio<MAX)&&(fin<MAX)) {
			inicio=buscarInicio(fin+1);
			fin=buscarFin(inicio);
			sies=buscar_desc(inicio,fin);
            if (sies) {
                longitud=buscar_long(inicio,fin);
                eliminar_sec(inicio,fin,longitud);
                sies=false;
            }
		}
		mostrarArreglo();
	}
    public static int buscar_long(int inicio,int fin){
    int longitud=0;
        for(int i=inicio;i<=fin;i++){
            longitud++;
        }
    return longitud;
    }

    public static void eliminar_sec(int inicio, int fin, int longitud) {
        while (longitud>0) {
            for(int i=inicio;i<fin;i++){
                arr_sec[i]=arr_sec[i+1];
            }
            longitud--;
        }
    }

    public static boolean buscar_desc(int inicio,int fin){
        boolean aux=false;
            for(int i=inicio;i<fin;i++){
                if(arr_sec[i]>arr_sec[i+1]){
                    aux=true;
                } else{
                    aux=false;
                }
            }
        return aux;
    }
	
	public static int buscarInicio(int inicio) {
		while((inicio<MAX)&&(arr_sec[inicio]==0)) {
			inicio++;
		}
		return inicio;
	}
	
	public static int buscarFin(int inicio) {
		int fin=inicio;
		while((fin<MAX)&&(arr_sec[fin]!=0)) {
			fin++;
		}
		return fin-1;
	}
	
	public static void mostrarArreglo() {
		for(int i=0;i<MAX;i++) {
			System.out.print(arr_sec[i]+"|");
		}
	}
}

