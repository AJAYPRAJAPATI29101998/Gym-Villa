package com.stackroute.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gym_details")
public class GymOwner {
    @MongoId
    private int gymOwnerId;
    private String gymName;
    private String gymOwnerName;
    private String gymOwnerEmail;
    private List<Slot> slots;
    private List<GymSubscriptions> gymSubscriptions;



}
