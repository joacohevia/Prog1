import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E_5 {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
        System.out.println("El nombre es: ");
        String nombre = String.valueOf(entrada.readLine());
        System.out.println("El nombre es: " + nombre);

        System.out.println("La altura es: ");
        double altura = Double.valueOf(entrada.readLine());
        System.out.println("La altura es: " + altura);



	    
            } catch (Exception e) { 
                e.printStackTrace();
            } 
        }
            
    } // fin del método main
    