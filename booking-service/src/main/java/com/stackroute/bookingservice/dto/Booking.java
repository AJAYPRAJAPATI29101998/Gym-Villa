package com.stackroute.bookingservice.dto;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {
    @MongoId
    private Integer bookingId;
    private String userName;
    private String userEmail;
    private Integer userId;
    private Integer slot;
    private Status bookingStatus;
}
