package clases;

public class Partido {
    private final String nombreEquipo1;
    private final int golesEquipo1;
    private final int golesEquipo2;
    private final String nombreEquipo2;

    public Partido(String nombreEquipo1, int golesEquipo1, int golesEquipo2, String nombreEquipo2) {
        this.nombreEquipo1 = nombreEquipo1;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.nombreEquipo2 = nombreEquipo2;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public int getResultado() {
        if (golesEquipo1 > golesEquipo2) {
            return 1; // Gana equipo 1
        } else if (golesEquipo1 < golesEquipo2) {
            return 2; // Gana equipo 2
        } else {
            return 0; // empate
        }
    }
}


