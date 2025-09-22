package com.testautomation.builder;

public class UserBuilder {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User build() {
        return new User(email, password, firstName, lastName);
    }
}
