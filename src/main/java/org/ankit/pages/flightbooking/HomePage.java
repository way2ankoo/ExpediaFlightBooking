package org.ankit.pages.flightbooking;

import org.ankit.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".uitk-tab-anchor[href='/Flights']")
    private WebElement flightsTabButton;

    @FindBy(css = ".uitk-tab-anchor[href='#FlightSearchForm_ONE_WAY']")
    private WebElement oneWayButton;

    @FindBy(css = "button[aria-label='Leaving from']")
    private WebElement leavingFromButton;

    @FindBy(id="origin_select")
    private WebElement originCityInput;

    @FindBy(css = "button.origin_select-result-item-button")
    private List<WebElement> originButtonsList;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    private WebElement goingToButton;

    @FindBy(id = "destination_select")
    private WebElement destinationCityInput;

    @FindBy(css = "button.destination_select-result-item-button")
    private List<WebElement> destinationButtonsList;

    @FindBy(id = "search_button")
    private WebElement searchButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsTabButton));
        return this.flightsTabButton.isDisplayed();
    }

    public void goToFlightsTab(){
        this.flightsTabButton.click();
    }

    public boolean isAtOneWayMenu(){
        //this.wait.until(ExpectedConditions.visibilityOf(this.oneWayButton));
        return this.oneWayButton.isDisplayed();
    }

    public void goToOneWayOption() {
        this.oneWayButton.click();
    }

    public void enterOriginDetails(String originCity){
        this.leavingFromButton.click();
        this.originCityInput.sendKeys(originCity);

        // click on element having origin city in text
        //this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.cssSelector(".uitk-sheet-content"))));
        for(WebElement button : this.originButtonsList){
            String ariaLabel = button.getAttribute("aria-label");
            System.out.println(ariaLabel);
            if(ariaLabel.contains(originCity)){
                button.click();
                break;
            }
        }
    }

    public void enterDestinationDetails(String destinationCity){
        this.goingToButton.click();
        this.destinationCityInput.sendKeys(destinationCity);
        for(WebElement button : this.destinationButtonsList){
            String ariaLabel = button.getAttribute("aria-label");
            if(ariaLabel.contains(destinationCity)){
                button.click();
                break;
            }
        }
    }

    public void search(){
        this.searchButton.click();
    }

}
