
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Event {
	
   private int id;
   
   private String title;
   private String location;
   private String description;
   
   private LocalDate dateStart;
   private LocalDate dateEnd;
   
   private LocalTime hourStart;
   private LocalTime hourEnd;
   
   private String encounterCode; //no se para que sirve esto

   public Event(int id, String title, String location, String descryption, LocalDate dateStart, LocalDate dateEnd,
		LocalTime hourStart, LocalTime hourEnd, String encounterCode) {
	this.id = id;
	this.title = title;
	this.location = location;
	this.description = descryption;
	this.dateStart = dateStart;
	this.dateEnd = dateEnd;
	this.hourStart = hourStart;
	this.hourEnd = hourEnd;
	this.encounterCode = encounterCode;
   }

   public int getId() {
	return id;
   }

   public void setId(int id) {
	this.id = id;
   }

   public String getTitle() {
	return title;
   }

   public void setTitle(String title) {
	this.title = title;
   }

   public String getLocation() {
	return location;
   }

   public void setLocation(String location) {
	this.location = location;
   }

   public String getDescription() {
	return description;
   }

   public void setDescription(String descryption) {
	this.description = descryption;
   }

   public LocalDate getDateStart() {
	return dateStart;
   }

   public void setDateStart(LocalDate dateStart) {
	this.dateStart = dateStart;
   }

   public LocalDate getDateEnd() {
	return dateEnd;
   }

   public void setDateEnd(LocalDate dateEnd) {
	this.dateEnd = dateEnd;
   }

   public LocalTime getHourStart() {
	return hourStart;
   }

   public void setHourStart(LocalTime hourStart) {
	this.hourStart = hourStart;
   }

   public LocalTime getHourEnd() {
	return hourEnd;
   }

   public void setHourEnd(LocalTime hourEnd) {
	this.hourEnd = hourEnd;
   }

   public String getEncounterCode() {
	return encounterCode;
   }

   public void setEncounterCode(String encounterCode) {
	this.encounterCode = encounterCode;
   }

   @Override
   public String toString() {
	return "Event [id=" + id + ", title=" + title + ", location=" + location + ", descryption=" + description
			+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", hourStart=" + hourStart + ", hourEnd=" + hourEnd
			+ ", encounterCode=" + encounterCode + "]";
   }

   @Override
   public int hashCode() {
	return Objects.hash(dateEnd, dateStart, description, encounterCode, hourEnd, hourStart, id, location, title);
   }

   @Override
   public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Event other = (Event) obj;
	return Objects.equals(dateEnd, other.dateEnd) && Objects.equals(dateStart, other.dateStart)
			&& Objects.equals(description, other.description) && Objects.equals(encounterCode, other.encounterCode)
			&& Objects.equals(hourEnd, other.hourEnd) && Objects.equals(hourStart, other.hourStart) && id == other.id
			&& Objects.equals(location, other.location) && Objects.equals(title, other.title);
   }
   
   
   }
