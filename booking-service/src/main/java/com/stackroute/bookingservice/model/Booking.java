package com.stackroute.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {

    @Transient
    public static final String SEQUENCE_NAME="booking_sequence";
    @Id
    private Integer bookingId;
    @NotBlank
    @Size(min = 4,max = 200,message = "Name size is less then 4")
    private String userName;
    @NotBlank(message = "Email should not be blank")
    private String userEmail;
    private LocalDateTime createdAt;
    private String gymOwnerEmail;
    private int slotId;
    private GymSubscription gymSubscription;
    private int gymId;
}
