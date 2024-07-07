package org.ankit.pages.flightbooking;

import org.ankit.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class FlightSelectionPage extends AbstractPage {

    @FindBy(css="ul[data-test-id='listings']")
    private WebElement flightsListing;

    @FindBy(css="button.uitk-card-link")
    private ArrayList<WebElement> flightButtonList;

    @FindBy(xpath = "//button[@stif='select-button']")
    private WebElement selectButton;

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsListing));
        return this.flightsListing.isDisplayed();
    }

    public void selectFlightButton(int idx){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.uitk-card-link")));
        this.flightButtonList.get(idx).click();
//        for(WebElement button : this.flightButtonList){
//            button.click();
//        }
    }

    public void select(){
        this.selectButton.click();
    }
}
