package com.learningspringboot.learningspringboot.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserRequest {
    @NotNull(message = "First name cannot be missing or empty")
    private String firstName;
    @NotNull(message = "Last name cannot be missing or empty")
    private String lastName;

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

}
