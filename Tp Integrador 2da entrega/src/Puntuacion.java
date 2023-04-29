import java.util.*;

public class Puntuacion {

    public static Map<String, Integer> calcularPuntuacion(List<Ronda> rondas, List<Pronostico> pronosticos, int puntos_por_acierto) {

        Map<String, Integer> puntajes = new HashMap<>();
        for (Ronda ronda : rondas) {
            for (Partido partido : ronda.getPartidos()) {
                String equipo1 = partido.getEquipo1().getNombreEquipo();
                String equipo2 = partido.getEquipo2().getNombreEquipo();
                int resultado = partido.getResultado();
                for (Pronostico pronostico : pronosticos) {
                    String participante = pronostico.getNombreParticipante();
                    puntajes.putIfAbsent(participante, 0);
                    List<Partido> prediccion = pronostico.getPredicciones();
                    for (Partido prediccionPartido : prediccion) {
                        if (prediccionPartido != null
                                && prediccionPartido.getEquipo1().getNombreEquipo().equals(equipo1)
                                && prediccionPartido.getEquipo2().getNombreEquipo().equals(equipo2)
                                && prediccionPartido.getResultado() == resultado) {
                            int puntosActuales = puntajes.get(participante);
                            puntajes.put(participante, puntosActuales + puntos_por_acierto);
                        }
                    }

                }

            }
        }
        return puntajes;
    }

}