package funtions;

import clases.Partido;
import clases.Pronostico;
import clases.Ronda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;


public class Funciones {
    public static List<Ronda> leerRondas(String archivo) {
        List<Ronda> rondas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            if (reader.ready()) {
                reader.readLine();
            }
            int rondaActual = -1;
            List<Partido> partidos = new ArrayList<>();
            while (reader.ready()) {
                String[] datos = reader.readLine().split(",");
                if (datos.length != 5) {
                    System.out.println("Error de formato en la línea: " + Arrays.toString(datos));
                    continue;
                }
                int ronda;
                try {
                    ronda = Integer.parseInt(datos[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en la ronda en la línea: " + Arrays.toString(datos));
                    continue;
                }
                String nombreEquipo1 = datos[1];
                int golesEquipo1;
                try {
                    golesEquipo1 = Integer.parseInt(datos[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en los goles del equipo 1 en la línea: " + Arrays.toString(datos));
                    continue;
                }
                int golesEquipo2;
                try {
                    golesEquipo2 = Integer.parseInt(datos[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Error en los goles del equipo 2 en la línea: " + Arrays.toString(datos));
                    continue;
                }
                String nombreEquipo2 = datos[4];
                Partido partido = new Partido(nombreEquipo1, golesEquipo1, golesEquipo2, nombreEquipo2);
                if (ronda != rondaActual) {
                    if (!partidos.isEmpty()) {
                        rondas.add(new Ronda(rondaActual, partidos));
                        partidos.clear();
                    }
                    rondaActual = ronda;
                }
                partidos.add(partido);
            }
            if (!partidos.isEmpty()) {
                rondas.add(new Ronda(rondaActual, partidos));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
        return rondas;
    }

    public static Map<String, List<Pronostico>> leerPronosticos(String archivo) {
        Map<String, List<Pronostico>> pronosticos = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            if (reader.ready()) {
                reader.readLine();
            }
            while (reader.ready()) {
                String[] datos = reader.readLine().split(",");
                if (datos.length != 4) {
                    System.out.println("Error de formato en la línea: " + Arrays.toString(datos));
                    continue;
                }
                String participante = datos[0];
                String nombreEquipo1 = datos[1];
                String nombreEquipo2 = datos[2];
                int resultado = Integer.parseInt(datos[3]);
                Pronostico pronostico = new Pronostico(nombreEquipo1, nombreEquipo2, resultado);
                if (!pronosticos.containsKey(participante)) {
                    pronosticos.put(participante, new ArrayList<>());
                }
                pronosticos.get(participante).add(pronostico);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
        return pronosticos;
    }

    public static void escribirRondasEnBD(List<Ronda> rondas, String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM partidos");
                stmt.executeUpdate("DELETE FROM rondas");
            }
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO rondas (numero) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                for (Ronda ronda : rondas) {
                    stmt.setInt(1, ronda.getNumero());
                    stmt.executeUpdate();
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            int rondaId = rs.getInt(1);
                            try (PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO partidos (ronda_id, nombreEquipo1, golesEquipo1, golesEquipo2, nombreEquipo2) VALUES (?, ?, ?, ?, ?)")) {
                                for (Partido partido : ronda.getPartidos()) {
                                    stmt2.setInt(1, rondaId);
                                    stmt2.setString(2, partido.getNombreEquipo1());
                                    stmt2.setInt(3, partido.getGolesEquipo1());
                                    stmt2.setInt(4, partido.getGolesEquipo2());
                                    stmt2.setString(5, partido.getNombreEquipo2());
                                    stmt2.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<Pronostico>> leerPronosticosDesdeBD(String url, String user, String password) {
        Map<String, List<Pronostico>> pronosticos = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT participante, nombreEquipo1, nombreEquipo2, resultado FROM pronosticos")) {
            while (rs.next()) {
                String participante = rs.getString("participante");
                String nombreEquipo1 = rs.getString("nombreEquipo1");
                String nombreEquipo2 = rs.getString("nombreEquipo2");
                int resultado = rs.getInt("resultado");
                Pronostico pronostico = new Pronostico(nombreEquipo1, nombreEquipo2, resultado);
                if (!pronosticos.containsKey(participante)) {
                    pronosticos.put(participante, new ArrayList<>());
                }
                pronosticos.get(participante).add(pronostico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pronosticos;
    }

    public static void escribirPronosticosEnBD(Map<String, List<Pronostico>> pronosticos, String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM pronosticos");
            }
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO pronosticos (participante, nombreEquipo1, nombreEquipo2, resultado) VALUES (?, ?, ?, ?)")) {
                for (String participante : pronosticos.keySet()) {
                    for (Pronostico pronostico : pronosticos.get(participante)) {
                        stmt.setString(1, participante);
                        stmt.setString(2, pronostico.getNombreEquipo1());
                        stmt.setString(3, pronostico.getNombreEquipo2());
                        stmt.setInt(4, pronostico.getResultado());
                        stmt.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> leerConfiguracion(String archivo) {
        Map<String, String> config = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            while (reader.ready()) {
                String[] datos = reader.readLine().split("=");
                if (datos.length != 2) {
                    System.out.println("Error de formato en la línea: " + Arrays.toString(datos));
                    continue;
                }
                config.put(datos[0], datos[1]);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
        return config;
    }
}
