package com.stackroute.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    private int slotId;
    private Status slotStatus;
    private String time;
}
