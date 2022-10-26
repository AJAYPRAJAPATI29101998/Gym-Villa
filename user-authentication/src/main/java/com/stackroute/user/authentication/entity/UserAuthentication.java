package com.stackroute.user.authentication.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Validated
@NoArgsConstructor
public class UserAuthentication {
    @Id
    @JsonProperty(value = "emailId")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "give the correct email")
    private String emailId;
    @JsonProperty(value = "password")
    @NotNull(message = "it should be not null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "password must min 8 chars , contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;

    private Role role;


    public UserAuthentication(String user, String s, String s1, String user1) {
    }

    public UserAuthentication(String s, String s1, Role user) {
    }
}
