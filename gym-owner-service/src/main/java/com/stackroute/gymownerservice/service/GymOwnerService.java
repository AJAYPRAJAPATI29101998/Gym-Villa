package com.stackroute.gymownerservice.service;

import com.stackroute.gymownerservice.model.GymOwner;

import java.util.List;

public interface GymOwnerService {
    GymOwner createGym(GymOwner Gym);

    GymOwner getGymById(Integer gid);

    GymOwner updateGymDetails(GymOwner Gym);

    String deleteGym(Integer gid );

    Iterable<GymOwner> getAllGyms();

    Iterable<GymOwner> findGymByCity(String city);




}
