package util;

import java.sql.SQLException;
import model.Guest;
import model.Attendant;

public class TotalManagerEuskalEncounter {
    
    private ManagerGuests mgue = new ManagerGuests();
    private ManagerEvents meve = new ManagerEvents();
    private ManagerAttendants matt = new ManagerAttendants();

    public TotalManagerEuskalEncounter() throws SQLException {
    }
    
    // metodos invitado

    public String createGuest(String username, String name, String surnames, String phoneNumber, String career, String email, String password) throws SQLException {
        return mgue.createGuest(username, name, surnames, phoneNumber, career, email, password);
    }
    
    public String listGuests() {
        return mgue.listGuests();
    }

    public String updateGuest(Guest guest) throws SQLException {
        return mgue.updateGuest(guest);
    }
    
    public String deleteGuest(String username) throws SQLException {
        return mgue.deleteGuest(username);
    }

    // metodos atendiente

    public String createAttendant(String dni, String name, String surname, String email) throws SQLException {
        return matt.createAttendant(dni, name, surname, email);
    }

    public String listAttendants() {
        return matt.listAttendants();
    }

    public String updateAttendants(Attendant attendant) throws SQLException {
        return matt.updateAttendants(attendant);
    }

    public String deleteAttendant(String dni) throws SQLException {
        return matt.deleteAttendant(dni);
    }
}