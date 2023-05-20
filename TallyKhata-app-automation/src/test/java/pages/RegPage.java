package pages;

import helper.AppLauncher;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Paths;

import java.net.MalformedURLException;

public class RegPage {

    private AppLauncher appLauncher;
    private ConfigReader conf;

    @FindBy(id = Paths.nextButton)
    private MobileElement nextButton;

    @FindBy(id = Paths.phoneInput)
    private MobileElement phoneInput;

    public RegPage() throws MalformedURLException {
        appLauncher = AppLauncher.getInstance();
        conf = new ConfigReader();
        PageFactory.initElements(new AppiumFieldDecorator(appLauncher.getAppiumDriver()), this);
    }

    public boolean validateRegPageUiElementsVisibility() throws InterruptedException {
        Thread.sleep(10000);
        boolean isElementVisible = phoneInput.isDisplayed();
        return isElementVisible;
    }

    public boolean enterPhoneNumber() throws InterruptedException {
        Thread.sleep(2000);
        if (phoneInput.isDisplayed()) {
            phoneInput.sendKeys(conf.getConfig("phoneNumber"));
            return true;
        }
        return false;
    }

    public boolean clickNextButton() throws InterruptedException {
        Thread.sleep(2000);
        if (nextButton.isDisplayed()) {
            nextButton.click();
            return true;
        }
        return false;
    }

    public boolean enterOtp() throws InterruptedException {
        Thread.sleep(2000);
        if (nextButton.isDisplayed()) {
            nextButton.click();
            return true;
        }
        return false;
    }


    // You can add more methods to perform actions using the Appium driver
}
