import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Generador {
    static Equipo[] nomb_equipos(){
        Scanner entrada = new Scanner(System.in);
        Equipo[] equipos_torneo = new Equipo[10];
        for (int i=0; i<equipos_torneo.length;i++) {
            System.out.println("Nombre del equipo "+ (i+1) + ": ");
            Equipo equipo_x = new Equipo(entrada.nextLine());
            equipos_torneo[i] = equipo_x;
        }
        return equipos_torneo;
    }
    static Partido[] partidos(Equipo[] equipos){
        Random rand = new Random();
        Partido[] fecha = new Partido[(equipos.length/2)];
        for (int i = 0; i < fecha.length; i++) {
            int goles_eq1 = rand.nextInt(6);
            int goles_eq2 = rand.nextInt(6);
            for(int j=0; j<equipos.length-2;j+=2) {
                Partido enfrentamiento = new Partido(equipos[j], equipos[j+1], goles_eq1, goles_eq2);
                fecha[i] = enfrentamiento;
            }
            for (Partido f : fecha){
                System.out.println(f.getEquipo1().getNombre_equipo() + "  " + f.getEquipo2().getNombre_equipo());
            }
        }
        return fecha;
    }

    static Equipo[] nomb_desde_archivo(String archivo) throws IOException {
        Equipo[] equipos_torneo = new Equipo[10];
        int i = 0;
        for (String eq : Files.readAllLines(Paths.get(archivo))) {
            Equipo x = new Equipo(eq);
            equipos_torneo[i] = x;
            i++;
        };
//        for (Equipo eq : equipos_torneo){
//            System.out.println(eq.getNombre_equipo());
//        }
        return equipos_torneo;
    }
}

