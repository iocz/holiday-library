package model;

public class Tradition {
    private Holiday holiday;
    private Country country;
    private String description;

    public Tradition() {
    }

    public Tradition(Holiday holiday, Country country) {
        this.holiday = holiday;
        this.country = country;
        this.description = "";
    }
    
     public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
