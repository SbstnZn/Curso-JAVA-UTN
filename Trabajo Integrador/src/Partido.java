public class Partido {
    Partido(Equipo eq1, Equipo eq2, int goles_eq1, int goles_eq2) {
        equipo1 = eq1;
        equipo2 = eq2;
        goles_equipo1 = goles_eq1;
        goles_equipo2 = goles_eq2;
    }
    Equipo equipo1 = new Equipo(), equipo2 = new Equipo();
    int goles_equipo1 = 0, goles_equipo2 = 0;

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
    int resultado() {
        if(this.goles_equipo1 > this.goles_equipo2) { return 1;}

        else if (this.goles_equipo1 < this.goles_equipo2) { return 2;}

        return 0;
    }
}
