public class ItemCarrito {
    ItemCarrito(){}
    ItemCarrito(Producto producto, int cantidad, float precio){
        this.producto_x = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio;
    }
    private int cantidad;
    private float precio_unitario;
    private Producto producto_x = new Producto();
    float precioTotal(){
        float total = this.cantidad * this.precio_unitario;
        return total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Producto getProducto_x() {
        return producto_x;
    }

    public void setProducto_x(Producto producto_x) {
        this.producto_x = producto_x;
    }
}
