public class Producto {
    Producto(){};
    Producto(String nomb, String cod, float precio) {
        this.codigo = cod;
        this.nombre = nomb;
        this.precio = precio;
    }
    private String codigo;
    private String nombre;
    private float precio;
    float costo_final(int x){return 1;}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
