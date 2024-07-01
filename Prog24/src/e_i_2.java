import java.util.Scanner;

public class e_i_2 {
    public static void main(String args[]) {
    try  (Scanner Input = new Scanner(System.in)) { 
        int numero;
        int numero1;
        int numero2;
        System.out.println("Ingrese numero: ");
        numero = Input.nextInt();
        System.out.println("Ingrese su segundo numero: ");
        numero1 = Input.nextInt();
        System.out.println("Ingrese su tercer numero: ");
        numero2 = Input.nextInt();

        if (numero2 > numero1 && numero1 > numero){
        System.out.println("Estan en orden creciente");
        }

        else if (numero2 < numero1 && numero1 < numero){
        System.out.println("Estan en orden decreciente");
        }
        
       else {
       System.out.println("No estan en ningun orden"); 
       }


    } catch (Exception e) {
        // TODO: handle exception
    }
} 
}
