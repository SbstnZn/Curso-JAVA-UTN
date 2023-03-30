import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<ItemCarrito> carga_lista(String ruta_archivo)  {
        try {
            List<String> lista = Files.readAllLines(Paths.get(ruta_archivo));
            List<ItemCarrito> items_lista = new ArrayList<>();
            for (String x : lista) {
                Producto y = new Producto();
                String[] z = x.split(";");
                y.setNombre(z[1]);
                y.setPrecio(Float.parseFloat(z[2]));
                ItemCarrito item = new ItemCarrito(y,Integer.parseInt(z[0]),y.getPrecio());
                items_lista.add(item);
            }

            System.out.println("se cargo con exito la lista");
            return items_lista;

        } catch (IOException e){
            System.out.println("error al leer archivo");
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        List<ItemCarrito> lista_compras = carga_lista(".\\lista.txt");
        Persona cliente1 = new Persona("Esteban");
        Carrito cl1_carro = new Carrito(cliente1,lista_compras);
        System.out.print(cl1_carro.getPersona_x().getNombre() + "  " + cl1_carro.getFecha_compra()+"\n");
        System.out.println("El precio total es: " + cl1_carro.precio());

    }
}