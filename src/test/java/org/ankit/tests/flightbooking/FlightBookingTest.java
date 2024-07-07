package org.ankit.tests.flightbooking;

import org.ankit.pages.flightbooking.FlightSelectionPage;
import org.ankit.pages.flightbooking.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlightBookingTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void flightSelectionTest(){
        HomePage homePage = new HomePage(driver);
        homePage.goTo("https://www.expedia.com/");

        Assert.assertTrue(homePage.isAt());
        homePage.goToFlightsTab();

        Assert.assertTrue(homePage.isAtOneWayMenu());
        homePage.goToOneWayOption();

        homePage.enterOriginDetails("Delhi");
        homePage.enterDestinationDetails("Bengaluru");
        homePage.search();

    }

    @Test(dependsOnMethods = "flightSelectionTest")
    public void selectDepartingFlight(){
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());
        System.out.println("I am here");

        flightSelectionPage.selectFlightButton(2);
        flightSelectionPage.select();


    }

//    @AfterTest
//    public void quitDriver(){
//        this.driver.quit();
//    }
}
