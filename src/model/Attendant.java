package model;

import java.util.Objects;

public class Attendant {

	private int id;
	private String dni;
	private String name;
	private String surname;
	private String email;

	// constructores
	public Attendant(String dni, String name, String surname, String email) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public Attendant(int id, String dni, String name, String surname, String email) {
		this(dni, name, surname, email); // llamada al constructor de arriba
		this.id = id;
	}

	// getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n" + "**************************************************\n" + "         FICHA DE ASISTENTE: "
				+ (dni != null ? dni.toUpperCase() : "N/A") + "\n"
				+ "**************************************************\n" + " > ID:        " + id + "\n"
				+ " > DNI:       " + dni + "\n" + " > NOMBRE:    " + name + " " + surname + "\n" + " > EMAIL:     "
				+ email + "\n" + "**************************************************";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Attendant other = (Attendant) obj;
		return id == other.id || Objects.equals(dni, other.dni);
	}
}