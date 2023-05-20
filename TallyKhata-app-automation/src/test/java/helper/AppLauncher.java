package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppLauncher {

    public static AppLauncher instance;
    public static AppiumDriver appiumDriver;
    private AppLauncher() throws MalformedURLException {
        initDriver();
    }

    //    Method which will be accessible from outside to get an instance of this class
    public static AppLauncher getInstance() throws MalformedURLException {
        instance = (instance == null) ? new AppLauncher() : instance;
        return instance;
    }


    private void initDriver() throws MalformedURLException {
        ConfigReader conf = new ConfigReader();

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", conf.getConfig("deviceName"));
        cap.setCapability("platformName", conf.getConfig("platformName"));
        cap.setCapability("platformVersion", conf.getConfig("platformVersion"));
        cap.setCapability("udid", conf.getConfig("udid"));
        cap.setCapability("appPackage", conf.getConfig("appPackage"));
        cap.setCapability("appActivity", conf.getConfig("appActivity"));
        cap.setCapability("autoGrantPermissions", true);



        URL url = new URL(conf.getConfig("appServerUrl"));
        appiumDriver = new AppiumDriver<MobileElement>(url, cap);


    }


    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }
}
