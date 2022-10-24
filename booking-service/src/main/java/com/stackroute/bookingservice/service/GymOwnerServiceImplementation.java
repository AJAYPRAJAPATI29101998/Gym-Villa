package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dao.GymOwnerRepository;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import com.stackroute.bookingservice.exceptions.SlotAlreadyBookedException;
import com.stackroute.bookingservice.model.GymOwner;
import com.stackroute.bookingservice.model.GymSlot;
import com.stackroute.bookingservice.model.SlotStatus;
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
    public GymOwner getGymDetails(int gymId) throws DataNotPresentException {
        Optional<GymOwner> gymOwner = this.gymOwnerRepository.findById(gymId);
        if (gymOwner.isEmpty()) {
            throw new DataNotPresentException("No gym available for ID :- " + gymId);
        }
        return gymOwner.get();
    }

    @Override
    public GymOwner addGymData(GymOwner gymOwner) throws SameEntryException {
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(gymOwner.getGymId());
        if (owner.isPresent()) {
            throw new SameEntryException("Gym data is already present please try to update or use new Id");
        }
        return this.gymOwnerRepository.save(gymOwner);
    }

    @Override
    public List<GymOwner> listAllGym() throws DataNotPresentException {
        List<GymOwner> gymOwners = this.gymOwnerRepository.findAll();
        if (gymOwners.isEmpty()) {
            throw new DataNotPresentException("Gym data not present");
        }
        return gymOwners;
    }

    @Override
    public void updateSlotToBooked(int gymOwnerID, int slotId) throws DataNotPresentException {
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(gymOwnerID);
        if (owner.isEmpty()) {
            throw new DataNotPresentException("Gym not available by ID :-" + gymOwnerID);
        }
        owner.get().getGymSlot().stream().filter(e -> e.getSlotId() == slotId).forEach(e -> e.setSlotStatus(SlotStatus.BOOKED));
        this.gymOwnerRepository.save(owner.get());
    }

    @Override
    public void updateSlotToAvailable(int gymOwnerID, int slotId) throws DataNotPresentException {
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(gymOwnerID);
        if (owner.isEmpty()) {
            throw new DataNotPresentException("Gym not available by ID :-" + gymOwnerID);
        }
        owner.get().getGymSlot().stream().filter(e -> e.getSlotId() == slotId).forEach(e -> e.setSlotStatus(SlotStatus.AVAILABLE));
        this.gymOwnerRepository.save(owner.get());
    }

    @Override
    public GymOwner getSlotsByGymId(int id) throws DataNotPresentException {
        Optional<GymOwner> owner = this.gymOwnerRepository.findById(id);
        if (owner.isEmpty()) {
            throw new DataNotPresentException("\"Gym not available by ID :-" + id);
        }
        if (owner.get().getGymSlot().isEmpty()) {
            throw new DataNotPresentException("No Slot Available for gymId:-" + id);
        }
        owner.get().setGymSlot(owner.get().getGymSlot().stream().filter(e -> e.getSlotStatus() == SlotStatus.AVAILABLE).collect(Collectors.toList()));
        return owner.get();
    }

    @Override
    public String deleteGymById(int id) throws DataNotPresentException {

        Boolean check = this.gymOwnerRepository.existsById(id);
        if (Boolean.FALSE.equals(check)) {
            throw new DataNotPresentException("No gym data present with id:-" + id);
        }
        this.gymOwnerRepository.deleteById(id);
        return "Gym Details Removed Successfully";

    }

    @Override
    public Boolean checkBookedSlot(int slotId, int gymId) throws DataNotPresentException, SlotAlreadyBookedException {
        Optional<GymOwner> gymOwner = this.gymOwnerRepository.findById(gymId);
        if (gymOwner.isEmpty()) {
            throw new DataNotPresentException("Gym not present with ID:-" + gymId);
        }
        Optional<GymSlot> status = gymOwner.get().getGymSlot().stream().filter(e -> e.getSlotId() == slotId).findAny();
        if (status.isEmpty()) {
            throw new DataNotPresentException("No slot present with Slot ID -" + slotId + "on gym - " + gymId);
        }
        if (status.get().getSlotStatus() == SlotStatus.BOOKED) {
            throw new SlotAlreadyBookedException("Slot is booked for Slot ID -" + slotId + "on gym - " + gymId);
        }
        return true;
    }

    @Override
    public String getGymOwnerEmail(int gymId) throws DataNotPresentException {
        GymOwner gymOwner = getGymDetails(gymId);
        return gymOwner.getEmailId();
    }
}
