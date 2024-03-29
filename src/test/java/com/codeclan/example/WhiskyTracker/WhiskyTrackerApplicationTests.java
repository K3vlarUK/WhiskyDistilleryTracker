package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyThatHasYear() {
		List<Whisky> found = whiskyRepository.findWhiskysByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void findDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistillerysByRegion("Lowland");
		assertEquals("Lowland", found.get(0).getRegion());
	}

	@Test
	public void findWhiskyByDistilleryAndAge() {
		List<Whisky> found = whiskyRepository.findWhiskiesByDistilleryIdAndAge(1L, 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findWhiskiesByRegion() {
		List<Whisky> found = whiskyRepository.findWhiskiesByDistilleryRegion("Speyside");
		assertEquals(1, found.size());
	}

	@Test
	public void findDistillieriesByWhiskyAge() {
		List<Distillery> found = distilleryRepository.findDistillerysByWhiskiesAge(12);
		assertEquals(2, found.size());
	}
}
