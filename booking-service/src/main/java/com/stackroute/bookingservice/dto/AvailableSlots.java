package com.stackroute.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableSlots {
    private List<Slot> slots;
    private List<GymSubscriptions> gymSubscriptions;
}
