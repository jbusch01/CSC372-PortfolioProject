import java.util.*;
import java.util.Scanner;

public class StudentData {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private double gpa;

    // Constructor
    public void Student(String firstName, String lastName, String streetAddress, String city, String state, int zipCode, double gpa) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.streetAddress=streetAddress;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.gpa=gpa;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getGPA() {
        return gpa;
    }
}
