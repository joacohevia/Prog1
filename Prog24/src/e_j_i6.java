import java.util.Scanner;
    public class e_j_i6 {
        /**
         * @param args
         */
        public static void main(String args[]){
            try (Scanner imput = new Scanner(System.in)){
                int dias = 31;
                int dias1 = 30;
                int mes = 0;
                System.out.println("Ingrese mes: ");
                mes = imput.nextInt();
                switch (mes) {
                    case 1: System.out.println("El mes es enero" + dias);break;
                    case 3: System.out.println("El mes es: marzo" + dias);break;
                    case 5: System.out.println("El mes es mayo y tiene" + dias + "dias");break;
                    case 7: System.out.println("El mes es: julio" + dias);break;
                    case 8: System.out.println("El mes es: agosto" + dias);break;
                    case 10: System.out.println("El mes es: octubre" + dias);break;
                    case 12: System.out.println("El mes es: diciembre" + dias);break;

                    case 4: System.out.println("El mes es: abril" + dias1);break;
                    case 6: System.out.println("El mes es: junio" + dias1);break;
                    case 9: System.out.println("El mes es: septiembre" + dias1);break;
                    case 11: System.out.println("El mes es: noviembre" + dias1);break;

                    case 2: 
                    System.out.println("Ingrese el anio");
                    int anio = imput.nextInt();
                    if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
                        dias = 29; // Año bisiesto
                        System.out.println("El anio es bisiesto");
                    } else {
                        dias = 28; // Año no bisiesto
                        System.out.println("El anio no es bisiesto");
                    }
                    break;
                default:
                    System.out.println("Número de mes inválido.");
                    System.exit(0);
                    break;

                }

        
            }
        }
    }