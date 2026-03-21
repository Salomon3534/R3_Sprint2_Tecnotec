package util;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import db.DatabaseConnector;
import model.Encounter;

public class ManagerEncounters {

    private ArrayList<Encounter> encountersList = new ArrayList<>();

    public ManagerEncounters() throws SQLException {
        loadEncounters();
    }

    public void loadEncounters() throws SQLException {
        encountersList.clear();
        String query = "SELECT * FROM ENCUENTRO";
        try (PreparedStatement ps = DatabaseConnector.getConexion().prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	encountersList.add(new Encounter(
                    rs.getString("CODIGO"), 
                    rs.getDate("FECHA_INICIO"),
                    rs.getDate("FECHA_FIN"), 
                    rs.getString("UBICACION")
                ));
            }
        }
    }

    public String createEncounter(String code, Date dateStart, Date dateEnd, String location) throws SQLException {
        String query = "INSERT INTO ENCUENTRO VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnector.getConexion().prepareStatement(query)) {
            ps.setString(1, code); ps.setDate(2, dateStart); ps.setDate(3, dateEnd);
            ps.setString(4, location);
            ps.executeUpdate();
        }
        loadEncounters();
        return "¡Encuentro con el codigo'" + code + "' se ha creado con éxito!";
    }

    public String listEncounters() {
        if (encountersList.isEmpty()) return "No hay encuentros registrados.";
        StringBuilder sb = new StringBuilder();
        for (Encounter e : encountersList) sb.append(e.toString());
        return sb.toString();
    }

    public String updateEncounter(Encounter e) throws SQLException {
        String query = "UPDATE ENCUENTRO SET CODIGO=?, FECHA_INICIO=?, FECHA_FIN=?, UBICACION=? WHERE CODIGO=?";
        try (PreparedStatement ps = DatabaseConnector.getConexion().prepareStatement(query)) {
            ps.setString(1, e.getCode());
            ps.setDate(2, e.getDateStart());
            ps.setDate(3, e.getDateEnd());
            ps.setString(4, e.getLocation());
            ps.setString(5, e.getCode());
            if (ps.executeUpdate() > 0) {
                loadEncounters();
                return "Datos del encuentro con codigo '" + e.getCode() + "' actualizados correctamente.";
            }
        }
        return "Error: El encuentro no existe.";
    }

    public String deleteEncounter(String code) throws SQLException {
        String query = "DELETE FROM ENCUENTRO WHERE CODIGO = ?";
        try (PreparedStatement ps = DatabaseConnector.getConexion().prepareStatement(query)) {
            ps.setString(1, code);
            if (ps.executeUpdate() > 0) {
                loadEncounters();
                return "El encuentro con el codigo: '" + code + "' se ha eliminado correctamente.";
            }
        }
        return "Error: No se encontró el encuentro con el codigo'" + code + "'.";
    }
}