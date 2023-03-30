import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    Carrito(){}
    Carrito(Persona x,List<ItemCarrito> lista_items){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.setPersona_x(x);
        this.setItem_carro(lista_items);
        fecha_compra = LocalDateTime.now().format(formato);
    }
    private Persona persona_x = new Persona();
    private List<ItemCarrito> item_carro = null;
    private String fecha_compra;
    float precio(){
       if ( item_carro != null){
           float total=0;
           for (ItemCarrito x : item_carro){
               total = total + x.precioTotal();
           }
           return total;
       }
       System.out.println("No se cargo lista de items.");
       return 0;
    };

    public Persona getPersona_x() {
        return persona_x;
    }

    public void setPersona_x(Persona persona_x) {
        this.persona_x = persona_x;
    }

    public List<ItemCarrito> getItem_carro() {
        return item_carro;
    }

    public void setItem_carro(List<ItemCarrito> lista_items) {
        this.item_carro = lista_items;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
}
