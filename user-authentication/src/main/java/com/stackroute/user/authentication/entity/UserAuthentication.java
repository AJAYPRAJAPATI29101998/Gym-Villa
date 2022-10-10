package com.stackroute.user.authentication.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAuthentication {
    @Id
    @JsonProperty(value = "emailId")
    private String emailId;
    @JsonProperty(value = "password")
    private String password;
    private enum role{user,GymOwner};

    public UserAuthentication() {
    }

    public UserAuthentication(String emailId, String Password) {
        emailId = emailId;
        Password = Password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String EmailId) {
        this.emailId = EmailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }
}
