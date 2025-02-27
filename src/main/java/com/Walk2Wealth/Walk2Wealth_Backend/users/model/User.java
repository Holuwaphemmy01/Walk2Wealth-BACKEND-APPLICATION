package com.Walk2Wealth.Walk2Wealth_Backend.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Column(nullable = false, name = "firstName")
    private String firstName;
    @Column(nullable = false, name = "lastName")
    private String lastName;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "password")
    private String password;
    public enum Gender{
        MALE, FEMALE
    }
    @Column(nullable = false, name = "gender")
    private Gender gender;
    @Column(nullable = false, name = "dateOfBirth")
    private Date dateOfBirth;
    @Id
    @Column(nullable = false, name = "userName")
    private String userName;



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
