package pages;

import helper.AppLauncher;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Paths;

import java.net.MalformedURLException;
import java.util.List;

public class RegOrLoginPage {

    private final AppLauncher appLauncher;
    private final ConfigReader conf;

    @FindBy(id = Paths.nextButton)
    private MobileElement nextButton;
    @FindBy(id = Paths.nextButtonAfterOtp)
    private MobileElement nextButtonAfterOtp;

    @FindBy(id = Paths.phoneInput)
    private MobileElement phoneInput;

    @FindBy(id = Paths.otpInput)
    private MobileElement otpInput;
    @FindBy(id = Paths.pinInput)
    private MobileElement pinInput;

    @FindBy(className = Paths.genericTextView)
    private MobileElement genericTextView;

    @FindBy(className = Paths.forgotPinButton)
    private MobileElement forgotPinButton;

    // Wait for element visibility
    WebDriverWait wait;


    public RegOrLoginPage() throws MalformedURLException {
        appLauncher = AppLauncher.getInstance();
        conf = new ConfigReader();
        PageFactory.initElements(new AppiumFieldDecorator(appLauncher.getAppiumDriver()), this);
        wait = new WebDriverWait(appLauncher.getAppiumDriver(), 20);
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

    /*
    Locate elements on the screen that may contain the text
    and then check if the text is present in any of those elements.
    */
    public boolean checkIsTkLoginPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(pinInput));
//        Thread.sleep(10000);
        String searchText = "PIN দিয়ে লগইন করুন।";

        // Get all text elements on the screen
        List<MobileElement> textElements = appLauncher.getAppiumDriver().findElements(By.className("android.widget.TextView"));
        // Check if the text is present in any of the elements
        boolean textFound = false;
        for (MobileElement element : textElements) {
            if (element.getText().contains(searchText)) {
                textFound = true;
                break;
            }
        }

        return textFound;
    }

    public boolean doLoginViaPin() {
        wait.until(ExpectedConditions.visibilityOf(pinInput));
        if (pinInput.isDisplayed()) {
            appLauncher.getAppiumDriver().getKeyboard().sendKeys("1234");
            return true;
        }
        return false;
    }

    public boolean IsSuccessfulLogin() {
        wait.until(ExpectedConditions.visibilityOf(pinInput));
        if (pinInput.isDisplayed()) {
            appLauncher.getAppiumDriver().getKeyboard().sendKeys("1023");
            return true;
        }
        return false;
    }

}
