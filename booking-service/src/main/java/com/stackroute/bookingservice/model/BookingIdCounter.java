package com.stackroute.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookingid_counter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingIdCounter {
    @Id
    private String id;
    private int sequence;
}
