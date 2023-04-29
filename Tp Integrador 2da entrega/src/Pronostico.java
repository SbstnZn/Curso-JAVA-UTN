import java.util.ArrayList;
import java.util.List;

class Pronostico {
    private String nombreParticipante;
    private List<Partido> predicciones = new ArrayList<>();

    public Pronostico(String nombreParticipante, Equipo eq1, Equipo eq2, int resultado) {
        this.nombreParticipante = nombreParticipante;
        Partido p = new Partido(eq1,eq2,resultado);
        predicciones.add(p);

    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public List<Partido> getPredicciones() {
        return predicciones;
    }

    public void agregarPartido(Partido partido) {
        predicciones.add(partido);
    }
}