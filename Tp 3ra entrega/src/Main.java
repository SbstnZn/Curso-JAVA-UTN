import funtions.*;
import clases.*;
import java.util.*;
import static funtions.Funciones.*;

class Main {
    public static void main(String[] args) {
        //el formato del archivo .csv debe ser el siguiente:
        //Pronostico : Participante,Equipo 1,Equipo 2,Resultado
        //Ronda: Ronda,Equipo 1,Goles Eq1, Goles Eq2, Equipo 2
        Map<String, List<Pronostico>> pronosticos = Funciones.leerPronosticos(".\\pronostico.csv");
        List<Ronda> rondas = leerRondas(".\\ronda.csv");
        Map<String, String> config = leerConfiguracion(".\\cfg.txt");
        String url = config.get("url");
        String user = config.get("user");
        String password = config.get("password");
        int[] puntos = {
                Integer.parseInt(config.get("puntos")),
                Integer.parseInt(config.get("extra_ronda")),
                Integer.parseInt(config.get("extra_fase"))
        };
        escribirPronosticosEnBD(pronosticos, url, user, password);
        Map<String, List<Pronostico>> pronosticos_db = Funciones.leerPronosticosDesdeBD(url, user, password);
        Map<String, int[]> puntajes = Puntuacion.calcularPuntuacion(rondas, pronosticos_db, puntos);
        System.out.println("Puntajes finales:");
        for (String participante : puntajes.keySet()) {
            int aciertos = puntajes.get(participante)[0];
            int puntos_participante = puntajes.get(participante)[1];
            System.out.println(String.join(": ", participante, aciertos + " aciertos", puntos_participante + " puntos."));
        }
    }
}

