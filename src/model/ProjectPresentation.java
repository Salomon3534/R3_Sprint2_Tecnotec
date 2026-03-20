package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ProjectPresentation extends Event {

    private String presentationType;

    public ProjectPresentation(int id, String title, String location, String description, LocalDate dateStart,
                               LocalDate dateEnd, LocalTime hourStart, LocalTime hourEnd, String encounterCode, 
                               String presentationType) {
        super(id, title, location, description, dateStart, dateEnd, hourStart, hourEnd, encounterCode);
        this.presentationType = presentationType;
    }

    public String getPresentationType() {
        return presentationType;
    }

    public void setPresentationType(String presentationType) {
        this.presentationType = presentationType;
    }

    @Override
    public String toString() {
        return "ProjectPresentation [presentationType=" + presentationType + ", id=" + getId() + ", title=" + getTitle()
                + ", location=" + getLocation() + ", description=" + getDescription() + ", dateStart="
                + getDateStart() + ", dateEnd=" + getDateEnd() + ", hourStart=" + getHourStart()
                + ", hourEnd=" + getHourEnd() + ", encounterCode=" + getEncounterCode() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), presentationType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        ProjectPresentation other = (ProjectPresentation) obj;
        return Objects.equals(presentationType, other.presentationType);
    }
}