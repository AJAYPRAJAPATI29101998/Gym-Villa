package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dao.BookingRepository;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.BookingDTO;
import com.stackroute.bookingservice.model.BookingIdCounter;
import com.stackroute.bookingservice.rqmproducer.BookingQueues;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class BookingServiceImplementation implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private GymOwnerServiceImplementation gymService;

    @Override
    public Booking addBookingStatus(Booking booking) throws DataNotPresentException {
        booking.setCreatedAt(LocalDateTime.now());
        booking.setGymOwnerEmail(this.gymService.getGymOwnerEmail(booking.getGymId()));
        booking.setBookingId(getSequenceNumber(Booking.SEQUENCE_NAME));
        Booking currentBooking= this.bookingRepository.save(booking);
        this.gymService.updateSlotToBooked(currentBooking.getGymId(), currentBooking.getSlotId());
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(currentBooking.getBookingId());
        bookingDTO.setUserName(currentBooking.getUserName());
        bookingDTO.setUserEmail(currentBooking.getUserEmail());
        bookingDTO.setCreatedAt(String.valueOf(currentBooking.getCreatedAt()));
        bookingDTO.setGymOwnerEmail(currentBooking.getGymOwnerEmail());
        bookingDTO.setSlotId(currentBooking.getSlotId());
        bookingDTO.setGymSubscription(currentBooking.getGymSubscription());
        bookingDTO.setGymId(currentBooking.getGymId());
        rabbitTemplate.convertAndSend("booking_information_slots", "booking_routingkey", bookingDTO);
        rabbitTemplate.convertAndSend(BookingQueues.TOPIC_EXCHNAGE, BookingQueues.ROUTING_KEY,bookingDTO);
        return currentBooking;
    }

    @Override
    public Booking getBookingByid(int id) throws DataNotPresentException {

            Optional<Booking> booking= this.bookingRepository.findById(id);
            if(booking.isEmpty()){
                throw new DataNotPresentException("NO booking available for Booking ID -"+id);
            }
            return booking.get();

    }

    @Override
    public Boolean deleteBookingById(int id) {
        try {
            this.bookingRepository.deleteById(id);
            return true;
        } catch (Exception e) {
             e.getMessage();
        }
        return false;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        try {
            Optional<Booking> booking1 = this.bookingRepository.findById(booking.getBookingId());
            if(booking1.isEmpty()){
                throw new DataNotPresentException("booking not present with booking id - "+booking.getBookingId());
            }
            return this.bookingRepository.save(booking);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookings() throws SQLException {


        List<Booking> result = this.bookingRepository.findAll();
        return result;
    }

    @Override
    public int getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update=new Update().inc("sequence",1);
        BookingIdCounter counter= mongoOperations.findAndModify(query, update,options().returnNew(true).upsert(true),BookingIdCounter.class);
        return !Objects.isNull(counter)?counter.getSequence():1;
    }


}
