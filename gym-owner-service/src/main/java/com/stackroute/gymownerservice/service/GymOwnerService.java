package com.stackroute.gymownerservice.service;

import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;

public interface GymOwnerService {
    GymOwner createGym(GymOwner Gym) throws GymIdAlreadyExistsException, GymNameAlreadyExistsException;

    GymOwner getGymById(Integer gid);

    GymOwner updateGymDetails(GymOwner Gym);

    String deleteGym(Integer gid );

    Iterable<GymOwner> getAllGyms();

    Iterable<GymOwner> findGymByCity(String city);

    Iterable<GymSlot> findGymBySlotId(Integer slotid);


}
