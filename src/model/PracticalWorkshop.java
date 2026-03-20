package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class PracticalWorkshop extends Event {

    private String workshopType;

    public PracticalWorkshop(int id, String title, String location, String description, LocalDate dateStart,
                             LocalDate dateEnd, LocalTime hourStart, LocalTime hourEnd, String encounterCode, 
                             String workshopType) {
        super(id, title, location, description, dateStart, dateEnd, hourStart, hourEnd, encounterCode);
        this.workshopType = workshopType;
    }

    public String getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(String workshopType) {
        this.workshopType = workshopType;
    }

    @Override
    public String toString() {
        return "PracticalWorkshop [workshopType=" + workshopType + ", id=" + getId() + ", title=" + getTitle()
                + ", location=" + getLocation() + ", description=" + getDescription() + ", dateStart="
                + getDateStart() + ", dateEnd=" + getDateEnd() + ", hourStart=" + getHourStart()
                + ", hourEnd=" + getHourEnd() + ", encounterCode=" + getEncounterCode() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workshopType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PracticalWorkshop other = (PracticalWorkshop) obj;
        return Objects.equals(workshopType, other.workshopType);
    }
}