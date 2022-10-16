package com.stackroute.gymownerservice.controller;

import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymOwnerController {

    @Autowired
    private GymOwnerService gymOwnerService;

    @PostMapping("gym")
    public GymOwner addGym(@RequestBody GymOwner newgymowner) throws GymIdAlreadyExistsException, GymNameAlreadyExistsException {
        return this.gymOwnerService.createGym(newgymowner);
    }

    @GetMapping("gym/{gid}")
    public GymOwner getGymById(@PathVariable("gid") Integer gid) {
        return this.gymOwnerService.getGymById(gid);
    }

    /*@GetMapping("gym/{gid}/availableSlots")
    public List<GymSlot> getGymAvailableSlotById(@PathVariable("gid") Integer gid) {
        return this.gymOwnerService.getGymAvailableSlotById(gid);
    }*/

    @PutMapping("gym")
    public GymOwner updateGymDetails(@RequestBody GymOwner newgymowner) {
        return this.gymOwnerService.updateGymDetails(newgymowner);
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
    @GetMapping("gyms/by/{slotid}")
    public Iterable<GymSlot> getGymsBySlotId(@PathVariable("slotid") Integer slotId)

    {
        return this.gymOwnerService.findGymBySlotId(slotId);
    }

}