import java.util.Scanner;

public class E_7 {
    public static void main(String args[]){
        try (Scanner Input = new Scanner(System.in)) {
        
              
            System.out.println("Ingrise primer numero: ");    
            float numero1 = Input.nextFloat();
            System.out.println("Ingrese segundo numero: ");
            float numero2 = Input.nextFloat();
            System.out.println("Ingrese su tercer numero: ");    
            float numero3 = Input.nextFloat();           
            float resultado = (numero1 / numero2) - numero3;           
            System.out.println("El resultado es: " + resultado);



   } catch (Exception e) {
             }
        }
    }

