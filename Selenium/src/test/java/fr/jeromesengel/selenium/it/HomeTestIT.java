package fr.jeromesengel.selenium.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import fr.jeromesengel.selenium.common.Result;

public class HomeTestIT {

	private static FirefoxDriver driver;
	private static Wait wait;

	@BeforeClass
	public static void before() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.cache.disk.enable", false);
		profile.setPreference("browser.cache.memory.enable", false);
		profile.setPreference("browser.cache.offline.enable", false);
		profile.setPreference("network.http.use-cache", false);
		profile.setPreference("intl.accept_languages", "no,en-us,en");

		driver = new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 10);
	}

	@AfterClass
	public static void after() {
		if (driver != null) {
			//driver.close();
		}
	}

	@Test
	public void checkTestResult() {
		// Go to the right URL for this test
		driver.get("localhost:8080");

		// HTML elements for this test
		By testLink = By.id("testLink");
		By testResult = By.id("testResult");

		// No result yet, so the <p> is empty
		assertEquals("", driver.findElement(testResult).getText());

		// First click on the link, the result must be FAIL
		driver.findElement(testLink).click();
		assertEquals(Result.FAIL.toString(), driver.findElement(testResult).getText());

		// Second click on the link, the result must be PENDING
		driver.findElement(testLink).click();
		assertEquals(Result.PENDING.toString(), driver.findElement(testResult).getText());

		// Third click on the link, the result must be SUCCESS
		driver.findElement(testLink).click();
		assertEquals(Result.SUCCESS.toString(), driver.findElement(testResult).getText());

		// When the service returns "SUCCESS", the link should disappear from the page
		assertTrue(driver.findElements(By.id("testLink")).isEmpty());
	}
}