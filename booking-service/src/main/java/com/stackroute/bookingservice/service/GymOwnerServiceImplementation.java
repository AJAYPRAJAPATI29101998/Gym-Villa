package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dao.GymOwnerRepository;
import com.stackroute.bookingservice.dto.GymOwner;
import com.stackroute.bookingservice.dto.Status;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GymOwnerServiceImplementation implements GymOwnerService {

    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    @Override
    public GymOwner addGymData(GymOwner gymOwner) throws SameEntryException {
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(gymOwner.getGymOwnerId());
        if(owner.isPresent()){
            throw new SameEntryException("Gym data is already present please try to update or use new Id");
        }
        return this.gymOwnerRepository.save(gymOwner);
    }

    @Override
    public List<GymOwner> listAllGym() throws DataNotPresentException {
        List<GymOwner> gymOwners = this.gymOwnerRepository.findAll();
        if(gymOwners.isEmpty()){
            throw new  DataNotPresentException("Gym data not present");
        }
        return gymOwners;
    }

    @Override
    public void updateSlote(int gymOwnerID, int slotId) throws DataNotPresentException{
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(gymOwnerID);
        if(owner.isEmpty()){
            throw new DataNotPresentException("Gym not available by ID :-" +gymOwnerID);
        }
        owner.get().getSlots().stream().filter(e->e.getSlotId()==slotId).forEach(e->e.setSlotStatus(Status.BOOKED));
        this.gymOwnerRepository.save(owner.get());
    }

    @Override
    public GymOwner getSlotsByGymId(int id) throws DataNotPresentException{
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(id);
        if(owner.isEmpty()){throw new DataNotPresentException("\"Gym not available by ID :-" +id);}
        if(owner.get().getSlots().isEmpty()){throw new DataNotPresentException("No Slot Available for gymId:-" +id);}
        owner.get().setSlots(owner.get().getSlots().stream().filter(e->e.getSlotStatus()==Status.AVAILABLE).collect(Collectors.toList()));
        return owner.get();
    }

    @Override
    public String deleteGymById(int id) throws DataNotPresentException {

        Boolean check =  this.gymOwnerRepository.existsById(id);
        if(Boolean.FALSE.equals(check)){throw new DataNotPresentException("No gym data present with id:-"+id);}
            this.gymOwnerRepository.deleteById(id);
            return "Gym Details Removed Successfully";

    }
}
