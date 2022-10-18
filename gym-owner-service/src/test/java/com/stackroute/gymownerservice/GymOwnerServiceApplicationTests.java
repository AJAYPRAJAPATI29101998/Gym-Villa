package com.stackroute.gymownerservice;

import com.stackroute.gymownerservice.exceptions.GymIdAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymIdNotAvailable;
import com.stackroute.gymownerservice.exceptions.GymNameAlreadyExistsException;
import com.stackroute.gymownerservice.exceptions.GymNameNotAvailable;
import com.stackroute.gymownerservice.model.GymOwner;
import com.stackroute.gymownerservice.model.GymSlot;
import com.stackroute.gymownerservice.model.GymSubscription;
import com.stackroute.gymownerservice.service.GymOwnerService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.stackroute.gymownerservice.model.SlotStatus.AVAILABLE;
import static com.stackroute.gymownerservice.model.SlotTime.Evening;
import static com.stackroute.gymownerservice.model.SlotTime.Morning;
import static com.stackroute.gymownerservice.model.Subscription.monthly;
import static com.stackroute.gymownerservice.model.Subscription.quarterly;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GymOwnerServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GymOwnerService gymOwnerService;

	GymOwner gymOwner = new GymOwner(100, "TestGym100", "TestGymOwner", "TestGym100@gmail.com",
			"TestCity", "TestAddress", 12345, 987654321,
			Arrays.asList(new GymSlot(3, Morning, AVAILABLE)),
			Arrays.asList(new GymSubscription(monthly, 2000.0)));

	@Test
	@Order(1)
	public void testCreateGym()
	{
		try
		{
			GymOwner gymOwnerCreate = this.gymOwnerService.createGym(gymOwner);
			assertEquals(gymOwner, gymOwnerCreate, "testCreateGym(): Created Gym Owner information is not matching with input values");
		}
		catch (GymIdAlreadyExistsException e)
		{
			try {
				this.gymOwnerService.deleteGym(gymOwner.getGymId());
			} catch (GymIdNotAvailable e1) {
				assertEquals("GymOwner Not Found","GymOwner ID Found", "testCreateGym() : GymIdAlreadyExistsException raised wrongly");
			}
		}
		catch (GymNameAlreadyExistsException e)
		{
			GymOwner delGymOwner = null;
			try {
				delGymOwner = this.gymOwnerService.getGymByName(gymOwner.getGymName());
				this.gymOwnerService.deleteGym(delGymOwner.getGymId());
			} catch (GymNameNotAvailable|GymIdNotAvailable e1) {
				assertEquals("GymOwner Not Found","GymOwner Name Found", "testCreateGym(): GymNameAlreadyExistsException raised wrongly");
			}
		}
	}

	@Test
	@Order(2)
	public void testGetGymById() {
		try {
			assertEquals(gymOwner, this.gymOwnerService.getGymById(100), "testGetGymById(): Gym Owner information fetched is not matching with Input GymID");
		} catch (GymIdNotAvailable e) {
			assertEquals("Gym ID Found","Gym ID Not Found", "testGetGymById(): Could not fetch GymOwner using GymId");
		}
	}

	@Test
	@Order(3)
	public void testGetGymByName() {
		try {
			assertEquals(gymOwner, this.gymOwnerService.getGymByName("TestGym100"), "testGetGymByName(): Gym Owner information fetched is not matching with Input Name");
		} catch (GymNameNotAvailable e) {
			assertEquals("Gym Name Found","Gym Name Not Found", "testGetGymByName(): Could not fetch GymOwner using GymName");
		}
	}

	@Test
	@Order(4)
	public void testUpdateGymDetails()
	{
		gymOwner.setGymSlot(Arrays.asList(new GymSlot(100, Evening, AVAILABLE)));
		gymOwner.setGymSubscription(Arrays.asList(new GymSubscription(monthly, 3000.0), new GymSubscription(quarterly, 6000.0)));
		gymOwner.setGymOwnerName("TestGym100Owner");
		try {
			assertEquals(gymOwner, this.gymOwnerService.updateGymDetails(gymOwner), "testUpdateGymDetails(): Updated Gym owner is not matching with the input values");
		} catch (GymIdNotAvailable e) {
			assertEquals("Gym ID Found","Gym ID Not Found", "testUpdateGymDetails(): Could not fetch GymOwner using GymID");
		}
	}

	@Test
	@Order(5)
	public void testFindGymByCity()
	{
		Iterable<GymOwner> gymOwnerIter = this.gymOwnerService.findGymByCity("TestCity");
		List<GymOwner> gymOwnerNotCityList = StreamSupport.stream(gymOwnerIter.spliterator(), false).filter((go) -> ! go.getCity().equals("TestCity")).collect(Collectors.toList());
		assertEquals(0,gymOwnerNotCityList.size(), "testFindGymByCity(): Fetched Gym details not matching with City");
		Stream<GymOwner> gymOwnerCityStr = StreamSupport.stream(gymOwnerIter.spliterator(), false).filter((go) -> go.getCity().equals("TestCity"));
		assertEquals(100, gymOwnerCityStr.filter((go) -> go.getGymId() == 100).collect(Collectors.toList()).get(0).getGymId(), "testFindGymByCity(): Could not fetch test Gym owner information which is having matching City");
	}

	@Test
	@Order(7)
	public void testDeleteGym()
	{
		try
		{
			assertEquals("Gym Owner deleted", this.gymOwnerService.deleteGym(100), "testDeleteGym(): Gym owner delete return message not matching");
		} catch (GymIdNotAvailable e) {
			assertEquals("Gym ID Found","Gym ID Not Found", "testDeleteGym(): Gym ID not available to delete");
		}
	}
}
