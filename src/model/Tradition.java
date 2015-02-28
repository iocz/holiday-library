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
}