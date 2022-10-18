package com.stackroute.gymownerservice;

import com.stackroute.gymownerservice.controller.GymOwnerController;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.model.GymSubscription;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static com.stackroute.gymownerservice.model.SlotStatus.AVAILABLE;
import static com.stackroute.gymownerservice.model.SlotTime.Morning;
import static com.stackroute.gymownerservice.model.Subscription.monthly;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GymOwnerControllerTests {

    GymOwner gymOwner = new GymOwner(101, "TestGym101", "TestGymOwner", "TestGym101@gmail.com",
            "TestCity", "TestAddress", 12345, 1234567890,
            Arrays.asList(new GymSlot(1, Morning, AVAILABLE)),
            Arrays.asList(new GymSubscription(monthly, 1000.0)));

    @Test
    void contextLoads() {
    }

    @Autowired
    private GymOwnerController gymOwnerController;

    public void testAddGym()
    {

    }

}
