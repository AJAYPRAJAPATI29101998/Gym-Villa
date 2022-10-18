package com.stackroute.gymownerservice.service;
import com.stackroute.gymownerservice.Config.Producer;
import com.stackroute.gymownerservice.exceptions.GymIdNotAvailable;
import com.stackroute.gymownerservice.exceptions.GymNameNotAvailable;
import com.stackroute.gymownerservice.repository.GymSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.repository.GymOwnerRepository;
import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


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
    public GymOwner getGymById(Integer gid) throws GymIdNotAvailable
    {
        if (this.gymownerRepo.findById(gid).isEmpty())
        {
            throw new GymIdNotAvailable(gid);
        }
        return this.gymownerRepo.findById(gid).get();
    }

    @Override
    public GymOwner getGymByName(String name) throws GymNameNotAvailable
    {
        GymOwner gymOwner = this.gymownerRepo.findGymByGymName(name);
        if (gymOwner == null)
        {
            throw new GymNameNotAvailable(name);
        }
        return gymOwner;
    }

    @Override
    public GymOwner updateGymDetails(GymOwner updateGym) throws GymIdNotAvailable
    {
        if(this.gymownerRepo.findById(updateGym.getGymId()).isEmpty())
        {
            throw new GymIdNotAvailable(updateGym.getGymId());
        }
        GymOwner newGymOwner = this.gymownerRepo.save(updateGym);
        producer.sendMessageToRabbitMq(newGymOwner);
        return newGymOwner;
    }

    @Override
    public String deleteGym(Integer gid) throws GymIdNotAvailable
    {
        if (this.gymownerRepo.findById(gid).isEmpty())
        {
            throw new GymIdNotAvailable(gid);
        }
         this.gymownerRepo.deleteById(gid);
         return "Gym Owner deleted";
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
