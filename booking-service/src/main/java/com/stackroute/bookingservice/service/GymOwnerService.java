package com.stackroute.bookingservice.service;

import com.mongodb.MongoException;
import com.stackroute.bookingservice.dto.AvailableSlots;
import com.stackroute.bookingservice.dto.GymOwner;
import com.stackroute.bookingservice.dto.Slot;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;

import java.sql.SQLException;
import java.util.List;

public interface GymOwnerService {
    GymOwner addGymData(GymOwner gymOwner) throws SameEntryException;
    List<GymOwner> listAllGym() throws DataNotPresentException;

    void updateSlote(int gymOwnerID,int slotID) throws DataNotPresentException;

    GymOwner getSlotsByGymId(int id) throws DataNotPresentException;

    String deleteGymById(int id) throws DataNotPresentException;
}
