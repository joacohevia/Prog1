import java.util.Scanner;

public class final_mat_biblioteca {
    final static int N = 3;
    final static int M= 20;

    public static void main(String[] args) {
        int [][] libros ={{0,12,15,-18,0,5,-55,63,88,0,0,-74,-99,0,0,11,25,64,0,0}
                ,{0,0,2,-6,52,0,0,-85,87,89,0,0,1,10,20,-30,0,0,0,0},
                {0,8,-23,24,33,84,-98,0,0,21,22,-34,-36,-44,0,4,13,26,0,0}};
        char [] catalogo ={'A','C','T'};
        elegirOpcion(libros, catalogo);
    }
    public static void elegirOpcion(int[][] libro, char[] catalogo){
        Scanner sc = new Scanner (System.in);
        try{
            System.out.println("ingrese 1: regristrar nuevo libro" +"\n"+ " 2: obtener tamatica con mas prestados " + "\n "+ " 3: determinar sin un libro fue prestado" );
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                        registrarLibro(libro,catalogo);
                        mostrarLibros(libro);
                   break;
                    case 2:
                            ObtenerLibrosMasPrestados(libro,catalogo);
                    break;
                        case 3:
                               elLibroFuePrestados(libro);
                            break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void mostrarLibros(int[][] mat) {
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < M; col++) {
                System.out.print(mat[fila][col] + " ");
            }
            System.out.println();
        }
    }
    public static void registrarLibro(int [][] libro,char []catalogo){
        Scanner sc = new Scanner (System.in);
        try{
            System.out.println("ingrese letra de catalogo");
            char letra = sc.next().charAt(0);
            System.out.println("ingrese numero de estanteria");
            int estanteria = sc.nextInt();
            System.out.println("ingrese codigo de libro");
            int codigo = sc.nextInt();
            if (CumpleRequisitos(libro,catalogo,letra,estanteria,codigo)){
                insertarLibro(libro,catalogo,letra,estanteria,codigo);
            }else {
                System.out.println("el libro no cumple con los requisitos");
            }
        }catch (Exception e){
            System.out.println(e);
        }

     }
     public static boolean CumpleRequisitos(int [][] libro, char[] catalogo, char letra, int estanteria,int codigo){
        int indice = BuscarIndicedDeGenero(catalogo, letra);
        if(indice == -1 || estanteria < 0 || estanteria >= M ){
            return false;
        }
        int ini = 0;
        int fin = -1;
        int contEstanterias = 0;
        while (ini<M){
            ini = buscarIni(libro[indice],fin+1);
            if(ini<M){
                fin = obtenerFin(libro[indice],ini);
                contEstanterias ++;
            }
        }
        if (estanteria > contEstanterias){
            return false;
        }
        return true;
     }
         public static int BuscarIndicedDeGenero(char[] catalogo, char letra) {
        for (int i = 0; i < N; i++) {
            if (catalogo[i] == letra) {
                return i;
            }
        }
        return -1;
    }

    public static void insertarLibro(int[][] libro, char[] catalogo, char letra, int estanteria, int codigo) {
        int indice = BuscarIndicedDeGenero(catalogo, letra);
        int inicio = 0;
        int fin = -1;
        int contSecuencia = 0;
        if (indice != -1) {
            while (inicio < M) {
                inicio = buscarIni(libro[indice], fin + 1);
                if (inicio < M) {
                    fin = obtenerFin(libro[indice], inicio);
                    contSecuencia++;
                    if (contSecuencia == estanteria) {
                        insertarEnSecuencia(libro[indice], inicio, fin, codigo);
                        System.out.println("Libro registrado exitosamente");
                    }
                }
                }
            }else {
            System.out.println("Error al registrar el libro");
        }
    }

    public static int obtenerFin(int[] fila, int pos) {
        while (pos < M && fila[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static int buscarIni(int[] fila, int pos) {
        while (pos < M && fila[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static void insertarEnSecuencia(int[] estanteria, int inicio, int fin, int codigo) {
        while (inicio <= fin){
            if (codigo > estanteria[inicio]){
               inicio++;
            }else {
                correrDerecha(estanteria, inicio);
                estanteria[inicio] = codigo;
                inicio = fin +1;
            }

        }

    }

    public static void correrDerecha(int[] estanteria, int inicio){
        int pos = M-1;
        while (pos > inicio){
            estanteria[pos] = estanteria[pos-1];
            pos--;
        }
        estanteria[pos] = 0;
    }

    public static void ObtenerLibrosMasPrestados(int[][] libro, char[] catalogo) {
        int maxPrestados = 0;
        char tematicaMaxPrestados = ' ';
        for (int i = 0; i < N; i++) {
            int prestados = 0;
            for (int j = 0; j < M; j++) {
                if (libro[i][j] < 0) {
                    prestados++;
                }
            }
            if (prestados > maxPrestados) {
                maxPrestados = prestados;
                tematicaMaxPrestados = catalogo[i];
            }
        }
        System.out.println("La temática con más libros prestados es: " + tematicaMaxPrestados);
    }

    public static void elLibroFuePrestados(int[][] libro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del libro:");
        int codigo = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (libro[i][j] == -codigo) {
                    System.out.println("El libro con código " + codigo + " está prestado.");
                    return;
                }
            }
        }
        System.out.println("El libro con código " + codigo + " no está prestado.");
    }
}
