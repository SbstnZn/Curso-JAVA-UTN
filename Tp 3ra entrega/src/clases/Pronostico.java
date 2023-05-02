package clases;

public class Pronostico {
    private final String nombreEquipo1;
    private final String nombreEquipo2;
    private final int resultado;

    public Pronostico(String nombreEquipo1, String nombreEquipo2, int resultado) {
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.resultado = resultado;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public int getResultado() {
        return resultado;
    }
}