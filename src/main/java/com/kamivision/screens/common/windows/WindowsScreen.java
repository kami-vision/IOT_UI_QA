package com.kamivision.screens.common.windows;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class WindowsScreen {
    private final UIHelper app;
    public WindowsScreen(UIHelper app) {
        this.app=app;
    }
    public static boolean isCloudSubMissing = false;

    public UIHelper pleasePairDevice() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("camera_splitscreen_unbind_content")+ "')]"), By.xpath("//*[@name=\"" + app.lang.getProperty("camera_splitscreen_unbind_content")+ "\"]"));}
    public UIHelper multiLiveBackButton() throws Exception{ return app.setBy(By.xpath("NA"), By.xpath("//XCUIElementTypeButton[@name='multi live back']"));}
    public UIHelper missingSubscription() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("camera_splitscreen_unpaid_overseas")+"')]"), By.xpath("ios"));}

    @Step("Verify please pair device message displayed")
    public void verifyPleasePairDeviceMessageDisplayed() throws Exception {
        if (app.isAndroid() && missingSubscription().isElementPresent(15)) {
            isCloudSubMissing = true;
            return;
        }
        log.info("Verify please pair device message");
        Assert.assertTrue(pleasePairDevice().isElementPresent(10),
                "Please pair device message is not displayed");

    }

    @Step("Navigate back {0}")
    public void navigateBack(int times) throws Exception {
        if (app.isIOS()) {
            Thread.sleep(5000);
            pleasePairDevice().click();
            multiLiveBackButton().click();
        } else {
            for (int i = 0; i < times; i++) {
                Thread.sleep(1500);
                app.navigateBack();
            }
        }
    }
}
