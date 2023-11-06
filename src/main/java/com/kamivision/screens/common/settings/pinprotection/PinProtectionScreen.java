package com.kamivision.screens.common.settings.pinprotection;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class PinProtectionScreen  {
    private final UIHelper app;
    public PinProtectionScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper setPINTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("system_setPIN")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name='"+app.lang.getProperty("system_setPIN")+"']"));}
    public UIHelper disablePINTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("system_turnoffPIN")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name='"+app.lang.getProperty("system_turnoffPIN")+"']"));}
    public UIHelper verifyPINTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("cameraSetting_security_verifyPIN")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name='"+app.lang.getProperty("cameraSetting_security_verifyPIN")+"']"));}
    public UIHelper shareWithOtherAccount() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text ='"+app.lang.getProperty("share_YIAccount")+"']"),By.xpath("ios"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("ios"));}
    public UIHelper incorrectPINCodeMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@text, 'You have entered an incorrect PIN code 5 times. Please try again in 30 minutes or reset the camera.')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("cameraSetting_pincode_hint_err01")+"']"));}
    public UIHelper enterPinTextBox() throws Exception{ return app.setBy(By.xpath(""),By.xpath("//XCUIElementTypeImage[@name='yh_connect_pwd_alert_bg.png']/..//XCUIElementTypeTextField"));}



    @Step("Enter PIN")
    public void enterPIN(AndroidKey number1, AndroidKey number2, AndroidKey number3, AndroidKey number4) throws InterruptedException {
        log.info("Enter PIN");
        app.pressNumber(number1);
        app.pressNumber(number2);
        app.pressNumber(number3);
        app.pressNumber(number4);
        Thread.sleep(3000);
    }

    @Step("Verify 'Set PIN' page displayed")
    public void verifySetPinPageDisplayed() throws Exception {
        log.info("Verify 'Set PIN' page displayed");
        Assert.assertTrue(setPINTitle().isElementPresent(5),
                "Set PIN page is not displayed");
    }

    @Step("Verify 'Verify PIN' page displayed")
    public void verifyVerifyPinPageDisplayed() throws Exception {
        log.info("Verify 'Verify PIN' page displayed");
        Assert.assertTrue(verifyPINTitle().isElementPresent(5),
                "Verify PIN page is not displayed");
    }

    @Step("Verify 'Disable the PIN' page displayed")
    public void verifyDisableThePinPageDisplayed() throws Exception {
        log.info("Verify 'Disable the PIN' page displayed");
        Assert.assertTrue(disablePINTitle().isElementPresent(5),
                "Disable the PIN page is not displayed");
    }

    @Step("Verify Incorrect PIN code inputted 5 times message displayed")
    public void verifyIncorrectPINCodeInputtedFiveTimeDisplayed() throws Exception {
        log.info("Verify Incorrect PIN code inputted 5 times message displayed");
        Assert.assertTrue(incorrectPINCodeMessage().isElementPresent(5),
                "Set PIN page is not displayed");
    }
}
