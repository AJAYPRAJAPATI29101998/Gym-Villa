package com.stackroute.gymownerservice.controller;

import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GymOwnerController {

    @Autowired
    private GymOwnerService gymOwnerService;

        @PostMapping("gymowner")
        public GymOwner addGymOwner(@RequestBody GymOwner newgymowner)
        {
            return this.gymOwnerService.createGymowner(newgymowner);
        }
        @GetMapping ("gymowner/{gid}")
        public GymOwner getGymOwnerById(@PathVariable("gid") Integer gid)
        {
            return this.gymOwnerService.getGymownerById(gid);
        }
    }


