package clases;

import java.util.List;

public class Ronda {
    private final int numero;
    private final List<Partido> partidos;

    public Ronda(int numero, List<Partido> partidos) {
        this.numero = numero;
        this.partidos = partidos;
    }

    public int getNumero() {
        return numero;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}