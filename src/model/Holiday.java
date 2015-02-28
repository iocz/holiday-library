package model;

import java.util.ArrayList;
import java.util.Date;

public class Holiday {
    private String name;
    private Date startDate;
    private Date endDate;
    private HolidayType type;

    public Holiday (String name) {
        this.name = name;
        this.startDate = new Date();
        this.endDate = null;

    }
    // Конструктор праздника без указания даты (используется сегодняшняя)
    public Holiday(String name, int typeNum) {
        this.name = name;
        this.startDate = new Date();
        this.endDate = null;
        this.type = HolidayType.values()[typeNum];
    }
    // Конструктор с указанием даты
    public Holiday(String name, Date start,  Date end, int typeNum) {
        this.name = name;
        this.startDate = start;
        this.endDate = end;
        this.type = HolidayType.values()[typeNum];
    }

    public String getName() {
        return  this.name;
    }

    public String toString() {
        String s;
        if (endDate == null) s = startDate.toString();//(!startDate.equals(endDate)) s = startDate.toString();
        else s = String.format("с %s по %s",startDate,endDate);

        return String.format("Праздник %s празднуется %s",name,s);//"Праздник "+ name + " празднуется в стране " + country.getName() + " с " + startDate + " по " + endDate;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setType(HolidayType type) {
        this.type = type;
    }
}
