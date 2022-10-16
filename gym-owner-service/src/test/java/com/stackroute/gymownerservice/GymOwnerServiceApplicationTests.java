package com.stackroute.gymownerservice;

import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.model.GymSubscription;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.stackroute.gymownerservice.model.SlotStatus.AVAILABLE;
import static com.stackroute.gymownerservice.model.SlotTime.Morning;
import static com.stackroute.gymownerservice.model.Subscription.monthly;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GymOwnerServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GymOwnerService gymOwnerService;
	{
	/*@Test

	public void testcreateGym() {
		this.gymOwnerService.createGym(new GymOwner(3, "Fit", "ChriS", "Fit@gmail.com", "Chennai", "1st main road,Besant Avenue", 600041, 987654321,
				new GymSlot(3, Morning, AVAILABLE),
				new GymSubscription(monthly, 2000.0)));
		assertEquals("Fit", this.gymOwnerService.getGymById(3).getGymName());*/

	}

	@Test
	public void testgetGymById() {
		assertEquals(1, this.gymOwnerService.getGymById(1).getGymId());
	}

	@Test
	public void testdeleteGym() {
		assertEquals("Gym deleted", this.gymOwnerService.deleteGym(1));
	}
	@Test
	public void testfindGymByCity() {
			assertEquals("Chennai",this.gymOwnerService.getGymById(3).getCity());

	}
	@Test
	public void testfindGymBySlotId()
	{
		assertEquals(3,this.gymOwnerService.getGymById(3).getGymSlot());
	}
}
