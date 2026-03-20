package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class RoundTable extends Event {

    private String tableType;

    public RoundTable(int id, String title, String location, String description, LocalDate dateStart,
                      LocalDate dateEnd, LocalTime hourStart, LocalTime hourEnd, String encounterCode, String tableType) {
        super(id, title, location, description, dateStart, dateEnd, hourStart, hourEnd, encounterCode);
        this.tableType = tableType;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    @Override
    public String toString() {
        return "RoundTable [tableType=" + tableType + ", id=" + getId() + ", title=" + getTitle()
                + ", location=" + getLocation() + ", description=" + getDescription() + ", dateStart="
                + getDateStart() + ", dateEnd=" + getDateEnd() + ", hourStart=" + getHourStart()
                + ", hourEnd=" + getHourEnd() + ", encounterCode=" + getEncounterCode() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tableType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        RoundTable other = (RoundTable) obj;
        return Objects.equals(tableType, other.tableType);
    }
}