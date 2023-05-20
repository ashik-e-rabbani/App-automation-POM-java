package helper;

import io.appium.java_client.MobileElement;

public class FlexElementor {

    // Custom sendKeys method with an additional sleep time parameter
    public void sendKeysWithDelay(MobileElement element, String text, long sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
        element.sendKeys(text);
    }
}
