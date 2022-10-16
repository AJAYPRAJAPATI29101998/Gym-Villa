package com.stackroute.gymownerservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName ="gymvilla",shards = 2,createIndex = true)

public class GymOwner {
    @Id
    private Integer gymId;
    private String gymName;
    private String gymOwnerName;
    private String emailId;
    private String city;
    private String address;
    private long pinCode;
    private long contactNumber;
    private List<GymSlot> gymSlot;
    private List<GymSubscription> gymSubscription;
}
