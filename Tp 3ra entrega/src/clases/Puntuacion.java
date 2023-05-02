package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puntuacion {
    public static Map<String, int[]> calcularPuntuacion(List<Ronda> rondas, Map<String, List<Pronostico>> pronosticos, int[] puntos) {
        Map<String, int[]> resultados = new HashMap<>();
        for (String participante : pronosticos.keySet()) {
            resultados.put(participante, new int[]{0, 0});
        }
        for (Ronda ronda : rondas) {
            Map<String, Boolean> aciertosRonda = new HashMap<>();
            for (String participante : pronosticos.keySet()) {
                aciertosRonda.put(participante, true);
            }
            for (Partido partido : ronda.getPartidos()) {
                for (String participante : pronosticos.keySet()) {
                    boolean acierto = false;
                    for (Pronostico pronostico : pronosticos.get(participante)) {
                        if (pronostico.getNombreEquipo1().equals(partido.getNombreEquipo1()) && pronostico.getNombreEquipo2().equals(partido.getNombreEquipo2())) {
                            if (pronostico.getResultado() == partido.getResultado()) {
                                int[] resultado = resultados.get(participante);
                                resultado[0]++;
                                resultado[1] += puntos[0];
                                acierto = true;
                            }
                        }
                    }
                    if (!acierto) {
                        aciertosRonda.put(participante, false);
                    }
                }
            }
            for (String participante : pronosticos.keySet()) {
                if (aciertosRonda.get(participante)) {
                    int[] resultado = resultados.get(participante);
                    resultado[1] += puntos[1];
                }
            }
        }
        int total_partidos = 0;
        for (Ronda x : rondas) {
            total_partidos += x.getPartidos().size();
        }
        for (String participante : resultados.keySet()) {
            if (resultados.get(participante)[0] == total_partidos) {
                int[] resultado = resultados.get(participante);
                resultado[1] += puntos[2];
            }
        }
        return resultados;
    }
}