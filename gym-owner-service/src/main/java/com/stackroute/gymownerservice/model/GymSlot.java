package com.stackroute.gymownerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymSlot {
    @Id
    private Integer slotId;
    private SlotTime slotTime ;
    private  SlotStatus slotStatus ;
}
