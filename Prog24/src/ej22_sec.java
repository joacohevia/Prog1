/*22. Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño. */
public class ej22_sec {
    public static int[]arr_A = {0,1,2,0,8,7,6,0,6,0};
    public static final int MAX=10;
    public static int[]arr_P = {8,7,6};
    public static int MAX_ocurrencia =3;
    public static int[]arr_R = {5,6,7};
    public static void main (String [] args) {
        int inicio=0, fin=0, longitud=0;
		boolean sies=false;
		while((inicio<MAX)&&(fin<MAX)) {
			inicio=buscarInicio(fin+1);
			fin=buscarFin(inicio);
			longitud=buscar_longitud(inicio,fin);
            if (longitud==MAX_ocurrencia) {
                sies=comparar_elementos_arr(inicio);//comparo los elementos del arrR
                if (sies) {
                    remplazar(inicio);
                    sies=false;
                }
            }
		}
		mostrarArreglo();
	}
    public static void remplazar(int inicio){
        int j=inicio;
		for(int i=0;i<MAX_ocurrencia;i++) {
			arr_A[j]=arr_R[i];
			j++;
		}
    }

    public static boolean comparar_elementos_arr(int inicio) {
        boolean aux=false;
        int j=inicio;
            for(int i=0; i<MAX_ocurrencia; i++){
                if (arr_P[i]==arr_A[j]) {
                    aux=true;
                }else{
                    aux=false;
                }
                j++;
            }
        return aux;
    }

    public static int buscar_longitud(int inicio,int fin) {
        int longitud=0;
            for(int i=inicio; i<=fin; i++){
                longitud++;
            }
        return longitud;
    }

    public static int buscarInicio(int inicio) {
		while((inicio<MAX)&&(arr_A[inicio]==0)) {
			inicio++;
		}
		return inicio;
	}
	
	public static int buscarFin(int inicio) {
		int fin=inicio;
		while((fin<MAX)&&(arr_A[fin]!=0)) {
			fin++;
		}
		return fin-1;
	}
	
	public static void mostrarArreglo() {
		for(int i=0;i<MAX;i++) {
			System.out.print(arr_A[i]+"|");
		}
	}
}

