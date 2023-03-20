import java.io.*;
import java.util.*;
import java.util.List;

public class Generador {
    static void muestra_fecha (Partido[] fecha) {
        int n = 1;
        for (Partido x: fecha) {
            System.out.println("Partido " + n + ": " +
                    x.getEquipo1().getNombre_equipo() +
                    "  " + x.getGoles_equipo1() + " - " +
                    x.getEquipo2().getNombre_equipo() + "  " +
                    x.getGoles_equipo2() + "  Resultado: " + x.getResultado());
            n++;
        }
    }
    static Equipo[] nomb_equipos_manual(){
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
        int j=0;
        for (int i = 0; i < fecha.length; i++) {
            int goles_eq1 = rand.nextInt(6);
            int goles_eq2 = rand.nextInt(6);
            Partido enfrentamiento = new Partido(equipos[j], equipos[j+1], goles_eq1, goles_eq2);
            fecha[i] = enfrentamiento;
            j+=2;
        }
        return fecha;
    }

    static Equipo[] nomb_desde_archivo(String archivo) {
        Equipo[] equipos_torneo = new Equipo[10];

        try {
            File archi = new File(archivo);
            Scanner lector = new Scanner(archi);
            int i = 0;
            while(lector.hasNextLine()){
                String nomb = lector.nextLine();
                Equipo a = new Equipo(nomb);
                equipos_torneo[i] = a;
                i++;
            }
            lector.close();
        } catch (FileNotFoundException e){
            System.out.println("error de lectura");
            e.printStackTrace();
        }
        return equipos_torneo;
    }

    static void pronostico(Partido[] fecha, String archivo) {

        String[] partidos = new String[fecha.length];
        Random rand = new Random();

        int cont = 0;
        for (Partido a: fecha) {
            partidos[cont] = a.getEquipo1().getNombre_equipo() + ";" + a.getEquipo2().getNombre_equipo() + ";" + rand.nextInt(3) + "\n";
            cont++;
        }

        try {
            File crea = new File(archivo);
            if (crea.createNewFile()) {
                System.out.println("se creo pronostico.txt");
            } else {
                System.out.println("se sobrescribio el archivo pronostico.txt");
            }

            FileWriter escribe = new FileWriter(archivo);
            for (int i = 0; i < partidos.length; i++) {
                escribe.write(partidos[i]);
            }
            escribe.close();
        }catch (IOException e) {
            System.out.println("error al crear el archivo pronostico.txt");
            e.printStackTrace();
        }
    }

    static int obtencion_puntos(String archivo_fecha, String archivo_pronostico) {
        List<String[]> fecha = new ArrayList<String[]>();
        List<String[]> pronostico = new ArrayList<String[]>();

        int puntos = 0;


        try{

            File arch_fecha = new File(archivo_fecha);
            File arch_prono = new File(archivo_pronostico);
            Scanner fecha_scanner = new Scanner(arch_fecha);
            Scanner prono_scanner = new Scanner(arch_prono);

            while (fecha_scanner.hasNextLine() && prono_scanner.hasNextLine()) {
                fecha.add(fecha_scanner.nextLine().split(";"));
                pronostico.add(prono_scanner.nextLine().split(";"));
            }

        } catch (IOException e){
            System.out.println("error al obtener puntos");
            e.printStackTrace();
        }
        for (int i = 0; i < fecha.size(); i++){
            if (Integer.parseInt(fecha.get(i)[2]) == Integer.parseInt(pronostico.get(i)[2])) {
                puntos++;
            }
        }
        return puntos;
    }


    public static void fecha(Partido[] fecha,String archivo_fecha) {
        try {
            File archivo = new File(archivo_fecha);
            if (archivo.createNewFile()) {
                System.out.println("se creo el archivo fecha.txt");
            } else {
                System.out.println("se sobrescribio el archivo fecha.txt");
            }
            FileWriter escribe_archivo = new FileWriter(archivo_fecha);
            for (int i = 0; i < fecha.length; i++){
                escribe_archivo.write(fecha[i].getEquipo1().getNombre_equipo() + ";"
                                        + fecha[i].getEquipo2().getNombre_equipo() + ";"
                                        + fecha[i].getResultado() + "\n");
            }
            escribe_archivo.close();
        } catch (IOException e){
            System.out.println("error al crear archivo fecha.txt");
        }


    }
}
