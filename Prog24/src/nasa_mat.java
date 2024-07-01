    /*Extra prefinal
El proyecto SETI de la NASA quiere analizar una serie de señales recibidas por su
radiotelescopio. El radiotelescopio realiza lecturas en 50 canales en la frecuencia del
hidrógeno neutro. Dichas señales son almacenadas en una matriz en donde cada fila
representa una lectura realizada por el radiotelescopio y cada columna representa la
intensidad captada para los 50 canales de rastreo. Cada intensidad se representa por una
serie de caracteres alfanuméricos: si el valor es un 0, se representa mediante un espacio en
blanco; los valores entre el 1 y el 9 son representados por los caracteres del ‘1’ al ‘9’; y los
valores del 10 al 35 son representados con las letras mayúsculas que van de la A a la Z
respectivamente. Por lo tanto, en cada fila se forman secuencias de valores separadas por
espacios, en donde cada secuencia representa las lecturas en canales de rastreo
consecutivos.
Dado una matriz de NxM, donde N es la cantidad de lecturas realizadas y M la cantidad de
canales analizados más 2 (cada fila comienza y termina con un espacio), se pide:
determinar la cantidad de señales de posible origen extraterrestre en la matriz. Una señal es
de posible origen extraterrestre si en P lecturas consecutivas (filas) existen al menos K
intensidades superiores a un determinado valor alfanumérico L en una de sus secuencias
(canales de rastreo con lecturas consecutivas distintas de 0).
Para el siguiente ejemplo donde N=5 y M=20 (18 canales), K=2, L=’F’ y P=2 existe UNA
señal de posible origen extraterrestre en las lecturas 0 y 1
1 2 G H 2 A 3 3 R B J 6 5 K
2 1 4 5 R P D 3 7 M N W
4 G 8 3 5 7 1 2 X D 4 1
5 T T M A P 1 1 2 1 3 1 3
6 6 4 5 4 A 2 1 2 G 4 2 1 8
Eso es así, porque, en la fila 0, la secuencia 12GH y la secuencia 3RBJ poseen al menos
dos intensidades superiores a ‘F’, además, de forma consecutiva, en la fila 1, la secuencia
RP y la secuencia 7MNW también lo cumplen. Nótese que la fila 4 cumple el criterio de que
al menos posee una secuencia con más de dos intensidades superiores a ‘F’ pero no la fila
que sigue (fila 5).
El ejemplo es meramente ilustrativo y para que sea más fácil la interpretación del
enunciado. El programa realizado debe ser flexible para procesar cualquier matriz y
para cualquier valor que pueda tomar K, L y P. */
public class nasa_mat {
        public static final int MAXC = 20;
        public static final int MAXF = 5;
        public static final int SEPARADOR = ' ';
        public static final int P=2;
        public static final int K=2;
        public static final char L='F';
    
        public static void main(String[] args) {
            // Ejemplo de matriz de intensidades
            char[][] matriz = {
                {' ','1','2','G','H',' ','2','A','3',' ','3','R','B','J',' ','6','5','K',' ',' '},
                {' ',' ','2','1','4','5',' ','R','P',' ','D','3',' ','7','M','N','W',' ',' ',' '},
                {' ','4','G','8',' ','3','5','7','1',' ',' ','2','X',' ','D','4','1',' ',' ',' '},
                {' ',' ',' ','5','T','T','M',' ','A','P','1','1',' ','2','1','3',' ','1','3',' '},
                {' ','6','T','M',' ','5','4',' ',' ','A','2','1','2',' ','G','4','2','1','8',' '}
            };
            
           descomprimir(matriz);
        }
        public static void descomprimir(char[][]matriz){
            int cant_senial=0;
            int senial=0;
            for(int i=0; i<MAXF; i++){
                cant_senial+=buscar_senial(matriz[i]);
                if (cant_senial>=P) {
                    senial++;
                    cant_senial=0;
                }
            }
            System.out.println("la cantidad es:"+senial);
        }
        
        public static int buscar_senial(char[]mat){
            int ini=0,fin=-1,consecutivo=0,senial=0;
            boolean sies=true;
            while (ini<MAXC) {
                ini=buscar_ini(mat,fin+1);
                if (ini<MAXC) {
                    fin=buscar_fin(mat,ini);
                    senial=analizar_estudio(ini,fin,mat);
                    if (senial>0 && sies) {
                        consecutivo++;
                        sies=false;
                    }
                }
            }
            return consecutivo;
        }

        public static int analizar_estudio(int ini,int fin, char[]mat){
            int cant=0;
            if (es_mayor(ini, fin, mat)) {
                cant++;
            }
            return cant;
        }
        public static boolean es_mayor(int ini,int fin, char[]mat){
            int cont=0;
            boolean aux =false;
            while (ini<=fin ) {
                if (mat[ini]>=L && es_mayus(mat[ini])) {
                    cont++;
                }
                if (cont>=K) {
                    aux= true;
                }
                ini++;  
            }
            return aux;
        }
        public static boolean es_mayus(char c){
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
            return false;
        }
        public static int buscar_fin(char [] mat, int fin){
            while (fin<MAXC && mat[fin]!=SEPARADOR) {
                fin++;
            }
            return fin-1;
        }
        public static int buscar_ini(char []mat,int ini){
            while (ini<MAXC && mat[ini]==SEPARADOR) {
                ini++;
            }
            return ini;
        }
}
    