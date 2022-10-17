package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import com.stackroute.bookingservice.model.GymOwner;

import java.util.List;

public interface GymOwnerService {
    GymOwner addGymData(GymOwner gymOwner) throws SameEntryException;
    List<GymOwner> listAllGym() throws DataNotPresentException;

    void updateSlote(int gymOwnerID,int slotID) throws DataNotPresentException;

    GymOwner getSlotsByGymId(int id) throws DataNotPresentException;

    String deleteGymById(int id) throws DataNotPresentException;
}
