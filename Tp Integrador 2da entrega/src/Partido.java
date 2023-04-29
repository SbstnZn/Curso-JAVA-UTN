class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int resultado;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, int resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.resultado = resultado;
    }
    public Partido(Equipo equipo1, Equipo equipo2, int resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public int getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Partido:" +
                equipo1.getNombreEquipo() +
                " " + golesEquipo1 +
                "-" + golesEquipo2 +
                " " + equipo2.getNombreEquipo() +
                " " + golesEquipo2 +", Resultado " + resultado + "\n";
    }
}
