public class Equipo {
    private String nombre_equipo;
    private String descripcion_equipo;
    Equipo (){};
    Equipo (String nombre) {
        setNombre_equipo(nombre);}

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getDescripcion_equipo() {
        return descripcion_equipo;
    }

    public void setDescripcion_equipo(String descripcion_equipo) {
        this.descripcion_equipo = descripcion_equipo;
    }
}
