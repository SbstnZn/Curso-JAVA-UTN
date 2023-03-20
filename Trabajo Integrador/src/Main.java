import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Equipo[] equipos_10 = new Equipo[10];
        String ruta_nomb_equipos = "C:\\Users\\szd\\Desktop\\java\\git_prueba\\Trabajo Integrador\\equipos.txt";
        String ruta_fecha = "C:\\Users\\szd\\Desktop\\java\\git_prueba\\Trabajo Integrador\\fecha.txt";
        String ruta_pronostrico = "C:\\Users\\szd\\Desktop\\java\\git_prueba\\Trabajo Integrador\\pronostico.txt";

        equipos_10 = Generador.nomb_desde_archivo(ruta_nomb_equipos);

        Partido[] fecha_x = Generador.partidos(equipos_10);
        Generador.fecha(fecha_x, ruta_fecha );
        Generador.pronostico(fecha_x, ruta_pronostrico);

        int puntos = Generador.obtencion_puntos(ruta_fecha, ruta_pronostrico);
        Generador.muestra_fecha(fecha_x);
        System.out.println("Obtuvo " + puntos + " puntos.");
    }
}
