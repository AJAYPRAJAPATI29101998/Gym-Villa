package com.stackroute.gymownerservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.repository.GymOwnerRepository;
@Service
public class GymOwnerServiceImpl  implements GymOwnerService{
    @Autowired
    private GymOwnerRepository gymownerRepo;

    @Override
    public GymOwner getGymownerById(Integer gid) {
        return this.gymownerRepo.findById(gid).get();
    }

    @Override
    public GymOwner createGymowner(GymOwner newGymOwner) {
        return this.gymownerRepo.save(newGymOwner);
    }
}
