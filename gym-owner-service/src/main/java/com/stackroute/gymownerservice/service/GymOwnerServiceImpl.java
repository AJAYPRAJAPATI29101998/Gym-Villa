package com.stackroute.gymownerservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.repository.GymOwnerRepository;

import java.util.List;

@Service
public class GymOwnerServiceImpl  implements GymOwnerService{
    @Autowired
    private GymOwnerRepository gymownerRepo;
    @Override
    public GymOwner createGym(GymOwner newGymOwner) {
        return this.gymownerRepo.save(newGymOwner);
    }
    @Override
    public GymOwner getGymById(Integer gid) {
        return this.gymownerRepo.findById(gid).get();
    }

    @Override
    public GymOwner updateGymDetails(GymOwner updateGym) {
        return this.gymownerRepo.save(updateGym);
    }

    @Override
    public String deleteGym(Integer gid) {
         this.gymownerRepo.deleteById(gid);
         return "Gym deleted";
    }

    @Override
    public Iterable<GymOwner> getAllGyms() {
        return this.gymownerRepo.findAll();
    }

    @Override
    public Iterable<GymOwner> findGymByCity(String city) {
        return this.gymownerRepo.findGymByCity(city);
    }



}
