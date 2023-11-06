package com.kamivision.screens.common.settings.firmwareversion;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class FirmwareVersionScreen {
    private final UIHelper app;
    public FirmwareVersionScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("update_version")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name=\""+app.lang.getProperty("CameraUpdate_1441676159_195")+"\"]"));}
    public UIHelper updateButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnUpgrade') and  @text ='"+app.lang.getProperty("update_update")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("update_onekey")+"']"));}
    public UIHelper upToDate() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvAntsDialogContent') and  @text ='"+app.lang.getProperty("update_version_hint_latestAlready")+"']"),By.xpath("//XCUIElementTypeAlert//*[@name='"+app.lang.getProperty("CameraUpdate_1441676159_202")+"']"));}
    public UIHelper updateText() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@text, '"+app.lang.getProperty("update_update")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("update_onekey")+"']"));}

    @Step("Verify 'Firmware version' page displayed")
    public void verifyFirmwareVersionPageDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify 'Firmware version' page displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5), "Firmware version page is not displayed");
    }

    @Step("Click on Update button")
    public void clickOnUpdateButton() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Update button");
        updateButton().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Up to date Popup displayed")
    public void verifyUpToDatePopupDisplayed() throws Exception {
        log.info("Verify Up to date Popup displayed");
        Assert.assertTrue(upToDate().isElementPresent(15), "Up to date is not displayed");
    }

    @Step("Verify Firmware update text displayed")
    public void verifyFirmwareUpdateTextDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Firmware update text displayed");
        Assert.assertTrue(updateText().isElementPresent(15), "Firmware Update is not displayed");
    }
}
