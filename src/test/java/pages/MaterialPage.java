package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaterialPage {

    @FindBy(css = "li.learn-list-item.active")
    WebElement activeMaterialIndicator;

    @FindBy(css = "span.next-button")
    WebElement nextButton;

    public MaterialPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isCurrentMaterialActive() {
        return activeMaterialIndicator.isDisplayed();
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isDisplayed();
    }
}