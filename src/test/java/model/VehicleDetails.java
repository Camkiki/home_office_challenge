package model;

/**
 * Created by tolaf on 02/05/2018.
 * Getter and Setter for Vehicle
 */
public class VehicleDetails {
    private String registrationNumber;
    private String make;
    private String colour;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
