import java.util.Scanner;
    public class e_i_4 {
        public static void main(String args[]) {
        try  (Scanner Imput = new Scanner(System.in)) {
            int numero= 0;
             System.out.println("Ingrese numero entre 0 y 999");
             numero = Imput.nextInt();
             if (numero>0 && numero<10) {   
                System.out.println("El numero tiene un digito.");}
                
                else if (numero>10 && numero<99) {
                System.out.println("El numero tiene dos digitos.");
            }
                
                else if (numero>100 && numero<999) {
                System.out.println("El numero tiene tres digitos y es:" + numero);}

                else {
                System.out.println("El numero es mas grande que mil."); } 
                      
             
            }catch (Exception e) {
            // TODO: handle exception
            }
            
        }
    }
    
        
       
