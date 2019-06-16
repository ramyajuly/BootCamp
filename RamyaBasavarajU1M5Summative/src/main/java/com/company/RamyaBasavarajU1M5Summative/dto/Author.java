package com.company.RamyaBasavarajU1M5Summative.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Author {
    private int authorId;
    @NotEmpty(message = "FIRST NAME cannot be empty")
    private String firstName;
    @NotEmpty(message = "LAST NAME cannot be empty")
    private String lastName;
    @NotEmpty(message = "STREET cannot be empty")
    private String street;
    @NotEmpty(message = "CITY cannot be empty")
    private String city;
    @NotEmpty(message = "STATE cannot be empty")
    private String state;
    @NotEmpty(message = "POSTAL CODE cannot be empty")
    private String postalCode;
    @NotEmpty(message = "PHONE cannot be empty")
    private String phone;
    @NotEmpty(message = "EMAIL cannot be empty")
    private String email;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId &&
                firstName.equals(author.firstName) &&
                lastName.equals(author.lastName) &&
                street.equals(author.street) &&
                city.equals(author.city) &&
                state.equals(author.state) &&
                postalCode.equals(author.postalCode) &&
                phone.equals(author.phone) &&
                email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, street, city, state, postalCode, phone, email);
    }
}
