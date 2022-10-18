package com.stackroute.gymownerservice.service;

import com.stackroute.gymownerservice.exceptions.GymIdNotAvailable;
import com.stackroute.gymownerservice.exceptions.GymNameNotAvailable;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;

public interface GymOwnerService {
    GymOwner createGym(GymOwner Gym) throws GymIdAlreadyExistsException, GymNameAlreadyExistsException;

    GymOwner getGymById(Integer gid) throws GymIdNotAvailable;

    GymOwner getGymByName(String name) throws GymNameNotAvailable;

    GymOwner updateGymDetails(GymOwner Gym) throws GymIdNotAvailable;

    String deleteGym(Integer gid ) throws GymIdNotAvailable;

    Iterable<GymOwner> getAllGyms();

    Iterable<GymOwner> findGymByCity(String city);

}
