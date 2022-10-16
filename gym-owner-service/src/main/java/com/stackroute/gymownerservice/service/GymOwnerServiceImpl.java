package com.stackroute.gymownerservice.service;
import com.stackroute.gymownerservice.Config.Producer;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.repository.GymSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.repository.GymOwnerRepository;
import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;


@Service
public class GymOwnerServiceImpl  implements GymOwnerService{
    @Autowired
    private GymOwnerRepository gymownerRepo;
    @Autowired
    private GymSlotRepository gymslotRepo;
    @Autowired
    private Producer producer;

    @Override
    public GymOwner createGym(GymOwner newGymOwner) throws GymIdAlreadyExistsException, GymNameAlreadyExistsException
    {
        GymOwner gymOwner = this.gymownerRepo.findGymByGymName(newGymOwner.getGymName());
        if(gymOwner != null)
        {
            throw new GymNameAlreadyExistsException(gymOwner.getGymName(), gymOwner.getGymId());
        }
        else if(this.gymownerRepo.findById(newGymOwner.getGymId()).isPresent())
        {
            throw new GymIdAlreadyExistsException(newGymOwner.getGymId());
        }
        else
        {
            this.gymownerRepo.save(newGymOwner);
            producer.sendMessageToRabbitMq(newGymOwner);
        }
        return newGymOwner;
    }

    @Override
    public GymOwner getGymById(Integer gid)
    {
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

    @Override
    public Iterable<GymSlot> findGymBySlotId(Integer slotid) {
        return this.gymslotRepo.findGymBySlotId(slotid);
    }


}
