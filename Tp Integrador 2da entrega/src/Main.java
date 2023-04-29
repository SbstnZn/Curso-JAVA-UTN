import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //el formato del archivo .csv debe ser el siguiente:
        //Pronostico : Participante,Equipo 1,Equipo 2,Resultado
        //Ronda: Ronda,Equipo 1,Goles Eq1, Goles Eq2, Equipo 2
        List<Ronda> rondas = leerRondas(".\\ronda.csv");
        List<Pronostico> pronosticos = leerPronosticos(".\\pronostico.csv");

        int puntos_por_acierto = 1;
        Map<String, Integer> puntajes = Puntuacion.calcularPuntuacion(rondas,pronosticos,puntos_por_acierto);
        System.out.println("Puntajes finales:");
        for (String participante : puntajes.keySet()) {
            int aciertos = puntajes.get(participante);
            System.out.println(participante + ": " + aciertos + " aciertos, " + aciertos*puntos_por_acierto + " puntos." );
        }
    }
    public static List<Ronda> leerRondas(String archivo) {
        List<Ronda> rondas = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(archivo))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            int rondaActual = -1;
            List<Partido> partidos = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length != 5) {
                    System.out.println("Error de formato en la línea: " + Arrays.toString(datos));
                    continue;
                }
                int ronda;
                try {
                    ronda = Integer.parseInt(datos[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en la ronda en la línea: " + Arrays.toString(datos));
                    continue;
                }
                String nombreEquipo1 = datos[1];
                int golesEquipo1;
                try {
                    golesEquipo1 = Integer.parseInt(datos[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en los goles del equipo 1 en la línea: " + Arrays.toString(datos));
                    continue;
                }
                int golesEquipo2;
                try {
                    golesEquipo2 = Integer.parseInt(datos[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en los goles del equipo 2 en la línea: " + Arrays.toString(datos));
                    continue;
                }
                String nombreEquipo2 = datos[4];
                Equipo equipo1 = new Equipo(nombreEquipo1);
                Equipo equipo2 = new Equipo(nombreEquipo2);
                int resultado = 0;
                if (golesEquipo1 < golesEquipo2) {
                    resultado = 2;
                } else if (golesEquipo1 > golesEquipo2) {
                    resultado = 1;
                }
                Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2,resultado);
                if (ronda != rondaActual) {
                    if (!partidos.isEmpty()) {
                        Ronda rondaAnterior = new Ronda(rondaActual, partidos);
                        rondas.add(rondaAnterior);
                        partidos = new ArrayList<>();
                    }
                    rondaActual = ronda;
                }
                partidos.add(partido);
            }
            if (!partidos.isEmpty()) {
                Ronda ultimaRonda = new Ronda(rondaActual, partidos);
                rondas.add(ultimaRonda);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rondas;
    }

    public static List<Pronostico> leerPronosticos(String archivoPronosticos) throws FileNotFoundException {
        List<Pronostico> pronosticos = new ArrayList<>();
        Scanner scanner = new Scanner(new File(archivoPronosticos));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] campos = linea.split(",");
            if (campos.length == 4) {
                String nombreParticipante = campos[0];
                String nombreEquipo1 = campos[1].trim();
                String nombreEquipo2 = campos[2].trim();
                int resultado = Integer.parseInt(campos[3].trim());
                Equipo equipo1 = new Equipo(nombreEquipo1);
                Equipo equipo2 = new Equipo(nombreEquipo2);
                Partido partido = new Partido(equipo1, equipo2, resultado);
                Pronostico pronosticoExistente = null;
                for (Pronostico pronostico : pronosticos) {
                    if (pronostico.getNombreParticipante().equals(nombreParticipante)) {
                        pronosticoExistente = pronostico;
                        break;
                    }
                }
                if (pronosticoExistente == null) {
                    pronosticoExistente = new Pronostico(nombreParticipante,equipo1,equipo2,resultado);
                    pronosticos.add(pronosticoExistente);
                }else {
                    pronosticoExistente.agregarPartido(partido);
                }
            }
        }
        scanner.close();
        return pronosticos;
    }
}