package com.ait.qa31;

public class User {
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public User() {
        // Конструктор по умолчанию
    }

    public User(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Геттеры и сеттеры для каждого поля

    public String getGender() {
        return gender;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public void clickOnAddLink() {
    }

    public void clickOnSaveButton() {
    }

    public boolean isContactCreatedByText() {
        return false;
    }
}

