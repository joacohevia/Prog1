/*en el arreglo arrM estan las materias con sus alumnos inscriptos, en arrA es un arr con las 
aulas que se puede asignar a dicha materia. crear un programa que a cada materia asigne un aula
si la asigna cambiar el valor del arrA a negativo y eliminar la ocurrencia en el arrM.
en caso de no existir un aula con la capacidad se debe informar con un system.out.print y conservar la sec.
si la cantidad de materias fuera superior a las aulas disponibles se debe informar que no quedan mas aulas disponibles
cuando ya hayan sido todas asignadas.
las asignaciones deben salir por consola, en este ejmplo seria: "la materia 1 se asigno al aula 2",
"la materia 2 no se pudo asignar","la materia 3 se asigno al aula 1"
 * 
 */

public class examen_mio {
    public static final int MAX = 20;
    public static final int MAX_A = 3;
    public static final int SEPARADOR=0;
    
    public static void main(String[] args) {
        int ini=0,fin=-1,sec=0,cant_aulas=3;
        int materia=1;//para los syso
        int[] arrM = {0, 0, 34, 2, 12, 25, 0, 32, 55, 12, 3, 88, 14, 0, 0, 17, 36, 19, 0, 0};
        int[] arrA = {2, 3, 6};
        mostrar_arreglo(arrM);
       
        while (ini < MAX) {
            ini = buscar_inicio(arrM, fin + 1);
            if (ini < MAX) {
                fin = buscar_fin(arrM, ini);
                sec = fin - ini + 1;
                if (cant_aulas > 0) {
                    int aulaAsignada = asignarAula(arrA, sec);
                    if (aulaAsignada != -1) {
                        eliminar(arrM, ini, fin);
                        fin=ini;
                        cant_aulas--;
                        System.out.println("La materia " + materia + " se asignó al aula " + aulaAsignada);
                    } else {
                        System.out.println("La materia " + materia + " no se pudo asignar");
                    }
                } else {
                    System.out.println("No quedan más aulas disponibles.");
                }
                materia++;
            }
        }
        mostrar_arreglo(arrM);
    }

    public static void eliminar(int[] arrM, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            corimiento_izq(arrM,ini);
        }
    }
    public static void corimiento_izq(int[]arrM,int ini){
        for(int i=ini; i<MAX-1; i++){
            arrM[i]=arrM[i+1];
        }
    }
    
   
    public static int asignarAula(int[] arrA, int sec) {
        for (int i = 0; i < MAX_A; i++) {
            if (arrA[i] >= sec) {
                arrA[i] = -arrA[i];
                return i + 1; 
            }
        }
        return -1; 
    }

    public static int buscar_fin(int[] arr_imagen, int inicio) {
        int fin = inicio;
        while (fin < MAX && arr_imagen[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }

    public static int buscar_inicio(int[] arr_imagen, int fin) {
        int ini = fin;
        while (ini < MAX && arr_imagen[ini] == SEPARADOR) {
            ini++;
        }
        return ini;
    }

    public static void mostrar_arreglo(int[] arrM) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arrM[i] + "|");
        }
        System.out.println();
    }
  
}
