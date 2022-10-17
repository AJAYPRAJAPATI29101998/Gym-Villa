//package com.stackroute.bookingservice.service;
//
//import com.stackroute.bookingservice.dto.GymSubscriptions;
//import com.stackroute.bookingservice.dto.Slot;
//import com.stackroute.bookingservice.dto.Status;
//import com.stackroute.bookingservice.exceptions.DataNotPresentException;
//import com.stackroute.bookingservice.exceptions.SameEntryException;
//import com.stackroute.bookingservice.model.GymOwner;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class GymOwnerServiceImplementationTest {
//
//    GymOwner gymOwner = null;
//    Slot slot1 = null;
//    Slot slot2 = null;
//    GymSubscriptions gymSubscription1 = null;
//    GymSubscriptions gymSubscription2 = null;
//    List<GymSubscriptions> gymSubscriptions = null;
//    List<Slot> slots = null;
//    @Autowired
//    private GymOwnerServiceImplementation gymService;
//
//    @BeforeEach
//    void addTestObject() {
//        slot1 = new Slot(45, Status.AVAILABLE, "5-6P.M");
//        slot2 = new Slot(46, Status.BOOKED, "9-10P.M");
//        slots = new ArrayList<>();
//        slots.add(slot1);
//        slots.add(slot2);
//        gymSubscription1 = new GymSubscriptions(798, "Basic", 3000.0);
//        gymSubscription2 = new GymSubscriptions(799, "Advance", 4000.0);
//        gymSubscriptions = new ArrayList<>();
//        gymSubscriptions.add(gymSubscription1);
//        gymSubscriptions.add(gymSubscription2);
//        gymOwner = new GymOwner(199, "Test Gym", "Test",
//                "test@gmail.com", slots, gymSubscriptions);
//    }
//
//    @Test
//    void addGymData() throws SameEntryException {
//        GymOwner gymOwnerTest = this.gymService.addGymData(gymOwner);
//        assertEquals(199, gymOwnerTest.getGymOwnerId());
//        assertEquals("Test Gym", gymOwnerTest.getGymName());
//        assertEquals("Test", gymOwnerTest.getGymOwnerName());
//        assertEquals("test@gmail.com", gymOwnerTest.getGymOwnerEmail());
//        assertEquals(slot1, gymOwnerTest.getSlots().get(0));
//        assertEquals(slot2, gymOwnerTest.getSlots().get(1));
//        assertEquals(gymSubscription1, gymOwnerTest.getGymSubscriptions().get(0));
//        assertEquals(gymSubscription2, gymOwnerTest.getGymSubscriptions().get(1));
//    }
//
//    @Test
//    void updateSlote() throws DataNotPresentException {
//        this.gymService.updateSlote(199, 46);
//        assertEquals(Status.AVAILABLE, this.gymService.getSlotsByGymId(199).getSlots().get(0).getSlotStatus());
//    }
//
//    @Test
//    void getSlotsByGymId() throws DataNotPresentException {
//        GymOwner slots1 =this.gymService.getSlotsByGymId(199);
//        assertEquals(slots.get(0),slots1.getSlots().get(0));
//    }
//
//    @AfterAll
//    void removeTestObject() throws DataNotPresentException {
//        this.gymService.deleteGymById(199);
//    }
//}