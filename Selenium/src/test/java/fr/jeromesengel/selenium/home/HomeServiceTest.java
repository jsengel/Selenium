package fr.jeromesengel.selenium.home;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.jeromesengel.selenium.common.Result;
import fr.jeromesengel.selenium.home.HomeService;
import fr.jeromesengel.selenium.home.HomeServiceImpl;

public class HomeServiceTest {

	@Test
	public void test() {
		HomeService homeService = new HomeServiceImpl();

		assertEquals(Result.FAIL, homeService.fakeBusinessMethod());
		assertEquals(Result.PENDING, homeService.fakeBusinessMethod());
		assertEquals(Result.SUCCESS, homeService.fakeBusinessMethod());
	}
}