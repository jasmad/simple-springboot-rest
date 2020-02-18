package com.jason.sbrest.model;

import javax.validation.constraints.NotBlank;

public class UserBody {
    private String firstName;
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String password;
    private USER_ROLE role;

    public UserBody() {
    }

    public UserBody(String firstName, String lastName, String email, String password, USER_ROLE role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }
}
