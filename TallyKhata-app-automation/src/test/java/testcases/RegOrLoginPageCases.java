package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegOrLoginPage;

import java.io.IOException;

public class RegOrLoginPageCases {

RegOrLoginPage regOrLoginPage;
    @BeforeTest
    public void init() throws IOException, InterruptedException {
        regOrLoginPage = new RegOrLoginPage();
    }

    @Test(priority = 0)
    public void testUiElementVisibility() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.validateRegPageUiElementsVisibility());
    }

    @Test(priority = 1)
    public void isPhoneNumberEntered() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.enterPhoneNumber());
    }

    @Test(priority = 2)
    public void isNextButtonClicked() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.clickNextButton());
    }

    @Test(priority = 3)
    public void isOtpEntered() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.enterOtp());
    }
    @Test(priority = 4)
    public void isNextButtonClickedAfterOtp() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.clickNextButtonAfterOtp());
    }
    @Test(priority = 5)
    public void isLoginPage() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.checkIsTkLoginPage());
    }

    @Test(priority = 6)
    public void loggedViaPin() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.doLoginViaPin());
    }

    @Test(priority = 7)
    public void SuccessfulLogin() throws IOException, InterruptedException {
        Assert.assertTrue(regOrLoginPage.IsSuccessfulLogin());
    }



}
