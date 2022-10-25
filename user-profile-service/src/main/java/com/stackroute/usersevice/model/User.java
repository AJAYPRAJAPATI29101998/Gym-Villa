package com.stackroute.usersevice.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users_data")
public class User {
    @Id
    private int userId;
    private String userName;
    private int age;
    private long contactNumber;
    @Indexed(unique = true)
    @NotBlank(message = "Email cannot be blank")
    private String emailId;
    private String address;
    private long pincode;
    private GenderEnum gender;
}
