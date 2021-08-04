
package com.testannotation.appointmentservice.model;

public class Patient {
    private String MRN;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String registrationDate;

    public String getMRN() {
        return MRN;
    }

    public void setMRN(String MRN) {
        this.MRN = MRN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public Patient(){

    }

    public Patient(String firstName, String lastName, String dateOfBirth, String registrationDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public Patient(String firstName, String lastName, String MRN, String dateOfBirth, String registrationDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.MRN = MRN;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.address = address;
    }

}
