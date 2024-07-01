import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E_6 {
     public static void main (String args[]) {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

     try {
        System.out.println("Letra de factura: ");
        String letra = String.valueOf(entrada.readLine());
        System.out.println("Su factura es: " + letra);
        
        System.out.println("FCactura numero: ");
        int factura = Integer.valueOf(entrada.readLine());
        System.out.println("El numero de su factura es: " + factura);

        System.out.println("Nombre del cliente: ");
        String nombre = String.valueOf(entrada.readLine());
        System .out.println("Su nombre es: " + nombre);

        System.out.println("Producto1: ");
        String producto1 = String.valueOf(entrada.readLine());
        System.out.println("Su producto es: " + producto1 );
        System.out.println("Importe1" );
        int importe1 = Integer.valueOf(entrada.readLine());
        System.out.println("Precio: " + importe1 );

        System.out.println("Producto2: ");
        String producto2 = String.valueOf(entrada.readLine());
        System.out.println("Su producto es: " + producto2 );
        System.out.println("Importe2" );
        int importe2 = Integer.valueOf(entrada.readLine());
        System.out.println("Precio: " + importe2 );

        System.out.println("Total: " + (importe1 + importe2));
        

        


            } catch  (Exception e) { 
                //yyy
            } 
        }
    }