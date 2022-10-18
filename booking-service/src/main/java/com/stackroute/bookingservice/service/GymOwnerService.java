package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import com.stackroute.bookingservice.exceptions.SlotAlreadyBookedException;
import com.stackroute.bookingservice.model.GymOwner;

import java.util.List;

public interface GymOwnerService {
    GymOwner getGymDetails(int gymId) throws DataNotPresentException;
    GymOwner addGymData(GymOwner gymOwner) throws SameEntryException;
    List<GymOwner> listAllGym() throws DataNotPresentException;

    void updateSlotToBooked(int gymOwnerID,int slotID) throws DataNotPresentException;

    void updateSlotToAvailable(int gymOwnerID,int slotID) throws DataNotPresentException;

    GymOwner getSlotsByGymId(int id) throws DataNotPresentException;

    String deleteGymById(int id) throws DataNotPresentException;

    Boolean checkBookedSlot(int slotId,int gymId) throws DataNotPresentException, SlotAlreadyBookedException;

}
