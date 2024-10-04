import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Persona{

  public static void main(String[] args) {
    Persona persona = new Persona("Juan", 20, "15/04/2004", 12345678, 'M', 70, 1.75);
  System.out.println(persona);}
  

    private String nombre;
    private int edad;
    private String fechaNac;
    private int dni;
    private char sexo;
    private int peso;
    private double altura;

    public Persona(String nombre, int edad, String fechaNac, int dni, char sexo, int peso, double altura) {
        this.nombre = nombre!= null? nombre:"N N";
        this.edad = edad>0?edad:0;
        this.fechaNac= fechaNac != null ? fechaNac : "1/1/2000"; //si (fecha de nac no es nulo) fechaNac else: "1/1/2020"
        this.dni = dni;
        this.sexo = sexo=='M'||sexo=='F' ? sexo:'F';
        this.peso = peso>=0? peso:1;
        this.altura = altura>=0? altura:1;
    }
    public Persona(int dni){
        this("N N",0, "1/1/2020",dni,'F',1 ,1);
    }
    public Persona(int dni, String Nombre){
        this(Nombre,0,"1/1/2000",dni,'F',1,1);
    }
    public Persona(int dni, String Nombre, String fechaNac ){
        this(Nombre,0,fechaNac,dni,'F',1,1);
    }
   
  public double calcularImc() {
    double imc;
    imc= peso/(altura*altura);
    return imc;
  }
  public boolean estaEnForma(){
    double imc=calcularImc();
    return (imc>=18.5 &&imc<=25);
  }
  public int cantAños(){
            LocalDate fechaNac= parseFecha(this.fechaNac);
            LocalDate hoy = LocalDate.now();
            Period periodo = Period.between(fechaNac, hoy);
            return periodo.getYears();
        
    }
    private LocalDate parseFecha(String fecha) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            return LocalDate.parse(fecha, formatter);
    }
  public boolean cumpleaños(){
            LocalDate fechaNac= parseFecha(this.fechaNac);
            LocalDate hoy = LocalDate.now();
            return(fechaNac.getMonthValue()==hoy.getMonthValue()&& fechaNac.getDayOfMonth()==hoy.getDayOfMonth());
  }
  public boolean esMayor (){
    return (cantAños()>=18);
  }
  public boolean puedeVotar(){
    return(cantAños()>=16);
  }
  public boolean esCoherente(){
    return (cantAños()==edad);
  }


public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public void setFechaNac(String fechaNac) {
    this.fechaNac = fechaNac;
}
public void setSexo(char sexo) {
    this.sexo = sexo;
}
public void setPeso(int peso) {
    this.peso = peso;
}
public void setAltura(double altura) {
    this.altura = altura;
}
public String toString() {
    return "Persona{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", fecha de nacimiento='" + fechaNac + '\'' +
            ", dni=" + dni +
            ", sexo=" + sexo +
            ", peso=" + peso +
            ", altura=" + altura +
            ", IMC="+ calcularImc()+
            ", esta en forma="+(estaEnForma()?"SI":"NO")+
            ", cantidad de años="+cantAños()+
            ", es su cumpleaños="+(cumpleaños()?"SI":"NO")+
            ", es Mayor de edad="+(esMayor()? "SI":"NO")+
            ", puede votar="+(puedeVotar()?"SI":"NO")+
            ", es coherente="+(esCoherente()?"SI":"NO")+
            '}';
}



}

