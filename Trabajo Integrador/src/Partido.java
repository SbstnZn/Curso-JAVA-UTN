public class Partido {
    Partido(Equipo eq1, Equipo eq2) {
        setEquipo1(eq1);
        setEquipo2(eq2);
    }Partido(Equipo eq1, Equipo eq2, int resultado) {
        setEquipo1(eq1);
        setEquipo2(eq2);
        setResultado_partido(resultado);
    }
    Partido(Equipo eq1, Equipo eq2, int goles_eq1, int goles_eq2) {
        setEquipo1(eq1);
        setEquipo2(eq2);
        setGoles_equipo1(goles_eq1);
        setGoles_equipo2(goles_eq2);

        if (goles_eq1 > goles_eq2) {
            setResultado_partido(1);
        } else if (goles_eq1 < goles_eq2){
            setResultado_partido(2);
        }
    }

    private Equipo equipo1 = new Equipo();
    private Equipo equipo2 = new Equipo();
    private int goles_equipo1 = 0;
    private int goles_equipo2 = 0;
    private int resultado_partido = 0;

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGoles_equipo1() {
        return goles_equipo1;
    }

    public int getGoles_equipo2() {
        return goles_equipo2;
    }
    int getResultado() {
        return resultado_partido;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public void setGoles_equipo1(int goles_equipo1) {
        this.goles_equipo1 = goles_equipo1;
    }

    public void setGoles_equipo2(int goles_equipo2) {
        this.goles_equipo2 = goles_equipo2;
    }

    public void setResultado_partido(int resultado_partido) {
        this.resultado_partido = resultado_partido;
    }
}
