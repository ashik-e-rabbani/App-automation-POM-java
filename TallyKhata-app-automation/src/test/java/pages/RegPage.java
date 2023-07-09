package pages;

import helper.AppLauncher;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Paths;

import java.net.MalformedURLException;

public class RegPage {

    private AppLauncher appLauncher;
    private ConfigReader conf;

    @FindBy(id = Paths.nextButton)
    private MobileElement nextButton;
    @FindBy(id = Paths.nextButtonAfterOtp)
    private MobileElement nextButtonAfterOtp;

    @FindBy(id = Paths.phoneInput)
    private MobileElement phoneInput;

    @FindBy(id = Paths.otpInput)
    private MobileElement otpInput;

    // Wait for element visibility
    WebDriverWait wait;


    public RegPage() throws MalformedURLException {
        appLauncher = AppLauncher.getInstance();
        conf = new ConfigReader();
        PageFactory.initElements(new AppiumFieldDecorator(appLauncher.getAppiumDriver()), this);
        wait = new WebDriverWait(appLauncher.getAppiumDriver(), 10);
    }

    public boolean validateRegPageUiElementsVisibility() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        return phoneInput.isDisplayed();
    }

    public boolean enterPhoneNumber() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        if (phoneInput.isDisplayed()) {
            phoneInput.sendKeys(conf.getConfig("phoneNumber"));
            return true;
        }
        return false;
    }

    public boolean clickNextButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        if (nextButton.isDisplayed()) {
            nextButton.click();
            return true;
        }
        return false;
    }

    public boolean enterOtp() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(otpInput));
        if (otpInput.isDisplayed()) {
//            otpInput.sendKeys(Keys.NUMPAD1,Keys.NUMPAD2,Keys.NUMPAD3,Keys.NUMPAD4);
            appLauncher.getAppiumDriver().getKeyboard().sendKeys("1234");
            return true;
        }
        return false;
    }

    public boolean clickNextButtonAfterOtp() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(nextButtonAfterOtp));
        if (nextButtonAfterOtp.isDisplayed()) {
            nextButtonAfterOtp.click();
            return true;
        }
        return false;
    }


    // You can add more methods to perform actions using the Appium driver
}
