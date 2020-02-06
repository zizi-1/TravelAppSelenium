package Test.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoiPage {

    @FindBy(xpath="/html/body/header/div/nav/ul/li[4]/a")
    private WebElement navbar;

    @FindBy(xpath="/html/body/section[5]/div/div[4]/div/div/div/div[1]/form/input[1]")
    private WebElement poiName;

    @FindBy(xpath="/html/body/section[5]/div/div[4]/div/div/div/div[1]/form/input[2]")
    private WebElement poiLink;

    @FindBy(xpath="/html/body/section[5]/div/div[4]/div/div/div/div[1]/form/button")
    private WebElement addPoiButton;


    public void selectPoiPage() {
        navbar.click();
    }
    public void addPoi(String name, String link) {
        this.poiName.sendKeys(name);
        this.poiLink.sendKeys(link);
        this.addPoiButton.click();

    }
}
