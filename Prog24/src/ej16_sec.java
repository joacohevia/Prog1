/*Hacer un programa que devuelva la posición de inicio y fin de la
secuencia de números distintos de ceros cuya suma del contenido
sea mayor. */
public class ej16_sec {
    public static int MAX = 10;
    public static int [] arrSecuencia = {0,1,2,0,4,7,0,3,1,0};
    public static void main(String [] args) {
        int inicio=0;
        int fin=0;
        int sumaMax=0;
        int inicioMax=0;
        int finMax=0;
        while (inicio<MAX) {
            inicio = buscar_inicio(fin+1);
            if (inicio<MAX) {
                fin = buscar_fin(inicio);
                int suma;
                suma = suma_contenido(inicio,fin);
                if (suma > sumaMax) {
                    sumaMax = suma;
                    inicioMax=inicio;
                    finMax=fin;
                }
            }
        }
        System.out.println("La suma max es: "+sumaMax+" de la sec "+inicioMax+":"+finMax);
    }

    public static int buscar_inicio(int fin) {
        int ini = fin;
        while (ini<MAX && arrSecuencia[ini] == 0) {
            ini++;
        }
        return ini;
    }

    public static int buscar_fin(int inicio) {
        int fin=inicio;
        while (fin<MAX && arrSecuencia[fin] !=0) {
            fin++;
        }
        return fin-1;
    }
    
    public static int suma_contenido(int inicio,int fin){
        int suma=0;
        while (inicio<=fin) {
            suma = suma+arrSecuencia[inicio];
            inicio++;
        }
        
        return suma;
    }
    public static void mostrar_arr(int inicio, int fin) {
        System.out.println("."+inicio+":"+fin);
     }
}
