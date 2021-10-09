package com.learningspringboot.learningspringboot.ui;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull(message = "First name cannot be missing or empty")
    private String firstName;
    @NotNull(message = "Last name cannot be missing or empty")
    private String lastName;
    @NotNull(message = "First name cannot be missing or empty")
    @Email
    private String email;
    private String userId;
    @NotNull(message = "First name cannot be missing or empty")
    @Size(min = 8, max = 16, message = "Password must be equal to or greater than 8 characters and less than 16 characters")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
