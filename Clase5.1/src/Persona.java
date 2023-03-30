import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
    Persona(){}
    Persona(String nombre) {
        this.nombre = nombre;
    }
    private String nombre;
    private String apellido;
    private LocalDate fecha_nac=null;
    int edad(){
        if (getFecha_nac() != null) {
            Long edad = ChronoUnit.YEARS.between(LocalDate.now(), getFecha_nac());
            return edad.intValue();
        }else {
            System.out.println("no se cargado la fecha de nacimiento");
        }
        return 0;
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
}
