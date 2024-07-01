import java.io.BufferedReader;
import java.io.InputStreamReader;

public class e_i_5 {
    public static void main(String args[]){
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)))  {
           System.out.println("Ingrise letra: "); 
           String letra = "i";
              String caracter = entrada.readLine();
              switch (caracter.toLowerCase()) {
                case "a":System.out.println("Es vocal");break;
                case "e":System.out.println("Es vocal");break;
                case "i":System.out.println("Es vocal");break;
                case "o":System.out.println("Es vocal");break;
                case "u":System.out.println("Es vocal");break;
                

                default: System.out.println("Es una consonante");break;


            }   
            
        } catch (Exception e) {
             }
    }
}    