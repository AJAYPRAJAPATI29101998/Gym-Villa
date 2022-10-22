package com.stackroute.gymownerservice.controller;

import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymIdNotAvailable;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameNotAvailable;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Gym-owner-service")
public class GymOwnerController {

    @Autowired
    private GymOwnerService gymOwnerService;

    @PostMapping("gym")
    public GymOwner addGym(@RequestBody GymOwner newgymowner) throws GymIdAlreadyExistsException, GymNameAlreadyExistsException {
        return this.gymOwnerService.createGym(newgymowner);
    }

    @GetMapping("gym/{gid}")
    public GymOwner getGymById(@PathVariable("gid") Integer gid) throws GymIdNotAvailable {
        return this.gymOwnerService.getGymById(gid);
    }

    @GetMapping("gymname/{gymName}")
    public GymOwner getGymByName(@PathVariable("gymName") String gName) throws GymNameNotAvailable {
        return this.gymOwnerService.getGymByName(gName);
    }

    @PutMapping("gym")
    public GymOwner updateGymDetails(@RequestBody GymOwner newgymowner) throws GymIdNotAvailable {
        return this.gymOwnerService.updateGymDetails(newgymowner);
    }

    @DeleteMapping("gym/{gid}")
    public String deleteGym(@PathVariable("gid") Integer gid) throws GymIdNotAvailable {
        return this.gymOwnerService.deleteGym(gid);
    }

    @GetMapping("gyms")
    public Iterable<GymOwner> getAllGyms() {
        return this.gymOwnerService.getAllGyms();
    }

    @GetMapping("gyms/city/{city}")
    public Iterable<GymOwner> getGymsByCity(@PathVariable("city") String cityName) {
        return this.gymOwnerService.findGymByCity(cityName);
    }

}