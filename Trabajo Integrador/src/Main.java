import java.io.IOException;

public class Main {
    static void muestra_fecha (Partido[] fecha) {
        int n = 1;
        for (Partido x: fecha) {
            System.out.println("Partido " + n + ": " +
                    x.getEquipo1().getNombre_equipo() +
                    "  " + x.getGoles_equipo1() + " - " +
                    x.getEquipo2().getNombre_equipo() + "  " +
                    x.getGoles_equipo2() + "  Resultado: " + x.resultado());
            n++;
        }
    }
    public static void main(String[] args) throws IOException {
        Equipo[] equipos_10 = new Equipo[10];
//        equipos_10 = Generador.nomb_equipos_manual();
        equipos_10 = Generador.nomb_desde_archivo("C:\\Users\\szd\\Desktop\\java\\Trabajo Integrador\\equipos.txt");

        Partido[] fecha_x = Generador.partidos(equipos_10);//new Partido[equipos_10.length];
       // fecha_x = Generador.partidos(equipos_10);

        muestra_fecha(fecha_x);
    }
}
