
package model;

import java.util.Objects;

public class Attendant {
	
	private int id;
	private String dni;
	private String password;
	private String name;
	private String surname;
	private String email;
	
	public Attendant(int id, String dni, String password, String name, String surname, String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Attendant [id=" + id + ", dni=" + dni + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, email, id, name, password, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendant other = (Attendant) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}
	
	
	}