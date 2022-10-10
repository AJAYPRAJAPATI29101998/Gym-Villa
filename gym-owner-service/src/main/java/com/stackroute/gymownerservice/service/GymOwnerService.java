package com.stackroute.gymownerservice.service;

import com.stackroute.gymownerservice.model.GymOwner;

public interface GymOwnerService {


    GymOwner getGymownerById(Integer gid);
    GymOwner createGymowner(GymOwner newGymOwner);

}
