
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Encounter {

	private int id;
	private String location;
	private String code;
	private Date dateStart;
	private Date dateEnd;

	// eventos que este encuentro engloba
	private ArrayList<Event> eventsInEncounterList;

	// constructor
	public Encounter(String code, Date dateStart, Date dateEnd, String location) {
		this.code = code;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String lugar) {
		this.location = lugar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public ArrayList<Event> getEventsInEncounterList() {
		return eventsInEncounterList;
	}

	public void setEventsInEncounterList(ArrayList<Event> eventsInEncounterList) {
		this.eventsInEncounterList = eventsInEncounterList;
	}

	@Override
	public String toString() {
		return "Encounter [id=" + id + ", location=" + location + ", code=" + code + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + ", eventsInEncounterList=" + eventsInEncounterList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, dateEnd, dateStart, eventsInEncounterList, id, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encounter other = (Encounter) obj;
		return Objects.equals(code, other.code) && Objects.equals(dateEnd, other.dateEnd)
				&& Objects.equals(dateStart, other.dateStart)
				&& Objects.equals(eventsInEncounterList, other.eventsInEncounterList) && id == other.id
				&& Objects.equals(location, other.location);
	}

}