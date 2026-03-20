package view;

import java.sql.SQLException;
import model.Guest;
import util.InputOutputChecks;
import util.TotalManagerEuskalEncounter;

public class ViewEuskalEncounter {

    private InputOutputChecks checksInputOutput = new InputOutputChecks();
    private TotalManagerEuskalEncounter totalManager;

    public ViewEuskalEncounter(TotalManagerEuskalEncounter totalManagerEuskalEncounter) {
        this.totalManager = totalManagerEuskalEncounter;
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println(" SISTEMA DE GESTIÓN DE EUSKAL ENCOUNTER");
            System.out.println("========================================");
            System.out.println(" 1. Acceso Usuario (Modo Consulta)");
            System.out.println(" 2. Acceso Administrador (Modo Edición)");
            System.out.println(" 0. Salir del Sistema");
            System.out.print("\nSeleccione perfil: ");
            
            choice = checksInputOutput.getInt(0, 2);
            if (choice == 1) userMenu();
            else if (choice == 2) adminMenu();
        } while (choice != 0);
        
        System.out.println("\nSaliendo...");
    }

    private void userMenu() {
        int option;
        do {
            System.out.println("\n--- VISTA DE USUARIO ---");
            System.out.println("1. Ver Encuentros");
            System.out.println("2. Ver Eventos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Opción: ");
            option = checksInputOutput.getInt(0, 3);
            
            //TODO
        } while (option != 0);
    }

    private void adminMenu() {
        int entity;
        do {
            System.out.println("\n===========================");
            System.out.println("   PANEL DE ADMINISTRADOR  ");
            System.out.println("===========================");
            System.out.println("1. Gestionar Atendientes (DESACTIVADO)");
            System.out.println("2. Gestionar Encuentros (DESACTIVADO)");
            System.out.println("3. Gestionar Eventos (DESACTIVADO)");
            System.out.println("4. Gestionar Invitados");
            System.out.println("0. Volver");
            System.out.print("Seleccione entidad: ");

            entity = checksInputOutput.getInt(0, 4);
            
            if (entity == 4) {
            	
                // bucle de gestión de invitados
                manageGuests(showActionMenu("Invitados"));
            } else if (entity > 0 && entity < 4) {
                System.out.println("\n[!] Esta sección está temporalmente desactivada.");
            }
        } while (entity != 0);
    }

    private int showActionMenu(String title) {
        System.out.println("\n>> GESTIÓN DE " + title.toUpperCase());
        System.out.println("1. Crear invitado");
        System.out.println("2. Listar todos los invitados");
        System.out.println("3. Actualizar un invitado");
        System.out.println("4. Eliminar un invitado");
        System.out.println("0. Volver");
        System.out.print("Acción: ");
        return checksInputOutput.getInt(0, 4);
    }

    private void manageGuests(int initialAction) {
        int action = initialAction;
        
        if (action == 0) return;

        do {
            try {
                switch (action) {
                    case 1 -> {
                        System.out.println("\n--- REGISTRO DE NUEVO INVITADO ---");
                        System.out.println(totalManager.createGuest(
                            checksInputOutput.getString("Username: ", 50),
                            checksInputOutput.getString("Nombre: ", 100),
                            checksInputOutput.getString("Apellidos: ", 150),
                            checksInputOutput.getString("Teléfono: ", 15),
                            checksInputOutput.getString("Carrera/Perfil: ", 200),
                            checksInputOutput.leerEmail("Correo electrónico: ", 150),
                            checksInputOutput.getString("Contraseña: ", 255)
                        ));
                    }
                    case 2 -> {
                        System.out.println("\n--- LISTA DE INVITADOS REGISTRADOS ---");
                        System.out.println(totalManager.listGuests());
                    }
                    case 3 -> {
                        System.out.println("\n--- ACTUALIZAR DATOS ---");
                        System.out.println(totalManager.listGuests());
                        System.out.println("\nIntroduzca el Username actual y los nuevos detalles:");
                        System.out.println(totalManager.updateGuest(getGuestData()));
                    }
                    case 4 -> {
                        System.out.println("\n--- ELIMINAR REGISTRO ---");
                        System.out.println(totalManager.listGuests());
                        System.out.println("\nIntroduzca el Username del invitado a borrar:");
                        System.out.println(totalManager.deleteGuest(checksInputOutput.getString("Username: ", 50)));
                    }
                }
            } catch (SQLException e) {
                System.err.println("\n[ERROR DE SQL]: " + e.getMessage());
            }

            // tras cada acción, volvemos a mostrar el menú de Invitados
            if (action != 0) {
                action = showActionMenu("Invitados");
            }
        } while (action != 0);
    }

    private Guest getGuestData() {
        return new Guest(
            checksInputOutput.getString("Confirmar Username: ", 50),
            checksInputOutput.getString("Nombre: ", 100),
            checksInputOutput.getString("Apellidos: ", 150),
            checksInputOutput.getString("Teléfono: ", 15),
            checksInputOutput.getString("Carrera/Perfil: ", 200),
            checksInputOutput.leerEmail("Email: ", 150),
            checksInputOutput.getString("Contraseña: ", 255)
        );
    }
}