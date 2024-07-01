import java.util.Scanner;

public class E2_1 {
    public static void main(String[] args) {
        // Declaración de variables
        double numero;
        Scanner input = new Scanner(System.in);

        // Carga de datos
        System.out.print("Ingrese un número: ");
        numero = input.nextDouble();

        // Procesamiento
        String mensaje;
        if (numero > 0) {
            mensaje = "El número ingresado es positivo.";
        } else if (numero < 0) {
            mensaje = "El número ingresado es negativo.";
        } else {
            mensaje = "El número ingresado es cero.";
        }

        // Impresión de resultados
        System.out.println(mensaje);

        input.close();
    }
}