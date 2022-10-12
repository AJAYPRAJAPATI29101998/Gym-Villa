package com.stackroute.gymownerservice.controller;

import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymOwnerController {

    @Autowired
    private GymOwnerService gymOwnerService;

    @PostMapping("gym")
    public GymOwner addGym(@RequestBody GymOwner newgymowner) {
        return this.gymOwnerService.createGym(newgymowner);
    }

    @GetMapping("gym/{gid}")
    public GymOwner getGymById(@PathVariable("gid") Integer gid) {
        return this.gymOwnerService.getGymById(gid);
    }

    @PutMapping("gym")
    public GymOwner updateGymDetails(@PathVariable("gid") Integer gid) {
        return this.updateGymDetails(gid);
    }

    @DeleteMapping("gym/{gid}")
    public String deleteGym(@PathVariable("gid") Integer gid) {
        return this.gymOwnerService.deleteGym(gid);
    }

    @GetMapping("gyms")
    public Iterable<GymOwner> getAllGyms() {
        return this.gymOwnerService.getAllGyms();
    }

    @GetMapping("gyms/by/{city}")
    public Iterable<GymOwner> getGymsByCity(@PathVariable("city") String cityName) {
        return this.gymOwnerService.findGymByCity(cityName);
    }


}