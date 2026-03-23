package app;

<<<<<<< HEAD
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import model.*;
import util.*;
import java.util.Scanner;
=======
import java.sql.Connection;
import java.sql.SQLException;
import db.DatabaseConnector;
import util.TotalManagerEuskalEncounter;
import view.ViewEuskalEncounter;
>>>>>>> main

import db.ConexionBBDD;

public class Main {

<<<<<<< HEAD
    public static void main(String[] args) throws SQLException{
    	ConexionBBDD.getConexion();
    	
        System.out.println("#########################################");
        System.out.println("#      BIENVENIDO AL GESTOR DE EVENTOS  #");
        System.out.println("#########################################");

        MenuUsuario menuUsuario = new MenuUsuario();
        MenuAdmin menuAdmin = new MenuAdmin();
        int opcion;
        
        do {
            OpcionesElecionUsuarioAdmin.mostrar();
            System.out.print("Seleccione su perfil: ");
            opcion = checks.leerEntero(1, 3);
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("\nAccediendo como USUARIO...");
                    menuUsuario.menuU();
                }
                case 2 -> {
                    System.out.println("\nAccediendo como ADMINISTRADOR...");
                    menuAdmin.menuA();
                }
                case 3 -> System.out.println("\nGracias por usar el sistema. ¡Hasta pronto!");
            }
        } while (opcion != 3);
        ConexionBBDD.cerrarConexion();
    }
=======
	public static void main(String[] args) {
		try {
			// Intentamos obtener la conexión
			Connection connection = DatabaseConnector.getConexion();

			// Verificamos si la conexión es nula o no es válida (la BD no existe o no es
			// accesible)
			if (connection == null || connection.isClosed()) {
				throw new SQLException(
						"No se pudo establecer comunicación con el servidor SQL. Verifique que la base de datos existe.");
			}
>>>>>>> main

			TotalManagerEuskalEncounter managerTotal = new TotalManagerEuskalEncounter();
			ViewEuskalEncounter view = new ViewEuskalEncounter(managerTotal);

			// Loop principal de la app
			view.mainMenu();

			// Fin y cierre
			DatabaseConnector.cerrarConexion();

		} catch (SQLException e) {
			System.err.println("\n[ERROR DE BASE DE DATOS]");
			System.err
					.println("No se puede iniciar la aplicación porque la base de datos SQL no existe o no responde.");
			System.err.println("Detalles: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\n[ERROR INESPERADO]");
			System.err.println("Causa: " + e.getMessage());
		}
	}
}