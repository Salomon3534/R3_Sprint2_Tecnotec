
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class KeynoteSpeech extends Event {
	
	   private String speechType;
	
   public KeynoteSpeech(int id, String title, String location, String descryption, LocalDate dateStart,
			LocalDate dateEnd, LocalTime hourStart, LocalTime hourEnd, String encounterCode, String speechType) {
		super(id, title, location, descryption, dateStart, dateEnd, hourStart, hourEnd, encounterCode);
		this.speechType = speechType;
	}

   public String getSpeechType() {
	return speechType;
   }

   public void setSpeechType(String speechType) {
	this.speechType = speechType;
   }

   @Override
   public String toString() {
	return "KeynoteSpeech [speechType=" + speechType + ", getId()=" + getId() + ", getTitle()=" + getTitle()
			+ ", getLocation()=" + getLocation() + ", getDescription()=" + getDescription() + ", getDateStart()="
			+ getDateStart() + ", getDateEnd()=" + getDateEnd() + ", getHourStart()=" + getHourStart()
			+ ", getHourEnd()=" + getHourEnd() + ", getEncounterCode()=" + getEncounterCode() + ", toString()="
			+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
   }

   @Override
   public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(speechType);
	return result;
   }

   @Override
   public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	KeynoteSpeech other = (KeynoteSpeech) obj;
	return Objects.equals(speechType, other.speechType);
   }

   }