package util;

import java.sql.SQLException;
import model.Guest;
import util.*;

public class TotalManagerEuskalEncounter {
    
    private ManagerGuests mgue = new ManagerGuests();
    private ManagerEvents meve = new ManagerEvents();

    public TotalManagerEuskalEncounter() throws SQLException {
    }
    
    public String createGuest(String username, String name, String surnames, String phoneNumber, String career, String email, String password) throws SQLException {
        return mgue.createGuest(username, name, surnames, phoneNumber, career, email, password);
    }
    
    public String listGuests() {
        return mgue.listGuests();
    }

    public String updateGuest(Guest guest) throws SQLException {
        return mgue.updateGuest(guest);
    }
    
    // CORREGIDO: Firma del método para aceptar String
    public String deleteGuest(String username) throws SQLException {
        return mgue.deleteGuest(username);
    }
}