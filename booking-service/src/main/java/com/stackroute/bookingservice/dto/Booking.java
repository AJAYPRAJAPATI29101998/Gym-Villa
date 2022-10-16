package com.stackroute.bookingservice.dto;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {
    @MongoId
    private Integer bookingId;
    @NotBlank
    @Size(min = 4,max = 200,message = "Name size is less then 4")
    private String userName;
    @NotBlank(message = "Email should not be blank")
    @Email
    private String userEmail;
    private Integer userId;
    private int slotId;
    private GymSubscriptions gymSubscriptions;
    private int gymOwnerId;
}
