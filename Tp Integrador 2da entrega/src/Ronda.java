import java.util.List;

class Ronda {
    private int numeroRonda;
    private List<Partido> partidos;

    public Ronda(int numeroRonda, List<Partido> partidos) {
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }
}
