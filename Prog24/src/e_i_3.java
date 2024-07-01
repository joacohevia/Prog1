import java.util.Scanner;

public class e_i_3 {
    public static void main(String args[]){
        try (Scanner entrada = new Scanner(System.in)) {
            int numero = 1;
              System.out.println("Ingrise numero: "); 
              numero = (entrada.nextInt());
              switch (numero) {
                case 1:System.out.println("Es lunes");break;
                case 2:System.out.println("Es martes");break;
                case 3:System.out.println("Es miercoles");break;
                case 4:System.out.println("Es jueves");break;
                case 5:System.out.println("Es viernes");break;
                case 6:System.out.println("Es sabado");break;
                case 7:System.out.println("Es domingo");break;

                default: System.out.println("No corresponde a la semana");break;


              }   
            
        } catch (Exception e) {
             }
        }
    }
