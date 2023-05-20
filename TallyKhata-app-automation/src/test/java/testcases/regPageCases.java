package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegPage;

import java.io.IOException;

public class regPageCases {

RegPage regPage;
    @BeforeTest
    public void init() throws IOException, InterruptedException {
        regPage = new RegPage();
    }

    @Test(priority = 0)
    public void testUiElementVisibility() throws IOException, InterruptedException {
        Assert.assertEquals(true, regPage.validateRegPageUiElementsVisibility());
    }

    @Test(priority = 1)
    public void isPhoneNumberEntered() throws IOException, InterruptedException {
        Assert.assertEquals(true, regPage.enterPhoneNumber());
    }

    @Test(priority = 2)
    public void isNextButtonClicked() throws IOException, InterruptedException {
        Assert.assertEquals(true, regPage.clickNextButton());
    }


}
